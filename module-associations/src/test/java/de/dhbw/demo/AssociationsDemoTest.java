package de.dhbw.demo;

import de.dhbw.demo.associations.n.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class AssociationsDemoTest {

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

}