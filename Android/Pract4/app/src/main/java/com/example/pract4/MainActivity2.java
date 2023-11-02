package com.example.pract4;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
public class MainActivity2 extends AppCompatActivity {
    DatabaseHelper db;
    TextView show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        db=new DatabaseHelper(MainActivity2.this);
        show=(TextView) findViewById(R.id.textView2);
        Cursor c= db.showData();
        String data="";
        while(c.moveToNext()){
            data+="Name: "+c.getString(0)+"\n"+"Roll No: "+c.getInt(1)+"\n"+"EmailId: "+c.getString(2)+"\n"+"Course: "+c.getString(3);
            data+="\n\n";

        }
        show.setText(data);
    }
}
