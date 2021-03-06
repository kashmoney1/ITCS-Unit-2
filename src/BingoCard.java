public class BingoCard {
    String[][] card = new String[6][5];

    public BingoCard() {
        generateCard();
    }

    public void generateCard() {

            for (int row = 0; row < card.length; row++) {
                for (int col = 0; col < card[row].length; col++) {
                    String first = (int)(Math.random()*15+(col * 15)+1) + "";
                    StringBuilder second = new StringBuilder();
                    for (String[] strings : card) {
                        for (String string : strings) {
                            second.append(string).append(" ");
                        }
                    }
                    while (second.toString().contains(first + " ")) {
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
        for (String[] strings : card) {
            for (String string : strings) {
                System.out.print(string + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        BingoCard card = new BingoCard();
        card.displayCard();
    }
}
