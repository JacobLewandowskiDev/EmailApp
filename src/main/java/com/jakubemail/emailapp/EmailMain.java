package com.jakubemail.emailapp;

import java.util.*;

public class EmailMain
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        // User info
        System.out.println("Enter you first name: ");
        String firstName = scanner.next();
        System.out.println("Enter you last name: ");
        String lastName = scanner.next();

        //Creating email object for user info
        Email email1 = new Email(firstName, lastName);
        int choice = -1;

        do {
            System.out.println("\n******\n Enter your choice: " +
                    "\n1. Show info " +
                    "\n2. Change password " +
                    "\n3. Change mailbox capacity " +
                    "\n4. Set alternate email " +
                    "\n5. Store data to a file " +
                    "\n6. Display data from file " +
                    "\n7. Exit");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    email1.getInfo();
                    break;
                case 2:
                    email1.setPassword();
                    break;
                case 3:
                    email1.setCapacity();
                    break;
                case 4:
                    email1.alternateEmail();
                    break;
                case 5:
                    email1.storeFile();
                    break;
                case 6:
                    email1.readFile();
                    break;
                case 7:
                    System.out.println("Thank you for using the email application");
                    break;
                default:
                    System.out.println("Incorrect input, enter a proper Integer in accordance to the available choices.");
            }
        } while(choice != 7);
    }
}
