package de.dhbw.planning;

import de.dhbw.planning.resources.FileResource;
import de.dhbw.planning.resources.ResourceManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.Duration;

import static de.dhbw.planning.MockFactory.mockContent;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PlanningWithContentsTest {

    private ResourceManager resourceManager;

    @BeforeEach
    void setUp() {
        this.resourceManager = new ResourceManager();
    }

    @Test
    @DisplayName("[Course] Read Example-Course + Days + Contents")
    public void canReadCourseJson() throws IOException {
        // given
        Course course;

        // when
        course = resourceManager.readCourse(FileResource.Input.Course_1_CourseDay_n_Contents);

        // then
        assertNotNull(course);
    }

    @Test
    @DisplayName("[Course] Read + Write Course with Contents instead of Modules")
    public void canReadAndWriteCourseJson() throws IOException {
        // given
        Course course;

        // when
        course = resourceManager.readCourse(FileResource.Input.Course_1_CourseDay_n_Contents);

        // then
        assertNotNull(course);

        // write again
        resourceManager.writeCourse(FileResource.Output.Course_1_CourseDay_n_Contents, course);
    }

    @Test
    @DisplayName("[Content] Calculate Total Content Duration")
    public void canCalculateDuration() throws IOException {
        // given
        Course course;

        // when
        course = resourceManager.readCourse(FileResource.Input.Course_1_CourseDay_n_Contents);
        Duration duration = course.getDuration();

        // then
        assertNotNull(course);
        assertEquals("PT3H45M", duration.toString());
    }

}
