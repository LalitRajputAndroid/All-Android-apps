package com.example.messenger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class sign_up_Activity2 extends AppCompatActivity {
    EditText email,password,conform_pass,name;
    Button sign_up;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);

        email = findViewById(R.id.signup_email);
        password = findViewById(R.id.sigup_password);
        sign_up = findViewById(R.id.signup_button);
        conform_pass = findViewById(R.id.sigup_conformpassword);
        name = findViewById(R.id.fullname_id);

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String N = name.getText().toString();
                String E = email.getText().toString();
                String P = password.getText().toString();
                String cp = conform_pass.getText().toString();


                Intent intent = new Intent(sign_up_Activity2.this,MainActivity.class);

                if(N.isEmpty() || E.isEmpty() || P.isEmpty() || cp.isEmpty())
                {
                    Toast.makeText(sign_up_Activity2.this, "Feil full detail", Toast.LENGTH_SHORT).show();
                }
                else if (P.equals(cp))
                {
                    Toast.makeText(sign_up_Activity2.this, "Succes", Toast.LENGTH_SHORT).show();
                    intent.putExtra("email",E);
                    intent.putExtra("password",P);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(sign_up_Activity2.this, "Confrm password not macth", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}