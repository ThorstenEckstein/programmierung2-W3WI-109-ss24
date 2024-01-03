package de.dhbw.planning;

import java.time.Duration;
import java.time.LocalDate;

import static de.dhbw.planning.ContentType.*;
import static de.dhbw.planning.Constants.*;

public class MockFactory {

    /*
     * ----------------------- Course
     */

    public static Course mockCourse(String title, Semester semester) {
        return new Course(
                title,
                semester
        );
    }

    public static Course mockCourse(String title, Semester semester, CourseDay... days) {
        Course course = new Course(title, semester);
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
        courseDay.setDate(LocalDate.of(2024, 2, counter * 7));

        return courseDay;
    }

    public static CourseDay mockCourseDay(int counter, Item... agendaItems) {
        CourseDay courseDay = new CourseDay();
        courseDay.setTitle("Day " + counter);
        courseDay.setDate(LocalDate.of(2024, 2, counter * 7));
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
        return new Module(
                counter,
                "Modul " + counter,
                "module-" + counter,
                null
        );
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
        return new Content(
                Unknown,
                Duration.ZERO,
                "Content description " + counter,
                Modules.Unknown,
                false);
    }

    public static Content mockContent(ContentType contentType, Duration duration, Modules module, String description) {
        return new Content(
                contentType,
                duration,
                description,
                module,
                false);
    }

    public static Content mockWelcome() {
        return new Content(
                Welcome,
                DURATION_30_MIN,
                "Herzlich Willkommen!",
                Modules.WelcomeIntroAndSetup,
                false);
    }

    public static Content mockSetup() {
        return new Content(
                Setup,
                DURATION_30_MIN,
                "Technisches IDE Setup",
                Modules.WelcomeIntroAndSetup,
                false);
    }

    public static Content mockDomain() {
        return new Content(
                Domain,
                DURATION_15_MIN,
                "Fachliche Einführung",
                Modules.WelcomeIntroAndSetup,
                false);
    }

    public static Content mockTopic(String about) {
        return new Content(
                Topic,
                DURATION_45_MIN,
                "Thema/Inhalt '" + about + "'",
                Modules.Unknown,
                false);
    }

    public static Content mockDemo(String about) {
        return new Content(
                Demo,
                DURATION_15_MIN,
                "Demo zum Thema/Inhalt '" + about + "'",
                Modules.Unknown,
                false);
    }

    public static Content mockExercise(String about) {
        return new Content(
                Exercise,
                DURATION_30_MIN,
                "Demo zum Thema/Inhalt '" + about + "'",
                Modules.Unknown,
                false);
    }

    public static Content mockBreak(int number) {
        return new Content(
                Break,
                DURATION_15_MIN,
                "Pause " + number,
                Modules.Miscellaneous,
                false);
    }

}