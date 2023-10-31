package de.dhbw.generics;

import de.dhbw.commons.Logger;
import de.dhbw.generics.solution.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ExerciseSolutions {

    private final Logger logger = new Logger(ExerciseSolutions.class);

    @Test
    @DisplayName("Exercise 1 - Calculator")
    public void exercise1Solution() {
        // given
        Calculator<Integer> integerCalculator = new IntegerCalculator();

        // when
        Number number = integerCalculator.add(2, 7);

        // then
        assertEquals(9, number);
    }

    @Test
    @DisplayName("Exercise 2 - Workflow")
    public void exercise2Solution() {
        // given
        Step step1 = new Start();
        Step step2 = new Choice();
        Step step3 = new SendEmail();

        // when
        Workflow.execute(step1);
        Workflow.execute(step2);
        Workflow.execute(step3);

        // then
    }

}
