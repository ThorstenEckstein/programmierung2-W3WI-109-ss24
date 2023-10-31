package de.dhbw.generics;

import de.dhbw.commons.Logger;
import de.dhbw.generics.demo.Joiner;
import de.dhbw.generics.demo.NaturalPerson;
import de.dhbw.generics.demo.Person;
import de.dhbw.generics.demo.Printer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("unused")
public class GenericsTests {

    private final Logger logger = new Logger(GenericsTests.class);

    @Test
    public void canUseGenericClassWithString() {
        // given
        Joiner<String> joiner = new Joiner<>();

        Collection<String> strings = new TreeSet<>();
        strings.add("A");
        strings.add("B");
        strings.add("C");

        // when
        String joined = joiner.join(strings);

        // then
        assertEquals("[A, B, C]", joined);
    }

    @Test
    public void canUseGenericClassWithBooleans() {
        // given
        Joiner<Boolean> joiner = new Joiner<>();

        Collection<Boolean> booleans = new Vector<>();
        booleans.add(Boolean.TRUE);
        booleans.add(Boolean.FALSE);
        booleans.add(Boolean.TRUE);

        // when
        String joined = joiner.join(booleans);

        // then
        assertEquals("[true, false, true]", joined);
    }

    @Test
    public void canUseGenericClassWithObject() {
        // given
        Joiner<Person> joiner = new Joiner<>();

        Collection<Person> people = new ArrayList<>();
        people.add(new Person("Blake"));
        people.add(new Person("Eric"));
        people.add(new Person("Anna"));

        // when
        String joined = joiner.join(people);

        // then
        assertEquals("[Blake, Eric, Anna]", joined);
    }

    @Test
    public void canUseGenericMethod() {
        // given
        Printer printer = new Printer();

        // when
        String output1 = printer.print("String");
        String output2 = printer.print(1827.08);
        String output3 = printer.print(new Person("Ronaldo"));

        // then
        assertEquals("String", output1);
        assertEquals("1827.08", output2);
        assertEquals("Ronaldo", output3);
    }

    @Test
    public void canUseBoundedGenericMethod() {
        // given
        Printer printer = new Printer();

        Person person1 = new Person("Messi");
        Person person2 = new NaturalPerson("Ronaldo");
        String person3 = "Neymar";

        // when
        String output1 = printer.format(person1);
        String output2 = printer.format(person2);
        //String output3 = printer.format(person3);

        // then
        assertEquals("Messi", output1);
        assertEquals("NaturalPerson: Ronaldo", output2);
    }

}