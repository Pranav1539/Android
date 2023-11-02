package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
public class ResultActivity extends AppCompatActivity {
    //variables
    TextView t1,t2,t3,t4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //hooks
        t1=findViewById(R.id.name);
        t2=findViewById(R.id.gender);
        t3=findViewById(R.id.subjects);
        t4=findViewById(R.id.rating);

        Intent intent=getIntent();

        String name = intent.getStringExtra("Name");
        String gender = intent.getStringExtra("Gender");
        String subjects = intent.getStringExtra("Selected Subjects");
        String rb = intent.getStringExtra("Rating");
        t1.setText("Name: " +name);
        t2.setText("Gender: "+gender);
        t3.setText("Subjects Appeared: "+subjects);
        t4.setText("Rating is: "+rb);
    }
}
