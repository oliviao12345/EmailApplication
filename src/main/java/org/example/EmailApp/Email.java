package org.example.EmailApp; // Package declaration

import java.util.Scanner; // Importing the Scanner class

public class Email {
    private String firstName; // Variable to store the first name
    private String lastName; // Variable to store the last name
    private String email; // Variable to store the email address

    private String password; // Variable to store the password
    private String department; // Variable to store the department
    private int mailboxCapacity = 500; // Variable to store the mailbox capacity
    private String alternateEmail; // Variable to store the alternate email address
    private int defaultPasswordLength = 10; // Variable to store the default password length
    private String companySuffix = "company.com"; // Variable to store the company suffix

    // Constructor to receive the first name and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName);

        // Call a method asking for the department - return the department
        this.department = setDepartment();

        // Call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        // Combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
    }

    // Ask for the department
    private String setDepartment() {
        System.out.println("DEPARTMENT CODES \n 1 for Sales \n 2 for Development\n 3 for Accounting \n 0 for None \n Enter Department Code: ");
        Scanner in = new Scanner(System.in); // Create a new Scanner object to read user input
        int depChoice = in.nextInt(); // Read the user's input as an integer
        if (depChoice == 1) { // Check if the user selected the Sales department
            return "sales";
        } else if (depChoice == 2) { // Check if the user selected the Development department
            return "dev";
        } else if (depChoice == 3) { // Check if the user selected the Accounting department
            return "acct";
        } else { // If the user selected None or an invalid department code
            return "";
        }
    }

    // Generate a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ@!$£%"; // Set of characters to generate the password from
        char[] password = new char[length]; // Array to store the password characters
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length()); // Generate a random index within the passwordSet length
            password[i] = passwordSet.charAt(rand); // Get the character at the random index and assign it to the password array
        }
        return new String(password); // Convert the password array to a String and return it
    }

    // Set the mailbox capacity
    public void setMailboxCapacity(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }

    // Set an alternate email address
    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    // Change the password
    public void changePassword(String password) {
        this.password = password;
    }

    // Get the mailbox capacity
    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    // Get the alternate email address
    public String getAlternateEmail() {
        return alternateEmail;
    }

    // Get the password
    public String getPassword() {
        return password;
    }

    // Display the user's information
    public String showInfo() {
        return "\nDISPLAY NAME:" + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }
}
