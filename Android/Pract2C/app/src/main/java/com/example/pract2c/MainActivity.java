package com.example.pract2c;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText e1;
    TextView t1,t2;
    Button b1;
    RadioGroup radioGroup;
    RadioButton r1,r2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.calculate);
        t1=findViewById(R.id.result);
        t2=findViewById(R.id.t);
        e1=findViewById(R.id.t1);
        radioGroup=findViewById(R.id.group);
        r1=findViewById(R.id.c2f);
        r2=findViewById(R.id.f2c);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num=e1.getText().toString();
                int n=Integer.parseInt(num);
                if(r1.isChecked()){
                    int conversion=(n*(9/5))+32;
                    t1.setText(conversion+" degree farenhite");
                    t2.setVisibility(View.VISIBLE);


                }
                if(r2.isChecked()){
                    int conversion=((n-32)*5)/9;
                    t1.setText(conversion+" degree celcius");
                    t2.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
