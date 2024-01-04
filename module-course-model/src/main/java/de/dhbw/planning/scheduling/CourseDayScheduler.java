package de.dhbw.planning.scheduling;

import de.dhbw.planning.model.Agenda;
import de.dhbw.planning.model.Content;
import de.dhbw.planning.model.CourseDay;
import de.dhbw.planning.model.Item;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;

/**
 * Example Schedule:
 * <pre>
 * +-------------+------------+-------------------------+
 * | Item Name   | Type       | StartTime  -   EndTime  |
 * +-------------+------------+-------------------------+
 * |             | Scheduler  |   09:15                 |
 * | Day 1       | CourseDay  |   09:15    -    ...     |
 * |  Content 1  | Welcome    |   09:15    -    10:30   |
 * |  Content 2  | Break      |   10:30    -    10:45   |
 * |  Content 3  | Topic      |   10:45    -    12:15   |
 * |             | CourseDay  |   ...      -    12:15   |
 * +-------------+------------+-------------------------+
 * </pre>
 */
public class CourseDayScheduler {

    private LocalDate startDate;

    private LocalTime startTime;

    public CourseDayScheduler(LocalDate startDate, LocalTime startTime) {
        this.startDate = startDate;
        this.startTime = startTime;
    }

    public List<CourseDaySchedule> schedule(Agenda agenda) {
        assertNotNull(agenda, Agenda.class);

        // course day items
        List<Item> items = agenda.getItems();

        List<CourseDaySchedule> courseDaySchedules = new LinkedList<>();

        for (Item item : items) {
            CourseDay courseDay = (CourseDay) item;
            CourseDaySchedule courseDaySchedule = schedule(courseDay);
            courseDaySchedule.setDate(this.startDate); // todo calculate correct date (+7) with fori loop
            courseDaySchedules.add(courseDaySchedule);
        }

        return courseDaySchedules;
    }

    private CourseDaySchedule schedule(CourseDay courseDay) {
        assertNotNull(courseDay, CourseDay.class);
        assertNotNull(courseDay.getAgenda(), Agenda.class);

        // course day schedule
        CourseDaySchedule courseDaySchedule = new CourseDaySchedule();
        // set courseDay
        courseDaySchedule.setCourseDay(courseDay);
        // each gets manually set start time
        courseDaySchedule.setStartTime(this.startTime);

        // now create schedules from content items
        List<Item> items = courseDay.getAgenda().getItems();
        List<ContentSchedule> contentSchedules = new LinkedList<>();

        int size = items.size();
        int lastIndex = getLastIndex(size);

        for (int currentIndex = 0; currentIndex < size; currentIndex++) {
            Content content = (Content)items.get(currentIndex);

            ContentSchedule contentSchedule = new ContentSchedule();
            contentSchedule.setContent(content);

            if (isFirstItem(currentIndex)) {
                contentSchedule.setStartTime(courseDaySchedule.getStartTime());
                LocalTime endTime = contentSchedule.getStartTime().plus(content.getDuration());
                contentSchedule.setEndTime(endTime);
            }
            else if (isBetweenFirstAndLastItem(currentIndex, lastIndex)) {
                ContentSchedule predecessor = contentSchedules.get(currentIndex - 1);
                contentSchedule.setStartTime(predecessor.getEndTime());
                LocalTime endTime = contentSchedule.getStartTime().plus(content.getDuration());
                contentSchedule.setEndTime(endTime);
            }
            else if (isLastItem(currentIndex, lastIndex)) {
                ContentSchedule predecessor = contentSchedules.get(currentIndex - 1);
                contentSchedule.setStartTime(predecessor.getEndTime());
                LocalTime endTime = contentSchedule.getStartTime().plus(content.getDuration());
                contentSchedule.setEndTime(endTime);

                // finally, take ent time of last content schedule and set to course day
                courseDaySchedule.setEndTime(contentSchedule.getEndTime());
            }
            else {
                System.out.println("?????????????????????????????");
            }

            // add content schedule to list
            contentSchedules.add(contentSchedule);
        }

        // add all content schedules to course day schedule
        courseDaySchedule.setContentSchedules(contentSchedules);

        return courseDaySchedule;
    }

    private boolean isFirstItem(int currentIndex) {
        return currentIndex == 0;
    }
    private boolean isBetweenFirstAndLastItem(int currentIndex, int lastIndex) {
        return currentIndex > 0 && currentIndex < lastIndex;
    }
    private boolean isLastItem(int currentIndex, int lastIndex) {
        return currentIndex == lastIndex;
    }

    private int getLastIndex(int size) {
        return size - 1;
    }

    /*
    private CourseDaySchedule from(CourseDay courseDay) {
        assertNotNull(courseDay, CourseDay.class);

        CourseDaySchedule courseDaySchedule = new CourseDaySchedule();
        courseDaySchedule.setStartTime(this.startTime);

        for(Item item : courseDay.getAgenda().getItems()) {
            Content content = (Content) item;

            ContentSchedule contentSchedule = from(content);
            courseDaySchedule.addContentSchedule(contentSchedule);

        }

        LocalTime calculatedEndTime = LocalTime.MAX;
        courseDaySchedule.setEndTime(calculatedEndTime);

        return null;
    }

    private ContentSchedule from(Content content) {
        assertNotNull(content, Content.class);

        ContentSchedule contentSchedule = new ContentSchedule();
        contentSchedule.setContent(content);

        return null;
    }
    */

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    private void assertNotNull(Object o, Class<?> clazz) {
        if (o == null) {
            throw new IllegalArgumentException("'" + clazz.getSimpleName().toLowerCase() + "' must not be null!");
        }
    }
}
