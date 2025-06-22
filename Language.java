// In Language.java

package assignment02PartB;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Scanner;

public final class Language {

    private static final Scanner input = new Scanner(System.in);
    private static ResourceBundle messages; // for localizing text
    private static String currentLocaleCode = "en"; // Default to English
    private static final String DEFAULT_ALIEN_SOUND = "~ alien ~";

    // Private constructor
    public Language() {
    }

    /**
     * Prompts the user to select a language and loads the appropriate resource bundle.
     * @return A new Language object.
     */
    public static Language setLanguagePreference() {
        while (true) {
            System.out.print("Language: ");
            String choice = input.next().toLowerCase();
            input.nextLine(); // consume the rest of the line

            if ("alien".equals(choice)) {
                currentLocaleCode = "al";
                loadBundle(currentLocaleCode);
                return new Language();
            } else if ("english".equals(choice)) {
                currentLocaleCode = "en";
                loadBundle(currentLocaleCode);
                return new Language();
            } else {
                System.out.println("Language: UNSUPPORTED language. Please enter your language.");
                System.out.println("Language: English or Alien");
            }
        }
    }

    /**
     * Loads the resource bundle for the given locale code.
     */
    private static void loadBundle(String localeCode) {
        Locale chosenLocale = new Locale(localeCode);
        messages = ResourceBundle.getBundle("assignment02PartB.messages", chosenLocale);
    }

    /**
     * The main method to get a string from the loaded bundle.
     * @param key The key from the .properties file.
     * @return The translated string.
     */
    public static String getString(String key) {
        if (messages == null) {
            System.err.println("WARN: Language preference not set. Defaulting to English.");
            loadBundle("en");
        }
        try {
            return messages.getString(key);
        } catch (MissingResourceException e) {
            System.err.println("ERROR: The key '" + key + "' was not found in the properties file.");
            return "!" + key.toUpperCase() + "!";
        }
    }

    // --- New Helper Methods ---

    /**
     * Checks if the current language is Alien.
     * @return true if the locale is "al", false otherwise.
     */
    public static boolean isAlien() {
        return "al".equals(currentLocaleCode);
    }

    /**
     * Gets the current locale code ("en" or "al").
     * @return The current locale code as a String.
     */
    public static String getLocale() {
        return currentLocaleCode;
    }

    /**
     * Returns the placeholder sound for the Alien language.
     * @return A string representing an alien sound.
     */
    public static String getAlienSound() {
        // You can define a specific key for this in your properties file if you wish
        return "~ alien ~";
    }


    public static void displayAppHeader() {
        System.out.println();
        System.out.println(Config.getOfficialAppHeader());
    }

    public String getLanguage() {
        return isAlien() ? getAlienSound() : Config.getDefaultLanguage();
    }

    public String getUniversityPhrase(int i) {
        return isAlien() ? getAlienSound() : Config.getDefaultUniversity();
    }

    public String getClubPhrase(int i) {
        return isAlien() ? getAlienSound() : Config.getDefaultClub();
    }

    public String getConfigPhrase(int i) {
        return switch (i) {
            case 0 -> getString("config.separator");
            case 1 -> getString("config.language");
            case 2 -> getString("config.timezone");
            case 3 -> getString("config.colors");
            case 4 -> getString("config.stdout");
            case 5 -> getString("config.stderr");
            case 6 -> getString("config.logpath");
            case 7 -> getString("config.logstatus");
            case 8 -> getString("config.university");
            case 9 -> getString("config.club");
            default -> "¡KEY_NOT_FOUND!";
        };
    }

    public String getGreetingPhrase(int i) {
        // Placeholder for greeting phrases if you decide to add them to properties files
        return "Hello";
    }
}