package com.example.textermessenger;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class HomeActivity5 extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tabLayout;
    TabItem chats,stores,calls;
    ViewPager viewPager;
    PageAdapter pageAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home5);

        toolbar =findViewById(R.id.toolbar_id);
        setSupportActionBar(toolbar);

        tabLayout = findViewById(R.id.tablayout_id);
        chats = findViewById(R.id.chats_tab_id);
        stores = findViewById(R.id.stories_tab_id);
        calls = findViewById(R.id.calls_tab_id);
        viewPager = findViewById(R.id.viewpager_id);


        getSupportFragmentManager().beginTransaction().replace(R.id.viewpager_id,new chats()).commit();

        pageAdapter = new PageAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition()==0 || tab.getPosition()==1 || tab.getPosition()==2){

                    pageAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.menu_item,menu);
        return super.onCreateOptionsMenu(menu);
}
}