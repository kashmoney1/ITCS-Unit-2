//Akash Patel   ITCS

import java.util.*;
import java.util.ArrayList;

public class Student {

    private static ArrayList<Integer> grades;

    public Student() {
        grades = new ArrayList<Integer>();
    }

    public static void displayGrades() {
        System.out.println(grades);
    }

    public static void addGrades() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a grade (enter -1 to stop): ");
            int number = scan.nextInt();
            if (number != -1) {
                grades.add(number);
            } else {
                break;
            }
        }
    }

    public static void getAverageGrades() {

    }

    public static void main(String[] args) {
        Student bob = new Student();
        bob.addGrades();
        bob.displayGrades();
    }
}


