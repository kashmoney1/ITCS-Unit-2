import java.util.*;
import java.util.ArrayList;

public class Student {

    private static ArrayList<Integer> grades;

    public Student() {
        grades = new ArrayList<>();
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
        for (Integer grade : grades) {
            sum += grade;
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
        int small = grades.get(0);
        int index = 0;
        for (int i = 0; i < grades.size(); i++) {
            if (grades.get(i) < small) {
                small = grades.get(i);
                index = i;
            }
        }
        grades.remove(index);
    }

    public static void main(String[] args) {
        addGrades();
        roundUpGrades();
        removeLowGrade();
        displayGrades();
        System.out.println(getAverageGrade());

    }
}


