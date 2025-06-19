/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: President.java
 * Author: Duc Ta
 * Author: <First Name> <Last Name>
 * **********************************************
 */

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

public final class President extends Person {

    //
    // Instance Data Fields
    //
    private FrontOffice frontOffice;
    private Club club;

    //
    // Constructors
    //
    public President() {
    }

    public President(String firstName, String lastName) {
        super(firstName, lastName);
    }
    public President(String firstName, String lastName, FrontOffice frontOffice, Club club) {
        super(firstName, lastName);
        this.frontOffice = frontOffice;
        this.club = club;
    }

    public President(FrontOffice frontOffice, Club club) {
        this.frontOffice = frontOffice;
        this.club = club;
    }
    public President(FrontOffice frontOffice) {
        this.frontOffice = frontOffice;
    }



    //
    // Instance Methods
    //
    public FrontOffice getFrontOffice() {
        return this.frontOffice;
    }
    public Club getClub() {
        return this.club;
    }

    public President setFrontOffice(FrontOffice frontOffice) {
        this.frontOffice = frontOffice;
        return this;
    }
    public President setClub(Club club) {
        this.club = club;
        return this;
    }
    //
    // Language
    //

    //
    // Override
    //
    @Override
    public void sayGreeting(String greeting) {
        System.out.println("I am a President");
    }

    @Override
    public String toString() {
        return super.toString().replace("}", "") + "{" +
                "frontOffice=" + frontOffice +
                ", club=" + club +
                '}';
    }
}


