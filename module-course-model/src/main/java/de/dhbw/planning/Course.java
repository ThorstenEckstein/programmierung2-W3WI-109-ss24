package de.dhbw.planning;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.Duration;

public class Course {

    private String title;
    private Semester semester;

    // Set of 'CourseDay' instances
    private Agenda agenda;

    public Course() {}

    public Course(String title, Semester semester) {
        this.title = title;
        this.semester = semester;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
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

    @JsonIgnore
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
