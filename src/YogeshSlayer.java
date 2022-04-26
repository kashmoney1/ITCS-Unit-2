//suchir and akash
//fatherless but not more fatherless than our roller coaster
public class YogeshSlayer extends TicTacToePlayer {

    public YogeshSlayer(String name, int piece) {
        super(name, piece);
    }

    public int[] playTurn() {
        int [] move = new int[2];
        int [][] board = GameController.game.getBoard();

        if (getPiece() == 1) {
            if (GameController.getTurnCount() == 0) {
                move[0] = 2;
                move[1] = 2;
            }
            else if (GameController.getTurnCount() == 2) {
                if (board[1][1] == 0) {
                    if (board[2][0] == 0) {
                        move[0] = 2;
                        move[1] = 0;
                    }
                    else if (board[2][1] != 0) {
                        move[0] = 0;
                        move[1] = 2;
                    }
                }
                else {
                    move[0] = 0;
                    move[1] = 0;
                }
            }
            else if (GameController.getTurnCount() == 4) {

            }

        }
        return move;
    }
}

