package de.dhbw.semantics;

import de.dhbw.commons.Logger;
import de.dhbw.semantics.demo.Account;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("unused")
public class SemanticTests {

    private final Logger logger = new Logger(SemanticTests.class);

    private static class Person {
        public String name;
    }

    // ------------------------------------------------------------- Wertsemantik

    @SuppressWarnings("ReassignedVariable")
    private static void square(int number) {
        number *= number;
    }

    @Test
    @DisplayName(
            """
            Wertsemantik mit Primitiven:
            Pass by Value: In the pass by value concept, the method is called by passing a value. The argument
            is a copy of the original one. This is called 'pass by value'. It does not affect the original parameter.
            """)
    //tag::ref-semantics-prim[]
    public void demo1() {
        // given - a primitive value
        int number = 10;

        // when
        logger.log("Before square : " + number);
        square(number);
        logger.log("After square  : " + number);

        // then
        assertEquals(10, number);
    }
    //end::ref-semantics-prim[]


    // ------------------------------------------------------------- Referenzsemantik (1 von 2)

    private static void renameForDemo2(Person person, String name) {
        person.name = name;
    }

    @Test
    @DisplayName(
            """
            Referenzsemantik mit Objekten:
            Although the argument variable is copied, just the reference is copied. The object that is referenced
            is still the same and thus changed here!
            """
    )
    //tag::ref-semantics-obj[]
    public void demo2() {
        // given - an object reference
        Person person = new Person();
        person.name = "Johnny Walker";

        // when
        logger.log("Before renaming : " + person.name);
        renameForDemo2(person, "Jenny Tonic");
        logger.log("After renaming : " + person.name);

        // then
        assertEquals("Jenny Tonic", person.name);
    }
    //end::ref-semantics-obj[]

    // ------------------------------------------------------------- Referenzsemantik (2 von 2)

    private static Person renameForDemo3(Person person, String name) {
        person.name = name;
        return person;
    }

    @Test
    public void demo3() {
        // given - an object reference
        Person person = new Person();
        person.name = "Johnny Walker";

        // when
        logger.log("Before renaming : " + person.name);
        person = renameForDemo3(person, "Jenny Tonic");
        logger.log("After renaming : " + person.name);

        // then
        assertEquals("Jenny Tonic", person.name);
    }







    /*
    //tag : : ref-semantics[]
    @Test
    public void canExplainReferenceSemanticsByExample() {
        // given
        Account a1 = new Account();
        assertEquals(0, a1.getAmount(), "initial amount of instance 'a1'");

        // when
        Account a2 = Account.process(a1);

        // then
        assertEquals(350, a2.getAmount(), "processed amount of (new inner) instance 'a2'");

        assertEquals(0, a1.getAmount(), "amount of instance 'a1' is still the same");
    }
    //end : : ref-semantics[]

    @Test
    @DisplayName(
            """
            Referenzsemantik mit Objekten:
            Although the argument variable is copied, just the reference is copied. The object that is referenced
            is still the same and thus changed here!
            """
    )
    //tag : : ref-semantics-obj[]
    public void canDemonstrateReferenceSemanticsWithObjects() {
        // given
        AccountManager manager = new AccountManager();
        Account account = new Account(1000);

        logger.log("Amount before deposit : "
                + account.getAmount());

        // when
        manager.depositV3(account, 300);

        // then
        logger.log("Amount after deposit  : "
                + account.getAmount());
    }
    //end : : ref-semantics-obj[]

    @Test
    @DisplayName(
            """
            Wertsemantik mit Primitiven:
             Pass by Value: In the pass by value concept, the method is called by passing a value. The argument
             is a copy of the original one. This is called 'pass by value'. It does not affect the original parameter.
            """
    )
    public void canDemonstrateReferenceSemanticsWithPrimitives() {
        // given - a primitive value
        AccountManager manager = new AccountManager();
        int amount = 2100;

        logger.log("Amount before deposit : " + amount);

        // when
        manager.depositV1(amount, 500);

        // then
        logger.log("Amount after deposit  : " + amount);
    }
    */
}