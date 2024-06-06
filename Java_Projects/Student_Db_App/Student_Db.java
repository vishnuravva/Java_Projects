package Student_Db_App;

import java.util.Scanner;

public class Student_Db {
    public static void main(String[] args) {
//Student std1 = new Student();
//std1.enroll();
//std1.payTution();
//        System.out.println(std1.toString());

        System.out.println("Enroll no of students to enroll");
        Scanner in = new Scanner(System.in);
        int noOfStudents = in.nextInt();
        Student[] students = new Student[noOfStudents];

        for(int i=0;i<noOfStudents;i++){
            students[i] = new Student();
            students[i].enroll();
            students[i].payTution();
            System.out.println(students[0].toString());

        }
        for(int i=0;i<noOfStudents;i++){
            System.out.println(students[i].toString());

        }




    }
}
