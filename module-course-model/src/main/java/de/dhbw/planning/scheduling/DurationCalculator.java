package de.dhbw.planning.scheduling;

import de.dhbw.planning.model.Agenda;
import de.dhbw.planning.model.Item;

import java.time.Duration;
import java.util.List;

import static de.dhbw.planning.util.Constants.DURATION_DEFAULT;

@SuppressWarnings("all")
public class DurationCalculator {

    public static Duration calculateTotalDuration(Agenda agenda, Class<?> clazz) {
        Duration total = Duration.ZERO;
        if (agenda == null) {
            System.err.printf(
                    "WARNING: Specified agenda for '%s' is 'null', \n"+
                    "         Using default '%s' to calculate total duration!",
                    clazz != null ? clazz.getSimpleName() : "unknown",
                    DURATION_DEFAULT
            );
            return total;
        }
        for (Item item : agenda.getItems()) {
            Duration itemDuration = item.getDuration();
            total = total.plus(itemDuration);
        }
        return total;
    }

    public static Duration calculateDuration(List<Item> items) {
        if (items == null) { return Duration.ZERO; }
        Duration sum = Duration.ZERO;
        for (Item item : items) {
            Duration itemDuration = item.getDuration();
            sum = sum.plus(itemDuration);
        }
        return sum;
    }

}