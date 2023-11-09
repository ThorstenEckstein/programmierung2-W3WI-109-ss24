package de.dhbw.basics;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import de.dhbw.demo.visibility.VisibilityExampleClass;
import de.dhbw.commons.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BasicsTest {

    private final Logger logger = new Logger(BasicsTest.class);

    //tag::classes-and-instances[]
    @Test
    @DisplayName("Demo 1: Klassen instanziieren")
    public void canInstantiateClass() {
        // given

        // when

        // then
    }
    //end::classes-and-instances[]

    //tag::visibility[]
    @Test
    @DisplayName("Demo 3: Sichtbarkeiten")
    public void canCheckVisibility() {
        // given
        VisibilityExampleClass someClass = new VisibilityExampleClass();

        // What is the reason for fields A, C and D being not accessible?

        //someClass.fieldA
        someClass.fieldB = "some value for field B";
        //someClass.fieldC
        //someClass.fieldD

        // when
        String fieldBValue = someClass.fieldB;

        // then
        assertNotNull(fieldBValue);
    }
    //end::visibility[]

}
