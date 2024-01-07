package de.dhbw.planning.util;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Constants {

    //
    // Duration
    //

    // also possible: Duration.parse("PT15M")
    public static final Duration DURATION_15_MIN = Duration.of(15, ChronoUnit.MINUTES);
    public static final Duration DURATION_30_MIN = Duration.of(30, ChronoUnit.MINUTES);
    public static final Duration DURATION_45_MIN = Duration.of(45, ChronoUnit.MINUTES);
    public static final Duration DURATION_60_MIN = Duration.of(60, ChronoUnit.MINUTES);
    public static final Duration DURATION_DEFAULT = Duration.ZERO;

    //
    // Time Defaults
    //

    public static final LocalTime TIME_09_15 = LocalTime.of(9,15);
    public static final LocalTime TIME_12_15 = LocalTime.of(12,15);
    public static final LocalTime DEFAULT_TIME_START = TIME_09_15;
    public static final LocalTime DEFAULT_TIME_END = TIME_12_15;

    //
    // Date & Time Formatting
    //

    public static final String DEFAULT_DATE_FORMAT = "dd.MM.yyyy";
    public static final DateTimeFormatter DEFAULT_DATE_FORMATTER = DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT);
    public static final String DEFAULT_DATETIME_FORMAT = "dd.MM.yyyy HH:mm:ss";
    public static final DateTimeFormatter DEFAULT_DATETIME_FORMATTER = DateTimeFormatter.ofPattern(DEFAULT_DATETIME_FORMAT);

    //
    // Date & Time Display
    //

    public static final String DEFAULT_DATE_DISPLAY_FORMAT = "E dd.MM.yyyy";
    public static final DateTimeFormatter DEFAULT_DATE_DISPLAY_FORMATTER = DateTimeFormatter.ofPattern(DEFAULT_DATE_DISPLAY_FORMAT);

}