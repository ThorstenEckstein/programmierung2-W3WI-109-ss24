package de.dhbw.demo;

import de.dhbw.demo.collections.nm.v1.Student;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("DataFlowIssue")
public class CollectionsDemoTest {

    @Test
    public void testASimpleListExample() {
        // given
        List<Student> students = new ArrayList<>();
        Student s1 = new Student("Michaela");
        Student s2 = new Student("Alexander");
        Student s3 = new Student("Henrik");

        // when
        students.add(s1);
        students.add(s2);
        students.add(s3);

        System.out.println("Before removal: " + students);

        // Wird das funktionieren? Wenn ja, warum? wenn nein, warum nicht?
        students.remove(s2);

        System.out.println("After removal:  " + students);

        // then
        assertEquals(2, students.size());
    }

    // ACTIVATE TO DEMONSTRATE EQUALS IN COURSE:
    //@Test
    public void testASimpleListExampleWithEquals() {
        // given
        List<Student> students = new ArrayList<>();
        Student s1 = new Student("Michaela");
        Student s2 = new Student("Alexander");
        Student s3 = new Student("Henrik");

        Student theGuyNamedAlex = new Student("Alexander");

        // when
        students.add(s1);
        students.add(s2);
        students.add(s3);

        System.out.println("Before removal: " + students);

        // Wird das funktionieren? Wenn ja, warum? wenn nein, warum nicht?
        students.remove(theGuyNamedAlex);

        System.out.println("After removal:  " + students);

        // then
        assertEquals(2, students.size());
    }

    @Test
    public void cannotModifyCollection1() {
        // given - die ausführliche Variante
        List<String> modifiableList = new ArrayList<>();
        modifiableList.add("A");
        modifiableList.add("B");
        modifiableList.add("C");

        List<String> unmodifiableList = Collections.unmodifiableList(modifiableList);

        boolean addedToModifiable = false;
        boolean addedToUnmodifiable = false;

        // when
        try {

            addedToModifiable = modifiableList.add("D");
            addedToUnmodifiable = unmodifiableList.add("D");

        } catch (UnsupportedOperationException uoe) {
            // ignore exception, just to demonstrate 'unmodifiable'
        }

        // then
        assertTrue(addedToModifiable, "D successfully added!");
        assertFalse(addedToUnmodifiable, "D not added, modification denied!");
    }

    @Test
    public void cannotModifyCollection2() {
        // given - siehe Test vorher, nur etwas anders implementiert!
        List<String> unmodifiableList = List.of("A", "B", "C");

        // when & then
        assertThrows(UnsupportedOperationException.class, () -> {
            unmodifiableList.add("D");
        });
    }

    // Später, Kurs 4
    //tag::synchronized-list[]
    @Test
    public void canSynchronizeCollection() {
        // given
        List<String> unsyncedList = new ArrayList<>();
        unsyncedList.add("E1");
        unsyncedList.add("E2");
        unsyncedList.add("E3");

        // when
        List<String> syncedList = Collections.synchronizedList(unsyncedList);

        // Iterieren über die Liste, aber ...
        Iterator<String> i = syncedList.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }

        /*
        // Iteration must be in synchronized block
        synchronized (syncedList) {
            Iterator<String> i = syncedList.iterator();
            while (i.hasNext()) {
                logger.log(i.next());
            }
        }
        */

        // then
        // no assertion, just to demonstrate 'synchronized'
    }
    //end::synchronized-list[]

}