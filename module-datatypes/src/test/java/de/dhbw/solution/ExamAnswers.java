package de.dhbw.solution;

import de.dhbw.commons.Answer;
import de.dhbw.commons.Answers;

public class ExamAnswers extends Answers {

    static {
        answers.put(Q1, Answer.fromExplanation("""
         A private variable may only be accessed within the class in which it is declared."""));
    }

}