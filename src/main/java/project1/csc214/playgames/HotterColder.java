package project1.csc214.playgames;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HotterColder extends AppCompatActivity {
    private final int number = (int)(Math.random()*10);
//    private final int number =3;
    private static boolean player = false;
    private int inputNumber,preNumber;
    private int guess1=0,guess2=0;
    TextView textView1,textView2;
    EditText editText;
    Button okButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotter_colder);
        editText = (EditText)findViewById(R.id.guess);
        textView1=(TextView)findViewById(R.id.numberguess);
        textView2 = (TextView)findViewById(R.id.numberguess2);
        guess1 =Integer.parseInt(textView1.getText().toString());
        guess2 = Integer.parseInt(textView2.getText().toString());
        okButton  = (Button)findViewById(R.id.okforHC);
        okButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                inputNumber = Integer.parseInt(editText.getText().toString());
                preNumber = inputNumber;
                checkCold();
            }
        });
    }


    public void checkCold(){
        if (!player){
            if (inputNumber==number){
                guess1++;
                textView1.setText(String.valueOf(guess1));
                Toast.makeText(HotterColder.this, R.string.correct, Toast.LENGTH_LONG).show();
                editText.setText("");
                player=true;
            }else {
                guess1++;
                if(Math.abs(inputNumber-number)<2){
                    textView1.setText(String.valueOf(guess1));
                    Toast.makeText(HotterColder.this,"On Fire",Toast.LENGTH_SHORT).show();
                }else if(Math.abs(inputNumber-number)<3){
                    textView1.setText(String.valueOf(guess1));
                    Toast.makeText(HotterColder.this,"Hot",Toast.LENGTH_SHORT).show();
                }else if(Math.abs(inputNumber-number)<4){
                    textView1.setText(String.valueOf(guess1));
                    Toast.makeText(HotterColder.this,"warm",Toast.LENGTH_SHORT).show();
                }else if(Math.abs(inputNumber-number)>5){
                    textView1.setText(String.valueOf(guess1));
                    Toast.makeText(HotterColder.this,"cold",Toast.LENGTH_SHORT).show();
                }else if(Math.abs(inputNumber-number)>6){
                    textView1.setText(String.valueOf(guess1));
                    Toast.makeText(HotterColder.this,"freezing",Toast.LENGTH_SHORT).show();
                }else if((Math.abs(inputNumber-number)>7)){
                    textView1.setText(String.valueOf(guess1));
                    Toast.makeText(HotterColder.this,"Absolute Zero",Toast.LENGTH_SHORT).show();

                }
            }
        }else if(player){
            if (inputNumber==number){
                guess2++;
                textView2.setText(String.valueOf(guess2));
                Toast.makeText(HotterColder.this, R.string.correct, Toast.LENGTH_LONG).show();
                player=false;
            }else {
                guess2++;
                if(Math.abs(inputNumber-number)<3){
                    Toast.makeText(HotterColder.this,"On Fire",Toast.LENGTH_SHORT).show();
                    textView2.setText(String.valueOf(guess2));
                }else if(Math.abs(inputNumber-number)<5){
                    textView2.setText(String.valueOf(guess2));
                    Toast.makeText(HotterColder.this,"Hot",Toast.LENGTH_SHORT).show();
                }else if(Math.abs(inputNumber-number)<15){
                    textView2.setText(String.valueOf(guess2));
                    Toast.makeText(HotterColder.this,"warm",Toast.LENGTH_SHORT).show();
                }else if(Math.abs(inputNumber-number)>15){
                    textView2.setText(String.valueOf(guess2));
                    Toast.makeText(HotterColder.this,"cold",Toast.LENGTH_SHORT).show();
                }else if(Math.abs(inputNumber-number)>25){
                    textView2.setText(String.valueOf(guess2));
                    Toast.makeText(HotterColder.this,"freezing",Toast.LENGTH_SHORT).show();
                }else if(Math.abs(inputNumber-number)>35){
                    textView2.setText(String.valueOf(guess2));
                    Toast.makeText(HotterColder.this,"Absolute Zero",Toast.LENGTH_SHORT).show();

                }
            }

        }
    }
}
