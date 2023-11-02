package com.example.pract1b;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    EditText t1,t2;
    Button b1;
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //hooks
        t1=findViewById(R.id.userName);
        t2=findViewById(R.id.passWord);
        b1=findViewById(R.id.Login);
        String un = "Pranav@13";
        String pw = "12345";
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count++;
                String username = t1.getText().toString();
                String password = t2.getText().toString();
                if (username.equals(un) && password.equals(pw)) {
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    intent.putExtra("UserName",username);
                    startActivity(intent);
                } else if (count == 3) {
                    Toast.makeText(getApplicationContext(), "Login Failed!!\nAttempts more than three", Toast.LENGTH_LONG).show();
                    b1.setEnabled(false);
                } else {
                    Toast.makeText(getApplicationContext(), "Attempt no: "+count+"\n "+(count-1)+"more attempts", Toast.LENGTH_LONG).show();

                }
            }
        });
    }
}
