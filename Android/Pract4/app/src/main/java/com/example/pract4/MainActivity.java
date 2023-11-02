package com.example.pract4;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    EditText nameEdit, rollEdit, emailEdit, courseEdit; Button addButton, viewButton,updateButton, deleteButton; String name, rollno, email, course;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=new DatabaseHelper(MainActivity.this);
        addButton=(Button)findViewById(R.id.addButton);
        viewButton= (Button) findViewById(R.id.viewButton);
        updateButton=(Button) findViewById(R.id.updateButton);
        deleteButton=(Button) findViewById(R.id.deleteButton);
        nameEdit = (EditText) findViewById(R.id.editName);
        rollEdit = (EditText) findViewById(R.id.editRoll);
        emailEdit = (EditText) findViewById(R.id.editClass);
        courseEdit = (EditText) findViewById(R.id.editDiv);
        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this,MainActivity2.class);
                startActivity(i);
            }
        });
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = nameEdit.getText().toString();
                rollno = rollEdit.getText().toString();
                email = emailEdit.getText().toString();
                course = courseEdit.getText().toString();
                if(name.isEmpty() || rollno.isEmpty() || email.isEmpty() || course.isEmpty()){ Toast.makeText(MainActivity.this,"Please enter all details",Toast.LENGTH_SHORT).show();
                }else{
                    name = nameEdit.getText().toString();
                    rollno = rollEdit.getText().toString();
                    email = emailEdit.getText().toString();
                    course = courseEdit.getText().toString();
                    String[] data= new String[4];
                    data[0]=name;
                    data[1]= rollno;
                    data[2]= email;
                    data[3]=course;
                    if(db.insertData(data)){
                        Toast.makeText(MainActivity.this,"Details inserted successfully",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(MainActivity.this,"Failed to insert details",Toast.LENGTH_SHORT).show();
                    }
                    nameEdit.setText("");
                    rollEdit.setText("");
                    emailEdit.setText("");
                    courseEdit.setText("");
                }
            }
        });
        updateButton.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View v) {
            name = nameEdit.getText().toString();
            rollno = rollEdit.getText().toString();
            email = emailEdit.getText().toString();
            course = courseEdit.getText().toString();
            if(name.isEmpty() || rollno.isEmpty() ){
                nameEdit.setError("Enter updated name");
                rollEdit.setError("Enter your roll no");
                nameEdit.requestFocus();
                rollEdit.requestFocus();
            }else {
                name = nameEdit.getText().toString();
                rollno = rollEdit.getText().toString();
                email = emailEdit.getText().toString();
                course = courseEdit.getText().toString();
                if(db.updateData(Integer.parseInt(rollno),name)){
                    Toast.makeText(MainActivity.this,"Details updated successfully",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"Failed to update details",Toast.LENGTH_SHORT).show();
                }
            }
        }
        });
        deleteButton.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View v) {
            rollno = rollEdit.getText().toString();
            if(rollno.isEmpty()){
                rollEdit.setError("Enter roll no.");
                rollEdit.requestFocus();
            }else{
                rollno = rollEdit.getText().toString();
                if(db.deleteData(Integer.parseInt(rollno))){
                    Toast.makeText(MainActivity.this,"Details deleted successfully",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"Failed to delete details",Toast.LENGTH_SHORT).show();
                }
                rollEdit.setText("");
            }
        }
        });
    }
}
