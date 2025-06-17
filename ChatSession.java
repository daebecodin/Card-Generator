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

public final class ChatSession {

    //  Static Data Fields
    private Club club = new Club();
    private University university = new University();
    private static final int WIDTH = 70;
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
        System.out.println();
        System.out.println(club.getShortName() +": Welcome to the " + club.getName().toUpperCase()+"!");
        System.out.print("-".repeat(WIDTH));
        System.out.println();

    }
    private void connectChatters() {
    }
    private void chat() {
    }
    private void runQuiz() {
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