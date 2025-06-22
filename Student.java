/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Student.java
 * @author: Durand Dyer
 * @author: Ian Brown
 * **********************************************
 */

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class Student extends Person {

    private static final int WIDTH = 70;
    private static final StringBuilder sb = new StringBuilder();

    private static final Color sfsuColors = Color.Yellow.and(Color.BgPurple);
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


    public String talk() {
//        sb.setLength(0);
//        sb.append(String.format("%s%s", this.getFullName(), ": "));
        return sfsuColors.colorize(this.getFullName()) + ": ";
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


}