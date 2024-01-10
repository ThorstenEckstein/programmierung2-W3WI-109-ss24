package de.dhbw.demo;

import de.dhbw.demo.associations.n.*;
import de.dhbw.demo.associations.nm.v2.Course;
import de.dhbw.demo.associations.nm.v2.Registration;
import de.dhbw.demo.associations.nm.v2.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class AssociationsDemoTest {

    @Test
    @DisplayName("Demo 1: 1:1 Assoziation")
    public void demo1() {
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
    @DisplayName("Demo 2a: 1:n Assoziation")
    public void demo2a() {
        // given
        Train1 train1 = new Train1();

        // when
        train1.addWagon(new Wagon1());
        train1.addWagon(new Wagon1());

        // then
        assertEquals(2, train1.wagons.size());
    }

    @Test
    @DisplayName("Demo 2b: 1:n Assoziation")
    public void demo2b() {
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
    @DisplayName("Demo 3: n:m Assoziation")
    public void demo3() {
        // given
        Course course = new Course();
        course.id = 2024001L;

        Course course2 = new Course();
        course2.id = 2024002L;

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