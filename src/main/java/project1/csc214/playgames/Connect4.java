package project1.csc214.playgames;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Connect4 extends AppCompatActivity {
    ImageView[][] cell;
    ImageView boardView;
    private int player1 =1;
    private int player2 =2;
    int player ;
    private View view;
    private Boards board;
    private static int rows=8;
    private static int colums = 8;
    Button col1;
    Button col2;
    Button col3;
    Button col4;
    Button col5;
    Button col6;
    Button col7;
    Button col8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect4);
        board = new Boards(rows,colums);
        boardView = (ImageView) findViewById(R.id.board);
//        buildBoard();
        col1 = (Button)findViewById(R.id.button1);
        col1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                updateBoard(0);
            }
        });
//        col2 = (Button)findViewById(R.id.button2);
//        col2.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                updateBoard(1);
//            }
//        });
//        col3 = (Button)findViewById(R.id.button3);
//        col3.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                updateBoard(2);
//            }
//        });
//        col4 = (Button)findViewById(R.id.button4);
//        col4.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                updateBoard(3);
//            }
//        });
//        col5 = (Button)findViewById(R.id.button5);
//        col5.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                updateBoard(4);
//            }
//        });
//        col6 = (Button)findViewById(R.id.button6);
//        col6.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                updateBoard(5);
//            }
//        });
//        col7 = (Button)findViewById(R.id.button7);
//        col7.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                updateBoard(6);
//            }
//        });
//        col8 = (Button)findViewById(R.id.button8);
//        col8.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                updateBoard(7);
//            }
//        });


    }

//    private void buildBoard(){
//        cell = new ImageView[rows][colums];
//        for (int i=0;i<rows;i++) {
//            ViewGroup row = (ViewGroup) ((ViewGroup) boardView).getChildAt(i);
//            row.setClipChildren(false);
//            for (int j = 0; j < colums; j++) {
//                ImageView imageView = (ImageView)row.getChildAt(j);
//                imageView.setImageResource(android.R.color.transparent);
//                cell[i][j] =imageView;
//            }
//        }
//    }

    private void updateBoard(int column) {
       if (board.isEnd==true){

       }
        int row = board.findSpot(column);
        if (row==-1){
            Toast.makeText(Connect4.this,"pick another available column",Toast.LENGTH_SHORT).show();
        }
        ImageView oneCell = cell[row][column];

        board.makeMove(row,column);
        if (board.checkWin()){
            Toast.makeText(Connect4.this,"you win!",Toast.LENGTH_LONG).show();
        }else {
            if (player == player1) {
                player = player2;
            } else {
                player = player1;
            }
        }
    }
    private int putIcons(){
        if (player==player1){
            return R.drawable.board_red;
        }else if(player==player2){
            return R.drawable.board_green;
        }
        return R.drawable.board_red;
    }

}
