/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Timer.java
 * @author: Durand Dyer
 * @author: Ian Brown
 * **********************************************
 */
package assignment02PartB;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Locale;
import java.util.Scanner;

public class Timer {

    private static final Scanner input = new Scanner(System.in);
    private final ZoneId zoneId;

    public Timer(ZoneId zone) {
        this.zoneId = zone;
    }
    public ZoneId getZoneId() {
        return this.zoneId;
    }

    public static Timer setTimeZonePreference() {
        while (true) {
                System.out.print(Language.getString("config.timezone"));
            String in = input.next().trim().toUpperCase();
            switch (in) {
                case "EST" -> {
                    return new Timer(ZoneId.of("America/New_York"));}
                case "PST" ->{
                    return new Timer(ZoneId.of("America/Los_Angeles"));}
                case "CST" ->{
                    return new Timer(ZoneId.of("America/Chicago"));
                }
                case "MST" ->{
                    return new Timer(ZoneId.of("America/Denver"));
                }
                case "GMT" ->{
                    return new Timer(ZoneId.of("GMT"));
                }
                case "UTC" ->{
                    return new Timer(ZoneId.of("UTC"));
                }
                case "CANADA" ->{
                    return new Timer(ZoneId.of("America/Toronto"));
                }
                default -> {
                    System.out.println("TimeZone: INVALID time zone. Please enter your time zone.");
                }
            }
        }
    }
    
    public  String timeStamp() {

        ZonedDateTime zdt = ZonedDateTime.now(this.zoneId);
        DateTimeFormatter dtf = new DateTimeFormatterBuilder()
                .appendPattern("yyyy/MM/dd hh:mm:ss ") // desired format for date and time
                .appendLiteral("[") // append a starting bracket
                .appendValue(ChronoField.MILLI_OF_SECOND, 4) // in the bracket we want to add milliseconds in time
                .appendLiteral("ms] ") // close brackets and add text inside
                .appendPattern("a z") // return am/pm and the zone
                .toFormatter(); // format

//        System.out.println(output);
        
        return zdt.format(dtf);
    }

    public String getTimeZoneFormatted() {
        // need to manually change for language

        if (Language.isAlien()) {
            return Language.getAlienSound();
        }

        ZonedDateTime zdt = ZonedDateTime.now(this.zoneId);
        String fullName = zdt.format(DateTimeFormatter.ofPattern("zzzz", Locale.ENGLISH));
        boolean isDst = zdt.getZone().getRules().isDaylightSavings(zdt.toInstant());
        String status = isDst ? "in Daylight Saving" : "not in Daylight Saving";
        return String.format("%s %s", fullName, status);
    }
}