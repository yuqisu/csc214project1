package project1.csc214.playgames;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NameInput extends AppCompatActivity {
    static EditText  player1Name;
    static EditText player2Name;
    Button player1_name_confirm;
    Button player2_name_confirm;
    Button playgame;
    static Scoreboard scoreboard;
    private static final String test= "test";
    static final String KEY_PLAYER1NAME="PLAYER1";
    static final String KEY_PLAYER2NAME="PLAYER2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_input);
        player1Name = (EditText)findViewById(R.id.nameforFirst);
        player2Name = (EditText)findViewById(R.id.nameforSecond);
        player1_name_confirm = (Button)findViewById(R.id.name_player_confirm_button);
        player1_name_confirm.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(NameInput.this,"player1 name "+player1Name.getText().toString()+" is confirmed",Toast.LENGTH_SHORT).show();

            }
        });
        player2_name_confirm = (Button)findViewById(R.id.name_player2_confirm_button);
        player2_name_confirm.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(NameInput.this,"player2 name "+player2Name.getText().toString()+" is confirmed",Toast.LENGTH_SHORT).show();


            }
        });
        playgame = (Button)findViewById(R.id.playGames);
        playgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMessage();
                Intent intent = new Intent(NameInput.this,MainActivity.class);
                startActivity(intent);

            }
        });


    }
    public void setMessage(){
        scoreboard  = new Scoreboard();
        Bundle bundle =new Bundle();
        bundle.putString(KEY_PLAYER1NAME,player1Name.getText().toString());
        bundle.putString(KEY_PLAYER2NAME,player2Name.getText().toString());
        scoreboard.setArguments(bundle);
//        System.out.println("Bundleeeeeeeeee"+bundle);
    }
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_PLAYER2NAME,player2Name.getText().toString());

    }
}
