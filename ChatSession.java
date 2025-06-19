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

import java.util.List;

public final class ChatSession {

    //  Static Data Fields
    private Club club = new Club("SF Giants");
    private University university = new University();
    private static final int WIDTH = 70;
    private static final StringBuilder sb = new StringBuilder();
    //
    // Instance Data Fields
    //
    // Constructors
    //
    public ChatSession() {
    }

    public ChatSession(Club club, University university) {
        this.club = club;
        this.university = university;
    }

    //
    // Instance Methods
    //

    //
    // Additional Instance Methods
    //
    private void startChatSession() {
        if (Language.getLocale().equalsIgnoreCase("alien")) {
            System.out.println(Timer.timeStamp() + " - " + Language.getAlienSound());
        } else {
            System.out.println(Timer.timeStamp() + " - Chat Session Started");
        }
        sb.append(club.getShortName()).append(":").append("Welcome to the ").append(club.getName().toUpperCase()).append("!").append("\n");
        sb.append("-".repeat(WIDTH)).append("\n");
        System.out.println();
        Club club = new Club()
                .setName("San Francisco Giants")
                .setShortName("SF Giants")
                .setEstablishedOn(1883)
                .setTeamColors(List.of("orange", "black", "gold", "cream"))
                .setTeamBallPark("Oracle Park")
                .setWorldSeriesTitles(8)
                .setNationalLeaguePennants(23)
                .setDivisionTitles(8)
                .setWildCardBerths(3)
                .setTeamOwners(new OwnerGroup("San Francisco Baseball Association", this.getClub()))
                .setTeamPresident(new President("Farhan", "Zadai"))
                .setTeamGeneralManager(new GeneralManager("Scott", "Harris"))
                .setManager(new Manager("Gabe", "Kepler"));

        sb.append(String.format("%-25s %-50s%n", "Club:", club.getName())).append("\n");

        System.out.println(sb);





    }
    private void connectChatters() {
    }
    private void chat() {
    }
    private void runQuiz() {
        Quiz giantsQuiz = new Quiz()
                .setQuizTitle(" *** FREE TICKETS to SF GIANTS Games *** _ 1 miss allowed _")
                .setWinMessage(" *** Congrats! You won FREE TICKETS to SF GIANTS Games ***")
                .setLoseMessage(" ____ Please try again at your graduation ceremony. ____")
                .setAllowedMisses(1)
                .addQuestion("Which type of class has 'protected' constructors?",
                        "abstract")
                .addQuestion(" What type of method did Java 8 add to 'interface'?",
                        "default")
                .addQuestion(" What new keyword did Java 13 add to 'switch' statement?",
                        "yield")
                .addQuestion(" In Java 15, what keyword pairs with 'sealed'?",
                        "permits")
                .addQuestion(" Giants in Spanish?",
                        "Gigantes")
                .addQuestion(" Take me out to the...?",
                        "Ball Game");
        //
        // Where put userName?? idk i didn't look into that yet
        //
    }
    private void stopChatSession() {
    }
    public void runChatSession() {
        startChatSession();
    }

    //
    // Language
    //


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