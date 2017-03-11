package project1.csc214.playgames;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by yuqisu on 3/8/17.
 */

public class HangmanModel {
    private static Context context;
    TextView wordHM;
    EditText editTextHM;
    TextView textView1HM,textView2HM;
    private static String[]words = {"exist","official","relationship","remarkable","silly",
            "constantly","independent","customs","university","breeze"};
    private String word;
    private String display="";
//    private String input;
    private boolean player = true;
    private static int guess1=8,guess2=8;
    private static int guessTime1;
    private static int guessTime2;
    TextView scorePlayer1;
    TextView scorePlayer2;
    private static final String KEY_SCORE1 = "hmscore1";
    private static final String KEY_SCORE2 = "hmscore2";
    static Scoreboard scoreboard;



    public HangmanModel(Context c){
        context = c;
        wordHM = (TextView)((Activity)context).findViewById(R.id.word);
        word = words[(int)(Math.random()*9)];
        setUp(word);
        editTextHM = (EditText)((Activity)context).findViewById(R.id.guessletter);
        textView1HM = (TextView)((Activity)context).findViewById(R.id.hmguess1);
        textView2HM = (TextView)((Activity)context).findViewById(R.id.hmguess2);
        scorePlayer1 = (TextView)((Activity) context).findViewById(R.id.player1scorehm);
        scorePlayer1.setText(String.valueOf(Scoreboard.score1));
        scorePlayer2 = (TextView)((Activity) context).findViewById(R.id.player2scorehm);
        scorePlayer2.setText(String.valueOf(Scoreboard.score2));

    }


    public void play(String input){
        if (isAlreadyInWord(input)){
            Toast.makeText(context, "this already appeared in the word", Toast.LENGTH_SHORT).show();
            editTextHM.setText("");
        }
        if (isInWord(input)){
            update(input);
            editTextHM.setText("");
        }else if (!isInWord(input)){
            editTextHM.setText("");
            Toast.makeText(context, "change a letter to try", Toast.LENGTH_SHORT).show();
            if (player) {
                guess1--;
                textView1HM.setText(String.valueOf(guess1));
                if (checkGuessTimes(guess1)) {
                    Toast.makeText(context, "Too many tries", Toast.LENGTH_LONG).show();
                    guessTime1=0;
                    guess1 = 8;
                    setUp(word);
                    player = false;
                }
            } else {
                guess2--;
                textView2HM.setText(String.valueOf(guess2));
                if (checkGuessTimes(guess2)) {
                    Toast.makeText(context, "Too many tries", Toast.LENGTH_LONG).show();
                    guessTime2=0;
                    calculateScore(guessTime1,guessTime2);
                    guess2 = 8;
                }
            }
        }

    }
    public void setUp(String word){
        this.word =word;
        Toast.makeText(context, "the length of the word is "+word.length(), Toast.LENGTH_SHORT).show();
        display="";
        for (int i=0;i<word.length();i++){
            display = display+"_";

        }
        wordHM.setText(display);
    }
    public void update(String letter){
        for (int i=0;i<word.length();i++){
            char c = word.toLowerCase().charAt(i);
            if (c==letter.toLowerCase().toCharArray()[0]){
                display = display.substring(0,i)+c+display.substring(i+1,display.length());
            }
        }
        wordHM.setText(display);
    }
    boolean isInWord(String letter){
        char c= letter.toLowerCase().toCharArray()[0];
        for (int i=0;i<word.length();i++){
            if (c==word.toLowerCase().charAt(i)){
                return true;
            }
        }
        return false;
    }

    boolean isAlreadyInWord(String letter){
        char c =letter.toLowerCase().toCharArray()[0];
        for (int i=0;i<display.length();i++){
            char x = display.toLowerCase().charAt(i);
            if (x == c){
                return true;
            }
        }
        return false;
    }
    boolean isWin(){
        return word.equals(display);

    }
    boolean checkGuessTimes(int guess) {
        return guess<=0;
    }
    public void ok(){
        if (isWin()){
            if (player) {
                Toast.makeText(context, "Correct", Toast.LENGTH_SHORT).show();
                guessTime1=guess1;
                guess1=8;
                setUp(word);
                player = false;
            } else {
                Toast.makeText(context, "Correct", Toast.LENGTH_SHORT).show();
//                System.out.println("guess1time!!!!!"+guessTime1);
//                System.out.println("guess2time!!!!!"+guessTime2);
                calculateScore(guessTime1,guess2);
                guess2=8;

            }
        }
    }
    public void calculateScore(int player1, int player2){
        int difference = player1-player2;
        int score = Math.abs(difference)*100;
        String name1 = NameInput.scoreboard.getArguments().getString(NameInput.KEY_PLAYER1NAME);
        String name2 = NameInput.scoreboard.getArguments().getString(NameInput.KEY_PLAYER2NAME);
        if (difference>0){

            Scoreboard.score1+=score;
            scorePlayer1.setText(String.valueOf(Scoreboard.score1));
            Toast.makeText(context, name1+" wins! add "+score+" to "+name1, Toast.LENGTH_LONG).show();
        }else if (difference<0){
            Scoreboard.score2+=score;
            scorePlayer2.setText(String.valueOf(Scoreboard.score2));
            Toast.makeText(context, name2+" wins! add "+score+" to "+name2, Toast.LENGTH_LONG).show();
        }else if (difference==0){
            Toast.makeText(context, "you got a draw!", Toast.LENGTH_SHORT).show();
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
