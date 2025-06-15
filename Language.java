/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Language.java
 * @author: Duc Ta
 * @author: <First Name> <Last Name>
 * **********************************************
 */

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

// java.util.ResourceBundle
// - ResourceBundle is a valid approach to internationalization.
// - ResourceBundle is not required.
// - Other approaches to internationalization are available. Some of these approaches are
// more straightforward and more relevant to new CSC 220 students then ResourceBundle is.
// - Yet, curiosity for intelligence is always highly encouraged:
// https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/ResourceBundle.html


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public final class Language {
    //
    // Static Data Fields
    //    
    private static final String defaultAlienSound = "~ ąļīæń ~ "; // Default
    private static final Config config = new Config();
    private static final int WIDTH = 70;

    private final Map<String, String> phrases = new HashMap<>();

    private static final Scanner input = new Scanner(System.in);


    //
    // Instance Data Fields
    //





    //
    // Constructors
    //
    public Language() {
    }
    public Language(String language) {

        switch (language.toLowerCase()) {
            case "alien" -> this.populateAlienPhrases();            // Supported
//            case "chinese" -> this.populateChinesePhrases();        // Future implementation
//            case "french" -> this.populateFrenchPhrases();          // Future implementation
//            case "spanish" -> this.populateSpanishPhrases();        // Future implementation
//            case "future" -> this.populateYourLanguagePhrases();    // Future implementation
            default -> this.populateEnglishPhrases();               // Supported
        }

    }

    public static void displayAppHeader() {
        System.out.println("----------------------------------------------------------------------");
        System.out.println("------------------------- SF GIANTS THANK YOU ------------------------");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("                                             powered by CSC 220 @ SFSU");
    }


    public void setLanguagePreference() {

        System.out.println("Language: ");
        String lang = input.next().trim().toLowerCase();
        switch (lang) {
            case "alien" -> populateAlienPhrases();
            case "english" -> populateEnglishPhrases();
            default -> throw new IllegalStateException("Unexpected value: " + lang);
        }

    }

    private void populateAlienPhrases() {
    }
    private void populateEnglishPhrases() {
    }

    //
    // Static Methods
    //

    //
    // Additional Static Methods
    //

    //
    // Instance Methods
    //

    //
    // Language
    //
}