package de.dhbw.planning;

import de.dhbw.planning.resources.ResourceManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateTimeTest {

    private ResourceManager resourceManager;

    @BeforeEach
    void setUp() {
        this.resourceManager = new ResourceManager();
    }

    @Test
    @DisplayName("Write date without any formatting")
    public void canConvertDateToStringWithoutFormat() {
        // given
        LocalDate date = LocalDate.of(2023, 12, 30);

        // when
        String _date = date.toString();

        // then
        assertEquals("2023-12-30", _date);
    }

    @Test
    @DisplayName("Write date using format")
    public void canConvertDateToStringWithFormat() {
        // given
        LocalDate date = LocalDate.of(2023, 12, 30);
        DateTimeFormatter formatter = Constants.DEFAULT_DATE_FORMATTER;

        // when
        String _date = formatter.format(date);

        // then
        assertEquals("30.12.2023", _date);
    }

}