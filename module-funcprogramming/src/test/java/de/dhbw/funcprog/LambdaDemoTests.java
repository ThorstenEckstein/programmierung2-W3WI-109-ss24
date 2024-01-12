package de.dhbw.funcprog;

import de.dhbw.commons.DateTimeUtil;
import de.dhbw.commons.Logger;
import de.dhbw.funcprog.demo.Schedule;
import de.dhbw.funcprog.demo.Validator;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.function.*;

import static de.dhbw.funcprog.demo.Validator.isScheduledFor2023;
import static org.junit.jupiter.api.Assertions.*;


public class LambdaDemoTests {

    private final Logger logger = new Logger(LambdaDemoTests.class);

    @Test
    public void consumer() {
        // given
        Consumer<String> consumer = (String msg) -> {
            System.err.println(msg);
        };

        // when
        consumer.accept("[ERROR] Item not found!");

        // then
        assertNotNull(consumer);
    }

    @Test
    public void predicate() {
        // given
        Predicate<Integer> predicate = i -> (i < 18);

        // when
        boolean result = predicate.test(17);

        // then
        assertTrue(result);
    }

    @Test
    public void unaryFunction() {
        // given

        // Hier keine primitiven Datentypen möglich, man nutzt einfach die 'Wrapper' Typen
        // UnaryOperator<int> unaryFunction = (int x) -> { return x * x; };
        UnaryOperator<Integer> function = (Integer x) -> {
            return x * x;
        };

        // when
        Integer result = function.apply(5);

        // then
        assertEquals(25, result);
    }

    @Test
    public void supplier() {
        // given
        Supplier<LocalDateTime> supplier = () -> LocalDateTime.now();

        // when
        LocalDateTime result = supplier.get();

        // then
        System.out.println(result);
    }

    @Test
    public void binaryFunction() {
        // given
        IntBinaryOperator lambda = (int x, int y) -> {
            return x + y;
        };

        // when
        int result = lambda.applyAsInt(7, 3);

        // then
        assertEquals(10, result);
    }

    //tag::lambda-example-1[]
    @Test
    public void canUseLambdaForLists() {
        // given
        List<String> trains = List.of("ICE 81", "RB 10", "IC 2027", "RE 39", "S8");

        // when - find IC's
        boolean matchesIC = trains.stream().anyMatch(e -> e.startsWith("IC"));

        // when - find regional trains
        String train = trains.stream()
                .filter(e -> e.contains("R"))
                .findFirst()
                .orElse("?");

        // then
        assertTrue(matchesIC);
        assertEquals("RB 10", train);
    }
    //end::lambda-example-1[]

    //tag::lambda-example-2[]
    @Test
    public void canUseValidatorPredicates() {
        // given (Timetable shall be created for the year '2023')

        ZonedDateTime departure = DateTimeUtil.from("15.02.2023");
        Schedule schedule = Schedule.of("MA", "DA", departure, 45);

        // when - (a) direct implementation
        Predicate<Schedule> predicate = s -> s.getDeparture().getYear() == 2023;
        boolean testResult1 = predicate.test(schedule);

        // when - (b) concern 'validation' wrapped in a separate class
        boolean testResult2 = Validator.validate(schedule, isScheduledFor2023());

        // then
        assertTrue(testResult1);
        assertTrue(testResult2);
    }
    //end::lambda-example-2[]

}