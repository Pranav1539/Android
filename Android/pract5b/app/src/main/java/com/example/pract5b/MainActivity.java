package com.example.pract5b;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences =
                this.getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
        String e=sharedPreferences.getString("Email","");
        if(e.length()>0)startHomeActivity();
        EditText email =findViewById(R.id.et1);
        EditText pass = findViewById(R.id.et2);
        CheckBox cbbx = findViewById(R.id.cb1);
        Button button = findViewById(R.id.btn1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cbbx.isChecked())
                    saveLoginDetails(email.getText().toString(), pass.getText().toString());
                startHomeActivity();
            }
        });
    }
    private void startHomeActivity() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
    }
    private void saveLoginDetails(String email, String password) {
        Toast.makeText(this,"pref",Toast.LENGTH_LONG);
        new PrefManager(this).saveLoginDetails(email, password);
    }
}