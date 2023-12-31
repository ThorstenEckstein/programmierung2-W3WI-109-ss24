package de.dhbw.planning;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.Duration;

import static de.dhbw.planning.MockFactory.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PlanningTest {

    private ResourceManager resourceManager;

    @BeforeEach
    void setUp() {
        this.resourceManager = new ResourceManager();
    }

    /*
     * -------------------------- Course Tests
     */

    @Test
    @DisplayName("[Course] LV ohne Agenda")
    public void canCreateCourseWithAgenda() {
        // given
        Course course = mockCourse("Programmierung II mit Java", Semester.WS24);

        // when
        String title = course.getTitle();

        // then
        assertEquals("Programmierung II mit Java", title);

        // print
        PlanningPrinter.printSimple(course);
    }

    @Test
    @DisplayName("[Course] Einlesen von Daten einer (Beispiel-) LV in das Objektmodell")
    public void canReadCourseJson() throws IOException {
        // given
        Course course;

        // when
        course = resourceManager.readCourse(FileResource.Prog2WithJava_Input);

        // then
        assertNotNull(course);
    }

    @Test
    @DisplayName("[Course] Einlesen der echten LV-Daten für WS 24")
    public void canReadRealCourseJson() throws IOException {
        // given
        Course course;

        // when
        course = resourceManager.readCourse(FileResource.Prog2WithJava_Input_JustCourseDay);

        // then
        assertNotNull(course);
    }

    @Test
    @DisplayName("[Course] Einlesen und direkt wieder Schreiben einer LV")
    public void canReadAndWriteCourseJson() throws IOException {
        // given
        Course course;

        // when
        course = resourceManager.readCourse(FileResource.Prog2WithJava_Input);

        // then
        assertNotNull(course);

        // write again
        resourceManager.writeCourse(FileResource.Prog2WithJava_Output, course);
    }

    @Test
    @DisplayName("[Course] Schreiben einer LV in eine json Datei")
    public void canWriteCourseJson() throws IOException {
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

        /*
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

        Course course = mockCourse("Programmierung II mit Java", Semester.WS24, day1, day2);
        */

        // when
        Course course = mockCourse("Programmierung II mit Java", Semester.WS24, day1);

        // then - dump to json
        resourceManager.writeCourse(FileResource.MockModel_Input, course);
    }

    @Test
    @DisplayName("[Course] Dauer einer LV")
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
        PlanningPrinter.printSimple(course);
    }

    /*
     * -------------------------- LV-Tag (CourseDay) Tests
     */

    @Test
    @DisplayName("[CourseDay] LV-Tag ohne Agenda")
    public void canCreateCourseDayWithoutAgenda() {
        // given
        CourseDay courseDay = mockCourseDay(1);

        // when
        String title = courseDay.getTitle();

        // then
        assertEquals("Day 1", title);

        // print
        PlanningPrinter.printSimple(courseDay);
    }

    @Test
    @DisplayName("[CourseDay] LV-Tag mit Agenda")
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
        PlanningPrinter.printSimple(courseDay);
    }

    @Test
    @DisplayName("[CourseDay] Dauer eines LV-Tages")
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

    /*
     * -------------------------- Module Tests
     */

    @Test
    @DisplayName("[Module] Modul ohne Agenda")
    public void canCreateModuleWithoutAgenda() {
        // given
        Module module = mockModule(1);

        // when
        String directory = module.getDirectory();

        // then
        assertEquals("module-1", directory);

        // print
        PlanningPrinter.printSimple(module);
    }

    @Test
    @DisplayName("[Module] Modul mit Agenda")
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
        PlanningPrinter.printSimple(module);
    }

    @Test
    @DisplayName("[Module] Dauer eines Moduls")
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

    /*
     * -------------------------- Content Tests
     */

    @Test
    @DisplayName("[Content] Inhaltselement (Default)")
    public void canCreateContent() {
        // given
        Content content = mockContent(1);

        // when
        ContentType contentType = content.getContentType();

        // then
        assertEquals(ContentType.Unknown, contentType);

        // print
        PlanningPrinter.printSimple(content);
    }

    @Test
    @DisplayName("[Content] Dauer eines Inhaltselements (Default)")
    public void canGetContentDuration() {
        // given
        Content content = mockContent(1);

        // when
        Duration duration = content.getDuration();

        // then
        assertEquals("PT0S", duration.toString());
    }

}
