import java.util.ArrayList;

public class Order {
    private String clientName;
    private ArrayList<String> items;
    private ArrayList<Integer> quantities;

    public Order (String clientName, ArrayList <String> items, ArrayList <Integer> quantities) {
        this.clientName = clientName;
        for (int i = 0; i < items.size(); i++) {
            items.add(items.get(i));
        }
        for (int i = 0; i < quantities.size(); i++) {
            quantities.add(quantities.get(i));
        }
    }

    public double calculateRevenue() {
        double price = 0.0;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).contains("Sweet")) {
                price += 0.5;
            }
            else if (items.get(i).contains("Idaho")) {
                price += 0.4;
            }
            else if (items.get(i).contains("Squash")) {
                price += 0.75;
            }
            else if (items.get(i).contains("Tomato")) {
                price += 0.3;
            }
            else if (items.get(i).contains("Green")) {
                price += 0.45;
            }
        }
        return price;
    }

    public void displayOrder() {
        System.out.println(clientName);
        for (int i = 0; i < items.size(); i++) {
            System.out.println(quantities.get(i) + items.get(i));
        }
    }

    public String getClientName() {
        return clientName;
    }

    public ArrayList<String> getItems() {
        return items;
    }

    public ArrayList<Integer> getQuantities() {
        return quantities;
    }
}
