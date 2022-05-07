import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

// ITCS Order Handler Lab Shell Code
public class OrderHandler {
    private final ArrayList<Order> orders = new ArrayList<>();


    /* TODO: This method should read the file given.
     * 		 The files should be in a subfolder called Sales in your project directory.
     *       Order objects will be created and added to the ArrayList.
     */
    public void readFile(String fileName) {
        File myFile = new File("src\\" + fileName + ".txt");
        Scanner s = null;
        int lines = 0;
        Order order;
        String clientName = "";
        ArrayList<String> items = new ArrayList<>();
        ArrayList<Integer> quantities = new ArrayList<>();

        try {
            s = new Scanner(myFile);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        while (true) {
            assert s != null;
            if (!s.hasNextLine()) break;
            if (!Objects.equals(s.nextLine(), "")) {
                if (lines == 0) {
                    clientName = s.nextLine();
                }
                else if (lines % 2 == 0) {
                    quantities.add(Integer.parseInt(s.nextLine()));
                }
                else {
                    items.add(s.nextLine());
                }
                lines++;
            }
            else {
                for (int i = 0; i < items.size(); i++) {

                }
            }
        }
    }

    // TODO: Call the displayOrder method on all Order objects in the ArrayList
    public void displayOrders() {
        for (Order order : orders) {
            order.displayOrder();
        }
    }

    // TODO: Calculate and return the total revenue from all Orders in the ArrayList
    //       Just call the calculateRevenue method on each Order object and sum up the results
    public double calculateTotalRevenue() {

        return -1; //placeholder
    }

    // contains tester code
    public static void main(String[] args) {
        // Get file name and read file
        OrderHandler testHandler = new OrderHandler();
        Scanner s = new Scanner(System.in);
        System.out.println("Which file should be read? (do not include .txt extension)");
        testHandler.readFile(s.nextLine());

        // display the orders and calculate revenue
        System.out.println("\nOrders Read:");
        testHandler.displayOrders();
        System.out.println("\nTotal Revenue From Orders: ");
        System.out.println(testHandler.calculateTotalRevenue());
    }
}

