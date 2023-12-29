package de.dhbw.planning;

import java.util.HashSet;
import java.util.Set;

public class Course {

    private String title;
    private final Semester semester;

    private Set<CourseDay> courseDays = new HashSet<>();

    private Course(String title, Semester semester, Set<CourseDay> courseDays) {
        this.title = title;
        this.semester = semester;
        this.courseDays = courseDays;
    }

    public static Course of(String title, Semester semester, Set<CourseDay> courseDays) {
        return new Course(title, semester, courseDays);
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

    public Set<CourseDay> getCourseDays() {
        return courseDays;
    }

    public void addModule(CourseDay module) {
        this.courseDays.add(module);
    }

    public void setCourseDays(Set<CourseDay> courseDays) {
        this.courseDays = courseDays;
    }
}
