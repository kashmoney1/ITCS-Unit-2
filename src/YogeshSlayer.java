//suchir and akash
//fatherless but not more fatherless than our roller coaster
public class YogeshSlayer extends TicTacToePlayer {

    public YogeshSlayer(String name, int piece) {
        super(name, piece);
    }

    //practically hard coding everything to make an unbeatable bot
    public int[] playTurn() {
        int [] move = new int[2];
        int [][] board = GameController.game.getBoard();

        //if our bot is X (first player)
        if (getPiece() == 1) {

            //turn #1 place X on bottom right corner
            if (GameController.getTurnCount() == 0) {
                move[0] = 2;
                move[1] = 2;
            }
            else if (GameController.getTurnCount() == 2) {
                //if in the center move to upper right corner
                if (board[1][1] == 2) {
                    move[0] = 0;
                    move[1] = 2;
                }
                //if in the upper or lower left hand corner move to the upper right corner
                else if (board[0][0] == 2 || board[2][0] == 2) {
                    move[0] = 0;
                    move[1] = 2;
                }
                //if in the upper right corner move to the lower left corner
                else if (board[0][2] == 2) {
                    move[0] = 2;
                    move[1] = 0;
                }
                //if on any edge move to upper right corner
                else if (board[1][0] == 2 || board[0][1] == 2 || board[2][1] == 2 || board[1][2] == 2) {
                    move[0] = 0;
                    move[1] = 2;
                }
            }
            else if (GameController.getTurnCount() == 4) {
                //if O isn't at [1][2]
                if (board[1][2] != 2) {
                    move[0] = 1;
                    move[1] = 2;
                }
            }
            else if (GameController.getTurnCount() == 6) {

            }

        }
        return move;
    }
}

