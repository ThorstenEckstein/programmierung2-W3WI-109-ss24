package de.dhbw.solution;

import de.dhbw.solution.realization.Regionalzug;
import de.dhbw.solution.realization.Zug;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InterfaceSolutionTest {

    @Test
    @DisplayName("Lösung 1: Interface & Realisierung")
    public void solution1() {
        // given
        Zug zug;

        // when
        zug = new Regionalzug();
        zug.setNumber("RB 10");

        // then
        assertEquals("RB 10", zug.getNumber());
    }

}
