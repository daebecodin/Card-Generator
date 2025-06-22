/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Receipt.java
 * Author: Duc Ta
 * Author: <First Name> <Last Name>
 * **********************************************
 */

package assignment02PartB;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public final class Receipt {

    /**
     * Generates a receipt file with a summary of the chat session, matching the specified format.
     */
    public static void generate(Config config, Student student, Player player, ArrayList<Card> cards, String quizResult) {
        String receiptPath = config.getStdOutStdErrTee().getReceiptFilePath();
        if (receiptPath == null || receiptPath.isEmpty()) {
            System.err.println("ERROR: Receipt file path is not set. Cannot generate receipt.");
            return;
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(receiptPath))) {
            String header = " SF GIANTS THANK YOU ";
            int totalWidth = 70;
            int headerWidth = header.length();
            int dashCount = (totalWidth - headerWidth) / 2;
            String separator = "-".repeat(dashCount);

            writer.println(separator + header + separator);
            writer.printf("%" + totalWidth + "s%n", "powered by CSC 220 @ SFSU"); // Right-aligned
            writer.println(config.getTimer().timeStamp() + " - Transaction started.");
            writer.println();

            writer.printf("%S, %d | %S%n", player.getFullName(), player.getJerseyNumber(), player.getClub().getName());
            writer.printf("%S, %S | %S%n", student.getFullName(), student.getEmail(), student.getUniversity().getOfficialName());
            writer.println();

            writer.println(cards.size());

            String cardSeparator = "-".repeat(totalWidth);
            for (Card card : cards) {
                writer.println(cardSeparator);
                writer.println(card.getRecipientName());
                writer.println(card.getArtSymbol());
                writer.println(card.getMessage());
            }
            writer.println(cardSeparator);

            writer.println(quizResult);
            writer.println(config.getTimer().timeStamp() + " - Transaction ended.");

        } catch (IOException e) {
            System.err.println("ERROR: Could not write receipt file to " + receiptPath);
            e.printStackTrace(System.err);
        }
    }
}

