package project1.csc214.playgames;

import android.app.Activity;
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

    private String input;
    int click;
    Button okHM;
    Button quitHM;
    EditText editTextHM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hangman);
        final HangmanModel hangman = new HangmanModel(Hangman.this);
        okHM = (Button)findViewById(R.id.okforHM);
        editTextHM = (EditText)findViewById(R.id.guessletter);
        okHM.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                    input = editTextHM.getText().toString();
                    hangman.play(input);
                    hangman.ok();

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


}
