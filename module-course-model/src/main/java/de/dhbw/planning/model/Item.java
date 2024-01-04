package de.dhbw.planning.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.time.Duration;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = CourseDay.class, name = "courseDay"),
        @JsonSubTypes.Type(value = Module.class, name = "module"),
        @JsonSubTypes.Type(value = Content.class, name = "content")
})
public interface Item {

    Duration getDuration();

}
