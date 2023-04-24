package com.example.signal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

public class otpenter extends AppCompatActivity {
    MaterialTextView code_textView,number_textview;
    MaterialButton ok_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpenter);

        code_textView = findViewById(R.id.code_text);
        String number = getIntent().getStringExtra("number");

        number_textview = findViewById(R.id.numbertext_id);
        number_textview.setText(number);

        ok_btn = findViewById(R.id.ok_btn);
        ok_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(otpenter.this,set_profile.class);
                startActivity(intent);
            }
        });
    }
}