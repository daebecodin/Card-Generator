/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Quiz.java
 * @author: Durand Dyer
 * @author: Ian Brown
 * **********************************************
 */

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static java.lang.System.out;
// I don't want to write System a bunch of time, so I did that here

public final class Quiz {

    private static final StringBuilder sb = new StringBuilder();

    //
    // Instance Data Fields
    //
    private String clubName;
    private String quizTitle;
    private  List<QuestionAnswer> questions = new ArrayList<>();
    private String winMessage;
    private String loseMessage;
    private int allowedMisses;
    private String studentName;

    //ANSI escape codes
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";

    //
    // Constructors
    //

    public Quiz() {
    }

    public Quiz(String clubName, String quizTitle, List<QuestionAnswer> questions,
                String winMessage, String loseMessage, int allowedMisses, String studentName) {
        this.clubName = clubName;
        this.quizTitle = quizTitle;
        this.questions = questions;
        this.winMessage = winMessage;
        this.loseMessage = loseMessage;
        this.allowedMisses = allowedMisses;
        this.studentName = studentName;
    }


    //
    // Setter section
    //


    public List<QuestionAnswer> getQuestions() {
        return this.questions;
    }

    public String getLoseMessage() {
        return loseMessage;
    }

    public String getStudentName() {
        return studentName;
    }

    public Quiz setStudentName(String studentName) {
        this.studentName = studentName;
        return this;
    }

    public String getClubName() {
        return clubName;
    }

    public Quiz setClubName(String clubName) {
        this.clubName = clubName;
        return this;
    }

    public Quiz setShortName(String clubName) {
        this.clubName = clubName;
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
    public Quiz addQuestion(String questionKey, String answerKey) {
        String questionText = Language.getString(questionKey);
        String correctAnswer = Language.getString(answerKey);
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
    public String getShortName() {return this.clubName;}

    public String getWinMessage() {return this.winMessage;}

    public int getAllowedMisses() {return this.allowedMisses;}

    public String getQuizTitle() {return this.quizTitle;}

    //
    // Instance Method
    // runQuiz method to be used in ChatSession
    //
    public String runQuiz(Club club, Student student, Scanner input)  {

        //
        // Opening and setting up Quiz for User
        //
        int oopsAnswers = 0;
        boolean firstQuestion = true;

        for (QuestionAnswer qa : questions) {
            // Handles blank lines between question. No Blank before first question.
            //if (!firstQuestion) {
            //    out.println();
            //} else {
            if (firstQuestion) {
                firstQuestion = false;
            }

            // Printing question prompt
            sb.setLength(0); // Clearing out StringBuilder for reuse
            sb.append(club.getShortName()).append(": ").append(qa.getQuestionText());
            out.println(sb);

            // Print Student Prompt and collect answer
            sb.setLength(0);
            sb.append(student.getFullName()).append(": ");
            out.print(sb);
            String userAnswer = input.nextLine();

            // This is error handling created specifically for
            // an empty input. System.err.print would just not work
            // due to buffer.
            String messageToDisplay;
            boolean currentAnswerIsOops = false;

            if (userAnswer.trim().isEmpty()) {
                messageToDisplay = club.getShortName() + ANSI_RED +  Language.getString("quiz.incorrect")+ ANSI_RESET;
                currentAnswerIsOops = true;
            } else {
                String qaResult = qa.checkAnswer(userAnswer); //This is the "Correct!" case

                sb.setLength(0);
                sb.append(club.getShortName());

                if (qaResult.equals("Oops...")) {
                    sb.append(ANSI_RED).append(qaResult).append(ANSI_RESET);
                    currentAnswerIsOops = true;
                } else {
                    sb.append(qaResult);
                }
                messageToDisplay = sb.toString();
            }

            // normal operation of runQuiz feedback loop
            if (currentAnswerIsOops) {
                out.println(messageToDisplay);
                oopsAnswers++;
            } else {
                out.println(messageToDisplay);
            }
        }

        String finalMessage;// Also append to StringBuilder
        // Still print immediately
        //Closing of runQuiz
        if (oopsAnswers <= allowedMisses) {
            finalMessage =winMessage;
        } else {
            finalMessage = loseMessage;
        }
        out.println(finalMessage); // Still print immediately
        out.println(Messenger.getConfig().getTimer().timeStamp() + " - " + Language.getString("chat.session.ended"));

        input.close();
        return finalMessage; // return empty String
    }


    @Override
    public String toString() {
        return String.format("%s%s %s _ %s misses allowed _", this.clubName, ":", this.quizTitle, this.allowedMisses);

    }
}



