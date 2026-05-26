/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.mychatapp.login;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author khazi
 */

public class loginTest {
    
 login user = new login();
 
 //Test: Username without underscore or too long should fail  
    @Test
    public void testUsernameIncorrect() {
        String result = user.registerUser("kyle!!!!!!!!!", "Ch@&sec@ke99!", "+27838996876");
        
        assertEquals("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.", result);
    }
    
 //Test: Password missing capital, number, or special char should fail   
    @Test
    public void testPasswordIncorrect() {
        String result = user.registerUser("kyl_1", "password", "+27838996876");
        
        assertEquals("Password is not correctly formatted; please ensure that the password contains atleast eight characters, a capital letter, a number, and a special character.", result);
    }
    
//Test: Phone number without +27 should fail    
    @Test
    public void testPhoneIncorrect() {
        String result = user.registerUser("kyl_1", "Ch@&sec@ke99!", "08996053");
        
        assertEquals("Cell phone number incorrectly formatted or does not contain international code.", result);
    }
    
//Test: All valid inputs should register successfully    
    @Test
    public void testRegisterSuccess() {
        String result = user.registerUser("kyl_1", "Ch@&sec@ke99!", "+27838996876");
        
        assertEquals("User has registered successfully.", result);
    }
    
//Test: Successful login returns welcome message with username    
    @Test
    public void testLoginMessageSuccess() {
        // First register a valid user
        user.registerUser("kyl_1", "Ch@&sec@ke99!", "+27838996876");
        // Try logging in with correct credentials
        boolean login = user.LoginUser("kyl_1", "Ch@&sec@ke99!");
        String message = user.returnLoginStatus(login);
        
        assertEquals("Welcome kyl_1 it is great to see you again.", message);
    }
    
//Test: Failed login returns error message    
    @Test
    public void testLoginMessageFail() {
        // First register a valid user
        user.registerUser("kyl_1", "Ch@&sec@ke99!", "+27838996876");
        // Try logging in with wrong password
        boolean login = user.LoginUser("kyl_1", "wrong");
        String message = user.returnLoginStatus(login);
        
        assertEquals("Username or password incorrect, please try again.", message);
    }
    

//Test: Valid username (has underscore, ≤5 chars) returns true 
    @Test
    public void testUsernameValid() {
        assertTrue(user.checkUserName("kyl_1"));
    }
//Test: Invalid username returns false    
    
    @Test
    public void testUsernameInvalid() {
        assertFalse(user.checkUserName("kyle!!!!!!!!!"));
    }
    
//Test: Valid password (8+ chars, capital, number, special) returns true    
    @Test
    public void testPasswordValid() {
        assertTrue(user.checkPasswordComplexity("Ch@&sec@ke99!"));
    }
    
//Test: Invalid password (missing requirements) returns false    
    @Test
    public void testPasswordInvalid() {
        assertFalse(user.checkPasswordComplexity("password"));
    }
    
//Test: Valid SA phone number returns true    
    @Test
    public void testPhoneValid() {
        assertTrue(user.checkphoneNumber("+27838996876"));
    }
    
// Test: Invalid phone number returns false    
    @Test
    public void testPhoneInvalid() {
        assertFalse(user.checkphoneNumber("08996053"));
    }
    
// Test: Login with correct credentials returns true    
    @Test
    public void testLoginSuccess() {
        user.registerUser("kyl_1", "Ch@&sec@ke99!", "+27838996876");
        
        assertTrue(user.LoginUser("kyl_1", "Ch@&sec@ke99!"));
    }
    
// Test: Login with wrong password returns false
    @Test
    public void testLoginFail() {
        user.registerUser("kyl_1", "Ch@&sec@ke99!", "+27838996876");
        
        assertFalse(user.LoginUser("kyl_1", "wrongpass"));
    }
}