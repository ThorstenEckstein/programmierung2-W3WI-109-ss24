package de.dhbw.planning;

import java.time.Duration;

public class Module implements Item {

    private int index;
    private String title;
    private String directory;

    // Set of 'Content' instances
    private Agenda agenda;

    private Module(
            int index,
            String title,
            String directory
    ) {
        this.index = index;
        this.title = title;
        this.directory = directory;
    }

    public static Module of(int index, String title, String directory) {
        return new Module(index, title, directory);
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