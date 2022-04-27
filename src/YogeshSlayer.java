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
                //if in the upper or lower left corner move to the upper right corner
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
                //if placed on center for second move
                if (board[1][1] == 2 && board[0][2] == 1) {
                    //if placed on any edge except [1][2]
                    if (board[1][0] == 2 || board[0][1] == 2 || board[2][1] == 2) {
                        move[0] = 1;
                        move[1] = 2;
                    }
                    //if placed on [1][2]
                    else if (board[1][2] == 2) {
                        move[0] = 1;
                        move[1] = 0;
                    }
                    //if placed on upper or lower left corner
                    else if (board[0][0] == 2 || board[2][0] == 2) {
                        move[0] = 1;
                        move[1] = 2;
                    }
                }
                //if in the upper or lower left corner for second move
                else if (board[0][0] == 2 || board[2][0] == 2 && board[0][2] == 1) {
                    //if it moves on any edge except [1][2]
                    if (board[1][0] == 2 || board[0][1] == 2 || board[2][1] == 2) {
                        move[0] = 1;
                        move[1] = 2;
                    }
                    //if placed on [1][2]
                    else if (board[1][2] == 2) {
                        move[0] = 2;
                        move[1] = 0;
                        //if [2][0] is taken
                        if (board[2][0] == 2) {
                            move[0] = 0;
                            move[1] = 0;
                        }
                    }
                    else {
                        move[0] = 1;
                        move[1] = 2;
                    }
                }
                //if the second move was to the upper right corner
                else if (board[0][2] == 2) {
                    //if [2][1] is empty then move there to win
                    if (board[2][1] == 0) {
                        move[0] = 2;
                        move[1] = 1;
                    }
                    else {
                        move[0] = 0;
                        move[1] = 0;
                    }
                }
            }
            else if (GameController.getTurnCount() == 6) {
                //if placed on center for second move
                if (board[1][1] == 2 && board[0][2] == 1) {
                    //if placed on [1][2]
                    if (board[1][2] == 2) {
                        //if placed on upper left corner
                        if (board[0][0] == 2) {
                            move[0] = 0;
                            move[1] = 1;
                        }
                        //if placed on lower left corner
                        else if (board[2][0] == 2) {
                            move[0] = 2;
                            move[1] = 1;
                        }
                    }
                }
            }

        }
        return move;
    }
}

