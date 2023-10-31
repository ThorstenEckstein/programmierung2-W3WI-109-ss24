package de.dhbw.javadoc;

import de.dhbw.commons.Logger;
import de.dhbw.javadoc.exercises.XmlAdapter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExerciseTests {

    private final Logger logger = new Logger(ExerciseTests.class);
    @Test
    @DisplayName("Exercise 1: improve javadoc to get better code documentation")
    public void exercise1() {
        // given - poorly documented interface 'XmlAdapter'
        XmlAdapter adapter = new XmlAdapter() {
            @Override
            public String toXml(String plainText) {
                // add tags to text
                return "<tag>" + plainText + "</tag>";
            }

            @Override
            public String fromXml(String xml) throws Exception {
                // clear xml from tags
                return xml;
            }

            @Override
            public String adapt(String xmlOrPlainText) throws Exception {
                return null;
            }
        };

        // when - developer has documented its public API

        // then - basic documentation is now far better ;-)
    }

}