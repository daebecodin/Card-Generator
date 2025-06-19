/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: OwnerGroup.java
 * Author: Duc Ta
 * Author: <First Name> <Last Name>
 * **********************************************
 */

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

public final class OwnerGroup extends Organization{
    //
    // Data fields
    //
    private String name;
    private Club club;
    //
    // Constructors
    //
    public OwnerGroup() {
    }

    public OwnerGroup(String name, Club club) {
        this.name = name;
        this.club = club;
    }

    public Club getClub() {
        return club;
    }

    public OwnerGroup setClub(Club club) {
        this.club = club;
        return this;
    }

    public String getName() {
        return name;
    }

    public OwnerGroup setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public void displayAbout() {

    }

    @Override
    public void displayMission() {

    }

    //
    // Instance Methods
    //

    //
    // Override
    //

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", club=" + club +
                "} " + super.toString();
    }
}