package emailapp;

import java.util.Locale;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private int defaultPasswordLength =10;
    private String department;
    private int mailboxCapacity;
    private String email;
    private String alternateEmail;
    private String companySuffix = "yourcompany.com";

    //Constructor for first name and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        //Call a method asking for department and that returns department
        this.department = setDepartment();

        //Method that returns random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your default password is: " + this.password);

        //Combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;

    }

    //Ask for department
    private String setDepartment(){
        System.out.print("New Employee: " + firstName +
                " " + "Enter department code: ");
        Scanner in = new Scanner(System.in);
        int deptChoice = in.nextInt();

        if (deptChoice == 1){ return "sales"; }
        else if (deptChoice == 2){ return "dev"; }
        else if (deptChoice == 3){ return "acct"; }
        else {return "";}
    }

    //Method that returns random default password
    private String randomPassword(int length) {
        String passwordSet  = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!$@&+";
        char[] password = new char[length];
        for (int i= 0; i<length; i++) {
           int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }

        return new String(password);
    }


    //Set mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    //Set alternate email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    //Change password
    public void changePassword(String newPassword) {
        this.password = password;
    }

    public int getMailboxCapacity() { return mailboxCapacity; }
    public String getAlternateEmail() { return alternateEmail; }
    public String getPassword() { return password; }

    public String showInfo() {
        return "\nDISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }
}
