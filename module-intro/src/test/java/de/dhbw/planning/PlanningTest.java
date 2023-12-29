package de.dhbw.planning;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlanningTest {

    private Course course;

    @BeforeEach
    void setUp() {
        this.course = MockFactory.mockCourse(
                "Programmierung II mit Java",
                Semester.WS24,
                null
        );
    }

    @Test
    public void canCreateBasicCourse() {
        // given - done in setUp()

        // when
        String title = course.getTitle();

        // then
        assertEquals("Programmierung II mit Java", title);
    }

    @Test
    public void canCreateModuleAgenda() {
        // given
        Module module = Module.of(2, "Klassen, Vererbung & Polymorphismus", "module-classes");
        Agenda agenda = MockFactory.mockModuleAgenda();

        // when
        module.setAgenda(agenda);
        AgendaPrinter.print(module.getAgenda());

        // then
        assertEquals("PT1H", module.getDuration().toString());
    }

    @Test
    public void canCreateCourseDayAgenda() {
        // given
        CourseDay courseDay = new CourseDay();
        Agenda agenda = MockFactory.mockCourseDayAgenda();

        // when
        courseDay.setAgenda(agenda);

        // then
        AgendaPrinter.print(courseDay.getAgenda());
    }

    @Test
    public void canCreateCourseAgenda() {
        // given
        Agenda agenda = MockFactory.mockCourseAgenda();

        // when
        course.setAgenda(agenda);

        // then
        AgendaPrinter.print(course.getAgenda());
    }

    @Test
    public void canSumDuration() {
        // given

        // when

        // then
    }

}
