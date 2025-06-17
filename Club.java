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


    public Club(String defaultClub) {
        this.name = "San Francisco Giants";
        this.shortName = "SF Giants";
        this.establishedOn = 1813;
        this.teamColors = List.of("Orange", "Black", "Gold", "Cream");
        this.teamBallPark = "Oracle Park";
        this.worldSeriesTitles = 8;
        this.nationalLeaguePennants = 23;
        this.divisionTitles = 8;
        this.wildCardBerths = 3;
        this.teamOwners = new OwnerGroup();

        // downcasting because they come in as Person objects
        this.teamPresident = (President) new President().setFirstName("Farhan").setLastName("Zaidi");
        this.teamGeneralManager = (GeneralManager) new GeneralManager().setFirstName("Scott").setLastName("Harris");
        this.manager = (Manager) new Manager().setFirstName("Gabe").setLastName("Kapler");
    }

    public static String getOfficialSong() {
        return "Yahoo";
    }

    @Override
    public void displayAbout() {

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

    public President getTeamPresident() {
        return this.teamPresident;
    }

    public GeneralManager getTeamGeneralManager() {
        return this.teamGeneralManager;
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

    public Club setTeamColors(List<String> teamColors) {
        this.teamColors = teamColors;
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

    //
    // Language
    //
}