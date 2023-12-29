package de.dhbw.planning;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class Content implements Item {

    // Done
    private boolean completed;

    // Zeitraum, Dauer
    private Duration duration;

    // Typ
    private ContentType contentType;

    // Inhaltsbeschreibung, Kommentar
    private String description;

    private Content(ContentType contentType, Duration duration, String description, boolean completed) {
        this.contentType = contentType;
        this.duration = duration;
        this.description = description;
        this.completed = completed;
    }

    public static Content of(ContentType contentType, Duration duration, String description, boolean completed) {
        return new Content(
                contentType,
                duration,
                description,
                completed
        );
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public ContentType getContentType() {
        return contentType;
    }

    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}