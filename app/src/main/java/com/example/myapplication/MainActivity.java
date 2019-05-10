package com.example.myapplication;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;

import android.widget.Toast;

import android.support.design.widget.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    LinearLayoutManager layoutManager;
    RecyclerView rvDetail;
    AdapterPeople adapterPeople;
    DataEmployee dataEmployee;
    ArrayList<Employee> list;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataEmployee = new DataEmployee();
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvDetail = findViewById(R.id.recycler_detail);
        fab = findViewById(R.id.fab);

        rvDetail.setLayoutManager(layoutManager);
        adapterPeople = new AdapterPeople(this);
        list = dataEmployee.getList();
        rvDetail.setAdapter(adapterPeople);
        adapterPeople.setEmployee(list);


        fab.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Choose your option");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case 100:
                Toast.makeText(this, "Begin edit  ", Toast.LENGTH_SHORT).show();
                Intent sendData = new Intent(MainActivity.this, EditActivity.class);
                String id = list.get(item.getGroupId()).getId();
                String name = list.get(item.getGroupId()).getName();
                String phone = list.get(item.getGroupId()).getPhone();
                Employee e = new Employee(id, name, phone);
                sendData.putExtra("data", e);
                startActivity(sendData);
                return true;
            case 101:
                Toast.makeText(this, "Delete successfull " + list.get(item.getGroupId()).getName(), Toast.LENGTH_SHORT).show();
                dataEmployee.Delete(list.get(item.getGroupId()).getId());
                adapterPeople.delete(item.getGroupId());
                return true;

            default:
                return super.onContextItemSelected(item);


        }
    }

}
