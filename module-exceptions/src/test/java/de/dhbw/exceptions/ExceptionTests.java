package de.dhbw.exceptions;

import de.dhbw.commons.Colourizer;
import de.dhbw.commons.Logger;
import de.dhbw.exceptions.demo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExceptionTests {

    private final Logger logger = new Logger(ExceptionTests.class);

    @Test()
    public void howToDoNot() {
        // given
        boolean exceptionCondition = true;

        // when
        try {
            if (exceptionCondition) {
                throw new Exception("Something weird happened!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // then
    }


    @Test()
    public void testExpectedException() {
        // given
        TrainObservationMonitor model = new TrainObservationMonitor();

        // when
        TrainTooLateException thrown = assertThrows(TrainTooLateException.class, () -> {
            // Code under test that can throw an exception
            model.observeOperatingTrain("RB-21");
        });

        // then
        assertTrue(thrown.getMessage().contains("is more than 6 minutes delayed!"));
    }

    @Test()
    public void testExpectedExceptionWithContext() {
        // given
        TrainObservationMonitor model = new TrainObservationMonitor();

        // when
        PassengerLimitPerWagonExceededException thrown = assertThrows(
                PassengerLimitPerWagonExceededException.class, () -> {
                    // Code under test that can throw an exception
                    model.observeOperatingTrainWithContext("RB-21");
                });
        Object passengersCount = thrown.getContext().getItem("passengers");

        // then
        assertEquals(Severity.WARN, thrown.getContext().getSeverity());
        assertTrue((int)passengersCount > 80);

        logger.log(Colourizer.red(thrown.getContext().getMessage()));
    }

    @Test()
    public void testHandleException() {
        // given
        DataLoader loader = new DataLoader();

        // when
        Product product = loader.tryLoadWithResources("/resources/macbook-pro.csv");

        // then
        assertNull(product);
    }

    @Test()
    public void testHandleExceptionWithSpecificHandler() {
        // given
        DataLoader loader = new DataLoader();

        // when
        Product product = loader.tryLoad("/resources/macbook-pro.csv");

        // then
        assertNull(product);
    }

}