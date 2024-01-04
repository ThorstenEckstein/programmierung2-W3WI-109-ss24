package de.dhbw.planning.resources;

import java.io.File;

public class FileResource {

    public enum Input {
        MockModel(
                "LV mit Mockdaten",
                "src/test/resources/input/_mock/mock-data.json"),

        Course_n_CourseDays(
                "1 Course + n CourseDays",
                "src/test/resources/input/coursedays/course-n-coursedays.json"),

        Course_n_CourseDays_n_Modules(
                "1 Course + n CourseDays + n Modules",
                "src/test/resources/input/modules/course-n-coursedays-n-modules.json"),

        Course_1_CourseDay_n_Contents(
                "1 Course + 1 CourseDays + n Contents",
                "src/test/resources/input/contents/course-1-courseday-n-contents.json"),
        CourseWs24(
                "Programmierung II mit Java",
                "src/test/resources/input/ws24/course.json"),
        ;

        private final String courseFile;
        private final String courseTitle;

        Input(String courseTitle, String courseFile) {
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

    public enum Output {
        MockModel(
                "LV mit Mockdaten",
                "src/test/resources/output/_mock/mock-data.json"),

        Course_n_CourseDays(
                "1 Course + n CourseDays",
                "src/test/resources/output/coursedays/course-n-coursedays.json"),

        Course_n_CourseDays_n_Modules(
                "1 Course + n CourseDays + n Modules",
                "src/test/resources/output/modules/course-n-coursedays-n-modules.json"),

        Course_1_CourseDay_n_Contents(
                "1 Course + 1 CourseDays + n Contents",
                "src/test/resources/output/contents/course-1-courseday-n-contents.json"),

        CourseWs24(
                "Programmierung II mit Java",
                "src/test/resources/output/ws24/course.json"),
        ;

        private final String courseFile;
        private final String courseTitle;

        Output(String courseTitle, String courseFile) {
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


}