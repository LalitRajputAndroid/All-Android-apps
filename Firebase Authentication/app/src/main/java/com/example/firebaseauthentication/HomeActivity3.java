package com.example.firebaseauthentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity3 extends AppCompatActivity {

    Button logoutbtn;
    FirebaseAuth auth ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home3);

        logoutbtn  = findViewById(R.id.logout_btnid);
        auth = FirebaseAuth.getInstance();

        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                auth.signOut();

                SharedPreferences preferences = getSharedPreferences("userdata",MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("open",false);
                editor.apply();

                startActivity(new Intent(HomeActivity3.this,MainActivity2.class));
                finish();
            }
        });

    }
}