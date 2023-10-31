package de.dhbw.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@SuppressWarnings("ConstantValue")
public class OperatorTests {

    @Test
    @DisplayName("(1) Logischer Operator: &")
    public void testOperator1() {
        // given
        boolean operand1 = true;
        boolean operand2 = false;

        // when - both are evaluated!
        boolean result = operand1 & operand2;

        // then
        System.out.printf("%s & %s -> %s", operand1, operand2, result);
    }

    @Test
    @DisplayName("(2) Logischer Operator: &")
    public void testOperator2() {
        // given
        boolean operand1 = true;
        boolean operand2 = true;

        // when - both are evaluated!
        boolean result = operand1 & operand2;

        // then
        System.out.printf("%s & %s -> %s", operand1, operand2, result);
    }

    @Test
    @DisplayName("(3) Logischer Operator: &&")
    public void testOperator3() {
        // given
        boolean operand1 = true;
        boolean operand2 = false;

        // when - both are evaluated!
        boolean result = operand1 && operand2;

        // then
        System.out.printf("%s && %s -> %s", operand1, operand2, result);
    }

    @Test
    @DisplayName("(4) Logischer Operator: &&")
    public void testOperator4() {
        // given
        boolean operand1 = false;
        boolean operand2 = true;

        // when - evaluation stops after operand1 has been evaluated to 'false'
        boolean result = operand1 && operand2;

        // then
        System.out.printf("%s && %s -> %s", operand1, operand2, result);
    }

    @Test
    @DisplayName("(5) Logischer Operator: ^")
    public void testOperator5() {
        // given
        boolean operand1 = true;
        boolean operand2 = false;

        // when - exclusive OR
        boolean result = operand1 ^ operand2;

        // then
        System.out.printf("%s ^ %s -> %s", operand1, operand2, result);
    }

}
