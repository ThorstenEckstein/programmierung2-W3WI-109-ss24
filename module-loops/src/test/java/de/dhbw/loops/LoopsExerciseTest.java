package de.dhbw.loops;

import de.dhbw.commons.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class LoopsExerciseTest {

    private final Logger logger = new Logger(LoopsExerciseTest.class);

    @Test
    @DisplayName("Exercise 1: Finde die größte Zahl in der Liste mithilfe einer for Schleife")
    public void exercise1() {
        // given
        List<Integer> numbers = List.of(2,5,3,8,65,4);

        // when

        // then
    }

    @Test
    @DisplayName("Exercise 2: While-Schleife, ein CountDown")
    public void exercise2() {
        // given
        int countdown = 10;

        // when

        // then
    }

}