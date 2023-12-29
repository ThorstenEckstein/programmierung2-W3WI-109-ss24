package de.dhbw.planning;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class PlanningUtil {

    // also possible: Duration.parse("PT15M")
    public static final Duration DURATION_15_MIN = Duration.of(15, ChronoUnit.MINUTES);
    public static final Duration DURATION_30_MIN = Duration.of(30, ChronoUnit.MINUTES);
    public static final Duration DURATION_45_MIN = Duration.of(45, ChronoUnit.MINUTES);
    public static final Duration DURATION_60_MIN = Duration.of(60, ChronoUnit.MINUTES);

}