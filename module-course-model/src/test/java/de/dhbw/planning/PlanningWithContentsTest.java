package de.dhbw.planning;

import de.dhbw.planning.model.*;
import de.dhbw.planning.print.DeepPrinter;
import de.dhbw.planning.resources.FileResource;
import de.dhbw.planning.resources.ResourceManager;
import de.dhbw.planning.scheduling.CourseDaySchedule;
import de.dhbw.planning.scheduling.CourseDayScheduler;
import de.dhbw.planning.util.AgendaUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static de.dhbw.planning.scheduling.DurationCalculator.calculateDuration;
import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("all")
public class PlanningWithContentsTest {

    private ResourceManager resourceManager;

    @BeforeEach
    void setUp() {
        this.resourceManager = new ResourceManager();
    }

    @Test
    @DisplayName("List Test")
    public void canUseList() throws IOException {
        // given
        List<Item> courseDays = new LinkedList<>();
        courseDays.add(MockFactory.mockCourseDay(1));

        List<Item> contents = new LinkedList<>();
        contents.add(MockFactory.mockContent(1)); // index 0
        contents.add(MockFactory.mockBreak(1));   // index 1
        contents.add(MockFactory.mockContent(2)); // index 2
        contents.add(MockFactory.mockBreak(2));   // index 3
        contents.add(MockFactory.mockContent(3)); // index 4

        // when
        List<Item> breaks = contents.stream().filter(i -> {
            return ((Content) i).getContentType().equals(ContentType.Break);
        }).collect(Collectors.toList());

        Item pause1 = breaks.get(0);
        Item pause2 = breaks.get(1);

        int index1 = contents.indexOf(pause1);
        int index2 = contents.indexOf(pause2);

        List<Item> betweenPauses = contents.subList(index1, index2);

        // then
        assertEquals(1, index1);
        assertEquals(3, index2);
        assertEquals(2, betweenPauses.size());
    }
    @Test
    @DisplayName("[Course] Read Example-Course + Days + Contents")
    public void canReadCourseJson() throws IOException {
        // given
        Course course;

        // when
        course = resourceManager.readCourse(FileResource.Input.Course_1_CourseDay_n_Contents);

        // then
        assertNotNull(course);
    }

    @Test
    @DisplayName("[Course] Read + Write Course with Contents instead of Modules")
    public void canReadAndWriteCourseJson() throws IOException {
        // given
        Course course;

        // when
        course = resourceManager.readCourse(FileResource.Input.Course_1_CourseDay_n_Contents);

        // then
        assertNotNull(course);

        // write again
        resourceManager.writeCourse(FileResource.Output.Course_1_CourseDay_n_Contents, course);

        // pretty print for adoc
        DeepPrinter.printPretty(course);
    }

    @Test
    @DisplayName("[Content] Calculate Total Course Duration")
    public void canCalculateTotalCourseDuration() throws IOException {
        // given
        Course course;

        // when
        course = resourceManager.readCourse(FileResource.Input.Course_1_CourseDay_n_Contents);
        Duration duration = course.getDuration();

        // then
        assertNotNull(course);
        assertEquals("PT4H40M", duration.toString());
    }

    @Test
    @DisplayName("[Content] Calculate Duration Of Agenda Items")
    public void canCalculateDurationOfAgendaItems() throws IOException {
        // given
        Course course = resourceManager.readCourse(FileResource.Input.Course_1_CourseDay_n_Contents);
        CourseDay courseDay = (CourseDay) course.getAgenda().getItems().stream().findFirst().get();
        AgendaUtil scheduler = new AgendaUtil(course.getAgenda());

        // when
        List<List<Item>> subLists = scheduler.splitAgendaBy(ContentType.Break, courseDay);

        // then
        assertEquals(3, subLists.size());

        List<Item> itemsBeforeFirstBreak = subLists.get(0);
        Duration durationBeforeFirstBreak = calculateDuration(itemsBeforeFirstBreak);

        List<Item> itemsBetweenBreaks = subLists.get(1);
        Duration durationBetweenBreaks = calculateDuration(itemsBetweenBreaks);

        List<Item> itemsAfterSecondBreak = subLists.get(2);
        Duration durationAfterSecondBreak = calculateDuration(itemsAfterSecondBreak);

        Duration totalDuration = courseDay.getDuration();

        // then
        assertEquals(3, itemsBeforeFirstBreak.size());
        assertEquals("PT1H15M", durationBeforeFirstBreak.toString());

        assertEquals(3, itemsBetweenBreaks.size());
        assertEquals("PT30M", durationBetweenBreaks.toString());

        assertEquals(3, itemsAfterSecondBreak.size());
        assertEquals("PT30M", durationAfterSecondBreak.toString());

        assertEquals("PT2H35M", totalDuration.toString());
    }

    @Test
    @DisplayName("[CourseDay] Schedule Course Days")
    public void canScheduleCourseDays() throws IOException {
        // given

        // load data and get first course day (as example)
        Course course = resourceManager.readCourse(FileResource.Input.Course_1_CourseDay_n_Contents);

        // course day shall start at 09:15
        LocalDate startDate = LocalDate.of(2024, 2, 27);
        LocalTime startTime = LocalTime.of(9,15);

        // provide scheduler with start time, which is the base of time calculations for content
        CourseDayScheduler scheduler = new CourseDayScheduler(startDate, startTime);

        // when
        List<CourseDaySchedule> courseDaySchedules = scheduler.schedule(course.getAgenda());

        // then
        assertFalse(courseDaySchedules.isEmpty());

        // print
        DeepPrinter.printPretty(courseDaySchedules);
    }

}