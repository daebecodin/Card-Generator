/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Manager.java
 * Author: Duc Ta
 * Author: <First Name> <Last Name>
 * **********************************************
 */

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

public final class Manager extends Person {

    //
    // Instance Data Fields
    //
    private FrontOffice frontOffice;
    //
    // Constructors
    //
    public Manager() {
    }

    public Manager(String firstName, String lastName, FrontOffice frontOffice) {
        super(firstName, lastName);
        this.frontOffice = frontOffice;
    }

    public Manager(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public FrontOffice getFrontOffice() {
        return frontOffice;
    }

    public Manager setFrontOffice(FrontOffice frontOffice) {
        this.frontOffice = frontOffice;
        return this;
    }


    @Override
    public void sayGreeting(String string) {

    }

    //
    // Instance Methods
    //

    //
    // Language
    //

    //
    // Override
    //
}