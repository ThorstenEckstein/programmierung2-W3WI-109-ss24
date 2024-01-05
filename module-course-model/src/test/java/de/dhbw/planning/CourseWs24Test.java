package de.dhbw.planning;

import de.dhbw.planning.model.Course;
import de.dhbw.planning.print.DeepPrinter;
import de.dhbw.planning.resources.FileResource;
import de.dhbw.planning.resources.ResourceManager;
import de.dhbw.planning.scheduling.CourseDaySchedule;
import de.dhbw.planning.scheduling.CourseDayScheduler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SuppressWarnings("all")
public class CourseWs24Test {

    private ResourceManager resourceManager;

    @BeforeEach
    void setUp() {
        this.resourceManager = new ResourceManager();
    }

    @Test
    @DisplayName("[Course] Schedule Complete Course WS24")
    public void canScheduleAndPrintCourse() throws IOException {
        // given - load data and get first course day (as example)
        Course course = resourceManager.readCourse(FileResource.Input.CourseWs24);

        // course day shall start at 09:15
        LocalDate startDate = LocalDate.of(2024, 2, 27);
        LocalTime startTime = LocalTime.of(9,15);

        // provide scheduler with start time, which is the base of time calculations for content
        CourseDayScheduler scheduler = new CourseDayScheduler(startDate, startTime);

        // when
        List<CourseDaySchedule> courseDaySchedules = scheduler.schedule(course.getAgenda());

        // then
        assertFalse(courseDaySchedules.isEmpty());

        // print - "Tag 1" or "all"
        DeepPrinter.printPretty("Tag 3", courseDaySchedules);
    }

}