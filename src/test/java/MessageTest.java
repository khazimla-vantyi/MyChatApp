/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.mychatapp.Messages;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {
    private Messages message1;
    private Messages message2;

    @BeforeEach  // Changed from @BeforeAll — @BeforeAll requires static method
    public void setUp() {
        message1 = new Messages(
                0,
                "+27718693002",
                "Hi Mike, can you join us for dinner tonight?"
        );
        message2 = new Messages(
                1,
                "08575975889",
                "Hi Keegan, did you receive the payment?"
        );
    }

    // Message length success
    @Test
    public void testCheckMessageLength_validMessage_returnsSuccess() {
        String result = message1.checkMessageLength();
        assertEquals("Message ready to send.", result);
    }

    // Message length failure
    @Test
    public void testCheckMessageLength_over250chars_returnsFailure() {
        String longMessage = "";
        for (int i = 0; i < 260; i++) {
            longMessage += "a";
        }
        Messages longMsg = new Messages(2, "+27718693002", longMessage);
        String result = longMsg.checkMessageLength();
        assertEquals(
                "Message exceeds 250 characters by 10; please reduce the size.",
                result
        );
    }

    // Recipient valid
    @Test
    public void testCheckRecipientCell_validNumber_returnsSuccess() {
        String result = message1.checkRecipientCell();
        assertEquals("Cell phone number successfully captured.", result);
    }

    // Recipient invalid
    @Test
    public void testCheckRecipientCell_invalidNumber_returnsFailure() {
        String result = message2.checkRecipientCell();
        assertEquals(
                "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.",
                result
        );
    }

    // Hash format test
    @Test
    public void testCreateMessageHash_correctFormat_endsWithExpectedWords() {
        String hash = message1.createMessageHash();
        assertTrue(hash.endsWith(":0:HITONIGHT"));
    }

    // Hash uppercase
    @Test
    public void testCreateMessageHash_isUppercase() {
        String hash = message1.createMessageHash();
        assertEquals(hash.toUpperCase(), hash);
    }

    // Message ID exists
    @Test
    public void testCheckMessageID_generatedID_isNotNull() {
        assertNotNull(message1.getMessageID());
    }

    // Message ID length
    @Test
    public void testCheckMessageID_generatedID_isExactly10Chars() {
        assertTrue(message1.checkMessageID());
    }

    // Send option
    @Test
    public void testSentMessage_userSelectsSend_returnsCorrectString() {
        String result = message1.sentMessage(1);
        assertEquals("Message successfully sent.", result);
    }

    // Disregard option
    @Test
    public void testSentMessage_userSelectsDisregard_returnsCorrectString() {
        String result = message1.sentMessage(2);
        assertEquals("Press 0 to delete the message.", result);
    }

    // Store option
    @Test
    public void testSentMessage_userSelectsStore_returnsCorrectString() {
        String result = message1.sentMessage(3);
        assertEquals("Message successfully stored.", result);
    }
}