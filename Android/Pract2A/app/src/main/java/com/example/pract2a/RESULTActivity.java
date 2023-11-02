package com.example.pract2a;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
public class RESULTActivity extends AppCompatActivity {
    TextView t1,t2,t3,t4,t5,t6,t7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t3);
        t4=findViewById(R.id.t4);
        t5=findViewById(R.id.t5);
        t6=findViewById(R.id.t6);
        t7=findViewById(R.id.t7);
        Intent intent=getIntent();
        String username=intent.getStringExtra("USERNAME");
        String fullname=intent.getStringExtra("FULL NAME");
        String email=intent.getStringExtra("EMAIL");
        String country=intent.getStringExtra("COUNTRY");
        String pn=intent.getStringExtra("PHONE NUMBER");
        String dob=intent.getStringExtra("DATE OF BIRTH");
        String gen=intent.getStringExtra("GENDER");
        t1.setText("USER NAME="+username);
        t2.setText("FULL NAME="+fullname);
        t3.setText("EMAIL ID="+email);
        t4.setText("CONTACT NO="+pn);
        t5.setText("COUNTRY="+country);
        t6.setText("GENDER="+gen);
        t7.setText("DATE OF BIRTH="+dob);
    }
}
