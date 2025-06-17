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

    // Instance Data Fields
    private Club club;
    private String position;
    private int jerseyNumber;
    private int totalBats;
    private int totalThrows;
    private int mlbDebut;
    //
    // Constructors
    //
    public Player() {
    }

    public Player(String firstName, String lastName, Club club, String position, int jerseyNumber, int totalBats, int totalThrows, int mlbDebut) {
        super(firstName, lastName);
        this.club = club;
        this.position = position;
        this.jerseyNumber = jerseyNumber;
        this.totalBats = totalBats;
        this.totalThrows = totalThrows;
        this.mlbDebut = mlbDebut;
    }

    //
    // Instance Methods
    //
    public StringBuilder display() {
        sb.append(this.getClass().getSimpleName()).append(": ").append(this.getFullName());
        sb.append(String.format("%-25s %-50s", "Club:", this.getClub()));
        sb.append(String.format("%-25s %-50s", "Position:", this.getPosition()));
        sb.append(String.format("%-25s %-50s", "Number:", this.getJerseyNumber()));
        sb.append(String.format("%-25s %-50s", "Bats:", this.getTotalBats()));
        sb.append(String.format("%-25s %-50s", "Throws:", this.getTotalThrows()));
        sb.append(String.format("%-25s %-50s", "MLB Debut:", this.getMlbDebut()));

        return sb;
    }
    //
    // Additional Instance Methods
    //
    public Club getClub() {
        return this.club;
    }
    public String getPosition() {
        return this.position;
    }
    public int getJerseyNumber() {
        return this.jerseyNumber;
    }
    public int getTotalBats() {
        return this.totalBats;
    }
    public int getTotalThrows() {
        return this.totalThrows;
    }
    public int getMlbDebut() {
        return this.mlbDebut;
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
    public Player setTotalBats(int totalBats) {
        this.totalBats = totalBats;
        return this;
    }
    public Player setTotalThrows(int totalThrows) {
        this.totalThrows = totalThrows;
        return this;
    }
    public Player setMlbDebut(int mlbDebut) {
        this.mlbDebut = mlbDebut;
        return this;
    }
    //
    // Language
    //

    //
    // @Override
    //
    @Override
    public void sayGreeting(String string) {
    }

    @Override
    public String toString() {
        return "{" +
                "club=" + club +
                ", position='" + position + '\'' +
                ", jerseyNumber=" + jerseyNumber +
                ", totalBats=" + totalBats +
                ", totalThrows=" + totalThrows +
                "} " + super.toString();
    }
}
