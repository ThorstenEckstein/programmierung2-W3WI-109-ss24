package de.dhbw.solution.classes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {

    @Test
    @DisplayName(
    """
     Erstelle die folgenden Klassen im Paket "java/de/dhbw/exercise/classes"
     1. Erstelle eine neue Klasse Zug mit einem parameterlosen Konstruktor
     2. Erstelle eine neue Klasse Fernzug mit einem parameterlosen Konstruktor
     3. Erstelle eine neue Klasse Regionalzug mit einem parameterlosen Konstruktor
     Teste, ob die Instanzen korrekt erzeugt wurden!
    """)
    public void exercise1() {
        // given
        Zug zug;
        Fernzug fernzug;
        Regionalzug regionalzug;

        // when
        zug = new Zug();
        fernzug = new Fernzug();
        regionalzug = new Regionalzug();

        // then
        assertNotNull(zug);
        assertNotNull(fernzug);
        assertNotNull(regionalzug);
    }

    @Test
    @DisplayName(
    """
    Ergänze die Klasse Zug mit einem Feld namens "number". Erzeuge eine Instanz und
    teste für die Instanz, welchen Wert dieses Feld einer Instanz hat!
    """)
    public void exercise2() {
        // given
        Zug zug;

        // when
        zug = new Zug();

        // then
        assertNull(zug.number);
        // oder auch:
        // assertEquals(null, zug.number);
    }


}
