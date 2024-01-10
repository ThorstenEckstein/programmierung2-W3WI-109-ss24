package de.dhbw.demo;

import de.dhbw.demo.collections.n.*;
import de.dhbw.demo.collections.nm.v2.Course;
import de.dhbw.demo.collections.nm.v2.Registration;
import de.dhbw.demo.collections.nm.v2.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class RelationsDemoTest {

    @Test
    @DisplayName("Demo: Einfache Assoziation")
    public void oneToOne() {
        // given
        Person person = new Person("Olaf");
        Passport passport = new Passport("sjw73h73hdkf8");

        // when
        person.setPassport(passport);
        person.deletePassport();

        // then
        assertNull(person.getPassport());
    }

    @Test
    public void oneToMany1() {
        // given
        Train1 train1 = new Train1();

        // when
        train1.addWagon(new Wagon1());
        train1.addWagon(new Wagon1());

        // then
        assertEquals(2, train1.wagons.size());
    }

    @Test
    public void oneToMany2() {
        // given
        Train2 train2 = new Train2();

        Wagon2 wagon2a = new Wagon2();
        Wagon2 wagon2b = new Wagon2();

        // Woher weiß der Wagon nun, zu welchem Zug er gehört?
        // Was muss gemacht werden, um dies sicherzustellen?

        // when
        train2.addWagon(wagon2a);
        train2.addWagon(wagon2b);

        // then
        assertEquals(2, train2.wagons.size());
    }

    @Test
    public void manyToMany() {
        // given
        Course course = new Course();
        course.id = 2023001L;

        Course course2 = new Course();
        course2.id = 2023002L;

        Student alex = new Student();
        alex.id = 1L;

        Student dana = new Student();
        dana.id = 2L;

        Registration reg1 = new Registration();
        Registration reg2 = new Registration();
        Registration reg3 = new Registration();

        // when
        reg1.courseId = course.id;
        reg1.studentId = dana.id;
        reg1.registrationDate = LocalDate.now();

        reg2.courseId = course.id;
        reg2.studentId = alex.id;
        reg2.registrationDate = LocalDate.now();

        reg3.courseId = course2.id;
        reg3.studentId = alex.id;
        reg3.registrationDate = LocalDate.now();

        // then
        // no asserts here, just for demonstration
        System.out.println(reg1);
        System.out.println(reg2);
        System.out.println(reg3);
    }

}