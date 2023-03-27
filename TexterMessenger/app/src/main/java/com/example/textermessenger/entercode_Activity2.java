package com.example.textermessenger;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;

public class entercode_Activity2 extends AppCompatActivity {

    MaterialTextView  textView;
    TextInputEditText editText;
    MaterialButton register_btn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entercode2);

        textView = findViewById(R.id.gettext_id);
        register_btn = findViewById(R.id.R_btn);
        editText=findViewById(R.id.otp_cid);

        String number = getIntent().getStringExtra("phone_N");

        String otp= getIntent().getStringExtra("OTP");

        textView.setText(number);

        Intent intent = new Intent(entercode_Activity2.this,profilesetup_Activity4.class);
       register_btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               String cotp=editText.getText().toString();
               if (otp.equals(cotp))
               {
                   startActivity(intent);
               }
               else
               {
                   Toast.makeText(entercode_Activity2.this, "please enter valid OTP.", Toast.LENGTH_SHORT).show();
               }
           }
       });
    }
}