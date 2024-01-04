package de.dhbw.planning.scheduling;

import de.dhbw.planning.model.Content;

import java.time.LocalTime;

public class ContentSchedule {

    private LocalTime startTime;

    private Content content;

    private LocalTime endTime;

    public ContentSchedule() {
    }

    public ContentSchedule(LocalTime startTime, Content content, LocalTime endTime) {
        this.startTime = startTime;
        this.content = content;
        this.endTime = endTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return String.format(
                "%s: %s - %s",
                content.getContentType(),
                startTime,
                endTime);
    }
}
