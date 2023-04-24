package com.example.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    Button back;
    TextView Em,pas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//        back= findViewById(R.id.buttonback);
//        back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(MainActivity2.this,MainActivity.class));
//            }
//        });

        Em=findViewById(R.id.v_email_id);
        pas=findViewById(R.id.v_password_id);
        String gmail=getIntent().getStringExtra("el");
        String password1=getIntent().getStringExtra("p1");

        Em.setText(gmail);
        pas.setText(password1);



    }
}