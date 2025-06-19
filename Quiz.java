/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Quiz.java
 * Author: Duc Ta
 * Author: <First Name> <Last Name>
 * **********************************************
 */

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static java.lang.System.out;
// I don't want to write System a bunch of time so I did that here

public final class Quiz {

    private static final StringBuilder sb = new StringBuilder();

    //
    // Instance Data Fields
    //
    private String shortName;
    private String quizTitle;
    private final List<QuestionAnswer> questions;
    private String winMessage;
    private String loseMessage;
    private int allowedMisses;




    //
    // Constructors
    //
    public Quiz() {
        this.questions = new ArrayList<>();
        this.shortName = "SF Giants";
        this.quizTitle = " *** FREE TICKETS to SF GIANTS Games *** _ 1 miss allowed _";
        this.winMessage = " *** Congrats! You won FREE TICKETS to SF GIANTS Games ***";
        this.loseMessage = " ____ Please try again at your graduation ceremony. ____";
        this.allowedMisses = 1;
    }
    //
    // Setter section
    //
    public Quiz setShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public Quiz setQuizTitle(String quizTitle) {
        this.quizTitle = quizTitle;
        return this;
    }

    //
    // This piece here took me the longest to figure out.
    // This is the first call into QuestionAnswer.
    // Set it up so each element within the array is a QuestionAnswer pair
    // When building in ChatSession, you will have to submit two arguments for every time
    //  you want to addQuestion. See runQuiz method at bottom for next use of QuestionAnswer
    // -Ian
    //
    public Quiz addQuestion(String questionText, String correctAnswer) {
        this.questions.add(new QuestionAnswer(questionText, correctAnswer));
        return this;
    }

    public Quiz setWinMessage(String winMessage) {
        this.winMessage = winMessage;
        return this;
    }

    public Quiz setLoseMessage(String loseMessage) {
        this.loseMessage = loseMessage;
        return this;
    }

    public Quiz setAllowedMisses(int allowedMisses) {
        this.allowedMisses = allowedMisses;
        return this;
    }
    //
    //Getter section
    //
    public String getShortName() {return this.shortName;}

    public String getWinMessage() {return this.winMessage;}

    public int getAllowedMisses() {return this.allowedMisses;}

    public String getQuizTitle() {return this.quizTitle;}

    //
    // Instance Method
    // runQuiz method to be used in ChatSession
    //
    public void runQuiz(String userName) {
        out.println(shortName + quizTitle + "\"");
        //
        // Opening and setting up Quiz for User
        //
        Scanner input = new Scanner(System.in);
        int oopsAnswers = 0;

        for (QuestionAnswer qa : questions) {
            out.println(shortName + qa.getQuestionText() + "\"");
            out.print(userName + "\"");
            String userAnswer = input.nextLine();

            String result = qa.checkAnswer(userAnswer);
            out.println(result);

            if (result.equals(" Oops...")) {
                oopsAnswers++;
            }
        }

        out.println();
        //
        // Closed quiz loop
        // Posting final results
        //
        if (oopsAnswers <= allowedMisses) {
            out.println(shortName + winMessage + "\"");
        } else {
            out.println(shortName + loseMessage + "\"");
        }
    }
}



    //
    // Additional Instance Methods
    //

    //
    // Language
    //
