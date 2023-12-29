package de.dhbw.planning;

import java.time.Duration;

public class Course {

    private String title;
    private final Semester semester;

    // Set of 'CourseDay' instances
    private Agenda agenda;

    private Course(String title, Semester semester) {
        this.title = title;
        this.semester = semester;
    }

    public static Course of(String title, Semester semester) {
        return new Course(title, semester);
    }

    public Semester getSemester() {
        return semester;
    }


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

    public Duration getDuration() {
        return Item.calculateTotalDuration(agenda, this.getClass());
    }

    @Override
    public String toString() {
        return "Course{" +
                "title='" + title + '\'' +
                ", semester=" + semester +
                ", agenda=" + agenda +
                '}';
    }
}
