package com.example.signal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    Button next;
    TextInputEditText number_editText;
    Spinner spinner;
    ArrayAdapter arrayAdapter;

    private static final String channal_id = "my channel";
    private static final int Notification_id = 100;

    String contry[] = {
            "India", "Australia", "Austria", "Belize", "Benin", "Canada", "Burundi", "Cape Verde", "Chad", "China", "Chile", "Cocos", "Congo",
            "Colombia", "Comoros", "France", "Greenland", "Hong Kong", "Iceland", "Iran", "Japan", "Kuwait", "Malaysia", "Maldives", "Maxico", "Nepal", "New Zealand",
            "North Korea", "Norway", "Pakistan", "Oman", "Russia", "Saudi Arabia", "South Africa", "South Korea", "Spain", "Sudan", "Syria", "TAiwan", "Togo", "Turkey",
            "United States", "Zambia", "Yeman", "Zimbabwe"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String ot = String.valueOf(otpgen(6));

        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.notification, null);

        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;

        Bitmap large_icon = bitmapDrawable.getBitmap();

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Notification notification;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            notification = new Notification.Builder(this)
                    .setLargeIcon(large_icon)
                    .setSmallIcon(R.drawable.notifications_icon)
                    .setSubText("OTP for your Signal account.")
                    .setContentText(ot)
                    .setChannelId(channal_id)
                    .build();

            nm.createNotificationChannel(new NotificationChannel(channal_id, "new chennal", NotificationManager.IMPORTANCE_HIGH));
        } else {

            notification = new Notification.Builder(this)
                    .setLargeIcon(large_icon)
                    .setSmallIcon(R.drawable.notifications_icon)
                    .setSubText("OTP for your Signal account.")
                    .setContentText(ot)
                    .build();
        }


        spinner = findViewById(R.id.spinner_id);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, contry);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String contry_name = contry[i];
                Toast.makeText(MainActivity2.this, contry_name, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        number_editText = findViewById(R.id.edittext_id);
        next = findViewById(R.id.nextbtn_id);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Ed = number_editText.getText().toString();

                if (Ed.isEmpty()) {
                    Toast.makeText(MainActivity2.this, "Please Enter a number", Toast.LENGTH_SHORT).show();
                } else {
                    AlertDialog.Builder alertbtn = new AlertDialog.Builder(MainActivity2.this);
                    alertbtn.setTitle(Ed);
                    alertbtn.setMessage("Is your phone number above correct ?");

                    Intent intent = new Intent(MainActivity2.this, otpenter.class);

                    alertbtn.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            nm.notify(Notification_id, notification);
                            intent.putExtra("number", Ed);
                            startActivity(intent);
                        }
                    });

                    alertbtn.setNegativeButton("Edit number", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    alertbtn.create();
                    alertbtn.show();
                }
            }
        });
    }
    private static char[] otpgen(int length){
        String number = "1234567890";
        Random random = new Random();
        char[] otp = new char[length];

        for (int i=0;i<length;i++)
        {
            otp[i] = number.charAt(random.nextInt(number.length()));
        }
        return otp;
    }
}
