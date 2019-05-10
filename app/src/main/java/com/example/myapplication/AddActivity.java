package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AddActivity extends AppCompatActivity implements View.OnClickListener {
   private EditText edName, edId, edPhone;
    private Button btnAdd, btnCancel;
    DataEmployee dataEmployee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        edName = findViewById(R.id.ed_name);
        edId = findViewById(R.id.ed_id);
        edPhone = findViewById(R.id.ed_phone);
        btnAdd = findViewById(R.id.btn_add);
        btnCancel = findViewById(R.id.btn_cancel);
        btnAdd.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

        dataEmployee = new DataEmployee();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_add) {
            String id = edId.getText().toString();
            String name = edName.getText().toString();
            String phone = edPhone.getText().toString();
            Employee employee = new Employee(id, name, phone);

            dataEmployee.Insert(employee);
            if (id.isEmpty() || name.isEmpty()  || phone.isEmpty() ) {
                Toast.makeText(this, "PLEASE INPUT ALL EDIT TEXT", Toast.LENGTH_SHORT).show();
            } else {
                Intent mainIntent = new Intent(AddActivity.this, MainActivity.class);
                startActivity(mainIntent);
            }
        }
        if (v.getId() == R.id.btn_cancel) {
            Intent maincancel = new Intent(AddActivity.this, MainActivity.class);
            startActivity(maincancel);
        }
   }
}
