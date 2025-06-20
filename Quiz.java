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





    //
    // Constructors
    //


    public Quiz() {
    }

    public Quiz(String clubName, String quizTitle, List<QuestionAnswer> questions, String winMessage, String loseMessage, int allowedMisses, String studentName) {
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
    public String getShortName() {return this.clubName;}

    public String getWinMessage() {return this.winMessage;}

    public int getAllowedMisses() {return this.allowedMisses;}

    public String getQuizTitle() {return this.quizTitle;}

    //
    // Instance Method
    // runQuiz method to be used in ChatSession
    //
    public String runQuiz(Club club, Student student)  {
        sb.append(club.getShortName()).append(": ").append(this.quizTitle);
        //
        // Opening and setting up Quiz for User
        //
        Scanner input = new Scanner(System.in);
        int oopsAnswers = 0;
        boolean firstQuestion = true;

        for (QuestionAnswer qa : questions) {
            if (!firstQuestion) {
                out.println();
            } else {
                firstQuestion = false;
            }

            sb.append(club.getShortName()).append(": ").append(qa.getQuestionText());
            sb.append(student.getFullName()).append(": ");
            String userAnswer = input.next();
            input.nextLine();

            String result = qa.checkAnswer(userAnswer);
            sb.append(club.getShortName()).append(": ").append(result);

            if (result.equals("Oops...")) {
                oopsAnswers++;
            }
        }

        sb.append("\n");

        // Closed quiz loop
        // Posting final results
        //
        if (oopsAnswers <= allowedMisses) {
            out.println(clubName + winMessage);
        } else {
            out.println(clubName + loseMessage);
        }
        input.close();

        sb.append(String.format("%s%s", Timer.timeStamp(), " - Chat Session Ended "));
        return sb.toString();
    }


    @Override
    public String toString() {
        return String.format("%s%s %s _ %s misses allowed _", this.clubName, ":", this.quizTitle, this.allowedMisses);

    }
}



