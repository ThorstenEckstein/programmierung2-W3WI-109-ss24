package de.dhbw.planning;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static de.dhbw.planning.PlanningUtil.*;
import static de.dhbw.planning.ContentType.*;

public class PlanningTest {

    private String courseTitle;
    private Semester semester;
    private Set<CourseDay> courseDays = new HashSet<>();

    @BeforeEach
    void setUp() {
        this.courseTitle  = "Programmierung II mit Java";
        this.semester     = Semester.WS24;
    }

    @Test
    public void canCreateBasicCourse() {
        // given
        Course course = Course.of(
                courseTitle,
                semester,
                courseDays
        );

        // when
        String title = course.getTitle();

        // then
        assertEquals("Programmierung II mit Java", title);
    }

    @Test
    public void canCreateCourseAgenda() {
        // given
        Agenda agenda = new Agenda();

        // mix of module and content!
        Module mod1 = Module.of(
                1,
                "Welcome & Setup",
                "module-intro");
        Content con = Content.of(
                Break,
                DURATION_15_MIN,
                "Pause",
                false);
        Module mod2 = Module.of(
                2,
                "Klassen, Vererbung & Polymorphismus",
                "module-classes");

        agenda.addItem(mod1);
        agenda.addItem(con);
        agenda.addItem(mod2);

        // when
        CourseDay courseDay = new CourseDay();
        courseDay.setAgenda(agenda);

        // then
        AgendaPrinter.print(courseDay.getAgenda());
    }

    @Test
    public void canCreateModuleAgenda() {
        // given
        Agenda agenda = new Agenda();

        Content c1 = Content.of(
                Welcome,
                DURATION_15_MIN,
                "Herzlich Willkommen",
                false);
        Content c2 = Content.of(
                Domain,
                DURATION_15_MIN,
                "Fachlicher Schwerpunkt der Lehrveranstaltung",
                false);
        Content c3 = Content.of(
                Setup,
                DURATION_15_MIN,
                "IDE Setup",
                false);
        Content c4 = Content.of(
                Topic,
                DURATION_15_MIN,
                "Projektverwaltung mit Maven",
                false);

        agenda.addItem(c1);
        agenda.addItem(c2);
        agenda.addItem(c3);
        agenda.addItem(c4);

        // when
        Module module = Module.of(2, "Klassen, Vererbung & Polymorphismus","module-classes");
        module.setAgenda(agenda);

        // then
        AgendaPrinter.print(module.getAgenda());
    }

}
