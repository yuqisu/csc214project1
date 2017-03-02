package project1.csc214.playgames;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Hangman extends AppCompatActivity {
    public static String[]words = {"exist","official","relationship","remarkable","silly",
    "constantly","independent","customs","university","breeze"};
    private String word;
    private String display="";
    private String input;
    private boolean player = true;
    private static int guess1=8,guess2=8,click;
    TextView wordHM;
    Button okHM;
    Button quitHM;
    EditText editTextHM;
    TextView textView1HM,textView2HM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hangman);
        wordHM = (TextView)findViewById(R.id.word);
        word = words[(int)(Math.random()*9)];
        setUp(word);
        editTextHM = (EditText)findViewById(R.id.guessletter);
        textView1HM = (TextView)findViewById(R.id.hmguess1);
        textView2HM = (TextView)findViewById(R.id.hmguess2);
        okHM = (Button)findViewById(R.id.okforHM);

        okHM.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                input = editTextHM.getText().toString();
                playHangman();
                if (isWin()) {
                    if (player) {
                        Toast.makeText(Hangman.this, "Win", Toast.LENGTH_LONG).show();
                        guess1=8;
                        setUp(word);
                        player = false;
                    } else {
                        guess2=8;
                        Toast.makeText(Hangman.this, "Win", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        quitHM = (Button)findViewById(R.id.quitforHM);
        quitHM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click++;
               if (click==1){
                   Toast.makeText(Hangman.this,"are you sure to quit?",Toast.LENGTH_LONG).show();
               }else if (click==2){
                   click=0;
                   setResult(RESULT_CANCELED);
                   finish();
               }
            }
        });





    }
    public void playHangman(){
        if (isAlreadyInWord(input)) {
            Toast.makeText(Hangman.this, "this already appeared in the word", Toast.LENGTH_SHORT).show();
        }
        if (isInWord(input)) {
            updateWord(input);
            editTextHM.setText("");
        }else if (!isInWord(input)) {
            editTextHM.setText("");
            Toast.makeText(Hangman.this, "change a letter to try", Toast.LENGTH_SHORT).show();
            if (player) {
                guess1--;
                textView1HM.setText(String.valueOf(guess1));
                if (checkGuessTimes(guess1)) {
                    Toast.makeText(Hangman.this, "Too many tries", Toast.LENGTH_LONG).show();
                    guess1 = 8;
                    setUp(word);
                    player = false;
                }
            } else {
                guess2--;
                textView2HM.setText(String.valueOf(guess2));
                if (checkGuessTimes(guess2)) {
                    Toast.makeText(Hangman.this, "Too many tries", Toast.LENGTH_LONG).show();
                    guess2 = 8;
                }
            }
        }
    }
    public void setUp(String word){
        this.word =word;
        display="";
        for (int i=0;i<word.length();i++){
           display = display+"_";

        }
        wordHM.setText(display);
        Toast.makeText(Hangman.this,"the length of the word is "+word.length(),Toast.LENGTH_SHORT).show();

    }
    public void updateWord(String letter){
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
        return guess<0;
    }
}
