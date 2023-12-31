package de.dhbw.planning;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

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

    public Course readCourse(FileResource resource) throws IOException {
        return mapper.readValue(resource.getResourceFile(), Course.class);
    }

    public void writeCourse(FileResource resource, Course course) throws IOException {
        mapper.writeValue(resource.getResourceFile(), course);
    }

}
