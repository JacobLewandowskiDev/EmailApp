package com.jakubemail.emailapp;

import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.io.*;

public class Email {
    Scanner scanner = new Scanner(System.in);

    private String firstName;
    private String lastName;
    private String dept;
    private String email;
    private String password;
    private int mailCapacity = 500;
    private String alterEmail;

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("New Employee: " + this.firstName + " " + this.lastName);
        // Calling methods
        this.dept = setDepartment();
        this.password = generatePassword(8);
        this.email = generateEmail();
    }

    // Generate mail
    private String generateEmail() {
        return this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + this.dept.toLowerCase() + ".company.com";
    }

    // Asking for the department
    private String setDepartment() {
        System.out.println("Department codes: " +
                "\n1 for Sales " +
                "\n2 for Development " +
                "\n3 for Accounting " +
                "\n0 for none");
        boolean flag = false;
        do{
            System.out.println("Enter department code");
            int choice = scanner.nextInt();

            switch(choice) {
                case 1:
                    return "Sales";

                case 2:
                    return "Development";

                case 3:
                    return "Accounting";

                case 0:
                    return "None";

                default:
                    System.out.println("Invalid choice, please input the correct dept code.");
            }
        }
        while(!flag);
            return null;
    }

    // Generate random password
    private String generatePassword(int length) {
        Random r = new Random();
        String upperCaseCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseCharacters = upperCaseCharacters.toLowerCase();
        String numbers = "0123456789";
        String symbols = "!@#$%^&";
        String value = upperCaseCharacters + lowerCaseCharacters + numbers + symbols;
        String password = "";

        for(int i = 0; i<length; i++) {
            password = password + value.charAt(r.nextInt(value.length()));
        }
        return password;
    }

    // Change password method
    public void setPassword() {
        boolean flag = false;
        do {
            System.out.println("Do you want to change your password?(Y/N)");
            char choice = scanner.next().charAt(0);
            if(choice == 'Y' || choice == 'y') {
                flag = true;
                System.out.println("Enter current password:");
                String currentPass = scanner.next();

                if(currentPass.equals(this.password)) {
                    System.out.println("Enter your new password:");
                    this.password = scanner.next();
                    System.out.println("Your password has been changed successfully.");
                } else {
                    System.out.println("Incorrect password.");
                }
            } else if(choice == 'N' || choice == 'n') {
                flag = true;
                System.out.println("Password change cancelled.");
            } else {
                System.out.println("Enter a valid choice");
            }
        } while (!flag);
    }

    // Set mailbox capacity
    public void setCapacity() {
        System.out.println("Current email capacity: " + this.mailCapacity);

        System.out.println("Enter your new mailbox capacity.");
        this.mailCapacity = scanner.nextInt();
        System.out.println("Email capacity successfully changed to: " + this.mailCapacity + "mb");
    }

    // Set alternate email
    public void alternateEmail() {
        System.out.println("Enter a alternate email address: ");
        this.alterEmail = scanner.next();
        System.out.println("Alternate email set to: " + this.alterEmail);
    }

    // Display user information
    public void getInfo() {
        System.out.println("New: " + this.firstName + " " + this.lastName);
        System.out.println("Department: " + this.dept);
        System.out.println("Email: " + this.email);
        System.out.println("Password: " + this.password);
        System.out.println("Mailbox capacity: " + this.mailCapacity + "mb");
        System.out.println("Alternate email: " + this.alterEmail);
    }

    //Store into file
    public void storeFile() {
        try {
            FileWriter writer = new FileWriter("D:\\JavaProjects\\Personal learning\\EmailApplication\\info.txt");
            writer.write("First name: " + this.firstName);
            writer.append("\nLast name: " + this.lastName);
            writer.append("\nEmail: " + this.email);
            writer.append("\nPassword: " + this.password);
            writer.append("\nCapacity: " + this.mailCapacity);
            writer.append("\nAlternate emial: " + this.alterEmail);
            writer.close();
            System.out.println("Data was stored");
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //Reading from file
    public void readFile() {
        try {
            FileReader reader = new FileReader("D:\\JavaProjects\\Personal learning\\EmailApplication\\info.txt");
            int i;
            while ((i = reader.read()) != -1) {
                System.out.print((char) i);
            }
            reader.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
