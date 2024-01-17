package de.dhbw.questions;

import de.dhbw.commons.Answer;
import de.dhbw.commons.Logger;
import de.dhbw.solution.ExamAnswers;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static de.dhbw.commons.Answers.Q1;

@Disabled
@DisplayName("Questions for module \"datatypes\"")
@SuppressWarnings("NewClassNamingConvention")
public class ExamQuestions {

    private final Logger logger = new Logger(ExamQuestions.class);

    private final ExamAnswers correctAnswers = new ExamAnswers();

    @DisplayName(
            """
            Q1: What do you mean by 'Access Modifier'?
            
            Explain in your own words!
            """
    )
    @Test
    public void question1() {
        // given
        Answer commonExplanation = correctAnswers.of(Q1);

        // when
        final String studentExplanation =
                """
                ... your answer here ...
                """;

        // then
        logger.log(commonExplanation.face(studentExplanation));
    }

}