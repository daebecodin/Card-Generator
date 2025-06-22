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
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public final class ChatSession {

    private Club club;
    private University university;
    private final Student student = new Student(); // composite relationship to the session
    private final Player player = new Player(); // compose relationship to the session
    private final Quiz quiz = new Quiz(); // composite relationship to the session
    private static final int WIDTH = 70;
    private static final Scanner input = new Scanner(System.in);



    /**
     * Default constructor.
     */
    public ChatSession() {
    }

    /**
     * Constructor to initialize a session with a club and university.
     * @param club The Club object.
     * @param university The University object.
     */
    public ChatSession(Club club, University university) {
        this.club = club;
        this.university = university;
    }

    /**
     * Initializes the chat session, sets up the Club's details, and prints the intro.
     */
    private void startChatSession() {
        // All club data is loaded from the resource bundle via the Language class
        club
                .setName(Language.getString("club.data.name"))
                .setShortName(Language.getString("club.data.shortName"))
                .setEstablishedOn(1883)
                .setTeamColors(Arrays.asList(Language.getString("club.data.colors").split(",\\s*")))
                .setTeamBallPark(Language.getString("club.data.ballpark"))
                .setWorldSeriesTitles(8)
                .setNationalLeaguePennants(23)
                .setDivisionTitles(8)
                .setWildCardBerths(3)
                .setOfficialSong(Language.getString("club.data.song"))
                .setTeamOwners(new OwnerGroup(Language.getString("club.data.ownerGroup"), this.getClub()))
                .setTeamPresident(new President(Language.getString("club.data.president.firstName"), Language.getString("club.data.president.lastName")))
                .setTeamGeneralManager(new GeneralManager(Language.getString("club.data.gm.firstName"), Language.getString("club.data.gm.lastName")))
                .setManager(new Manager(Language.getString("club.data.manager.firstName"), Language.getString("club.data.manager.lastName")));


        Timer timer = Messenger.getConfig().getTimer();
        System.out.printf("%s%s%s%n", timer.timeStamp(), " - ", Language.getString("chat.session.started"));
        System.out.println();

        System.out.println(club.clubIntro());
        System.out.println(club.toString());
    }

    /**
     * Gathers information from the student and sets up the University details.
     */
    private void connectChatters() {

        // Build the prompt using the club's short name and the prompt.
        System.out.print(club.getShortName() + " " + Language.getString("chat.prompt.name"));
        student.setFirstName(input.next());
        student.setLastName(input.next());

        System.out.print(club.getShortName() + " " + Language.getString("chat.prompt.email"));
        student.setEmail(input.next());
        System.out.println(""); // Print a blank line for spacing.

        // creating a receipt file path
        Messenger.getConfig().getStdOutStdErrTee().finalizeReceiptFilePath(student.getFullName(), student.getEmail());


        System.out.printf(Language.getString("chat.welcome") + "%n", student.talk());
        System.out.println(Language.getString("config.separator"));

        // All university data is loaded from the resource bundle.
        university
                .setOfficialName(Language.getString("university.data.name"))
                .setMottoInLatin(Language.getString("university.data.motto.latin"))
                .setMottoInEnglish(Language.getString("university.data.motto.english"))
                .setType(Language.getString("university.data.type"))
                .setYearOfEstablishment(1999)
                .setLocation(Language.getString("university.data.location"))
                .setAddress(Language.getString("university.data.address"))
                .setUniversityColors(Arrays.asList(Language.getString("university.data.colors").split(",\\s*")))
                .setNickName(Language.getString("university.data.nickname"))
                .setMascot(Language.getString("university.data.mascot"))
                .setWebsite(Language.getString("university.data.website"));

        student.setUniversity(university);
        System.out.println(university.toString());
    }

    /**
     * Handles getting the number of cards from the user with retries for invalid input.
     * @return The number of cards entered by the user, defaulting to 1 on repeated failure.
     */
    private int getNumberOfCards() {
        int numberOfCards = 1;
        int tries = 3; // Give the user 3 attempts.

        System.out.print(student.talk());
        while (tries > 0) {
            try {
                return input.nextInt();
            } catch (InputMismatchException e) {
                input.nextLine(); // Clear the invalid input from the scanner.
                System.err.println(e.getClass().getName()); // Keep errors on System.err.
                // This message for the programmer/user doesn't need to be localized.
                System.out.println("Please enter an INTEGER. " + (tries) + " tries left.");
                tries--;
                if (tries > 0) {
                    System.out.print(student.talk());
                }
            }
        }
        System.out.println("Proceeding with 1 card by default.");
        return numberOfCards;
    }

    /**
     * The main interactive part of the chat with the Player.
     */
    private void chat() {
        // All player data is now loaded from the resource bundle.
        player.setClub(club)
                .setPosition(Language.getString("player.data.position"))
                .setJerseyNumber(28)
                .setBats(Language.getString("player.data.bats"))
                .setSideThrows(Language.getString("player.data.throws"))
                .setMlbDebut(2009)
                .setFirstName(Language.getString("player.data.firstName"))
                .setLastName(Language.getString("player.data.lastName"));

        System.out.printf("%s%n", club.connectPlayerIntro());
        System.out.printf("%s%n", player.toString());

        System.out.printf("%s%n", player.congratulateStudent(student.getFirstName()));
        System.out.printf("%s%n", player.sayStudentUniversity(student.getUniversity().getOfficialName()));

        System.out.print(student.talk());
        input.next(); // Consume student's response.
        input.nextLine(); // Consume the rest of the line.

        System.out.printf("%s", player.replyToStudent(student.getFirstName()));
        System.out.printf("%s", player.askForNumberOfCards());

        int howManyCards = getNumberOfCards();
        System.out.printf("%s", player.getCardDetails(howManyCards));

        ArrayList<Card> cards = new ArrayList<>();
        int defaultArtSize = 13;
        String defaultArtFont = "Courier";

        for (int i = 0; i < howManyCards; i++) {
            System.out.println(player.talk() + "Card #" + (i + 1) + ":");

            System.out.print(student.talk() + "[1] ");
            String recipient = input.next();
            input.nextLine();

            System.out.print(student.talk() + "[2] ");
            char artSymbol = input.next().charAt(0);
            input.nextLine();

            System.out.print(student.talk() + "[3] ");
            String cardMessage = input.nextLine();

            cards.add(new Card(recipient, artSymbol, cardMessage, student.getFirstName(), student.getEmail(), defaultArtSize, defaultArtFont));
        }

        student.setCards(cards); // Store the created cards in the student object


        System.out.printf((Language.getString("player.confirmOrder")) + "%n", player.talk(), student.getFirstName());
        for (Card card : cards) {
            card.displayCard();
        }

        System.out.print(student.talk());
        input.next(); // Consume student's confirmation.
        input.nextLine();

        System.out.printf("%s%n%n", player.sayGoodbye(student.getFirstName()));
    }

    /**
     * Sets up and runs the quiz for the student.
     */
    private String performQuiz() {
        quiz //
                .setClubName(club.getShortName())
                .setQuizTitle(club.getShortName() + Language.getString("quiz.title")) //
                .setWinMessage(Language.getString("quiz.win")) // Modified to match screenshot
                .setLoseMessage(Language.getString("quiz.lose"))
                .setAllowedMisses(1) //
                .addQuestion("quiz.question.1", "quiz.answer.1")
                .addQuestion("quiz.question.2", "quiz.answer.2")
                .addQuestion("quiz.question.3", "quiz.answer.3")
                .addQuestion("quiz.question.4", "quiz.answer.4")
                .addQuestion("quiz.question.5", "quiz.answer.5")
                .addQuestion("quiz.question.6", "quiz.answer.6");

        System.out.println(quiz.getQuizTitle());
        return quiz.runQuiz(club, student, input); // Capture the returned result
    }


    /**
     * Stops the chat session and exits the program.
     */
    private void stopChatSession() {
//        System.exit(0); // A 0 status indicates a normal, successful exit.
    }

    /**
     * The main entry point to run the entire chat session flow.
     */
    public void runChatSession() {
        startChatSession();
        connectChatters();
        chat();
//        stopChatSession();

        // Generate the receipt with all collected info including the quiz result
        String result = performQuiz();
        Receipt.generate(Messenger.getConfig(), student, player, (ArrayList<Card>) student.getCards(), result );

        stopChatSession();
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