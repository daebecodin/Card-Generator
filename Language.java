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


import java.util.Scanner;

public final class Language {
    //
    // Static Data Fields
    //
    private static final String defaultAlienSound = "~ ąļīæń ~ "; // Default
    private static final Config config = new Config();
    private static final int WIDTH = 70;
    private static final Scanner input = new Scanner(System.in);
    private static String language;
    private static final StringBuilder sb = new StringBuilder();
    //
    // Instance Data Fields
    //
    private String locale = "";

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
    public static void clearConsole() {
        // Move cursor to home (0,0) and clear entire screen
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static Language getLang() {
        System.out.print("Pick a language: ");
        language = input.next();

        return new Language(language);

    }
    public static void displayAppHeader() {


        try {
            getLang();
        } catch (IllegalStateException e) {
            System.out.println("invalid language");
        }

        System.out.println();
        System.out.println(Config.getOfficialAppHeader());
    }

    public static Language handleLanguagePreferences() {

        while (true) {
            System.out.println("Language: " + language.toUpperCase());



            switch (language) {
                case "alien" -> {return populateAlienPhrases();}
                case "english" -> {return populateEnglishPhrases();}
                default -> System.out.println("Invalid Language: " + language );

            }
        }
    }

    // config is referencing this method from the class so it must be static
    public static Language setLanguagePreference() {
        while (true) {
            try {
                return handleLanguagePreferences();
            } catch (IllegalStateException e) {
                System.err.println("invalid language");
            }
        }
    }

    private static Language populateAlienPhrases() {
        return new Language("alien");

    }

    private static Language populateEnglishPhrases() {
        return new  Language(Config.getDefaultLanguage());
    }


    public String handleGreetingPhrase(int i) {

        return "hola";
    }

    public String getGreetingPhrase(int i) {
        return handleGreetingPhrase(i);
    }

    public String handleConfigPhrase(int i) {
        if (locale.equals("alien")) {
            return String.valueOf(switch(i) {
                case 0 -> {
                    sb.append(String.format("%-25s %-50s", defaultAlienSound, defaultAlienSound).repeat(10));
                    yield  sb.toString();
                }  // separator
                case 1 -> sb.append(String.format("%-25s %-50s", defaultAlienSound, defaultAlienSound));           // “Language: …”
                case 2 -> sb.append(String.format("%-25s %-50s", defaultAlienSound, defaultAlienSound));            // “Time Zone: …”
                case 3 -> sb.append(String.format("%-25s %-50s", defaultAlienSound, defaultAlienSound));         // “Color Sequences: …”
                case 4 -> sb.append(String.format("%-25s %-50s", defaultAlienSound, defaultAlienSound));           // “Standard Output Log: …”
                case 5 -> sb.append(String.format("%-25s %-50s", defaultAlienSound, defaultAlienSound));          // “Standard Error Log: …”
                case 6 -> sb.append(String.format("%-25s %-50s", defaultAlienSound, defaultAlienSound));         // “Receipt Log: …”
                case 7 -> sb.append(String.format("%-25s %-50s", defaultAlienSound, defaultAlienSound));     // “Receipt-*-*.log”
                case 8 -> sb.append(String.format("%-25s %-50s", defaultAlienSound, defaultAlienSound));          // “Default University: …”
                case 9 -> sb.append(String.format("%-25s %-50s", defaultAlienSound, defaultAlienSound));            // “Default Club: …”
                default -> Language.defaultAlienSound;
            });
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

    public String getConfigPhrase(int i) {
        return handleConfigPhrase(i);
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