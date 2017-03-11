package project1.csc214.playgames;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by yuqisu on 3/8/17.
 */

public class Connect4Board {
    private static Context context;
    GridLayout boardLayout;
    private static final String test = "test";
    int board[][] = new int[5][5];
    int player;
    int player1 = 1;
    int player2 = 2;
    TextView scorePlayer1;
    TextView scorePlayer2;
    private static final String KEY_SCORE1 = "c4score1";
    private static final String KEY_SCORE2 = "c4score2";
    static Scoreboard scoreboard;

    public Connect4Board(Context c) {
        context = c;
        boardLayout = (GridLayout) ((Activity) context).findViewById(R.id.Connect4_board);
        scorePlayer1 = (TextView)((Activity) context).findViewById(R.id.player1scorec4);
        scorePlayer1.setText(String.valueOf(Scoreboard.score1));
        scorePlayer2 = (TextView)((Activity) context).findViewById(R.id.player2scorec4);
        scorePlayer2.setText(String.valueOf(Scoreboard.score2));
    }

    public void initalizeGame() {
        player = player1;
        createBoard();

    }
    public void checkEnd(){

        if (!isEmpty()) {
            Toast.makeText(context, "you got a draw ", Toast.LENGTH_SHORT).show();
        }else {
            if (checkWin()) {
                if (player == player1) {
                    Scoreboard.score1 =+1000;
                    scorePlayer1.setText(String.valueOf(Scoreboard.score1));
                    Toast.makeText(context,  NameInput.scoreboard.getArguments().getString(NameInput.KEY_PLAYER1NAME)+" win!! +1000", Toast.LENGTH_LONG).show();
                } else {
                   Scoreboard.score2 =+ 1000;
                    scorePlayer2.setText(String.valueOf(Scoreboard.score2));
                    Toast.makeText(context, NameInput.scoreboard.getArguments().getString(NameInput.KEY_PLAYER2NAME)+" win!!  +1000", Toast.LENGTH_LONG).show();
                }

            }
        }
    }

    void checkGame(int number) {
        if (!checkWin()) {
            int available = checkAvailable(number);
            if (available != -1) {
                updateBoard(available, number);
            } else {
                Toast.makeText(context, "try another column ", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(context, "Game ends, please quit", Toast.LENGTH_SHORT).show();
        }

    }


    boolean isEmpty() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j] == 0) {
                    return true;
                }
            }

        }
        return false;
    }

    void createBoard() {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j] = 0;
            }
        }
    }

    int checkAvailable(int number) {
        for (int i = 0; i < 5; i++) {
            if (board[number][i] == 0) {
                return i;
            }
        }
        return -1;
    }

    boolean checkWin() {
        for (int i = 0; i < 5; i++) {
            if (checkFour(player, 1, 0, i, 0, 0) || checkFour(player, 1, 1, i, 0, 0) || checkFour(player, -1, 1, i, 4, 0)) {
                return true;
            }
        }
        for (int j = 0; j < 5; j++) {
            if (checkFour(player, 0, 1, 0, j, 0) || checkFour(player, 1, 1, 0, j, 0) || checkFour(player, -1, 1, 4, j, 0)) {
                return true;
            }
        }
        return false;
    }

    boolean checkFour(int player, int dirx, int diry, int row, int col, int count) {
        if (count >= 4) {
            return true;
        }

        if (col < 0 || col >= 5 || row < 0 || row >= 5) {
            return false;
        }
        int cell = board[row][col];
        if (cell == player) {
            return checkFour(player, dirx, diry, row + diry, col + dirx, count + 1);

        } else {
            return checkFour(player, dirx, diry, row + diry, col + dirx, 0);
        }
    }

    void updateBoard(int available, int column) {

        View view = boardLayout.getChildAt(-1);
        if (available == 0) {
            view = boardLayout.getChildAt(20 + column);
        } else if (available == 1) {
            view = boardLayout.getChildAt(15 + column);
        } else if (available == 2) {
            view = boardLayout.getChildAt(10 + column);
        } else if (available == 3) {
            view = boardLayout.getChildAt(5 + column);
        } else if (available == 4) {
            view = boardLayout.getChildAt(column);
        }
        if (player == player1) {
            view.setBackgroundResource(R.drawable.board_green);
            board[column][available] = player1;
            checkEnd();
            player = player2;
        } else {
            view.setBackgroundResource(R.drawable.board_red);
            board[column][available] = player2;
            checkEnd();
            player = player1;
        }

    }
//    void updateScore(int score1,int score2){
//        Bundle bundle = new Bundle();
//        bundle.putInt(KEY_SCORE1,score1);
//        bundle.putInt(KEY_SCORE2,score2);
//        scoreboard = new Scoreboard();
//        scoreboard.setArguments(bundle);
//    }

}
