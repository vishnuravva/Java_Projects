package Email_Application;

import java.util.Scanner;

public class Email_App {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter first name: ");
        String fname = in.next();
        System.out.println("Enter last name: ");
        String lname = in.next();
        Email em1 = new Email(fname,lname);
       em1.showInfo();
    }
}
