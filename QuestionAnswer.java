/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: QuestionAnswer.java
 * Author: Duc Ta
 * Author: <First Name> <Last Name>
 * **********************************************
 */

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

public final class QuestionAnswer {

    //
    // Instance Data Fields
    //
    private final String questionText;
    private final String correctAnswer;


    //
    // Constructors
    //
    public QuestionAnswer(String questionText, String correctAnswer) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    //
    // Use of ternary operator as recommended by Duran.
    // This trims any whitespace around userAnswer and compares it with the correct answer
    //   regardless of case. "?" is a quick inject to return Correct if T or Oops if F (T/F)
    // -Ian

    public String checkAnswer(String userAnswer) {
        return correctAnswer.equalsIgnoreCase(userAnswer.trim()) ? "Correct!" : "Oops...";
    }

    public static String winCheck() {
        return null;
    }
    //
    // Language
    //

    //
    // Override
    //
}