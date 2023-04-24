package com.example.signal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.button.MaterialButton;

public class set_profile extends AppCompatActivity {

    MaterialButton nextsetprofile_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_profile);

        nextsetprofile_btn = findViewById(R.id.setprofile_nextbtn);
        nextsetprofile_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(set_profile.this,create_pinActivity3.class);
                startActivity(intent);
            }
        });
    }
}