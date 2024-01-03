package de.dhbw.planning;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Objects;

@JsonPropertyOrder({ "itemType", "contentType", "description", "duration", "module", "completed" })
public class Content implements Item {

    // Inhaltstyp
    private ContentType contentType;

    // Inhaltsbeschreibung, Kommentar
    private String description;

    private LocalTime startTime;

    // Zeitraum, Dauer
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Duration duration;

    private Modules module;

    // Done
    private boolean completed;

    public Content() {}

    public Content(ContentType contentType, Duration duration, String description, Modules module, boolean completed) {
        this.contentType = contentType;
        this.duration = duration;
        this.description = description;
        this.module = module;
        this.completed = completed;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    @JsonIgnore
    public LocalTime getEndTime() {
        return this.getStartTime().plus(this.getDuration());
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

    public Modules getModule() {
        return module;
    }

    public void setModule(Modules module) {
        this.module = module;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Content{" +
                "contentType=" + contentType +
                ", description='" + description + '\'' +
                ", startTime=" + startTime +
                ", duration=" + duration +
                ", module=" + module +
                ", completed=" + completed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Content content = (Content) o;
        return contentType == content.contentType && Objects.equals(description, content.description) && Objects.equals(startTime, content.startTime) && Objects.equals(duration, content.duration) && module == content.module;
    }

    @Override
    public int hashCode() {
        return Objects.hash(contentType, description, startTime, duration, module);
    }

}