package de.dhbw.demo;

import de.dhbw.demo.objectcontract.Passenger;
import de.dhbw.demo.objectcontract.Train;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ObjectContractDemoTest {

    //tag::object-contract-1[]
    @Test
    @DisplayName("Demo 1: Instances Not Equal")
    public void cannotCommitEqualInstances() {
        // given
        Passenger passenger1 = new Passenger("Brad Pitt");
        Passenger passenger2 = new Passenger("Brad Pitt");

        // when
        boolean areEqual = passenger1.equals(passenger2);

        // then
        assertFalse(areEqual);
        System.out.printf(
                "%s != %s%n",
                passenger1.hashCode(),
                passenger2.hashCode());
    }
    //end::object-contract-1[]

    //tag::object-contract-2[]
    @Test
    @DisplayName("Demo 2: Instance Equality")
    public void canCommitEqualInstances() {
        // given
        Train train1 = new Train("RB-10");
        Train train2 = new Train("RB-10");

        // when
        boolean areEqual = train1.equals(train2);

        // then
        assertTrue(areEqual);
        System.out.printf(
                "%s == %s%n",
                train1.hashCode(),
                train2.hashCode());
    }
    //end::object-contract-2[]

}