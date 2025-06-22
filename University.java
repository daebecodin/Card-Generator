/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: University.java
 * @author: Durand Dyer
 * @author: Ian Brown
 * **********************************************
 */

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

import java.util.ArrayList;
import java.util.List;

public final class University extends Organization {
    private static final StringBuilder sb = new StringBuilder();

    private static final int WIDTH = 70;

    private String officialName;
    private String mottoInLatin;
    private String mottoInEnglish;
    private String type;
    private int yearOfEstablishment;
    private String location;
    private String address;
    private List<String> universityColors = new ArrayList<>();
    private String nickName;
    private String mascot;
    private String website;
    private List<Student> students = new ArrayList<>();



    public University() {
    }

    public University(String defaultUniversity) {
    }

    public University(String officialName, String mottoInLatin, String mottoInEnglish, String type, int yearOfEstablishment, String location, String address, List<String> universityColors, String nickName, String mascot, String website, List<Student> students) {
        this.officialName = officialName;
        this.mottoInLatin = mottoInLatin;
        this.mottoInEnglish = mottoInEnglish;
        this.type = type;
        this.yearOfEstablishment = yearOfEstablishment;
        this.location = location;
        this.address = address;
        this.universityColors = universityColors;
        this.nickName = nickName;
        this.mascot = mascot;
        this.website = website;
        this.students = students;
    }



    public String getOfficialName() {
        return officialName;
    }

    public University setOfficialName(String officialName) {
        this.officialName = officialName;
        return this;
    }

    public String getMottoInLatin() {
        return mottoInLatin;
    }

    public University setMottoInLatin(String mottoInLatin) {
        this.mottoInLatin = mottoInLatin;
        return this;
    }

    public String getMottoInEnglish() {
        return mottoInEnglish;
    }

    public University setMottoInEnglish(String mottoInEnglish) {
        this.mottoInEnglish = mottoInEnglish;
        return this;
    }

    public String getType() {
        return type;
    }

    public University setType(String type) {
        this.type = type;
        return this;
    }

    public int getYearOfEstablishment() {
        return yearOfEstablishment;
    }

    public University setYearOfEstablishment(int yearOfEstablishment) {
        this.yearOfEstablishment = yearOfEstablishment;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public University setLocation(String location) {
        this.location = location;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public University setAddress(String address) {
        this.address = address;
        return this;
    }

    public List<String> getUniversityColors() {
        return universityColors;
    }

    public University setUniversityColors(List<String> universityColors) {
        this.universityColors = universityColors;
        return this;
    }

    public String getNickName() {
        return nickName;
    }

    public University setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public String getMascot() {
        return mascot;
    }

    public University setMascot(String mascot) {
        this.mascot = mascot;
        return this;
    }

    public String getWebsite() {
        return website;
    }

    public University setWebsite(String website) {
        this.website = website;
        return this;
    }

    public List<Student> getStudents() {
        return students;
    }

    public University setStudents(List<Student> students) {
        this.students = students;
        return this;
    }

    @Override
    public void displayAbout() {

    }

    @Override
    public void displayMission() {

    }


    // In University.java

    @Override
    public String toString() {
        sb.setLength(0);
        sb.append(String.format("%-25s %-50s%n", Language.getString("university.officialName"), this.officialName));
        sb.append(String.format("%-25s %-50s%n", Language.getString("university.data.motto.latin"), this.mottoInLatin));
        sb.append(String.format("%-25s %-50s%n", Language.getString("university.data.motto.english"), this.mottoInEnglish));
        sb.append(String.format("%-25s %-50s%n", Language.getString("university.type"), this.type));
        sb.append(String.format("%-25s %-50s%n", Language.getString("university.established"), this.yearOfEstablishment));
        sb.append(String.format("%-25s %-50s%n", Language.getString("university.location"), this.location));
        sb.append(String.format("%-25s %-50s%n", Language.getString("university.address"), this.address));
        sb.append(String.format("%-25s %-50s%n", Language.getString("university.colors"), String.join(", ", this.universityColors)));
        sb.append(String.format("%-25s %-50s%n", Language.getString("university.nickname"), this.nickName));
        sb.append(String.format("%-25s %-50s%n", Language.getString("university.mascot"), this.mascot));
        sb.append(String.format("%-25s %-50s%n", Language.getString("university.website"), this.website));
        sb.append(Language.getString("config.separator")).append("%n");
        return sb.toString();
    }
}