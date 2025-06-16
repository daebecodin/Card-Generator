/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Timer.java
 * @author: Duc Ta
 * @author: <First Name> <Last Name>
 * **********************************************
 */

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;


public class Timer {

    //
    // Static Data Fields
    //

    private static final Scanner input = new Scanner(System.in);
    //
    // Instance Data Fields
    //
    //
    // Constructors
    //
   public Timer(ZoneId zone) {

   }



    public static Timer setTimeZonePreference() {


        while (true) {
            String timeZone;
            System.out.print("TimeZone: ");
            String in = input.next().trim().toUpperCase();
            ZoneId zone;


            switch (in) {
            case "EST" -> {
                zone = ZoneId.of("America/New_York");
            }

            case "PST" -> {
                zone = ZoneId.of("America/Los_Angeles");
            }

            default -> {
                System.out.println("Invalid Zone: " + in);
                continue;
            }
        }

        return new Timer(zone);
    }
   }

    public String getTimeZoneFormatted() {

        ZonedDateTime zdt = ZonedDateTime.now(); // current time zone

        String fullName = zdt.format(DateTimeFormatter.ofPattern("zzzz", Locale.ENGLISH));

        boolean isDst = zdt.getZone().getRules().isDaylightSavings(zdt.toInstant()); // returns a boolean of if the zone is in dst
        String status  = isDst ? "in Daylight Saving Time" : "not in Daylight Saving Time"; // based on that value , print with according text
        return String.format("%s %s", fullName, status); // formated string


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
    // Additional Instance Methods
    //

    //
    // Language
    //
}