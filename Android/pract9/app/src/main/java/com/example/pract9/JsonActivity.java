package com.example.pract9;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import org.json.JSONException;
import org.json.JSONObject;
public class JsonActivity extends AppCompatActivity {

    String JSON_STRING = "{\"employee\":{\"name\":\"PRANAV DESHMUKH\",\"salary\":40000}}";
    String name, salary;
    TextView employeeName, employeeSalary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
        employeeName = (TextView) findViewById(R.id.name);
        employeeSalary = (TextView) findViewById(R.id.salary);
        try {
            JSONObject obj = new JSONObject(JSON_STRING);
            JSONObject employee = obj.getJSONObject("employee");
            name = employee.getString("name");
            salary = employee.getString("salary");
            employeeName.setText("Name: "+name);
            employeeSalary.setText("Salary: "+salary);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}