package de.dhbw.enums;

import de.dhbw.commons.Logger;
import de.dhbw.enums.demo.Color;
import de.dhbw.enums.demo.FoodGroup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("unused")
public class EnumsTest {

    private final Logger logger = new Logger(EnumsTest.class);

    @Test
    @DisplayName("Demo 1: Simple enums methods")
    public void demo1() {
        // given
        Color red = Color.Unknown;

        // when
        String palette = red.getPalette();

        // then
        assertEquals("RGB", palette);
    }

    @Test
    @DisplayName("Demo 2: Using switch statements, but ...")
    public void demo2() {
        // given
        Color red = Color.Red;

        // when
        Color mixedColor = red.mix(Color.Green);

        // then
        assertEquals(Color.Brown, mixedColor);
    }

    @Test
    @DisplayName("Demo 3: Enhanced enums")
    public void demo3() {
        // given
        FoodGroup foodGroup; // = FoodGroup.Sonstiges;

        // when
        foodGroup = FoodGroup.from("Süßwaren");

        // then
        assertEquals(FoodGroup.Suesswaren, foodGroup);
    }

}