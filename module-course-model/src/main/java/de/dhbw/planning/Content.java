package de.dhbw.planning;

import java.time.Duration;
import java.util.Objects;

public class Content implements Item {

    // Done
    private boolean completed;

    // Zeitraum, Dauer
    private Duration duration;

    // Typ
    private ContentType type;

    // Inhaltsbeschreibung, Kommentar
    private String description;

    private Content(ContentType type, Duration duration, String description, boolean completed) {
        this.type = type;
        this.duration = duration;
        this.description = description;
        this.completed = completed;
    }

    public static Content of(ContentType type, Duration duration, String description, boolean completed) {
        return new Content(
                type,
                duration,
                description,
                completed
        );
    }

    public static Content of(ContentType type, Duration duration, String description) {
        return Content.of(
                type,
                duration,
                description,
                false
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

    public ContentType getType() {
        return type;
    }

    public void setType(ContentType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Content{" +
                "type=" + type +
                ", duration=" + duration +
                ", description='" + description + '\'' +
                ", completed=" + completed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Content content = (Content) o;
        return completed == content.completed && Objects.equals(duration, content.duration) && type == content.type && Objects.equals(description, content.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(completed, duration, type, description);
    }

}