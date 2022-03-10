//Akash Patel   ITCS

public class BingoCard {
    String[][] card = new String[6][5];

    public BingoCard() {
        generateCard();
    }

    public void generateCard() {

        for (int row = 0; row < card.length; row++) {
            for (int col = 0; col < card[row].length; col++) {
                if (row == 3 && col == 2) {
                    card[row][col] = "F";
                } else {
                    card[row][col] = (int) (Math.random() * (15) + col * 15 + 1) + "";
                }
            }
            System.out.println();
        }

        card[0][0] = "B";
        card[0][1] = "I";
        card[0][2] = "N";
        card[0][3] = "G";
        card[0][4] = "O";
    }

    public void displayCard() {
        for (int row = 0; row < card.length; row++) {
            for (int col = 0; col < card[row].length; col++) {
                System.out.print(card[row][col] + "\t");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        BingoCard card = new BingoCard();
        card.displayCard();
    }
}
