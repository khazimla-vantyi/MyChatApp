/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mychatapp;

import java.util.Random;

/**
 *
 * @author khazi
 */
public class Messages {

    private int messageIndex;
    private String recipientCell;
    private String messageText;
    private String messageID;

    // Constructor
    public Messages(int messageIndex, String recipientCell, String messageText) {
        this.messageIndex = messageIndex;
        this.recipientCell = recipientCell;
        this.messageText = messageText;
        this.messageID = generateMessageID();
    }

    // Generate random 10-character message ID
    private String generateMessageID() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();

        StringBuilder id = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            id.append(chars.charAt(random.nextInt(chars.length())));
        }

        return id.toString();
    }

    // Return message ID
    public String getMessageID() {
        return messageID;
    }

    // Check if message ID is valid
    public boolean checkMessageID() {
        return messageID != null && messageID.length() <= 10;
    }

    // Check recipient cell number
    public String checkRecipientCell() {

        if (recipientCell != null
                && recipientCell.startsWith("+27")
                && recipientCell.length() >= 11) {

            return "Cell phone number successfully captured.";

        } else {

            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
    }

    // Check message length
    public String checkMessageLength() {

        if (messageText.length() <= 250) {

            return "Message ready to send.";

        } else {

            int over = messageText.length() - 250;

            return "Message exceeds 250 characters by "
                    + over
                    + "; please reduce the size.";
        }
    }

    // Create message hash
    public String createMessageHash() {

        // First 2 characters of message ID
        String idPart = messageID.substring(0, 2);

        // Split message into words
        String[] words = messageText.split(" ");

        // First and last word
        String firstWord = words[0];
        String lastWord = words[words.length - 1];

        // Create hash
        String hash = idPart + ":" + messageIndex + ":"
                + firstWord + lastWord;

        return hash.toUpperCase();
    }

    // Send message options
    public String sentMessage(int option) {

        switch (option) {

            case 1:
                return "Message successfully sent.";

            case 2:
                return "Press 0 to delete the message.";

            case 3:
                return "Message successfully stored.";

            default:
                return "Invalid option.";
        }
    }
}
