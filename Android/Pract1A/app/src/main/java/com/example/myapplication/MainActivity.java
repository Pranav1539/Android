package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;

public class MainActivity extends AppCompatActivity {

    //variables
    Button b1;
    EditText name;
    RadioGroup rg;
    RadioButton radio_male,radio_female;
    CheckBox cb1,cb2,cb3;
    RatingBar rb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //hooks
        b1=findViewById(R.id.b1);
        name=findViewById(R.id.en_name);
        rg=findViewById(R.id.selectGender);
        radio_female=findViewById(R.id.female);
        radio_male=findViewById(R.id.male);
        cb1=findViewById(R.id.mc);
        cb2=findViewById(R.id.bc);
        cb3=findViewById(R.id.gc);
        rb=findViewById(R.id.rating);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name=name.getText().toString();
                String rating=String.valueOf(rb.getRating());
                Intent intent=new Intent(MainActivity.this,ResultActivity.class);

                intent.putExtra("Name",Name);
                intent.putExtra("Rating",rating);
                if(radio_male.isChecked()){
                    String male=radio_male.getText().toString();
                    intent.putExtra("Gender",male);
                }
                if(radio_female.isChecked()){
                    String female=radio_female.getText().toString();
                    intent.putExtra("Gender",female);
                }
                StringBuilder stringBuilder=new StringBuilder();
                if(cb1.isChecked()){
                    stringBuilder.append("\n Mobile Computing");
                }
                if(cb2.isChecked()){
                    stringBuilder.append("\n Block Chain");
                }
                if(cb3.isChecked()){
                    stringBuilder.append("\n Green Computing");
                }
                intent.putExtra("Selected Subjects",(CharSequence) stringBuilder);
                startActivity(intent);

            }
        });
    }

}
