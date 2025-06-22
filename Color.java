/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Color.java
 * @author: Duc Ta
 * @author: <First Name> <Last Name>
 * **********************************************
 */

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

import java.util.ArrayList;
import java.util.List;

public final class Color {

    //
    // Static Data Fields
    //
    public static final String ANSI_RESET = "\u001B[0m"; // use this
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";

//    public static final Color Reset = new Color(ANSI_RESET);
    public static final Color Yellow = new Color(ANSI_YELLOW);
    public static final Color BgPurple = new Color(ANSI_PURPLE_BACKGROUND);

    private List<String> codes = new ArrayList<>(); // list to store codes
    private String codes_str; //represents code string to accept
    //
    // Instance Data Fields
    //

    //
    // Constructors
    //
    public Color() {
    }
    public Color(String... codes) {
        this.codes = List.of(codes);
        StringBuilder _code_str = new StringBuilder();
        for (String code : codes) {
            _code_str.append(code);
        }
        codes_str = _code_str.toString();
    }

    public Color and(Color other) {
        List<String> both = new ArrayList<>(); // list to store both ansi styles
        both.addAll(codes); // previous codes
        both.addAll(other.codes); //new codes
        return new Color(both.toArray(new String[0]));
    }

    public String colorize(String original) {
        return codes_str + original + ANSI_RESET;
    }

    public String format(String template, Object... args) {
        return colorize(String.format(template,args));
    }

    public Object getColorSequences() {
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