package de.dhbw.solution.classes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClassesSolutionTest {

    @Test
    @DisplayName(
    """
     Erstelle die folgenden Klassen im Paket "java/de/dhbw/exercise/classes"
     2. Erstelle eine neue Klasse Fernzug mit einem parameterlosen Konstruktor
     3. Erstelle eine neue Klasse Regionalzug mit einem parameterlosen Konstruktor
     Teste, ob die Instanzen korrekt erzeugt wurden!
    """)
    public void exercise1() {
        // given
        Fernzug fernzug;
        Regionalzug regionalzug;

        // when
        fernzug = new Fernzug();
        regionalzug = new Regionalzug();

        // then
        assertNotNull(fernzug);
        assertNotNull(regionalzug);
    }

    @Test
    @DisplayName(
    """
    Ergänze die Klasse Fernzug mit einem Feld namens "number". Erzeuge eine Instanz und
    teste für die Instanz, welchen Wert dieses Feld einer Instanz hat!
    """)
    public void exercise2() {
        // given
        Fernzug fernzug;

        // when
        fernzug = new Fernzug();

        // then
        assertNull(fernzug.number);
        // oder auch:
        // assertEquals(null, fernzug.number);
    }


}
