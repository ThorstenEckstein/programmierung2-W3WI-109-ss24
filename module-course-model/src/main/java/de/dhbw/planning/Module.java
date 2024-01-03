package de.dhbw.planning;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.Duration;

@JsonPropertyOrder({ "itemType", "index", "title", "directory" })
public class Module implements Item {

    private int index;
    private String title;
    private String directory;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Duration duration;

    // Set of 'Content' instances
    private Agenda agenda;

    public Module() {}

    public Module(int index, String title, String directory, Duration duration) {
        this.index = index;
        this.title = title;
        this.directory = directory;
        this.duration = duration;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    @Override
    public Duration getDuration() {
        // if duration was manually set, use this, assuming it was set intentionally!
        if (duration != null) {
            return duration;
        }
        // agenda exists, so use this to calculate total duration of modules' contents
        else if (agenda != null && !agenda.getItems().isEmpty()) {
            return AgendaScheduler.calculateTotalDuration(agenda, this.getClass());
        }
        // neither duration nor agenda manually specified, simply return a default value
        else {
            return Constants.DURATION_DEFAULT;
        }
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Module{" +
                "index=" + index +
                ", title='" + title + '\'' +
                ", directory='" + directory + '\'' +
                ", agenda=" + agenda +
                '}';
    }

}