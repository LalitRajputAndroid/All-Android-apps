package com.example.aapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.AndroidException;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    Spinner spinner;
    String city[] = {"Ahemdabad","Surat","Mehsana","Varodara","Ghandhinagar","Ahemdabad","Surat","Mehsana","Varodara","Ghandhinagar","Ahemdabad","Surat","Mehsana","Varodara","Ghandhinagar","Ahemdabad","Surat","Mehsana","Varodara","Ghandhinagar"};
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview_id);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, city);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String cityname = city[i];
                Toast.makeText(MainActivity.this, cityname, Toast.LENGTH_SHORT).show();
            }
        });

        spinner =findViewById(R.id.spinner_id);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String cityname2= city[i];
                Toast.makeText(MainActivity.this,cityname2, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}