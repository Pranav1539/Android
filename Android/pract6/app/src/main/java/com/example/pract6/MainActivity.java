package com.example.pract6;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView im = findViewById(R.id.imageView);
        Button mvbtn = findViewById(R.id.btn1);
        Button robtn = findViewById(R.id.btn2);
        Button zobtn = findViewById(R.id.btn3);
        mvbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// To add move animation
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
                im.startAnimation(animation);
            }
        });
        robtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// To add rotate animation
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
                im.startAnimation(animation);
            }
        });
        zobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// To add zoom animation
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom);
                im.startAnimation(animation);
            }
        });}}