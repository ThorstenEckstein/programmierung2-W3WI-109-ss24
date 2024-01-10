
package de.dhbw.exercise;

import de.dhbw.demo.collections.nm.v1.Course;
import de.dhbw.demo.collections.nm.v1.Student;
import de.dhbw.demo.collections.nm.v2.Registration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

/* ----------------------------------------------------------------
 * Im test-package 'exercises' bzw. in dieser Testklasse können
 * einfach eigene Tests oder Experimente geschrieben werden.
 * ------------------------------------------------------------- */

public class CollectionsExerciseTests {

    @Test
    @DisplayName("Übung 1: SortedMap")
    public void exercise1() {
        // given

        // when

        // then
    }

    @Test
    @DisplayName("Übung 2: Nutzung von IDE Code-Generation, Auto-Completion oder Refactoring-Proposals")
    public void exercise2() {
        // given

        // when

        // then
    }

    @Test
    @DisplayName("Übung 3a: Listeneinträge summieren")
    public void exercise4a() {
        // given

        // when

        // then
    }

    @Test
    @DisplayName("Übung 3b: Map mit Key-Value-Paaren & Sortierung")
    public void exercise4b() {
        // given
        TreeMap<String, String> map = new TreeMap<>();

        // when
        map.put("a", "ZZZ");
        map.put("z", "AAA");
        map.put("k", "ajfhasjkfgashjk");
        map.put("v", "asdsadas");

        // then
        System.out.println(map);
    }

    @Test
    @DisplayName("Übung 4: Assoziation mit Kurs und Student:innen")
    public void exercise5() {
        // given
        de.dhbw.demo.collections.nm.v1.Course course  = new de.dhbw.demo.collections.nm.v1.Course();
        de.dhbw.demo.collections.nm.v1.Student s1 = new de.dhbw.demo.collections.nm.v1.Student("Hans");
        de.dhbw.demo.collections.nm.v1.Student s2 = new de.dhbw.demo.collections.nm.v1.Student("Julia");

        // when
        course.getStudents().add(s1);
        course.getStudents().add(s2);

        // then
        assertEquals(2, course.getStudents().size());
    }

    @Test
    @DisplayName("Übung 5: Information Hiding durch getter & setter Methoden")
    public void exercise6() {
        // given
        Course course = new Course();
        // Course Attribut 'id' setzen

        Student alex = new Student();
        // Student Attribut 'id' setzen

        Student dana = new Student();
        // Student Attribut 'id' setzen

        Registration reg1 = new Registration();
        Registration reg2 = new Registration();

        // when
        // je Registration: Attribute setzen durch "Holen" der zuvor gesetzten Werte aus Course & Student

        // then
        System.out.println(reg1);
        System.out.println(reg2);
    }

}