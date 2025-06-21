package assignment02PartB;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public final class Language {

    private static final String defaultAlienSound = "~ ąļīæń ~ ";
    private static final int WIDTH = 70;
    private static final Scanner input = new Scanner(System.in);
    private static String locale = "";

    // Added static "getters" so other classes like Timer can see the language.
    public static String getLocale() {
        return locale;
    }

    public static String getAlienSound() {
        return defaultAlienSound;
    }

    public Language() {}

    public Language(String locale) {
        Language.locale = locale;
    }

    public static boolean isAlien() { return "alien".equals(locale); }
    public static String translate(String in) {
        return isAlien() ? defaultAlienSound : in;
    }

    public static void hookSystemStreams() {
        if (!isAlien()) return;

        PrintStream origOut = System.out;
        System.setOut(new PrintStream(new OutputStream() {
            @Override public void write(int b) {
                origOut.write(b);
            } }, true) {
            @Override public void print(String s) {
                super.print(translate(s));
            }
            @Override public void println(String s) {
                super.println(translate(s));
            }
            @Override public void print(Object o) {
                super.print(translate(String.valueOf(o)));
            }
            @Override public void println(Object o) {
                super.println(translate(String.valueOf(o)));
            }
        });

        PrintStream origErr = System.err;
        System.setErr(new PrintStream(new OutputStream() {
            @Override public void write(int b) {
                origErr.write(b);
            }
        }, true) {
            @Override public void print(String s) { super.print(translate(s)); }
            @Override public void println(String s) { super.println(translate(s)); }
            @Override public void print(Object o) { super.print(translate(String.valueOf(o))); }
            @Override public void println(Object o) { super.println(translate(String.valueOf(o))); }
        });
    }


    public static void displayAppHeader() {
        System.out.println();
        System.out.println(Config.getOfficialAppHeader());

    }

    // This method is now simple: it just returns the correct Language object.
    public static Language setLanguagePreference() {

        while (true) {
            System.out.print("Language: ");
            Language.locale = input.next().toLowerCase();
            input.nextLine();
            switch (locale) {
                case "alien" -> {
                    Language lang = new Language("alien");
                    hookSystemStreams();
                    return lang;
                }
                case "english" -> {
                    Language lang = new Language("english");
                    hookSystemStreams();
                    return lang;
                }
                default -> {
                    System.out.println("Language: UNSUPPORTED language. Please enter your language.");
                    System.out.println("Language: English or Alien");

                }
            }
        }

    }


    // handleConfigPhrase now provides either English or Alien text.
    public String handleConfigPhrase(int i) {
        if ("alien".equals(Language.locale)) {
            return defaultAlienSound;
        }
        return switch (i) {
            case 0 -> "-".repeat(WIDTH);
            case 1 -> "Language:";
            case 2 -> "Time Zone:";
            case 3 -> "Color Sequences:";
            case 4 -> "Standard Output Log:";
            case 5 -> "Standard Error Log:";
            case 6 -> "Receipt Log:";
            case 7 -> "Receipt-*-*.log";
            case 8 -> "Default University:";
            case 9 -> "Default Club:";
            default -> "";
        };
    }

    public String getConfigPhrase(int i) {
        return handleConfigPhrase(i);
    }

    // All "get" methods are now simple and language-aware.
    public Object getLanguage() {
        return "alien".equals(Language.locale) ? defaultAlienSound : Config.getDefaultLanguage();
    }

    public Object getUniversityPhrase(int i) {
        return "alien".equals(Language.locale) ? defaultAlienSound : Config.getDefaultUniversity();
    }

    public Object getClubPhrase(int i) {
        return "alien".equals(Language.locale) ? defaultAlienSound : Config.getDefaultClub();
    }

    public String getGreetingPhrase(int i) {
        if ("alien".equals(Language.locale)) {
            return defaultAlienSound;
        }
        // Return a default English greeting otherwise
        return switch (i) {
            case 0 -> "Hello there,";
            default -> "Hi,";
        };
    }
}