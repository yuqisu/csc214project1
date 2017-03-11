package project1.csc214.playgames;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HotterColder extends AppCompatActivity {

    Button okButton;
    int inputNumber;
    EditText editText;
    private HotterColderModel hc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotter_colder);
        hc = new HotterColderModel(this);
//        hc = HotterColderModel.getInstance(this);
        editText = (EditText)findViewById(R.id.guess);
        okButton  = (Button)findViewById(R.id.okforHC);
        okButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
              try {
                  inputNumber = Integer.parseInt(editText.getText().toString());
                  hc.ok(inputNumber);

              }catch(NumberFormatException e){
                  Toast.makeText(HotterColder.this,"Please check your input",Toast.LENGTH_SHORT).show();
                  editText.setText("");
              }
            }
        });
    }



}
