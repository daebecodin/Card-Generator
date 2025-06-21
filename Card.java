/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Card.java
 * @author: Duc Ta
 * @author: <First Name> <Last Name>
 * **********************************************
 */

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

public final class Card {

    private String recipientName;
    private char artSymbol;
    private String message;
    private String senderName;
    private String senderEmail;
    private int artSize = 16;     // Please change artSize, if needed, to get an identical output
    private String artFont = "Courier"; // Please change artFont, if needed, to get an identical output

    public Card() {
    }

    public Card(String recipientName, char artSymbol, String message, String senderName, String senderEmail, int artSize, String artFont) {
        this.recipientName = recipientName;
        this.artSymbol = artSymbol;
        this.message = message;
        this.senderName = senderName;
        this.senderEmail = senderEmail;
        this.artSize = artSize;
        this.artFont = artFont;
    }

    public void displayCard() {
        try {
            SFGiantsCardGenerator.generateSFGiantsCard(

                    recipientName,
                    message,
                    senderName,
                    senderEmail,
                    artSymbol,
                    artSize,
                    artFont
            );
            System.out.println();
        } catch (Exception e) {
            System.err.println("cannot print card");
        }
    }
    //
    // Additional Instance Methods
    //


    //
    // Language
    //

}
