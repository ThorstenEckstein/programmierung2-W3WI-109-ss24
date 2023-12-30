package de.dhbw.planning;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

public class ResourceManager {

    public enum CourseFile {
        Prog2WithJava(
                "Programmierung II mit Java",
                "src/test/resources/programming-2-with-java.json")
        ;

        private final String courseFile;
        private final String courseTitle;

        CourseFile(String courseTitle, String courseFile) {
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

    private final ObjectMapper mapper;

    public ResourceManager() {
        this.mapper = this.configure();
    }

    private ObjectMapper configure() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();

        // add more configuration options here
        // ...

        return mapper;
    }

    public void write(Course course) throws IOException {
        mapper.writeValue(CourseFile.Prog2WithJava.getResourceFile(), course);
    }

}
