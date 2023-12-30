package de.dhbw.planning;

import java.time.Duration;

public class CourseDay implements Item {

    private String title;

    // Set of 'Module or Content' instances
    private Agenda agenda;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    @Override
    public Duration getDuration() {
        return Item.calculateTotalDuration(agenda, this.getClass());
    }

    @Override
    public String toString() {
        return "CourseDay{" +
                "title='" + title + '\'' +
                ", agenda=" + agenda +
                '}';
    }
}
