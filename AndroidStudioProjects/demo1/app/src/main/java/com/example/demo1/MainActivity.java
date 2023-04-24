package com.example.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.QuickContactBadge;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button login,date,time;
    SeekBar s1;
    TextView age,email,password,date_pi;

    DatePickerDialog datePickerDialog;
    TimePickerDialog timePickerDialog;
    int minute,hour;
    int day1,month,year;
    Calendar calendar1;

    ListView listView;
    Spinner spinner;
    String city[]={"Ahemdabad","surat","mehsana","Ahemdabad","surat","mehsana","Ahemdabad","surat","mehsana"};
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login =findViewById(R.id.login_id);
        s1=findViewById(R.id.seekbar_id);
        age=findViewById(R.id.age_id);
        email =findViewById(R.id.g_email_id);
        password=findViewById(R.id.g_password_id);

        date = findViewById(R.id.datepicker_id);
        calendar1 = Calendar.getInstance();

        date_pi = findViewById(R.id.show_date);

        listView = findViewById(R.id.listv_id);
        listView.setAdapter(arrayAdapter);

        arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,city);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String cityname = city[i];
                Toast.makeText(MainActivity.this, cityname, Toast.LENGTH_SHORT).show();
            }
        });
        spinner = findViewById(R.id.spi_id);
        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String cityname = city[i];
                Toast.makeText(MainActivity.this,cityname, Toast.LENGTH_SHORT).show();
            }
        });





        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                day1 = calendar1.get(Calendar.DAY_OF_MONTH);
                month = calendar1.get(Calendar.MONTH);
                year = calendar1.get(Calendar.YEAR);

                datePickerDialog =new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {


                        date_pi.setText(String.valueOf(i)+"/"+String.valueOf(i1)+"/"+String.valueOf(i2));
                        Toast.makeText(MainActivity.this, String.valueOf(i)+"/"+String.valueOf(i1)+"/"+String.valueOf(i2), Toast.LENGTH_SHORT).show();
                    }
                },day1,month,year);
                datePickerDialog.show();
            }
        });
        time = findViewById(R.id.timepicker_id);
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        Toast.makeText(MainActivity.this, String.valueOf(i)+" : "+String.valueOf(i1), Toast.LENGTH_SHORT).show();
                    }
                },hour,minute,true);
                timePickerDialog.show();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String E=email.getText().toString();
                String P=password.getText().toString();



                Intent i= new Intent(MainActivity.this,MainActivity2.class);
                i.putExtra("el",E);
                i.putExtra("p1",P);

                startActivity(i);



            }
        });

        s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                age.setText("age:"+String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}