package de.dhbw.planning;

import java.time.Duration;

import static de.dhbw.planning.ContentType.*;
import static de.dhbw.planning.PlanningUtil.*;

public class MockFactory {

    /*
     * ----------------------- Course
     */

    public static Course mockCourse(String title, Semester semester) {
        return Course.of(
                title,
                semester
        );
    }

    public static Course mockCourse(String title, Semester semester, CourseDay... days) {
        Course course = Course.of(title, semester);
        Agenda agenda = new Agenda();

        for (CourseDay day : days) {
            agenda.addItem(day);
        }
        course.setAgenda(agenda);

        return course;
    }

    /*
     * ----------------------- CourseDay
     */

    public static CourseDay mockCourseDay(int counter) {
        CourseDay courseDay = new CourseDay();
        courseDay.setTitle("Day " + counter);

        return courseDay;
    }

    public static CourseDay mockCourseDay(int counter, Item... agendaItems) {
        CourseDay courseDay = new CourseDay();
        courseDay.setTitle("Day " + counter);
        Agenda agenda = new Agenda();

        for (Item item : agendaItems) {
            agenda.addItem(item);
        }
        courseDay.setAgenda(agenda);

        return courseDay;
    }

    /*
     * ----------------------- Module
     */

    public static Module mockModule(int counter) {
        return Module.of(
                counter,
                "Modul " + counter,
                "module-" + counter);
    }

    public static Module mockModule(int counter, Content... agendaItems) {
        Module module = mockModule(counter);
        Agenda agenda = new Agenda();

        for (Content content : agendaItems) {
            agenda.addItem(content);
        }
        module.setAgenda(agenda);

        return module;
    }

    /*
     * ----------------------- Content
     */

    public static Content mockContent(int counter) {
        return Content.of(
                Unknown,
                Duration.ZERO,
                "Content description " + counter,
                false);
    }

    public static Content mockContent(ContentType contentType, Duration duration, String description) {
        return Content.of(
                contentType,
                duration,
                description,
                false);
    }

    public static Content mockWelcome() {
        return Content.of(
                Welcome,
                DURATION_30_MIN,
                "Herzlich Willkommen!",
                false);
    }

    public static Content mockSetup() {
        return Content.of(
                Setup,
                DURATION_30_MIN,
                "Technisches IDE Setup",
                false);
    }

    public static Content mockDomain() {
        return Content.of(
                Domain,
                DURATION_15_MIN,
                "Fachliche Einführung",
                false);
    }

    public static Content mockTopic(String about) {
        return Content.of(
                Topic,
                DURATION_45_MIN,
                "Thema/Inhalt '" + about + "'",
                false);
    }

    public static Content mockDemo(String about) {
        return Content.of(
                Demo,
                DURATION_15_MIN,
                "Demo zum Thema/Inhalt '" + about + "'",
                false);
    }

    public static Content mockExercise(String about) {
        return Content.of(
                Exercise,
                DURATION_30_MIN,
                "Demo zum Thema/Inhalt '" + about + "'",
                false);
    }

    public static Content mockBreak(int number) {
        return Content.of(
                Break,
                DURATION_15_MIN,
                "Pause " + number,
                false);
    }

    /*
    public static Module mockModule(int index, String title, String directory) {
        return Module.of(
                index,
                title,
                directory);
    }

    public static Content mockContent(ContentType contentType, Duration duration, String description, boolean completed) {
        return Content.of(
                contentType,
                duration,
                description,
                completed);
    }

    public static Agenda mockCourseAgenda() {
        Agenda agenda = new Agenda();

        CourseDay cd1 = mockCourseDay("Willkommen", "Setup", "Klassen", "Vererbung", "Polymorphismus");
        CourseDay cd2 = mockCourseDay("Interfaces", "abstrakte Klassen", "Visibility", "Code Generierung");
        CourseDay cd3 = mockCourseDay("Datentypen", "Operatoren", "Kontrollstrukturen");
        CourseDay cd4 = mockCourseDay("A", "B");

        agenda.addItem(cd1);
        agenda.addItem(cd2);
        agenda.addItem(cd3);
        agenda.addItem(cd4);

        return agenda;
    }

    public static Agenda mockCourseDayAgenda() {
        Agenda agenda = new Agenda();

        // mix of module and content!
        Module mod1 = mockModule(
                1,
                "Welcome & Setup",
                "module-intro");
        Content con = mockContent(
                Break,
                DURATION_15_MIN,
                "Pause",
                false);
        Module mod2 = mockModule(
                2,
                "Klassen, Vererbung & Polymorphismus",
                "module-classes");

        agenda.addItem(mod1);
        agenda.addItem(con);
        agenda.addItem(mod2);

        return agenda;
    }

    public static Agenda mockModuleAgenda() {
        Agenda agenda = new Agenda();

        Content c1 = mockContent(
                Welcome,
                DURATION_15_MIN,
                "Herzlich Willkommen",
                false);
        Content c2 = mockContent(
                Domain,
                DURATION_15_MIN,
                "Fachlicher Schwerpunkt der Lehrveranstaltung",
                false);
        Content c3 = mockContent(
                Setup,
                DURATION_15_MIN,
                "IDE Setup",
                false);
        Content c4 = mockContent(
                Topic,
                DURATION_15_MIN,
                "Projektverwaltung mit Maven",
                false);

        agenda.addItem(c1);
        agenda.addItem(c2);
        agenda.addItem(c3);
        agenda.addItem(c4);

        return agenda;
    }
    */

}
