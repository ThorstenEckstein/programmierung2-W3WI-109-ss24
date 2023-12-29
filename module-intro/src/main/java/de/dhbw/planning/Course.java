package de.dhbw.planning;

public class Course {

    private String title;
    private final Semester semester;

    // Set of 'CourseDay' instances
    private Agenda agenda;

    private Course(String title, Semester semester, Agenda agenda) {
        this.title = title;
        this.semester = semester;
        this.agenda = agenda;
    }

    public static Course of(String title, Semester semester, Agenda agenda) {
        return new Course(title, semester, agenda);
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

}
