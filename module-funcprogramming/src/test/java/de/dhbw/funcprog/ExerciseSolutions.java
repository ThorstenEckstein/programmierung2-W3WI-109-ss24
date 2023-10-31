package de.dhbw.funcprog;

import de.dhbw.commons.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ExerciseSolutions {

    private final Logger logger = new Logger(ExerciseSolutions.class);

    @Test
    @DisplayName("Exercise 1 - loop with lambda")
    public void exercise2Solution() {
        // given
        List<Boolean> list = List.of(true,false,true,false);

        // when
        list.stream().forEach(item -> System.out.println(item));
        // list.forEach(System.out::println);

        // then - nothing to assert here
    }

    @Test
    @DisplayName("Übung 2a: Calculate a total in old fashioned way")
    public void exercise2a() {
        // given - a list of at least 10 random Integers
        List<Double> list = List.of(1.0, 34.9, 34.23, 47.11);

        // when - loop over the list and calculate the total
        double sum = 0.0;

        for (Double value : list) {
            sum += value;
        }

        // then - assert the correct total
        assertEquals(117.24, sum);
    }

    @Test
    @DisplayName("Übung 2b: Calculate a total the modern way")
    public void exercise2b() {
        // given - a list of at least 10 random Integers
        List<Double> list = List.of(1.0, 34.9, 34.23, 47.11);

        // when - loop over the list and calculate the total (3 variants)
        double sum1 = list.stream().reduce(0.0 , (val1, val2) -> val1 + val2);
        double sum2 = list.stream().mapToDouble(d -> d.doubleValue()).sum();
        double sum3 = list.stream().mapToDouble(Double::doubleValue).sum();

        // then - assert the correct total
        assertEquals(117.24, sum1);
        assertEquals(117.24, sum2);
        assertEquals(117.24, sum3);
    }

}