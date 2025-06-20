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
import java.util.List;
import java.util.Scanner;

public final class ChatSession {

    private Club club;
    private University university;
    private final Student student = new Student();
    private final Player player = new Player("Buster", "Posey");
    private final Quiz quiz = new Quiz();
    private static final int WIDTH = 70;
    private static final StringBuilder sb = new StringBuilder();
    private static final Scanner input = new Scanner(System.in);

    public ChatSession() {
    }

    public ChatSession(Club club, University university) {
        this.club = club;
        this.university = university;
//        this.student = student;
//        this.player = player;
    }


    private void startChatSession() {

        sb.setLength(0);
        sb.append(String.format("%s%s", Timer.timeStamp(), " - Chat Session Started "));
        club
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

        university
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
    private void chat() {

        player.setClub(club)
                .setPosition("Catcher")
                .setJerseyNumber(28)
                .setBats("Right")
                .setSideThrows("Right")
                .setMlbDebut(2009);
        String connectPlayerIntro = club.connectPlayerIntro();
        System.out.println(connectPlayerIntro);
        String playerInfo = player.toString();
        System.out.println(playerInfo);


        sb.setLength(0);
        sb.append(String.format("%s%n", player.congratulateStudent(student.getFirstName())));
        sb.append(String.format("%s%n", player.sayStudentUniversity(student.getUniversity().getOfficialName())));
        System.out.print(sb);

        System.out.print(student.talk());
        String studentFirstResponse = input.next();
        input.nextLine();

        sb.setLength(0);
        sb.append(String.format("%s", player.replyToStudent(student.getFirstName())));
        sb.append(String.format("%s", player.askForNumberOfCards()));
        System.out.print(sb);

        System.out.print(student.talk());
        int numberOfCards = input.nextInt();
        input.nextLine();


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
        sb.append("\n");

        // student.sayThankyou
        // player.sayGoodbye
        runQuiz();
    }
    private void runQuiz() {

        quiz
                .setClubName(club.getShortName()) // Set club name from the ChatSession's club object
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

        System.out.println(quiz.runQuiz(club, student));

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