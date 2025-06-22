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

    // ---
    // Data Fields
    // ---
    private Club club;
    private University university;
    private final Student student = new Student(); // composite relationship to the session
    private final Player player = new Player(); // compose relationship to the session
    private final Quiz quiz = new Quiz(); // composite relationship to the session
    private static final int WIDTH = 70;
    private static final Scanner input = new Scanner(System.in);

    // ---
    // Refactoring Note:
    // The static StringBuilder 'sb' was removed. We will now use the methods
    // from the Language class (e.g., Language.printf) to handle all user-facing
    // output. This simplifies the code and automatically handles the translation
    // to the "alien" language when the locale is set.
    // ---

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
        // All club data is now loaded from the resource bundle via the Language class
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


        // This is a system log message, so it doesn't need translation.
        Timer timer = Messenger.getConfig().getTimer();
        System.out.printf("%s%s%n", timer.timeStamp(), " - Chat session started");
        System.out.println();

        // The clubIntro() and toString() methods are already localized, so we print their output directly.
        System.out.println(club.clubIntro());
        System.out.println(club.toString());
    }

    /**
     * Gathers information from the student and sets up the University details.
     */
    private void connectChatters() {
        // Build the prompt using the club's (now localized) short name and the localized prompt text.
        System.out.print(club.getShortName() + ": " + Language.getString("chat.prompt.name"));
        student.setFirstName(input.next());
        student.setLastName(input.next());

        System.out.print(club.getShortName() + ": " + Language.getString("chat.prompt.email"));
        student.setEmail(input.next());
        System.out.println(""); // Print a blank line for spacing.

        // The student's "talk()" method provides their name, and the welcome message is localized.
        System.out.printf(Language.getString("chat.welcome") + "%n", student.talk());
        System.out.println("-".repeat(WIDTH));

        // All university data is now loaded from the resource bundle.
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

        // All conversational methods now produce localized output.
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

        System.out.println("\n" + String.format(Language.getString("player.confirmOrder"), player.talk(), student.getFirstName()));
        for (Card card : cards) {
            card.displayCard();
        }

        System.out.print(student.talk());
        input.next(); // Consume student's confirmation.
        input.nextLine();

        System.out.printf("%s%n", player.sayGoodbye(student.getFirstName()));
        runQuiz();
    }

    /**
     * Sets up and runs the quiz for the student.
     */
    private void runQuiz() {
        quiz
                .setClubName(club.getShortName())
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

    /**
     * Stops the chat session and exits the program.
     */
    private void stopChatSession() {
        System.exit(0); // A 0 status indicates a normal, successful exit.
    }

    /**
     * The main entry point to run the entire chat session flow.
     */
    public void runChatSession() {
        startChatSession();
        connectChatters();
        chat();
        stopChatSession();
    }

    // ---
    // Getters and Setters
    // ---
    public Club getClub() {
        return this.club;
    }

    public String getCardDetails(int numberOfCards) {
        // Use a local StringBuilder to build the multi-line string
        StringBuilder detailsBuilder = new StringBuilder();

        // Line 1: The main prompt (e.g., "Buster Posey, 28: In 3 lines, please provide")
        detailsBuilder.append(player.talk())
                .append(String.format(Language.getString("player.cardDetails.prompt"), numberOfCards))
                .append(String.format("%n"));

        // Line 2: The first instruction with a tab
        detailsBuilder.append(String.format("\t%s%n", Language.getString("player.cardDetails.line1")));

        // Line 3: The second instruction with a tab
        detailsBuilder.append(String.format("\t%s%n", Language.getString("player.cardDetails.line2")));

        // Line 4: The third instruction with a tab
        detailsBuilder.append(String.format("\t%s", Language.getString("player.cardDetails.line3")));

        return detailsBuilder.toString();
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