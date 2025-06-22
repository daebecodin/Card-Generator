/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: GeneralManager.java
 * @author: Durand Dyer
 * @author: Ian Brown
 * **********************************************
 */

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

public final class GeneralManager extends Person {

    //
    // Instance Data Fields
    //
    private FrontOffice frontOffice;

    //
    // Constructors
    //
    public GeneralManager() {
    }

    public GeneralManager(String firstName, String lastName, FrontOffice frontOffice) {
        super(firstName, lastName);
        this.frontOffice = frontOffice;
    }

    public GeneralManager(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public FrontOffice getFrontOffice() {
        return frontOffice;
    }

    public GeneralManager setFrontOffice(FrontOffice frontOffice) {
        this.frontOffice = frontOffice;
        return this;
    }

    @Override
    public void sayGreeting(String string) {
        System.out.println("I am a general manager");
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