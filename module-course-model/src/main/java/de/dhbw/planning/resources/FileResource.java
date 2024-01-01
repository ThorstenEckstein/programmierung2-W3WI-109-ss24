package de.dhbw.planning.resources;

import java.io.File;

public enum FileResource {

    // mock data

    MockModel_Input(
            "LV mit Mockdaten aus Tests",
            "src/test/resources/input/mock-data.json"),
    MockModel_Output(
            "LV mit Mockdaten aus Tests",
            "src/test/resources/output/mock-data.json"),

    // real data for LV

    Prog2WithJava_Input(
            "Programmierung II mit Java",
            "src/test/resources/input/programming-2-with-java.json"),

    Prog2WithJava_Input_JustCourseDay(
            "Programmierung II mit Java",
            "src/test/resources/input/programming-2-with-java-coursedays.json"),

    Prog2WithJava_Input_Modules(
            "Programmierung II mit Java",
            "src/test/resources/input/programming-2-with-java-modules.json"),

    Prog2WithJava_Output(
            "Programmierung II mit Java",
            "src/test/resources/output/programming-2-with-java.json")
    ;

    private final String courseFile;
    private final String courseTitle;

    FileResource(String courseTitle, String courseFile) {
        this.courseTitle = courseTitle;
        this.courseFile = courseFile;
    }

    public File getResourceFile() {
        return new File(courseFile);
    }

    public String getCourseTitle() {
        return courseTitle;
    }
}