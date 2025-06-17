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
    private ZoneId zoneId;

    public Timer(ZoneId zone) {
        this.zoneId = zone;
    }
    public ZoneId getZoneId() {
        return this.zoneId;
    }

    public static Timer setTimeZonePreference() {
        while (true) {
            if (Language.getLocale().equalsIgnoreCase("alien")) {
                System.out.print(Language.getAlienSound() + ": ");
            } else {
                System.out.print("TimeZone: ");
            }
            String in = input.next().trim().toUpperCase();
            switch (in) {
                case "EST":
                    return new Timer(ZoneId.of("America/New_York"));
                case "PST":
                    return new Timer(ZoneId.of("America/Los_Angeles"));
                default:
                    System.out.println("Invalid Zone: " + in);
            }
        }
    }
    
    public static String timeStamp() {


        ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of(String.valueOf(ZoneId.systemDefault())));
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
        // --- NEW: This method is now language-aware ---
        if ("alien".equals(Language.getLocale())) {
            return Language.getAlienSound();
        }

        ZonedDateTime zdt = ZonedDateTime.now(this.zoneId);
        String fullName = zdt.format(DateTimeFormatter.ofPattern("zzzz", Locale.ENGLISH));
        boolean isDst = zdt.getZone().getRules().isDaylightSavings(zdt.toInstant());
        String status = isDst ? "in Daylight Saving Time" : "not in Daylight Saving Time";
        return String.format("%s %s", fullName, status);
    }
}