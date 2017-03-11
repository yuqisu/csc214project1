package project1.csc214.playgames;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Connect4 extends AppCompatActivity {

    Button quitC4;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    int click;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect4);
        final Connect4Board board = new Connect4Board(this);
        board.initalizeGame();

            button1 = (Button) findViewById(R.id.cell0);
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    board.checkGame(0);
                }
            });
            button2 = (Button) findViewById(R.id.cell1);
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    board.checkGame(1);
                }

            });
            button3 = (Button) findViewById(R.id.cell2);
            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    board.checkGame(2);
                }
            });
            button4 = (Button) findViewById(R.id.cell3);
            button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    board.checkGame(3);
                }
            });
            button5 = (Button) findViewById(R.id.cell4);
            button5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    board.checkGame(4);
                }
            });
        quitC4 = (Button) findViewById(R.id.quitforC4);
        quitC4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click++;
                if (click == 1) {
                    Toast.makeText(Connect4.this, "are you sure to quit?", Toast.LENGTH_SHORT).show();
                } else if (click == 2) {
                    click = 0;
                    setResult(RESULT_CANCELED);
                    finish();
                }
            }
        });
    }

}




