//Akash Patel   ITCS

public class BingoCard {
    String[][] card = new String[6][5];

    public BingoCard() {
        generateCard();
    }

    public void generateCard() {

            for (int row = 0; row < card.length; row++) {
                for (int col = 0; col < card[row].length; col++) {
                    String first = (int)(Math.random()*15+(col * 15)+1) + "";
                    String second = "";
                    for (int row2 = 0; row2 < card.length; row2++) {
                        for (int col2 = 0; col2 < card[row2].length; col2++) {
                            second += card[row2][col2] + " ";
                        }
                    }
                    while (second.contains(first + " ")) {
                        first = (int)(Math.random()*15 + (col * 15)+1) + "";
                    }
                    card[row][col] = first;
                }
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
