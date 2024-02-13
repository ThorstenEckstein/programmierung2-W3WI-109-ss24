package de.dhbw.demo.composition;

public class Life {

    public static Person birth(String name) {
        return new Person(name);
    }

    public static void death(Person p) {
        p.deletePassport();
        p = null;
    }
}
