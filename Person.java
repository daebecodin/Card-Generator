/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Person.java
 * Author: Duc Ta
 * Author: <First Name> <Last Name>
 * **********************************************
 */

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

// JAVA 15, 2020, added "sealed" and "permits" to Java classes.
// We are learning the new elements of JAVA 15.
// "sealed" and "permits" are used here so that we will have one more example to reference.
// We do not need to understand "sealed" and "permits" in order to start and complete this assignment.
public sealed abstract class Person implements Greeting permits Student, Player, President, GeneralManager, Manager {

    //
    // Instance Data Fields
    //
    private String firstName;
    private String lastName;
    private String fullName;

    //
    // Constructors
    //
    public Person() {
    }

    public Person(String firstName, String lastName) {

    }

    // Instance Methods

    public String getFirstName() {
        return this.firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public Person setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }
    public Person setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
    public Person setFullName(String firstName, String lastName) {
        this.fullName = firstName + " " + lastName;
        return this;
    }



    //
    // Language
    //

    //
    // @override
    //
    @Override
    public void sayGreeting(String greeting) {
        System.out.println("I am a person");
    }

    @Override
    public String toString() {
        return "{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}