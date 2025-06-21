/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Player.java
 * Author: Duc Ta
 * Author: <First Name> <Last Name>
 * **********************************************
 */

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"


public final class Player extends Person {

//    public static void main(String[] args) {
//        Club club = new Club()
//                .setName("San Francisco Giants")
//                .setShortName("SF Giants");
//
//        Person bp = new Player()
//                .setPosition("Short-Stop")
//                .setJerseyNumber(10)
//                .setTotalBats(74)
//                .setTotalThrows(16)
//                .setMlbDebut(2004)
//                .setClub(club)
//                .setFirstName("durand") // inherited from Person
//                .setLastName("dyer"); // inherited from Person
//
//
//        System.out.println(sb);
//    }
    private static final StringBuilder sb = new StringBuilder();
    private static final int WIDTH = 70;

    private static Color sfsuColors = Color.Yellow.and(Color.BgPurple);

    // Instance Data Fields
    private Club club;
    private String position;
    private int jerseyNumber;
    private String bats;
    private String sideThrows;
    private int mlbDebut;
    //
    // Constructors
    //
    public Player() {
    }

    public Player(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Player(String firstName, String lastName, Club club, String position, int jerseyNumber, String bats, String sideThrows, int mlbDebut) {
        super(firstName, lastName);
        this.club = club;
        this.position = position;
        this.jerseyNumber = jerseyNumber;
        this.bats = bats;
        this.sideThrows = sideThrows;
        this.mlbDebut = mlbDebut;
    }


    public Club getClub() {
        return this.club;
    }
    public String getPosition() {
        return this.position;
    }
    public int getJerseyNumber() {
        return this.jerseyNumber;
    }
    public String getBats() {
        return this.bats;
    }
    public String getSideThrows() {
        return this.sideThrows;
    }
    public int getMlbDebut() {
        return this.mlbDebut;
    }

    public String talk(){
//        StringBuilder localSb = new StringBuilder(); // local string builder because so we don't update shared string builder for messages
//        localSb.setLength(0);
//        localSb.append(String.format("%s%s %d%s", this.getFullName(), ",", this.getJerseyNumber(), ": "));
        return String.format("%s%s %d%s", this.getFullName(), ",", this.getJerseyNumber(), ": ");
    }

    public String congratulateStudent(String studentFirstName) {
        sb.setLength(0);
        sb.append(String.format("%s%s %s%s%s", talk(), "Hello", studentFirstName, ". ", "C-O-N-G-R-A-T-U-L-A-T-I-O-N-S!"));
        return sb.toString();
    }

    public String sayStudentUniversity(String studentUniversity) {
        sb.setLength(0);
        sb.append(String.format("%s%s%s%s", talk(), studentUniversity.toUpperCase(), ". ", "Way to go!"));
        return sb.toString();
    }

    public String replyToStudent(String studentName) {
        sb.setLength(0);
        sb.append(String.format("%s%s%s%s %s%n", talk(), "Likewise, ", studentName, ".", "Very nice chatting w/ you."));
        return sb.toString();
    }

    public String askForNumberOfCards() {
        sb.setLength(0);
        sb.append(String.format("%s%s%n", talk(), "How many SF Giants Thank You cards would you like to order?"));
        return sb.toString();
    }

    public String getCardDetails(int numberOfCards) {
        sb.setLength(0);
        sb.append(String.format("%s %s %d %s%n", this.talk(), "In", numberOfCards, "lines, please provide"));
        sb.append(String.format("%s%s%n", "\t", "[1] Recipients name"));
        sb.append(String.format("%s%s%n", "\t", "[2] Art symbol (a character)"));
        sb.append(String.format("%s%s%n", "\t", "[3] Message to recipient"));
        return sb.toString();
    }

    public String sayGoodbye(String studentName) {
        sb.setLength(0);
        sb.append(String.format("%s%s%s%s%n", talk(), "Thank you again, ", studentName, ". See you at your graduation ceremony"));
        return sb.toString();
    }

    public Player setClub(Club club) {
        this.club = club;
        return this;
    }
    public Player setPosition(String position) {
        this.position = position;
        return this;
    }
    public Player setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
        return this;
    }
    public Player setBats(String bats) {
        this.bats = bats;
        return this;
    }
    public Player setSideThrows(String sideThrows) {
        this.sideThrows = sideThrows;
        return this;
    }
    public Player setMlbDebut(int mlbDebut) {
        this.mlbDebut = mlbDebut;
        return this;
    }
    @Override
    public void sayGreeting(String string) {
    }

    @Override
    public String toString() {
        sb.setLength(0);
        sb.append(String.format("%-25s %-50s %n", this.getClass().getSimpleName(), this.getFullName()));
        sb.append(String.format("%-25s %-50s%n", "Club:", this.getClub().getName()));
        sb.append(String.format("%-25s %-50s%n", "Position:", this.getPosition()));
        sb.append(String.format("%-25s %-50s%n", "Number:", this.getJerseyNumber()));
        sb.append(String.format("%-25s %-50s%n", "Bats:", this.getBats()));
        sb.append(String.format("%-25s %-50s%n", "Throws:", this.getSideThrows()));
        sb.append(String.format("%-25s %-50s%n", "MLB Debut:", this.getMlbDebut()));
        sb.append("-".repeat(WIDTH)).append("\n"); // maybe String.format
        sb.append(String.format("%s", ". . . . ."));
        return sb.toString();

    }
}
