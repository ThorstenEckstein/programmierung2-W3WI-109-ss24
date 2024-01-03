package de.dhbw.planning;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.Duration;
import java.time.LocalDate;

@JsonPropertyOrder({"itemType", "title", "date", "agenda"})
public class CourseDay implements Item {

    private String title;

    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate date;

    // Set of 'Module or Content' instances
    private Agenda agenda;

    public CourseDay() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    @Override
    @JsonIgnore
    public Duration getDuration() {
        return AgendaInspector.calculateTotalDuration(agenda, this.getClass());
    }

    @Override
    public String toString() {
        return "CourseDay{" +
                "title='" + title + '\'' +
                ", date=" + date +
                ", agenda=" + agenda +
                '}';
    }
}
