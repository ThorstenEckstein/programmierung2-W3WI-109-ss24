package de.dhbw.planning;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ResourceManager {

    public enum FileResource {
        MockModel(
                "LV mit Mockdaten aus Tests",
                "src/test/resources/mock-data.json"),
        Prog2WithJava(
                "Programmierung II mit Java",
                "src/test/resources/programming-2-with-java.json")
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

    public Course readCourse(FileResource resource) throws IOException {
        return mapper.readValue(resource.getResourceFile(), Course.class);
    }

    public void writeCourse(FileResource resource, Course course) throws IOException {
        mapper.writeValue(resource.getResourceFile(), course);
    }

}
