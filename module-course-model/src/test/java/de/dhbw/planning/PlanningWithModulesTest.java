package de.dhbw.planning;

import de.dhbw.planning.print.DeepPrinter;
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

public class PlanningWithModulesTest {

    private ResourceManager resourceManager;

    @BeforeEach
    void setUp() {
        this.resourceManager = new ResourceManager();
    }

    @Test
    @DisplayName("[Course] Read Example-Course + Days + Modules + Contents")
    public void canReadCourseJson() throws IOException {
        // given
        Course course;

        // when
        course = resourceManager.readCourse(FileResource.Input.Course_n_CourseDays_n_Modules);

        // then
        assertNotNull(course);
    }

    @Test
    @DisplayName("[Course] Read Course + Days + Modules")
    public void canReadRealCourseWithDaysAndModulesJson() throws IOException {
        // given
        Course course;

        // when
        course = resourceManager.readCourse(FileResource.Input.Course_n_CourseDays_n_Modules);

        // then
        assertNotNull(course);

        // pretty print for adoc
        DeepPrinter.printPretty(course);
    }

    @Test
    @DisplayName("[Course] Read + Write Complete Course")
    public void canReadAndWriteCourseJson() throws IOException {
        // given
        Course course;

        // when
        course = resourceManager.readCourse(FileResource.Input.Course_n_CourseDays_n_Modules);

        // then
        assertNotNull(course);

        // write again
        resourceManager.writeCourse(FileResource.Output.Course_n_CourseDays_n_Modules, course);
    }

    @Test
    @DisplayName("[Course] Calculate Mocked Course Duration")
    public void canGetCourseDuration() throws IOException {
        // given

        // day 1
        Content welcome        = mockWelcome();
        Content pause1         = mockBreak(1);
        Content setup          = mockSetup();
        Content classes        = mockTopic("Klassen & Vererbung");
        Content polymorphism   = mockTopic("Polymorphismus");

        Module module1         = mockModule(1, welcome, setup);
        Module module2         = mockModule(2, classes, polymorphism);

        CourseDay day1         = mockCourseDay(1, module1, pause1, module2);

        // day 2
        Content ifc            = mockTopic("Interfaces");
        Content demoIfc        = mockDemo("Interfaces");
        Content exerciseIfc    = mockExercise("Interfaces");
        Content pause2         = mockBreak(2);
        Content absCls         = mockTopic("Abstrakte Klassen");
        Content demoAbsCls     = mockDemo("Abstrakte Klassen");
        Content exerciseAbsCls = mockExercise("Abstrakte Klassen");

        Module module3         = mockModule(3, ifc, demoIfc, exerciseIfc);
        Module module4         = mockModule(4, absCls, demoAbsCls, exerciseAbsCls);

        CourseDay day2         = MockFactory.mockCourseDay(2, module3, pause2, module4);

        // when
        Course course = mockCourse("Programmierung II mit Java", Semester.WS24, day1, day2);
        Duration duration = course.getDuration();

        // then
        assertEquals("PT6H", duration.toString());

        // print
        SimplePrinter.printSimple(course);
    }

    @Test
    @DisplayName("[CourseDay] Mock CourseDay with module agenda")
    public void canCreateCourseDayWithAgenda() {
        // given
        Content welcome      = mockWelcome();
        Content pause        = mockBreak(1);
        Content setup        = mockSetup();
        Content classes      = mockTopic("Klassen & Vererbung");
        Content polymorphism = mockTopic("Polymorphismus");

        Module module1       = mockModule(1, welcome, setup);
        Module module2       = mockModule(2, classes, polymorphism);

        CourseDay courseDay  = mockCourseDay(1, module1, pause, module2);

        // when
        String title = courseDay.getTitle();

        // then
        assertEquals("Day 1", title);

        // print
        SimplePrinter.printSimple(courseDay);
    }

    @Test
    @DisplayName("[Module] Create Mocked Module with agenda")
    public void canCreateModuleWithAgenda() {
        // given
        Content welcome      = mockWelcome();
        Content break1       = mockBreak(1);
        Content setup        = mockSetup();
        Content break2       = mockBreak(2);
        Content polymorphism = mockTopic("Polymorphismus");

        // when
        Module module = mockModule(1, welcome, break1, setup, break2, polymorphism);

        // then
        assertEquals(5, module.getAgenda().getItems().size());

        // print
        SimplePrinter.printSimple(module);
    }

    @Test
    @DisplayName("[Module] Calculate Mocked Module Duration")
    public void canGetModuleDuration() {
        // given
        Content welcome      = mockWelcome();
        Content break1       = mockBreak(1);
        Content setup        = mockSetup();
        Content break2       = mockBreak(2);
        Content polymorphism = mockTopic("Polymorphismus");

        // when
        Module module = mockModule(1, welcome, break1, setup, break2, polymorphism);

        // then
        assertEquals("PT2H15M", module.getDuration().toString());
    }

}
