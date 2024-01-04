package de.dhbw.planning.scheduling;

import de.dhbw.planning.model.CourseDay;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;

public class CourseDaySchedule {

    private LocalDate date;

    private LocalTime startTime;

    private CourseDay courseDay;

    private List<ContentSchedule> contentSchedules = new LinkedList<>();

    private LocalTime endTime;

    public CourseDaySchedule() {
    }

    public CourseDaySchedule(
            CourseDay courseDay,
            LocalDate date,
            LocalTime startTime,
            List<ContentSchedule> contentSchedules,
            LocalTime endTime) {
        this.courseDay = courseDay;
        this.date = date;
        this.startTime = startTime;
        this.contentSchedules = contentSchedules;
        this.endTime = endTime;
    }

    public CourseDay getCourseDay() {
        return courseDay;
    }

    public void setCourseDay(CourseDay courseDay) {
        this.courseDay = courseDay;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public List<ContentSchedule> getContentSchedules() {
        return contentSchedules;
    }

    public void setContentSchedules(List<ContentSchedule> contentSchedules) {
        this.contentSchedules = contentSchedules;
    }

    public void addContentSchedule(ContentSchedule contentSchedule) {
        this.contentSchedules.add(contentSchedule);
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "CourseDaySchedule{" +
                "date=" + date +
                ", startTime=" + startTime +
                ", contentSchedule=" + contentSchedules +
                ", endTime=" + endTime +
                '}';
    }
}
