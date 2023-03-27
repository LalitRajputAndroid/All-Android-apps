package com.example.flipkart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.flipkart.Fragments.Categories;
import com.example.flipkart.Fragments.Home;
import com.example.flipkart.Fragments.Notification;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView navigationView;
    Toolbar toolbar;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.btnflip_id);
        navigationView = findViewById(R.id.bottomnavigation_id);
        frameLayout = findViewById(R.id.framelayout_id);

        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id, new Home()).commit();


        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;

                switch (item.getItemId()) {

                    case R.id.home_id:
                        fragment = new Home();
                        break;
                    case R.id.categories_id:
                        fragment = new Categories();
                        break;
                    case R.id.notification_id:
                        fragment = new Notification();
                        break;
                    case R.id.account_id:
                        fragment = new Notification();
                        break;
                    case R.id.cart_id:
                        fragment = new Cart();
                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id, fragment).commit();
                return true;
            }
        });

    }
}