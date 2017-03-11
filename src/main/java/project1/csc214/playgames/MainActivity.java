package project1.csc214.playgames;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button bHotCold;
    Button bHangman;
    Button bConnect4;
    private final int RC_HC =2;
    private final int RC_HM =3;
    private final int RC_C4 =4;
    private static final String KEY_SCORE1 = "score1";
    private static final String KEY_SCORE2 = "score2";
    TextView scorePlayer1;
    TextView scorePlayer2;
    static Scoreboard scoreboard;
//    Scoreboard scoreboard = new Scoreboard();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bHotCold = (Button)findViewById(R.id.Bhotcold);
        bHangman = (Button)findViewById(R.id.Bhangman);
        bConnect4 = (Button)findViewById(R.id.Bconnect4);


        scorePlayer1 = (TextView)findViewById(R.id.player1scoremain);
        scorePlayer2 = (TextView)findViewById(R.id.player2scoremain);
        if (savedInstanceState!=null){
            scorePlayer1.setText(String.valueOf(Scoreboard.score1));
            scorePlayer2.setText(String.valueOf(Scoreboard.score2));
        }
        bHotCold.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this,HotterColder.class);
                startActivityForResult(intent,RC_HC);


            }

        });
        bHangman.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this,Hangman.class);
                startActivityForResult(intent,RC_HM);


            }

        });
        bConnect4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this,Connect4.class);
                startActivityForResult(intent,RC_C4);

            }

        });

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode==RC_HC || requestCode==RC_HM ||requestCode== RC_C4){
            Log.d("test","onResult called()");
            scorePlayer1.setText(String.valueOf(Scoreboard.score1));
            scorePlayer2.setText(String.valueOf(Scoreboard.score2));
        }
    }
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_SCORE1,Scoreboard.score1);
        outState.putInt(KEY_SCORE2,Scoreboard.score2);
        Log.d("test","onSaved called()");
    }

}
