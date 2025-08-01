/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Messenger.java
 * @author: Durand Dyer
 * @author: Ian Brown
 * **********************************************
 */

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"


//

// Please DO NOT CHANGE this file.

// Please DO NOT CHANGE this file.

// Please DO NOT CHANGE this file.

//

public final class Messenger {

    //
    // main method
    //
    public static void main(String[] args) {
        Messenger.start();
        Messenger.chat();
        Messenger.stop();
    }

    //
    // Static Data Fields
    //
    private static final Config config = new Config();

    //
    // Constructors
    //
    private Messenger() {
    }

    //
    // Static Methods
    //
    public static Config getConfig() {
        return Messenger.config;
    }

    private static void start() {
        Messenger.config.getStdOutStdErrTee().startLog();
        Messenger.config.setPreferences();
    }

    private static void chat() {
        (new ChatSession(Messenger.config.getClub(), Messenger.config.getUniversity())).runChatSession();
    }
    private static void stop() {
        Messenger.config.getStdOutStdErrTee().stopLog();
//         LogFileDriver.run(); // Please temporarily uncomment this line to run LogFileDriver.
    }
}

//

// Please DO NOT CHANGE this file.

// Please DO NOT CHANGE this file.

// Please DO NOT CHANGE this file.

//