/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Player.java
 * @author: Durand Dyer
 * @author: Ian Brown
 * **********************************************
 */

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"


public final class Player extends Person {

    private static final int WIDTH = 70;
    private static Color sfsuColors = Color.Yellow.and(Color.BgPurple);

    private Club club;
    private String position;
    private int jerseyNumber;
    private String bats;
    private String sideThrows;
    private int mlbDebut;


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
        return String.format("%s, %d: ", this.getFullName(), this.getJerseyNumber());
    }

    public String congratulateStudent(String studentFirstName) {
        return String.format(Language.getString("chat.congratulateStudent"), talk(), studentFirstName);
    }

    public String sayStudentUniversity(String studentUniversity) {
        return String.format(Language.getString("player.sayUniversity"), talk(), sfsuColors.colorize(studentUniversity.toUpperCase()), " Way To Go!");
    }

    public String replyToStudent(String studentName) {
        return String.format(Language.getString("player.replyToStudent"), talk(), studentName);
    }

    public String askForNumberOfCards() {
        return String.format(Language.getString("player.askForCards"), talk());
    }

    public String getCardDetails(int numberOfCards) {
        // Use a local StringBuilder to build the multi-line string from localized keys
        StringBuilder detailsBuilder = new StringBuilder();

        // Line 1: The main prompt (e.g., "Buster Posey, 28: In 3 lines, please provide")
        detailsBuilder.append(talk())
                .append(String.format(Language.getString("player.cardDetails.prompt"), numberOfCards))
                .append(String.format("%n"));

        // Line 2: The first instruction with a tab
        detailsBuilder.append(String.format("\t%s%n", Language.getString("player.cardDetails.line1")));

        // Line 3: The second instruction with a tab
        detailsBuilder.append(String.format("\t%s%n", Language.getString("player.cardDetails.line2")));

        // Line 4: The third instruction with a tab
        detailsBuilder.append(String.format("\t%s%n", Language.getString("player.cardDetails.line3")));

        return detailsBuilder.toString();
    }

    public String sayGoodbye(String studentName) {
        return String.format(Language.getString("player.goodbye"), talk(), studentName);
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
        // maybe String.format
        return String.format("%-25s %-50s %n", this.getClass().getSimpleName(), this.getFullName()) +
                String.format("%-25s %-50s%n", Language.getString("player.club"), this.getClub().getName()) +
                String.format("%-25s %-50s%n", Language.getString("player.position"), this.getPosition()) +
                String.format("%-25s %-50s%n", Language.getString("player.number"), this.getJerseyNumber()) +
                String.format("%-25s %-50s%n", Language.getString("player.bats"), this.getBats()) +
                String.format("%-25s %-50s%n", Language.getString("player.throws"), this.getSideThrows()) +
                String.format("%-25s %-50s%n", Language.getString("player.debut"), this.getMlbDebut()) +
                Language.getString("config.separator") + "\n" + // maybe String.format
                String.format("%s", ". . . . .");
    }
}