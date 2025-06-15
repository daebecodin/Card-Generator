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
    private String locale = "";



    public static void main(String[] args) {
        displayAppHeader();

        setLanguagePreference();
    }

    //
    // Instance Data Fields
    //

    //
    // Constructors
    //
    public Language() {
    }

    public  Language(String locale) {
        this.locale = locale;
    }
    //
    // Static Methods
    //

    public static void displayAppHeader() {
        System.out.println(Config.getOfficialAppHeader());
    }

    // congig is referencing this method from the class so it must be static
    public static Language setLanguagePreference() {
        System.out.print("Language: ");
        String lang = input.next().trim().toLowerCase();
        return switch (lang) {
            case "alien" -> populateAlienPhrases();
            case "english" -> populateEnglishPhrases();
            default -> throw new IllegalStateException("Unexpected value: " + lang);
        };

    }

    private static Language populateAlienPhrases() {
        return new Language("alien");

    }

    private static Language populateEnglishPhrases() {
        return new  Language(Config.getDefaultLanguage());
    }


    public String getGreetingPhrase(int i) {
        if (locale.equals("alien")) {
            return switch(i) {
                case 0 -> "Test from Alien";

                default -> Language.defaultAlienSound;
            };

        }

        return switch (i) {
            case 0 -> "Hello";

            default -> "";
        };
    }

    public String getConfigPhrase(int i) {
        if (locale.equals("alien")) {
            return switch(i) {
                case 0 -> "~ zzzk-blop-zzzk • zrrrk-blap • zzzk-blop ~";  // separator
                case 1 -> "~ blap-zzz: zrrrk-blop zzzk! ~";            // “Language: …”
                case 2 -> "~ blap-zzz: zrrrk-glar zzzk! ~";            // “Time Zone: …”
                case 3 -> "~ blap-zzz: zrrrk-floob zzzk! ~";           // “Color Sequences: …”
                case 4 -> "~ blap-zzz: zrrrk-splat zzzk! ~";           // “Standard Output Log: …”
                case 5 -> "~ blap-zzz: zrrrk-splat zzzk! ~";           // “Standard Error Log: …”
                case 6 -> "~ blap-zzz: zrrrk-splat zzzk! ~";           // “Receipt Log: …”
                case 7 -> "~ blap-zzz: zrrrk-name-name zzzk! ~";      // “Receipt-*-*.log”
                case 8 -> "~ blap-zzz: zrrrk-univ zzzk! ~";            // “Default University: …”
                case 9 -> "~ blap-zzz: zrrrk-club zzzk! ~";            // “Default Club: …”
                default -> Language.defaultAlienSound;
            };
        }

        return switch (i) {
            case 0 -> "-".repeat(WIDTH);
            case 1 -> "Language:";
            case 2 -> "Time Zone:";
            case 3 -> "Color Sequences:";
            case 4 -> "Standard Output Log:";
            case 5 -> "Standard Error Log:";
            case 6 -> "Receipt Log:";
            case 7 -> "Receipt-*-*.log";        // suffix that Config will append
            case 8 -> "Default University:";
            case 9 -> "Default Club:";
            default -> "";
        };
    }

    public Object getLanguage() {
        return Config.getDefaultLanguage();
    }

    public Object getUniversityPhrase(int i) {
        return Config.getDefaultUniversity();
    }

    public Object getClubPhrase(int i) {
        return Config.getDefaultClub();
    }

//    public String getGreetingPhrase(int i) {
//    }
//
//    public Object getUniversityPhrase(int i) {
//    }
//
//    public Object getClubPhrase(int i) {
//    }
//
//    public String getConfigPhrase(int i) {
//    }
//
//    public Object getLanguage() {
//    }

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