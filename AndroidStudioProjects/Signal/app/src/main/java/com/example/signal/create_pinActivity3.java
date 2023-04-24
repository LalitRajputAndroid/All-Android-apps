package com.example.signal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class create_pinActivity3 extends AppCompatActivity {

    TextInputEditText editText_pin;
    MaterialButton setpin_nextBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_pin3);
        editText_pin = findViewById(R.id.textinputpin_ed);
        setpin_nextBtn =findViewById(R.id.pincreate_nextbtn);

    }
}