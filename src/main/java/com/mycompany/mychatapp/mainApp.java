/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mychatapp;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author khazi
 */

public class mainApp {
 
    public static void main(String[] args) {
 
        // Create Scanner to read input from the keyboard
        Scanner input = new Scanner(System.in);
 
        // Create a new login object to use registration and login methods
        login login = new login();
 
        // ---REGISTRATION---
        System.out.println("=== USER REGISTRATION===");
 
        // Get username from user
        System.out.print("Enter a username: ");
        String username = input.nextLine();
 
        // Get password from user
        System.out.print("Enter a password: ");
        String password = input.nextLine();
 
        // Get phone number from user
        System.out.print("Enter your South African phone number (+27....): ");
        String phone = input.nextLine();
 
        // Register the user and get the result message
        String response = login.registerUser(username, password, phone);
 
        // Show the registration result
        System.out.println(response);
 
        // ---LOGIN---
        System.out.println("\n=== USER LOGIN===");
 
        // Get username for login
        System.out.println("Enter your username: ");
        String loginUsername = input.nextLine();
 
        // Get password for login
        System.out.println("Enter your password: ");
        String loginPassword = input.nextLine();
 
        // Check if the entered credentials match the registered user
        boolean loggedIn = login.LoginUser(loginUsername, loginPassword);
 
        // Get the appropriate message based on login success/failure
        String loginMessage = login.returnLoginStatus(loggedIn);
 
        // Display the login message to the user
        System.out.println(loginMessage);
    
    }
        }