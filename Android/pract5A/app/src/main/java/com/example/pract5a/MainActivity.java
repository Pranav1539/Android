package com.example.pract5a;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;

import java.io.FileReader;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText edit = findViewById(R.id.dir_name);
        EditText edit2 = findViewById(R.id.file_name);
        EditText edit3 = findViewById(R.id.content_name);
        Button button = findViewById(R.id.read);
        Button button2 = findViewById(R.id.write);
        Button button3 = findViewById(R.id.delete);
        TextView output = findViewById(R.id.readContent);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    StringBuilder result = new StringBuilder();
                    String line;
                    String folder = getApplication().getFilesDir().getAbsolutePath() + File.separator + edit.getText().toString();

                    File subFolder = new File(folder);
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(folder, edit2.getText().toString())));

                    while ((line = bufferedReader.readLine()) != null) {
                        result.append(line);
                    }
                    output.setText(result.toString());
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    String folder = getApplication().getFilesDir().getAbsolutePath() + File.separator + edit.getText().toString();

                    File subFolder = new File(folder);
                    if (!subFolder.exists()) {
                        subFolder.mkdirs();
                    }
                    FileOutputStream outputStream = new FileOutputStream(new File(subFolder, edit2.getText().toString()));

                    outputStream.write(edit3.getText().toString().getBytes());
                    outputStream.close();
                    Toast.makeText(getApplicationContext(), "Writing Successful", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String folder = getApplication().getFilesDir().getAbsolutePath() + File.separator + edit.getText().toString();

                    File subFolder = new File(folder);
                    File file = new File(folder, edit2.getText().toString());
                    if (file.exists()) {
                        file.delete();
                    }
                    Toast.makeText(getApplicationContext(), "Deletion Successful", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }

        });
    }
}