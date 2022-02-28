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

    public static int getAverageGrade() {
        int sum = 0;
        for (int i = 0; i < grades.size(); i++) {
            sum += grades.get(i);
        }
        return sum/grades.size();
    }

    public static void roundUpGrades() {
        for (int i = 0; i < grades.size(); i++) {
            if (grades.get(i) == 69 || grades.get(i) == 79 || grades.get(i) == 89) {
                grades.set(i, grades.get(i) + 1);
            }
        }
    }

    public static void removeLowGrade() {
        for (int i = 0; i < grades.size(); i++) {
            
        }
    }

    public static void main(String[] args) {
        Student bob = new Student();
        bob.addGrades();
        bob.roundUpGrades();
        bob.removeLowGrade();
        bob.displayGrades();
        System.out.println(bob.getAverageGrade());

    }
}


