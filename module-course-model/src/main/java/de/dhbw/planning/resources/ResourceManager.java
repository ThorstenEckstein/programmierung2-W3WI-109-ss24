package de.dhbw.planning.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.dhbw.planning.model.Course;

import java.io.IOException;

public class ResourceManager {

    private final ObjectMapper mapper;

    public ResourceManager() {
        this.mapper = this.configure();
    }

    private ObjectMapper configure() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();

        //SimpleModule module = new SimpleModule();
        //module.addDeserializer(Agenda.class, new AgendaDeserializer());
        //mapper.registerModule(module);

        // add more configuration options here...

        return mapper;
    }

    public Course readCourse(FileResource.Input resource) throws IOException {
        return mapper.readValue(resource.getResourceFile(), Course.class);
    }

    public void writeCourse(FileResource.Output resource, Course course) throws IOException {
        mapper.writeValue(resource.getResourceFile(), course);
    }

}
