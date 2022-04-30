import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FilePractice {
    public static void printFile() {
        File myFile = new File("FileTest\\filetest1.txt");
        Scanner s = null;

        try {
            s = new Scanner(myFile);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return;
        }

        while (s.hasNextLine()) {
            System.out.println(s.nextLine());
        }
        System.out.println("End of File");
        s.close();
    }
    public static void main(String[] args) {
        printFile();
    }
}
