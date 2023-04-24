 package com.example.navigation_drawerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

 public class MainActivity extends AppCompatActivity {


    ActionBarDrawerToggle toggle;
    NavigationView view;
    DrawerLayout drawerLayout;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar_id);
        setSupportActionBar(toolbar);

        view = findViewById(R.id.navigation_view_id);
        drawerLayout = findViewById(R.id.drawerlayout_id);

        drawerLayout.setDrawerListener(toggle);
        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        toggle.syncState();

        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id ,new home()).commit();
        view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = null;
                switch (item.getItemId())
                {
                    case  R.id.home_id:
                        fragment = new home();
                        break;
                    case R.id.setting_id:
                        fragment = new setting();
                        break;
                    case R.id.login_id:
                        fragment =new longin();
                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id,fragment).commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                return  true;

            }
        });
    }
}