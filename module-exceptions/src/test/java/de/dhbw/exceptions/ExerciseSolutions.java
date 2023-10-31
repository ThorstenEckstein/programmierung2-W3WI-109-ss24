package de.dhbw.exceptions;

import de.dhbw.commons.Logger;
import de.dhbw.exceptions.solution.CheckedException;
import de.dhbw.exceptions.solution.Executable;
import de.dhbw.exceptions.solution.InterruptedException;
import de.dhbw.exceptions.solution.Task;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ExerciseSolutions {

    private final Logger logger = new Logger(ExerciseSolutions.class);

    @Test
    @DisplayName("Exercise 1: Exception werfen und fangen")
    public void exercise1Solution() {
        // given
        Executable task = new Task();

        // when
        try {
            task.execute();
        } catch (CheckedException e) {
            e.printStackTrace();
        }

        // then
    }

    @Test
    @DisplayName("Exercise 1: V2 Exception werfen und fangen")
    public void exercise1Solution_v2() {
        // given
        Executable task = new Task();

        // when
        CheckedException thrown = assertThrows(InterruptedException.class, () -> {
            task.execute();
        });

        // then
        assertEquals(InterruptedException.class, thrown.getClass());
    }

}
