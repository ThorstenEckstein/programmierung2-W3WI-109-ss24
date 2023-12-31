package de.dhbw.planning;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.time.Duration;

import static de.dhbw.planning.Constants.DURATION_DEFAULT;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = CourseDay.class, name = "courseDay"),
        @JsonSubTypes.Type(value = Module.class, name = "module"),
        @JsonSubTypes.Type(value = Content.class, name = "content")
})
public interface Item {

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
