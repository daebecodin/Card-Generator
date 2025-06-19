/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Student.java
 * Author: Duc Ta
 * Author: <First Name> <Last Name>
 * **********************************************
 */

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

import java.util.ArrayList;
import java.util.List;

public final class Student extends Person {

    private static final int WIDTH = 70;
    //
    // Instance Data Fields
    //
    private String email;
    private List<Card> cards;
    private University university;

    //
    // Constructors
    //
    public Student() {
    }
    public Student(String name) {
        super(name);
    }
    public Student(String email, List<Card> cards, University university) {
        this.email = email;
        this.cards = cards;
        this.university = university;
    }

    public String getEmail() {
        return email;
    }

    public Student setEmail(String email) {
        this.email = email;
        return this;
    }

    public List<Card> getCards() {
        return cards;
    }

    public Student setCards(List<Card> cards) {
        this.cards = cards;
        return this;
    }

    public University getUniversity() {
        return university;
    }

    public Student setUniversity(University university) {
        this.university = university;
        return this;
    }

    @Override
    public void sayGreeting(String string) {
        System.out.println("I am a student");
    }

    //
    // Instance Methods
    //

    //
    // Additional Methods
    //

    //
    // Language
    //

    //
    // Override
    //
}