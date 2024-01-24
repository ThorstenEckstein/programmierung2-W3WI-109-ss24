package de.dhbw.questions;

import de.dhbw.commons.Answer;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static de.dhbw.commons.Answers.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Disabled
@SuppressWarnings({"NewClassNamingConvention", "ConstantValue"})
@DisplayName(
        "Questions for module data types"
)
public class ExamQuestions {

    //private final ExamAnswers correctAnswers = new ExamAnswers();

    @DisplayName(
            """
            Q1:...
            """
    )
    @Test
    public void question1() {
        // question without a parameter as answer
    }

    @DisplayName(
            """
            Q2:...
            """
    )
    // Please give your answer here:
    @ValueSource(strings = {"?"})
    @ParameterizedTest
    public void question2(String studentAnswer) {
        // question with a letter as answer
    }

}