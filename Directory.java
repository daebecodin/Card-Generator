/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Directory.java
 * @author: Durand Dyer
 * @author: Ian Brown
 * **********************************************
 */

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

public final class Directory {

    //
    // Static Data Fields
    //

    //
    // Instance Data Fields
    //

    //
    // Constructors
    //
    public Directory() {
    }

    public String getPath() {
        // need to manually change for language
        if (Language.isAlien()) {
            return Language.getAlienSound();
        }
        return Config.getDefaultLogDirectoryPath();
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
