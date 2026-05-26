/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mychatapp;

/**
 *
 * @author khazi
 */
public class login {
    
 //variables to store user credentials
    String username;
    String password;
    String phoneNumber;
    
    //Checks username format:
    //Must contain an underscore "_"
    //Must be 5 characters or less
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }
    
     //Validates password complexity:
     //At least 8 characters long
     //Contains at least one uppercase letter
     //Contains at least one number
     //Contains at least one special character
    public boolean checkPasswordComplexity(String password) {
        
        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false; 
        
        // Loop through each character to check requirements
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            
            // Check for uppercase letter
            if(Character.isUpperCase(c)) {
                hasCapital = true;
            }
            // Check for digit
            if(Character.isDigit(c)) {
                hasNumber = true;
            }
            // Check for special character 
            if(!Character.isLetterOrDigit(c)) {
                hasSpecial = true;
            }
        }   
        
       // Return true only if all conditions above are met
        return password.length() >= 8 && hasCapital && hasNumber && hasSpecial;
    }
    
   //Validates South African phone number format:
   //Must start with country code "+27"
   //Must be 12 characters or less (e.g., +27XXXXXXXXX)
    public boolean checkphoneNumber(String phone) {
        return phone.startsWith("+27") && phone.length() <= 12;
    }  
    
    //Registers a new user after validating all fields.
    //Returns success message or specific error message for first failed validation.
    public String registerUser(String username, String password, String phoneNumber) {
        // Validate username format
        if (!checkUserName(username)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        // Validate password complexity
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains atleast eight characters, a capital letter, a number, and a special character.";
        }
        // Validate phone number format
        if (!checkphoneNumber(phoneNumber)) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }
        //All validations passed - save user data
        this.username = username;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        return "User has registered successfully.";
    }
    //Authenticates user by comparing provided credentials with stored values.
    //Returns true if both username and password match.
    public boolean LoginUser(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
   //Returns a friendly message based on login success or failure.
    public String returnLoginStatus(boolean success) {
        if (success) {
            return "Welcome " + username + " it is great to see you again.";
        } else { 
            return "Username or password incorrect, please try again.";
        }
    }
}