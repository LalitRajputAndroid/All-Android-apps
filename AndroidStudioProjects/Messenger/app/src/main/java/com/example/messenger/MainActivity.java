package com.example.messenger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button log_in;
    TextView create_acc;
    EditText login_email,login_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login_email = findViewById(R.id.email_id);
        login_password = findViewById(R.id.password_id);

        log_in = findViewById(R.id.login_button);

        create_acc = findViewById(R.id.create_accID);
        create_acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,sign_up_Activity2.class));
            }
        });


        log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = getIntent().getStringExtra("email");
                String password = getIntent().getStringExtra("password");

                String em=login_email.getText().toString();
                String pas=login_password.getText().toString();

                if (em.equals(email)&& pas.equals(password))
                {
                    startActivity(new Intent(MainActivity.this,MainActivity2_chat.class));
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Wrong Email and Password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}