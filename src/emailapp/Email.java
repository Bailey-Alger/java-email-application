package emailapp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String address;
    private String department;
    private String password;
    private int mailCapacity = 500;
    private String alteranteEmail;
    private int defaultPasswordLength = 10;
    private String companySuffix = "company.com";

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        this.department = setDepartment();

        this.password = randPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        if (department != "") {
            this.address = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "."
                    + companySuffix;
        } else {
            this.address = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + companySuffix;
        }
    }

    private String setDepartment() {
        System.out.print("1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) {
            return "sales";
        } else if (depChoice == 2) {
            return "dev";
        } else if (depChoice == 3) {
            return "acct";
        } else {
            return "";
        }

    }

    // Returns and random password
    private String randPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    // Setters
    public void setMailboxCapacity(int capacity) {
        this.mailCapacity = capacity;
    }

    public void setAlternateEmail(String altEmail) {
        this.alteranteEmail = altEmail;
    }

    public void changePassword(String password) {
        this.password = password;
    }

    // Getters
    public int getMailboxCapacity() {
        return mailCapacity;
    }

    public String getAlternateEmail() {
        return alteranteEmail;
    }

    public String getPassword() {
        return password;
    }

    // Print info
    public String showInfo() {
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + address +
                "\nMAILBOX CAPACITY: " + mailCapacity + "mb";
    }
}
