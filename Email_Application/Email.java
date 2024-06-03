package Email_Application;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private int defaultPasswordLength = 10;
    private String email;
    private int defaultMailBoxCapacity = 500;
    private String alternateEmail;
    private String companySuffix = "ai.com";

    Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;

        this.department = setDepartment();
        System.out.println("Department is: "  + this.department);

        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is :" + this.password);

        email = firstName.toLowerCase() + lastName.toLowerCase() + "@" + department + "." + companySuffix;

    }

    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ@#$%&!";
        char[] password = new char[length];

        for (int i = 0; i < length; i++) {
            int randomChar = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(randomChar);
        }
        return new String(password);
    }
    private String setDepartment(){
        System.out.println("Department Codes \n 1.Sales\n 2.Development\n 3.Accounting \n 4.None");
        Scanner in  = new Scanner(System.in);
        int departmentChoice = in.nextInt();

        if(departmentChoice == 1) return "sales";
        else if(departmentChoice == 2) return "dev";
        else if(departmentChoice == 3) return "accounting";
        else return "";
    }

    public void setMailboxcapacity(int capacity){
        this.defaultMailBoxCapacity = capacity;
    }
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }
    public void changePassword(String password){
        this.password = password;
    }

    public int getMailboxCapacity() { return defaultMailBoxCapacity; }
    public String getAlternateEmail() { return alternateEmail; }
public String getPassword(){ return password; }


    public void showInfo(){
        System.out.println("DISPLAY NAME: " + firstName + " " + lastName + "\nCOMAPNY EMAIL: " + email + "\nMAILBOX CAPACITY: " + defaultMailBoxCapacity + "mb");
    }
}
