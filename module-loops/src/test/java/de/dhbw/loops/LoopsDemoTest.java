package de.dhbw.loops;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("unused")
public class LoopsDemoTest {

    @Test
    @DisplayName("Demo 1: for loop")
    public void demo1() {
        // given

        // when
        for (int i = 0; i < 5; i++) {
            System.out.println("For-Loop: i = " + i);
        }

        // then
    }

    @Test
    @DisplayName("Demo 2: do while loop")
    public void demo2() {
        // given
        int i = 0;

        // when ( mind. 1 Ausführung von do {...} )
        do {
            System.out.println("Do-While-Loop: i = " + i++);
        } while (i < 5);

        // then
        assertEquals(5, i);
    }

}