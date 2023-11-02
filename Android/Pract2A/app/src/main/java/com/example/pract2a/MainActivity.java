package com.example.pract2a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    Button b1;
    EditText uname,fullname,email,phoneno,country,dd,mm,yy;
    RadioGroup rg;
    RadioButton male,female;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=findViewById(R.id.register);
        uname=findViewById(R.id.username);
        fullname=findViewById(R.id.fullname);
        email=findViewById(R.id.email);
        phoneno=findViewById(R.id.phonenumber);
        country=findViewById(R.id.country);
        dd=findViewById(R.id.date);
        mm=findViewById(R.id.month);
        yy=findViewById(R.id.year);
        rg=findViewById(R.id.rg);
        male=findViewById(R.id.male);
        female=findViewById(R.id.female);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String USER_NAME=uname.getText().toString();
                String FULL_NAME=fullname.getText().toString();
                String PHONE_NO=phoneno.getText().toString();
                String EMAIL=email.getText().toString();
                String COUNTRY=country.getText().toString();
                String DD=dd.getText().toString();
                String MM=mm.getText().toString();
                String YY=yy.getText().toString();


                Intent intent=new Intent(MainActivity.this,RESULTActivity.class);
                if(male.isChecked()){
                    String m=male.getText().toString();
                    intent.putExtra("GENDER",m);
                }
                if(female.isChecked()){
                    String f=female.getText().toString();
                    intent.putExtra("GENDER",f);
                }
                String dob=DD+"/"+MM+"/"+YY;
                intent.putExtra("USERNAME",USER_NAME);
                intent.putExtra("FULL NAME",FULL_NAME);
                intent.putExtra("EMAIL",EMAIL);
                intent.putExtra("COUNTRY",COUNTRY);
                intent.putExtra("PHONE NUMBER",PHONE_NO);
                intent.putExtra("DATE OF BIRTH",dob);
                startActivity(intent);
            }
        });
    }
}
