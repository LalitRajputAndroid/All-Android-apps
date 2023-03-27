package com.example.textermessenger;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Random;

public class phone_NActivity2 extends AppCompatActivity {

    Spinner spinner;
    ArrayAdapter arrayAdapter;
    MaterialButton continue_btn;
    TextInputEditText editText;
    String contry[] = {
            "India", "Australia", "Austria", "Belize", "Benin", "Canada", "Burundi", "Cape Verde", "Chad", "China", "Chile", "Cocos", "Congo",
            "Colombia", "Comoros", "France", "Greenland", "Hong Kong", "Iceland", "Iran", "Japan", "Kuwait", "Malaysia", "Maldives", "Maxico", "Nepal", "New Zealand",
            "North Korea", "Norway", "Pakistan", "Oman", "Russia", "Saudi Arabia", "South Africa", "South Korea", "Spain", "Sudan", "Syria", "TAiwan", "Togo", "Turkey",
            "United States", "Zambia", "Yeman", "Zimbabwe"
    };

    private static final String channal_id = "my channel";
    private static final int Notification_id = 100;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_nactivity2);

        spinner = findViewById(R.id.spinner_id);

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,contry);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String c_name = contry[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        continue_btn = findViewById(R.id.continuebtn_id);
        editText = findViewById(R.id.phoneN_id);


        String ot = String.valueOf(otpgen(6));

        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.img, null);

        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;

        Bitmap large_icon = bitmapDrawable.getBitmap();

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Notification notification;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            notification = new Notification.Builder(this)
                    .setLargeIcon(large_icon)
                    .setSmallIcon(R.drawable.img)
                    .setSubText("OTP for your Signal account.")
                    .setContentText(ot+" is your texter varification code.")
                    .setChannelId(channal_id)
                    .build();

            nm.createNotificationChannel(new NotificationChannel(channal_id, "new chennal", NotificationManager.IMPORTANCE_HIGH));
        } else {

            notification = new Notification.Builder(this)
                    .setLargeIcon(large_icon)
                    .setSmallIcon(R.drawable.img)
                    .setSubText("OTP for your Signal account.")
                    .setContentText(ot)
                    .build();
        }


        continue_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String PN = editText.getText().toString();

                if (PN.isEmpty()) {
                    Toast.makeText(phone_NActivity2.this, "Please Enter a number", Toast.LENGTH_SHORT).show();
                } else {
                    AlertDialog.Builder alertbtn = new AlertDialog.Builder(phone_NActivity2.this);
                    alertbtn.setTitle(PN);

                    alertbtn.setMessage("Is your phone number above correct ?");

                    Intent intent = new Intent(phone_NActivity2.this, entercode_Activity2.class);

                    alertbtn.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            nm.notify(Notification_id, notification);
                            intent.putExtra("phone_N", PN);
                            intent.putExtra("OTP",ot);
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