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
        return sum(agenda);
    }

    private Duration sum(Agenda agenda) {
        if (agenda == null) {
            throw new IllegalArgumentException("Can't calculate duration from specified agenda, because it is null!");
        }
        Duration sum = Duration.ZERO;
        for (Item item : agenda.getItems()) {
            sum = sum.plus(item.getDuration());
        }
        return sum;
    }
}
