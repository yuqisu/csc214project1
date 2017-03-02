package project1.csc214.playgames;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button bHotCold;
    Button bHangman;
    Button bConnect4;
    EditText player1Name;
    EditText player2Name;
    Button player1_name_confirm;
    Button player2_name_confirm;
    TextView player1_score;
    TextView player2_score;
    private static final String KEY_PLAYER1NAME="PLAYER1";
    private static final String KEY_PLAYER2NAME="PLAYER2";
    private static final int RC_HC = 2;
    private static final int RC_HM = 3;
    private static final int RC_C4 = 4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bHotCold = (Button)findViewById(R.id.Bhotcold);
        bHangman = (Button)findViewById(R.id.Bhangman);
        bConnect4 = (Button)findViewById(R.id.Bconnect4);
        player1Name = (EditText)findViewById(R.id.nameforFirst);
        player2Name = (EditText)findViewById(R.id.nameforSecond);
        player1_name_confirm = (Button)findViewById(R.id.name_player_confirm_button);

        player1_name_confirm.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

            }
        });
        player2_name_confirm = (Button)findViewById(R.id.name_player2_confirm_button);
        player2_name_confirm.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

            }
        });
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
        if (resultCode==RESULT_OK&&requestCode==RC_HC){

        }
    }
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_PLAYER1NAME,player1Name.getText().toString());
        outState.putString(KEY_PLAYER2NAME,player2Name.getText().toString());
    }

}
