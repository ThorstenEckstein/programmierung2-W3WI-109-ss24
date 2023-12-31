package de.dhbw.planning;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.Duration;
import java.util.Objects;

@JsonPropertyOrder({ "itemType", "contentType", "description", "duration", "completed" })
public class Content implements Item {

    // Inhaltstyp
    private ContentType contentType;

    // Inhaltsbeschreibung, Kommentar
    private String description;

    // Zeitraum, Dauer
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Duration duration;

    // Done
    private boolean completed;

    public Content() {}

    public Content(ContentType contentType, Duration duration, String description) {
        this.contentType = contentType;
        this.duration = duration;
        this.description = description;
        this.completed = false;
    }

    public Content(ContentType contentType, Duration duration, String description, boolean completed) {
        this.contentType = contentType;
        this.duration = duration;
        this.description = description;
        this.completed = completed;
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

    @Override
    public String toString() {
        return "Content{" +
                "type=" + contentType +
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
        return completed == content.completed && Objects.equals(duration, content.duration) && contentType == content.contentType && Objects.equals(description, content.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(completed, duration, contentType, description);
    }

}