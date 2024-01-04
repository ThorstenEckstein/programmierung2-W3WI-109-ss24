package de.dhbw.planning;

import de.dhbw.planning.model.Course;
import de.dhbw.planning.model.Semester;
import de.dhbw.planning.print.SimplePrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static de.dhbw.planning.MockFactory.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PlanningBaseTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("[Course] Create Mock-Course without agenda")
    public void canCreateCourseWithAgenda() {
        // given
        Course course = mockCourse("Programmierung II mit Java", Semester.WS24);

        // when
        String title = course.getTitle();

        // then
        assertEquals("Programmierung II mit Java", title);

        // print
        SimplePrinter.printSimple(course);
    }

}
