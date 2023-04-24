package com.example.olbuz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;

import com.example.olbuz.databinding.ActivityMainBinding;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        changelanguages();

    }

    private void changelanguages() {

        binding.btnId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String languages[] = {"English","Hindi","Gujarati"};
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Choose Language");
                builder.setSingleChoiceItems(languages, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        if (i==0){
                            setlocale("");
                            recreate();

                        } else if (i==1) {
                            setlocale("hi");
                            recreate();

                        } else if (i==2) {
                            setlocale("gu");
                            recreate();
                        }
                    }
                });
                builder.create();
                builder.show();
            }
        });
    }

    public void setlocale(String languages){

        Locale locale = new Locale(languages);
        Locale.setDefault(locale);

        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getBaseContext().getResources().updateConfiguration(configuration,getBaseContext().getResources()
                .getDisplayMetrics());

    }

}