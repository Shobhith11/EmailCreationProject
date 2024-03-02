package emailapp;

import javax.sql.rowset.FilteredRowSet;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private int defaultPasswordLength = 10;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private String alternateEmail;
    private String companySuffix = "aeycompany.com";

    //Constructor to receive the first name and last name.
    public Email (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        //System.out.println("EMAIL CREATED : " + this.firstName + " " + this.lastName);

        //call a method asking for the department - return the department.
        this.department = setDepartment();
       // System.out.println("Department: " + this.department);

        // call a method that returns a random password.
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your Password: " + this.password);

        //Combine elements to generate email.
        email = firstName.toLowerCase() + "." +lastName.toLowerCase() + "@" +department +"."+ companySuffix;
        //System.out.println("Your Email is:"+ email);
    }

    //Ask for the department
    private String setDepartment() {
        System.out.println("New worker: " + firstName +", Departments codes: \n1. for Sales\n2. for Development\n3. Accounting\n0. for none\nEnter department code :");
        Scanner in =  new Scanner(System.in);
        int depChoice = in.nextInt();
        if(depChoice == 1) { return "sales"; }
        else if(depChoice == 2) { return "dev"; }
        else if(depChoice == 3 ) { return "acct"; }
        else { return ""; }

    }

    //Generate a random password.
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@*$%#";
        char[] password = new char[length];
        for(int i=0; i<length; i++) {
            int rand = (int)(Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }


    //set the email box capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    //set the alternate email.
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    //Change the password.
    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailboxCapacity() { return mailboxCapacity;}
    public String getAlternateEmail() { return alternateEmail; }
    public String getPassword() { return password; }
    public String showInfo() {
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " +  mailboxCapacity + "mb";
    }

}
