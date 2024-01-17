package de.dhbw.solution;

import de.dhbw.commons.Answer;
import de.dhbw.commons.Answers;

public class ExamAnswers extends Answers {

    static {
        answers.put(Q1, Answer.fromExplanation("""
         A private variable may only be accessed within the class in which it is declared."""));
        answers.put(Q2, Answer.from("B"));
        answers.put(Q3, Answer.from("C"));
        answers.put(Q4, Answer.from("D", detailsForQ4()));
    }

    private static String detailsForQ4() {
        return """
               Use the following code to get the range of 'short's:
               System.out.printf("MIN: %s, MAX: %s\\n", Short.MIN_VALUE, Short.MAX_VALUE);
               System.out.printf("MIN: %s, MAX: %s\\n", Math.negateExact(Math.round(Math.pow(2,15))), Math.round((Math.pow(2,15)-1)));
               """;
    }

}