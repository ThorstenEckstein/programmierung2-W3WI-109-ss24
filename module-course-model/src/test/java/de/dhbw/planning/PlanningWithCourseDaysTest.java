package de.dhbw.planning;

import de.dhbw.planning.model.Content;
import de.dhbw.planning.model.Course;
import de.dhbw.planning.model.CourseDay;
import de.dhbw.planning.model.Module;
import de.dhbw.planning.print.SimplePrinter;
import de.dhbw.planning.resources.FileResource;
import de.dhbw.planning.resources.ResourceManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.Duration;

import static de.dhbw.planning.MockFactory.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PlanningWithCourseDaysTest {

    private ResourceManager resourceManager;

    @BeforeEach
    void setUp() {
        this.resourceManager = new ResourceManager();
    }

    @Test
    @DisplayName("[Course] Read Course + CourseDays")
    public void canReadRealCourseWithDaysJson() throws IOException {
        // given
        Course course;

        // when
        course = resourceManager.readCourse(FileResource.Input.Course_n_CourseDays);

        // then
        assertNotNull(course);

        // pretty print for adoc
        SimplePrinter.printPretty(course);
    }

    @Test
    @DisplayName("[CourseDay] Mocked CourseDay - Without Agenda")
    public void canCreateCourseDayWithoutAgenda() {
        // given
        CourseDay courseDay = mockCourseDay(1);

        // when
        String title = courseDay.getTitle();

        // then
        assertEquals("Day 1", title);

        // print
        SimplePrinter.printSimple(courseDay);
    }

    @Test
    @DisplayName("[CourseDay] Mocked CourseDay - Calculate Duration")
    public void canGetCourseDayDuration() {
        // given
        Content welcome      = mockWelcome();
        Content pause        = mockBreak(1);
        Content setup        = mockSetup();
        Content classes      = mockTopic("Klassen & Vererbung");
        Content polymorphism = mockTopic("Polymorphismus");

        Module module1       = mockModule(1, welcome, pause, setup);
        Module module2       = mockModule(2, classes, pause, polymorphism);

        CourseDay courseDay  = mockCourseDay(1, module1, pause, module2);

        // when
        Duration duration = courseDay.getDuration();

        // then
        assertEquals("PT3H15M", duration.toString());
    }

}
