import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FilePractice {
    public static int printFile() {
        File myFile = new File("src\\filetest1.txt");
        Scanner s;
        int sum = 0;

        try {
            s = new Scanner(myFile);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return 0;
        }

        while (s.hasNextLine()) {
            try {
                sum += Integer.parseInt(s.nextLine());
            } catch (Exception ignored) {
            }
        }
        return sum;
    }

    public static int printFile2() {
        File myFile = new File("src\\filetest2.txt");
        Scanner s;
        int sum = 0;

        try {
            s = new Scanner(myFile);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return 0;
        }

        while (s.hasNextLine()) {
            try {
                sum += Integer.parseInt(s.nextLine());
            } catch (Exception ignored) {
            }
        }
        return sum;
    }

    public static void numAnimals() {
        File myFile = new File("src\\filetest2.txt");
        Scanner s;
        String animalName = "";
        int numAnimals;
        int lines = 0;

        try {
            s = new Scanner(myFile);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return;
        }

        while (s.hasNextLine()) {
            if (lines % 2 == 1) {
                numAnimals = Integer.parseInt(s.nextLine());
                System.out.println(animalName + ": " + numAnimals);
            } else {
                animalName = s.nextLine();
            }
            lines++;
        }
    }

    public static void main(String[] args) {
        System.out.println(printFile());
        System.out.println(printFile2());
        numAnimals();
    }
}
