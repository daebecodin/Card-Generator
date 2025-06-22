/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Club.java
 * @author: Duc Ta
 * @author: Durand Dyer
 * @author: Ian Brown
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
    private static String officialSong;
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


    public Club() {

    }
    public Club(String name, String shortName, String officialSong, int establishedOn, List<String> teamColors, String teamBallPark, int worldSeriesTitles, int nationalLeaguePennants, int divisionTitles, int wildCardBerths, OwnerGroup teamOwners, President teamPresident, GeneralManager teamGeneralManager, Manager manager) {
        this.name = name;
        this.shortName = shortName;
        Club.officialSong = officialSong;
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

    public Club setOfficialSong(String officialSong) {
        Club.officialSong = officialSong;
        return this;
    }

    public Club setTeamColors(List<String> teamColors) {
        this.teamColors = teamColors;
        return this;
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
        return Club.officialSong;
    }

    public String displayClub() {
        return null;
    }

    public String clubIntro() {
        sb.setLength(0);
        // Using Language.getString for the introduction text
        sb.append(Language.getString("club.intro"));
        sb.append("\n");
        sb.append(Language.getString("config.separator"));
        return sb.toString();
    }

    public String connectPlayerIntro() {
        sb.setLength(0);
        sb.append("\n");
        // Using Language.getString for the player intro text
        sb.append(Language.getString("club.playerIntro"));
        sb.append(String.format("%n%s%n", ". . . . ."));
        sb.append(Language.getString("config.separator"));
        return sb.toString();
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


    // In Club.java

    @Override
    public String toString() {
        // No more isAlien check here. Just get the string!
        sb.setLength(0);
        sb.append(String.format("%-25s %s%n", Language.getString("club.name"), this.getName()));
        sb.append(String.format("%-25s %s%n", Language.getString("club.shortName"), this.getShortName()));
        sb.append(String.format("%-25s %s%n", Language.getString("club.establishedOn"), this.getEstablishedOn()));
        sb.append(String.format("%-25s %s%n", Language.getString("club.colors"), String.join(", ", this.getTeamColors())));
        sb.append(String.format("%-25s %s%n", Language.getString("club.ballpark"), this.getTeamBallPark()));
        sb.append(String.format("%-25s %s%n", Language.getString("club.worldSeriesTitles"), this.getWorldSeriesTitles()));
        sb.append(String.format("%-25s %s%n", Language.getString("club.nlPennants"), this.getNationalLeaguePennants()));
        sb.append(String.format("%-25s %s%n", Language.getString("club.divisionTitles"), this.getDivisionTitles()));
        sb.append(String.format("%-25s %s%n", Language.getString("club.wildCardBerths"), this.getWildCardBerths()));
        sb.append(String.format("%-25s %s%n", Language.getString("club.owners"), this.getTeamOwners().getName()));
        sb.append(String.format("%-25s %s%n", Language.getString("club.president"), this.getTeamPresident().getFullName()));
        sb.append(String.format("%-25s %s%n", Language.getString("club.generalManager"), this.getTeamGeneralManager().getFullName()));
        sb.append(String.format("%-25s %s%n", Language.getString("club.manager"), this.getManager().getFullName()));
        sb.append(Language.getString("config.separator")).append("\n");
        return sb.toString();
    }

    @Override
    public void displayAbout() {
        System.out.println(displayClub());
    }
    @Override
    public void displayMission() {

    }


}