/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Club.java
 * @author: Duc Ta
 * @author: <First Name> <Last Name>
 * **********************************************
 */

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

import java.util.ArrayList;
import java.util.List;


public final class Club extends Organization {

    private static final StringBuilder sb = new StringBuilder();
    private static final int WIDTH = 70;

    //
    // Instance Data Fields
    //
    private String name;
    private String shortName;
    private int establishedOn;
    private List<String> teamColors = new ArrayList<>();
    private String teamBallPark;
    private int worldSeriesTitles;
    private int nationalLeaguePennants;
    private int divisionTitles;
    private int wildCardBerths;
    private OwnerGroup teamOwners;
    private President teamPresident;
    private GeneralManager teamGeneralManager;
    private Manager manager;

    //
    // Constructors
    //


    public Club() {

    }


    public Club(String name, String shortName, int establishedOn, List<String> teamColors, String teamBallPark, int worldSeriesTitles, int nationalLeaguePennants, int divisionTitles, int wildCardBerths, OwnerGroup teamOwners, President teamPresident, GeneralManager teamGeneralManager, Manager manager) {
        this.name = name;
        this.shortName = shortName;
        this.establishedOn = establishedOn;
        this.teamColors = teamColors;
        this.teamBallPark = teamBallPark;
        this.worldSeriesTitles = worldSeriesTitles;
        this.nationalLeaguePennants = nationalLeaguePennants;
        this.divisionTitles = divisionTitles;
        this.wildCardBerths = wildCardBerths;
        this.teamOwners = teamOwners;
        this.teamPresident = teamPresident;
        this.teamGeneralManager = teamGeneralManager;
        this.manager = manager;
    }

    public Club(String name) {
        this.name = name;
    }

    public President getTeamPresident() {
        return this.teamPresident;
    }
    public GeneralManager getTeamGeneralManager() {
        return this.teamGeneralManager;
    }
    public Manager getTeamManager() {
        return this.manager;
    }
    public static String getOfficialSong() {
        return "Yahoo";
    }

    @Override
    public void displayAbout() {
        System.out.println(displayClub());
    }

    public String displayClub() {
//        sb.append("Club: ").append(new Club().displayClub());
        return null;

    }

    @Override
    public void displayMission() {

    }

    public String getName() {
        return this.name;
    }

    public String getShortName() {
        return this.shortName;
    }

    public int getEstablishedOn() {
        return this.establishedOn;
    }

    public List<String> getTeamColors() {
        return this.teamColors;
    }

    public String getTeamBallPark() {
        return this.teamBallPark;
    }

    public int getWorldSeriesTitles() {
        return this.worldSeriesTitles;
    }

    public int getNationalLeaguePennants() {
        return this.nationalLeaguePennants;
    }

    public int getDivisionTitles() {
        return divisionTitles;
    }

    public int getWildCardBerths() {
        return this.wildCardBerths;
    }

    public OwnerGroup getTeamOwners() {
        return this.teamOwners;
    }

    public Manager getManager() {
        return this.manager;
    }

    public Club setName(String name) {
        this.name = name;
        return this;
    }

    public Club setShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public Club setEstablishedOn(int establishedOn) {
        this.establishedOn = establishedOn;
        return this;
    }

    public Club setTeamColors(String... teamColors) {
        this.teamColors = List.of(teamColors);
        return this;
    }

    public Club setTeamBallPark(String teamBallPark) {
        this.teamBallPark = teamBallPark;
        return this;
    }

    public Club setWorldSeriesTitles(int worldSeriesTitles) {
        this.worldSeriesTitles = worldSeriesTitles;
        return this;
    }

    public Club setNationalLeaguePennants(int nationalLeaguePennants) {
        this.nationalLeaguePennants = nationalLeaguePennants;
        return this;
    }

    public Club setDivisionTitles(int divisionTitles) {
        this.divisionTitles = divisionTitles;
        return this;
    }

    public Club setWildCardBerths(int wildCardBerths) {
        this.wildCardBerths = wildCardBerths;
        return this;
    }

    public Club setTeamOwners(OwnerGroup teamOwners) {
        this.teamOwners = teamOwners;
        return this;
    }

    public Club setTeamPresident(President teamPresident) {
        this.teamPresident = teamPresident;
        return this;
    }

    public Club setTeamGeneralManager(GeneralManager teamGeneralManager) {
        this.teamGeneralManager = teamGeneralManager;
        return this;
    }

    public Club setManager(Manager manager) {
        this.manager = manager;
        return this;
    }

    public String clubIntro() {
        sb.setLength(0);
        sb.append("\n");
        sb.append(this.getShortName()).append(": ").append("Welcome to the ").append(this.getName().toUpperCase()).append("!").append("\n");
        sb.append("-".repeat(WIDTH));
        return sb.toString();
    }
    public String connectPlayerIntro() {
        sb.setLength(0);
        sb.append("\n");
        sb.append(String.format("%s %s %s%n", this.getShortName(), ": ", "We are connecting you with our player...")).append(String.format("%s%n", "....."));
        sb.append("-".repeat(WIDTH));
        return sb.toString();
    }
    @Override
    public String toString() {
        sb.setLength(0); // clear buffer
        sb.append(String.format("%-25s %-50s%n", "Club:", this.getName()));
        sb.append(String.format("%-25s %-50s%n", "Short Name:", this.getShortName()));
        sb.append(String.format("%-25s %-50s%n", "Established In:", this.getEstablishedOn()));
        sb.append(String.format("%-25s %-50s%n", "Colors:", String.join(", ", this.getTeamColors())));
        sb.append(String.format("%-25s %-50s%n", "Ball Park:", this.getTeamBallPark()));
        sb.append(String.format("%-25s %-50s%n", "World Series Titles:", this.getWorldSeriesTitles()));
        sb.append(String.format("%-25s %-50s%n", "NL Pennants:", this.getNationalLeaguePennants()));
        sb.append(String.format("%-25s %-50s%n", "Wild Card Berths", this.getWildCardBerths()));
        sb.append(String.format("%-25s %-50s%n", "Owners", this.getTeamOwners().getName()));
        sb.append(String.format("%-25s %-50s%n", "President:", this.getTeamPresident().getFullName()));
        sb.append(String.format("%-25s %-50s%n", "General Manager:", this.getTeamGeneralManager().getFullName()));
        sb.append(String.format("%-25s %-50s%n", "Manager", this.getTeamManager().getFullName()));
        sb.append("-".repeat(WIDTH)).append("\n");
        return sb.toString();
    }
}