package com.example.pract1b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
public class ResultActivity extends AppCompatActivity {
    TextView t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        t1=findViewById(R.id.welcome);
        t2=findViewById(R.id.username);
        Intent intent=getIntent();
        String username=intent.getStringExtra("UserName");
        t2.setText(username);
    }
}
