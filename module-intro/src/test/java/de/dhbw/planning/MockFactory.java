package de.dhbw.planning;

import java.time.Duration;
import java.util.Set;

import static de.dhbw.planning.ContentType.*;
import static de.dhbw.planning.PlanningUtil.DURATION_15_MIN;

public class MockFactory {

    public static Course mockCourse(String title, Semester semester, Agenda agenda) {
        return Course.of(
                title,
                semester,
                agenda
        );
    }

    public static CourseDay mockCourseDay(String... titleElements) {
        CourseDay courseDay = new CourseDay();
        String title = String.join(",", titleElements);
        courseDay.setTitle(title);
        courseDay.setAgenda(null);
        return courseDay;
    }

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

}
