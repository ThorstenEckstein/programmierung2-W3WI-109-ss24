package de.dhbw.funcprog;

import de.dhbw.commons.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ExerciseTests {

    private final Logger logger = new Logger(ExerciseTests.class);

    @BeforeEach
    public void beforeEach() { }

    @Test
    @DisplayName("Exercise 1: Loop with Streams & Lambda")
    public void exercise2Solution() {
        // given - some list with boolean values

        // when - use list.stream() and some lambda expression
        //        to log each list item to console

        // then - nothing here
    }

    //tag::old-fashioned-reduce[]
    @Test
    @DisplayName("Übung 2a: Calculate a total in old fashioned way")
    public void exercise2a() {
        // given - a list of min. 5 arbitrary Integers

        // when - iterate over the list and calculate the total
        // for ( ... : ... ) { ... }

        // then - assert the correct total
    }
    //end::old-fashioned-reduce[]

    //tag::modern-reduce[]
    @Test
    @DisplayName("Übung 2b: Calculate a total the modern way")
    public void exercise2b() {
        // given - a list of min. 5 arbitrary Doubles

        // when - loop over the list and calculate the total

        // then - assert the correct total
    }
    //end::modern-reduce[]

    @Test
    @DisplayName("Übung 3: Filter & reduce a shopping cart, calculate total price")
    public void exercise3() {
        // given - use created shopping cart from above beforeEach()

        // when - step 1: filter your shopping cart for products for some 'category'
        // when - step 2: reduce your shopping cart by summing product prices

        // then - assert the correct total price
    }

}