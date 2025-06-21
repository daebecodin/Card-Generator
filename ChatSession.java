/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: ChatSession.java
 * @author: Duc Ta
 * @author: <First Name> <Last Name>
 * **********************************************
 */

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public final class ChatSession {

    // private data fields for a chat session
    private Club club;
    private University university;
    private final Student student = new Student(); // composite relationship to the session
    private final Player player = new Player("Buster", "Posey"); // compose relationship to the session
    private final Quiz quiz = new Quiz(); // composite relationship to the session
    private static final int WIDTH = 70;
    private static final StringBuilder sb = new StringBuilder(); // string builder is a buffer of strings; it must be cleared and printed.
    private static final Scanner input = new Scanner(System.in);

    public ChatSession() {
    }

    // the chat session is created with a club and a university
    public ChatSession(Club club, University university) {
        this.club = club;
        this.university = university;
//        this.student = student;
//        this.player = player;
    }


    private void startChatSession() {

        sb.setLength(0);
        club // club the sesion is constructed with
                .setName("San Francisco Giants")
                .setShortName("SF Giants")
                .setEstablishedOn(1883)
                .setTeamColors("Orange", "Black", "Gold", "Cream")
                .setTeamBallPark("Oracle Park")
                .setWorldSeriesTitles(8)
                .setNationalLeaguePennants(23)
                .setDivisionTitles(8)
                .setWildCardBerths(3)
                .setTeamOwners(new OwnerGroup("San Francisco Baseball Association", this.getClub()))

                .setTeamPresident(new President("Farhan", "Zadai"))
                .setTeamGeneralManager(new GeneralManager("Scott", "Harris"))
                .setManager(new Manager("Gabe", "Kepler"));



        sb.append(String.format("%s%s", Timer.timeStamp(), " - Chat session started"));
        System.out.println(sb); // printing current items in buffer

        // TODO: make these methods
        String clubIntro = club.clubIntro();
        System.out.println(clubIntro);
        String clubInfo = club.toString();
        System.out.println(clubInfo);
    }
    private void connectChatters() {


        // TODO: make these methods for student
        sb.setLength(0);
        sb.append(String.format("%s%s%s", club.getShortName(), ": ", "Your first name and last name, please: "));
        System.out.print(sb);
        String firstName = input.next();
        String lastName = input.next();
        student.setFirstName(firstName);
        student.setLastName(lastName);


        // TODO: make these methods for student
        sb.setLength(0);
        sb.append(String.format("%s%s%s", club.getShortName(), ": ", "Your school email address, please: "));
        System.out.print(sb);
        String email = input.next();
        student.setEmail(email);

        System.out.println();

        // TODO: make these methods student
        sb.setLength(0);
        sb.append(String.format("%s%s%n",student.getFullName(), ": Welcome to my university!"));
        sb.append("-".repeat(WIDTH));
        System.out.println(sb);

        university // university session is constructed with
                .setOfficialName("San Francisco State University")
                .setMottoInLatin("Experientia Docet")
                .setMottoInEnglish("Experience Teaches")
                .setType("Public")
                .setYearOfEstablishment(1999)
                .setLocation("San Francisco, California, United States")
                .setAddress("1600 Holloway Avenue, San Francisco, CA 94132 ")
                .setUniversityColors(List.of("Purple", "Gold"))
                .setNickName("Gators")
                .setMascot("Gator")
                .setWebsite("www.sfsu.edu");

        student.setUniversity(university);


        String universityInfo = university.toString();
        System.out.println(universityInfo);

    }

    /**
     * Handles getting the number of cards from the user with retries.
     * @return The number of cards entered by the user, or 1 if input is invalid after 3 tries.
     */
    private int getNumberOfCards() {
        int numberOfCards = 1; // Default value
        int tries = 3;
        for (int i = 0; i < 3; i++) {
            try {
                System.out.print(student.talk());
                numberOfCards = input.nextInt();
                input.nextLine(); // Consume the rest of the line
                return numberOfCards; // Return the valid input
            } catch (InputMismatchException e) {
                System.err.println("Please enter an INTEGER. " + (tries -1) + " tries left.");
                input.nextLine(); // Consume the invalid input
            }
            tries --;
        }
        System.out.println("Defaulting to 1 card.");
        return numberOfCards; // Return default value
    }
    private void chat() {

        player.setClub(club) // the player constructed with the class is given the club created for the class
                .setPosition("Catcher")
                .setJerseyNumber(28)
                .setBats("Right")
                .setSideThrows("Right")
                .setMlbDebut(2009);
        String connectPlayerIntro = club.connectPlayerIntro();
        String playerInfo = player.toString();
        sb.setLength(0);
        sb.append(String.format("%s%n",connectPlayerIntro));
        sb.append(String.format("%s%n",playerInfo));
        System.out.println(sb);


        sb.setLength(0);
        sb.append(String.format("%s%n", player.congratulateStudent(student.getFirstName())));
        sb.append(String.format("%s%n", player.sayStudentUniversity(student.getUniversity().getOfficialName())));
        System.out.print(sb);

        sb.setLength(0);
        System.out.print(student.talk());
        System.out.print(sb);
        String studentFirstResponse = input.next();
        input.nextLine();

        sb.setLength(0);
        sb.append(String.format("%s", player.replyToStudent(student.getFirstName())));
        sb.append(String.format("%s", player.askForNumberOfCards()));
        getNumberOfCards();
        System.out.print(sb);

        int numberOfCards = 1; // default number of cards to create

        sb.setLength(0);
        System.out.print(player.getCardDetails(numberOfCards));

        ArrayList<Card> cards = new ArrayList<>();
        int defaultArtSize = 13;
        String defaultArtFont = "Courier";

        for (int i = 0; i < numberOfCards; i++) {
            System.out.println(player.talk() + "Card #" + (i + 1) + ":");

            System.out.print(student.talk() + "[1] ");
            String recipient = input.next();
            input.nextLine();


            System.out.print(student.talk() + "[2] ");
            String artSymbolInput = input.next();
            char artSymbol = artSymbolInput.charAt(0);
            input.nextLine();

            System.out.print(student.talk() + "[3] ");
            String cardMessage = input.next();
            input.nextLine();

            cards.add(new Card(recipient, artSymbol, cardMessage, student.getFirstName(), student.getEmail(), defaultArtSize, defaultArtFont));
        }

        System.out.println("\n" + player.talk() + "Thanks " + student.getFirstName() + ". Please confirm your order");
        for (Card card : cards) {
            card.displayCard();
        }

        sb.setLength(0);
        sb.append(String.format("%s", student.talk()));
        System.out.print(sb);
        String studentThankYou = input.next();
        input.nextLine();

        sb.setLength(0);
        sb.append(String.format("%s%n", player.sayGoodbye(student.getFirstName())));
        System.out.print(sb);

        // student.sayThankyou
        // player.sayGoodbye
        runQuiz();
    }
    private void runQuiz() {

        quiz // quiz object given to the class
                .setClubName(club.getShortName()) // setClub name from the ChatSession's club object
                .setQuizTitle("*** FREE TICKETS to SF GIANTS Games ***")
                .setWinMessage("*** Congrats! You won FREE TICKETS to SF GIANTS Games ***")
                .setLoseMessage("____ Please try again at your graduation ceremony. ____")
                .setAllowedMisses(1)
                .addQuestion("Which type of class has 'protected' constructors?", "abstract")
                .addQuestion("What type of method did Java 8 add to 'interface'?", "default")
                .addQuestion("What new keyword did Java 13 add to 'switch' statement?", "yield")
                .addQuestion("In Java 15, what keyword pairs with 'sealed'?", "permits")
                .addQuestion("Giants in Spanish?", "Gigantes")
                .addQuestion("Take me out to the...?", "Ball Game");

        System.out.println(quiz.getQuizTitle());
        System.out.println(quiz.runQuiz(club, student, input));

    }

    private void stopChatSession() {
    }
    public void runChatSession() {
        startChatSession();
        connectChatters();
        chat();
    }

    public Club getClub() {
        return this.club;
    }

    public ChatSession setClub(Club club) {
        this.club = club;
        return this;
    }

    public University getUniversity() {
        return university;
    }

    public ChatSession setUniversity(University university) {
       this.university = university;
        return this;
    }

}