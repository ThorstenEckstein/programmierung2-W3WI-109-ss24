package de.dhbw.planning;

import java.time.Duration;

import static de.dhbw.planning.Constants.DURATION_DEFAULT;

public interface Item {

    String getItemType();

    Duration getDuration();

    static Duration calculateTotalDuration(Agenda agenda, Class<?> clazz) {
        Duration sum = Duration.ZERO;
        if (agenda == null) {
            System.err.printf(
                    "WARNING: Specified agenda for '%s' is 'null', using default '%s' to calculate total duration!",
                    clazz != null ? clazz.getSimpleName() : "unknown",
                    DURATION_DEFAULT
            );
            return sum;
        }
        for (Item item : agenda.getItems()) {
            sum = sum.plus(item.getDuration());
        }
        return sum;
    }


}
