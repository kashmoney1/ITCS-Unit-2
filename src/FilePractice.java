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
        File mySecondFile = new File("src\\filetest2.txt");
        Scanner s;
        int sum = 0;

        try {
            s = new Scanner(mySecondFile);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return 0;
        }

        while(s.hasNextLine()) {
            try {
                sum += Integer.parseInt(s.nextLine());
            } catch (Exception ignored) {
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(printFile());
        System.out.println(printFile2());
    }
}
