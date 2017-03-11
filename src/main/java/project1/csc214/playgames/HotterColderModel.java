package project1.csc214.playgames;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by yuqisu on 3/8/17.
 */

public class HotterColderModel {
    private static Context context;
    private static HotterColderModel INSTANCE;
    private final int number = (int) (Math.random() * 100);
    private static boolean player = true;
    private int guess1 = 0, guess2 = 0;
    int prenumber = 0;
    TextView textView1, textView2;
    EditText editText;
    TextView scorePlayer1;
    TextView scorePlayer2;
    private static final String KEY_SCORE1 = "hcscore1";
    private static final String KEY_SCORE2 = "hcscore2";
    static Scoreboard scoreboard;

    public HotterColderModel(Context c) {

        context = c;
        editText = (EditText) ((Activity) context).findViewById(R.id.guess);
        textView1 = (TextView) ((Activity) context).findViewById(R.id.numberguess);
        textView2 = (TextView) ((Activity) context).findViewById(R.id.numberguess2);
        guess1 = Integer.parseInt(textView1.getText().toString());
        guess2 = Integer.parseInt(textView2.getText().toString());
        scorePlayer1 = (TextView)((Activity) context).findViewById(R.id.player1scorehc);
        scorePlayer1.setText(String.valueOf(Scoreboard.score1));
        scorePlayer2 = (TextView)((Activity) context).findViewById(R.id.player2scorehc);
        scorePlayer2.setText(String.valueOf(Scoreboard.score2));
    }
    public static HotterColderModel getInstance(Context context) {
        if(INSTANCE == null) {
            INSTANCE = new HotterColderModel(context);
        }
        return INSTANCE;
    }
    public void ok(int number) {

        if (player) {
            if (isWin(number)) {
                guess1++;
                textView1.setText(String.valueOf(guess1));
                Toast.makeText(context, R.string.correct, Toast.LENGTH_LONG).show();
                editText.setText("");
                player = false;
            } else {
                checkNumber(prenumber, number, player);
                prenumber = number;
                editText.setText("");
            }
        } else if (!player) {
            if (isWin(number)) {
                guess2++;
                textView2.setText(String.valueOf(guess2));
                Toast.makeText(context, R.string.correct, Toast.LENGTH_LONG).show();
                player = true;
                calculateScore(guess1,guess2);
            }
            else {
                checkNumber(prenumber, number, player);
                prenumber = number;
                editText.setText("");
            }
        }

    }

    public void firstTimeCheck(int inputNumber) {
        if (Math.abs(inputNumber - number) < 3) {
            Toast.makeText(context, "On Fire", Toast.LENGTH_SHORT).show();
            textView2.setText(String.valueOf(guess2));
        } else if (Math.abs(inputNumber - number) < 5) {
            textView2.setText(String.valueOf(guess2));
            Toast.makeText(context, "Hot", Toast.LENGTH_SHORT).show();
        } else if (Math.abs(inputNumber - number) < 15) {
            textView2.setText(String.valueOf(guess2));
            Toast.makeText(context, "warm", Toast.LENGTH_SHORT).show();
        } else if (Math.abs(inputNumber - number) > 15 && Math.abs(inputNumber - number) <25) {
            textView2.setText(String.valueOf(guess2));
            Toast.makeText(context, "cold", Toast.LENGTH_SHORT).show();
        } else if (Math.abs(inputNumber - number) > 25 && Math.abs(inputNumber - number) <35) {
            textView2.setText(String.valueOf(guess2));
            Toast.makeText(context, "freezing", Toast.LENGTH_SHORT).show();
        } else if (Math.abs(inputNumber - number) > 35) {
            textView2.setText(String.valueOf(guess2));
            Toast.makeText(context, "Absolute Zero", Toast.LENGTH_SHORT).show();
        }
    }

    public void checkNumber(int preNumber, int number, boolean player) {
        if (player) {
            if (guess1==0){
                firstTimeCheck(number);
                guess1++;
                textView1.setText(String.valueOf(guess1));
            }else{
                firstTimeCheck(number);
                guess1++;
                textView1.setText(String.valueOf(guess1));
                checkNumber(preNumber, number);

            }


        } else if (!player) {
            if (guess1==0){
                firstTimeCheck(number);
                guess2++;
                textView2.setText(String.valueOf(guess2));
            }else{
                firstTimeCheck(number);
                guess2++;
                textView2.setText(String.valueOf(guess2));
                checkNumber(preNumber, number);
            }

        }
    }

    public void checkNumber(int preNumber, int input) {
        if (Math.abs(preNumber - number) < Math.abs(input - number)) {
            Toast.makeText(context, "colder", Toast.LENGTH_SHORT).show();

        } else if (Math.abs(preNumber - number) > Math.abs(input - number) ) {
            Toast.makeText(context, "hotter", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "why same number again???", Toast.LENGTH_SHORT).show();
        }
    }

    boolean isWin(int input) {
        return input == number;
    }

    void calculateScore(int player1,int player2){
        int difference = player1-player2;
        int score = Math.abs(difference)*100;
        String name1 = NameInput.scoreboard.getArguments().getString(NameInput.KEY_PLAYER1NAME);
        String name2 = NameInput.scoreboard.getArguments().getString(NameInput.KEY_PLAYER2NAME);
        if (difference>0){
            Toast.makeText(context, name2+" wins! add "+score+" to "+name2, Toast.LENGTH_SHORT).show();
            Scoreboard.score2+=score;
            scorePlayer2.setText(String.valueOf(Scoreboard.score2));

        }else if (difference<0){
            Toast.makeText(context, name1+" wins! add "+score+" to "+name1, Toast.LENGTH_SHORT).show();
//            MainActivity.score1+=score;
            Scoreboard.score1+=score;
            scorePlayer1.setText(String.valueOf(Scoreboard.score1));
        }else{
            Toast.makeText(context, "you got a draw!", Toast.LENGTH_SHORT).show();
        }
    }

}
