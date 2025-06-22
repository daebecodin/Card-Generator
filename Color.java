/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Color.java
 * @author: Duc Ta
 * @author: Durand Dyer
 * @author: Ian Brown
 * **********************************************
 */

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

import java.util.ArrayList;
import java.util.List;

public final class Color {


    public static final String ANSI_RESET = "\u001B[0m"; // use this
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";

    public static final Color Yellow = new Color(ANSI_YELLOW);
    public static final Color BgPurple = new Color(ANSI_PURPLE_BACKGROUND);

    private List<String> codes = new ArrayList<>(); // list to store codes
    private String codes_str; //represents code string to accept



    public Color() {
    }

    /**
     *
     * @param codes using vargas, we can accept a list or array of items
     */
    public Color(String... codes) { // collect many codes
        this.codes = List.of(codes); // initialize the list of codes
        StringBuilder _code_str = new StringBuilder(); // form a buffer for code concatenation
        for (String code : codes) { // for every code
            _code_str.append(code); // add code to the buffer
        }
        codes_str = _code_str.toString(); // initialize to the instance code
    }

    /**
     *
     * @param other code to be added to sequence
     * @return an array of ansi codes
     */
    public Color and(Color other) {
        List<String> both = new ArrayList<>(); // list to store both ansi styles
        both.addAll(codes); // previous codes
        both.addAll(other.codes); //new codes
        return new Color(both.toArray(new String[0])); // return an ansi sequence
    }

    /**
     *
     * @param original original text
     * @return colorized text
     */
    public String colorize(String original) {
        return codes_str + original + ANSI_RESET; // instance code + text + reset code
    }


    /**
     *
     * @param template the escape character sequence
     * @param args the word or words
     * @return
     */
    public String format(String template, Object... args) {
        return colorize(String.format(template,args)); // if I want to use escape characters
    }

    public Object getColorSequences() {
        // need to manually change for language

        if (Language.isAlien()) {
            return Language.getAlienSound();
        }
        return Config.getDefaultColorSequences();
    }

    //
    // Static Methods
    //

    //
    // Instance Methods
    //

    //
    // Language
    //
}