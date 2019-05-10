package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvId;
    private EditText edName,edPhone;
    private Button btnEdit, btnCancel;
    DataEmployee dataEmployee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        tvId=findViewById(R.id.tv_id);
        edName=findViewById(R.id.ed_edname);
        edPhone=findViewById(R.id.ed_edphone);
        btnEdit=findViewById(R.id.btn_update);
        btnCancel=findViewById(R.id.btn_canceladd);

        Employee employee= (Employee) getIntent().getSerializableExtra("data");
        tvId.setText(employee.getId());
        edName.setText(employee.getName());
        edPhone.setText(employee.getPhone());
        btnEdit.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
        dataEmployee=new DataEmployee();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_update) {
            String id = tvId.getText().toString();
            String name = edName.getText().toString();
            String phone = edPhone.getText().toString();
            Employee employee = new Employee(id, name, phone);

            dataEmployee.Update(employee);
            if (name.isEmpty()  || phone.isEmpty() ) {
                Toast.makeText(this, "PLEASE INPUT ALL EDIT TEXT", Toast.LENGTH_SHORT).show();
            } else {
                Intent mainIntent = new Intent(EditActivity.this, MainActivity.class);
                startActivity(mainIntent);
            }
        }
        if (v.getId() == R.id.btn_canceladd) {
            Intent maincancel = new Intent(EditActivity.this, MainActivity.class);
            startActivity(maincancel);
        }

    }
}
