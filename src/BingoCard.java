//Akash Patel   ITCS

public class BingoCard {
    public String[][] card;

    public BingoCard() {
        generateCard();
    }

    public void generateCard() {
        card = new String[6][5];

        card[0][0] = "B";
        card[0][1] = "I";
        card[0][2] = "N";
        card[0][3] = "G";
        card[0][4] = "O";

        for (int row = 0; row < card.length; row++) {
            for (int col = 0; col < card[0].length; col++) {
                card[row][col] = (int) (Math.random() * 1) + "\t";
            }
            System.out.println();
        }
    }

    public void displayCard() {
        for (int row = 0; row < card.length; row++) {
            for (int col = 0; col < card[0].length; col++) {
                System.out.print(card[row][col] + "\t");
            }
            System.out.println();
        }
    }
}
