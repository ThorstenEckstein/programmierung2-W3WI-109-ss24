package de.dhbw.demo;

import de.dhbw.demo.collections.nm.v1.Student;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("DataFlowIssue")
public class CollectionsDemoTest {

    @Test
    @DisplayName("Demo 1: Eine einfache Liste mit 'primitiven' Werten")
    public void demo1() {
        // given
        List<String> list = new ArrayList<>();

        // when
        list.add("A");
        list.add(0, "B");
        list.addAll(List.of("C","D"));

        // then
        assertEquals(4, list.size());
        assertEquals("[B, A, C, D]", list.toString());
    }

    @Test
    @DisplayName("Demo 2: Eine einfache Liste mit 'komplexen' Werten (Objektinstanzen)")
    public void demo2() {
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

    @Test
    @DisplayName("Demo 3: Key-Value-Paare mit Maps")
    public void demo3() {
        // given
        // <KEY   , VALUE>
        Map<String, Double> map = new HashMap<>();

        // when
        map.put("a", 123.45);

        // then
        assertEquals(123.45, map.get("a"));
    }

    @Test
    @DisplayName("Demo 4: Un-/Sortierte Map")
    public void demo4() {
        // given
        Map<String, Double> map = new LinkedHashMap<>();
        //Map<String, Double> map = new TreeMap<>();

        // when
        map.put("c", 300.0);
        map.put("a", 100.0);
        map.put("b", 200.0);

        System.out.println(map.getClass().getSimpleName() + ": " + map);

        // then
        assertEquals(3, map.size());
    }

    @Test
    @DisplayName("Demo 5a: Un-/Modifiable Lists")
    public void demo5a() {
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
    @DisplayName("Demo 5b: Un-/Modifiable Lists (alternative Implementierung)")
    public void demo5b() {
        // given - siehe Test vorher, nur anders implementiert!
        List<String> unmodifiableList = List.of("A", "B", "C");

        // when & then
        assertThrows(UnsupportedOperationException.class, () -> {
            unmodifiableList.add("D");
        });
    }


    // ACTIVATE TO DEMONSTRATE EQUALS IN COURSE:
    @Test
    @Disabled
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

    //tag::synchronized-list[]
    //@Test
    public void demo6() {
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