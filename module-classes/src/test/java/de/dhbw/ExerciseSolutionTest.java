package de.dhbw;

import de.dhbw.solution.classes.Train;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ExerciseSolutionTest {

    @Test
    @DisplayName(
     """
     Exercise 1:
      1. Erstelle eine neue Klasse "Train" im Paket "java/de/dhbw/exercise/classes"
      2. Erstelle in der Klasse einen parameterlosen Konstruktor
      3. Erstelle eine Klassen-Variable im Test-Abschnitt 'given'
      4. Instanziiere die Klasse im Test-Abschnitt 'when'
      5. Teste im Abschnitt 'then', ob die Klasseninstanz nicht 'null' ist
     """)
    public void exercise1() {
        // given
        Train train;

        // when
        train = new Train();

        // then
        assertNotNull(train);
    }

}
