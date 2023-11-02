package com.example.pract2b;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3,b4;
    TextView t1,t2;
    EditText e1,e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        e1=findViewById(R.id.n1);
        e2=findViewById(R.id.n2);
        b1=findViewById(R.id.addition);
        b2=findViewById(R.id.substraction);
        b3=findViewById(R.id.multiplication);
        b4=findViewById(R.id.division);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int no1=Integer.parseInt(e1.getText().toString());
                int no2=Integer.parseInt(e2.getText().toString());
                t1.setVisibility(View.VISIBLE);
                t2.setText(" "+(no1+no2));

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int no1=Integer.parseInt(e1.getText().toString());
                int no2=Integer.parseInt(e2.getText().toString());
                t1.setVisibility(View.VISIBLE);
                t2.setText(" "+(no1-no2));
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int no1=Integer.parseInt(e1.getText().toString());
                int no2=Integer.parseInt(e2.getText().toString());
                t1.setVisibility(View.VISIBLE);
                t2.setText(" "+(no1*no2));
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int no1=Integer.parseInt(e1.getText().toString());
                int no2=Integer.parseInt(e2.getText().toString());
                if(no2==0){
                    Toast.makeText(getApplicationContext(),"Cannot divide number by zero",Toast.LENGTH_LONG).show();
                }
                else{
                    t1.setVisibility(View.VISIBLE);
                    t2.setText(" "+(no1/no2));
                }
            }
        });
    }
}
