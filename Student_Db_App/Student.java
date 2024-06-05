package Student_Db_App;

import java.util.Scanner;

public class Student {

    private String firstName;
    private String lastName;
    private int gradeYear;
    private String studentId;
    private String courses = "";
    private int tutionBalance = 0;
    private static int costOfCourse = 600;
    private static int id = 1000;

    //  The variable id is shared across all instances of the class. This can be useful for purposes such as:
    // Maintaining a counter that is shared among all instances.
    Student(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Student first name");
        this.firstName = in.nextLine();
        System.out.println("Enter Student last name");
        this.lastName = in.nextLine();

        System.out.println("1 - Fresher\n 2. Software\n 3. Junior \n4. Senior \nEnter Student class level");
        this.gradeYear = in.nextInt();

        setStudentId();


    }
    private void setStudentId(){
        id++;
        this.studentId =  gradeYear + "" + id;
    }
    public void enroll(){
        // Get inside a loop
do {


    System.out.println("Enter a course to enroll ( Q to quit )");
    Scanner in = new Scanner(System.in);
    String course = in.nextLine();

    if (!course.equals("Q")) {
        courses = courses + "\n" + course;
        tutionBalance = tutionBalance + costOfCourse;
        System.out.println("ENROLLED IN: " + courses);
    } else {
        break;
    }
}while (1 != 0);
    }

    public void viewBalance(){
        System.out.println("TUTION BALANCE: "+tutionBalance);
    }
    public void payTution(){
        viewBalance();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your payment: ");
        int payment = in.nextInt();
        tutionBalance = tutionBalance - payment;
        System.out.println("Thank you for your payment of $: "+ payment);
        viewBalance();
    }
    public String toString(){
        return "Name: " + firstName + " "+lastName + " Grade Year: " + gradeYear + " Student Id: " + studentId + "\n Courses enrolled: "+courses + "\n Balance: " + tutionBalance;
    }

}
