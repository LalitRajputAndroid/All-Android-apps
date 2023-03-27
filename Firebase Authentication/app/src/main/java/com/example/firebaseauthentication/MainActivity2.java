package com.example.firebaseauthentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity2 extends AppCompatActivity {

    TextInputEditText email,password;
    Button loginbtn;
    TextView signuptext,resetpassword;
    FirebaseAuth auth ;
    ProgressDialog progressDialog ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        email = findViewById(R.id.email_login_id);
        password = findViewById(R.id.password_login_id);
        loginbtn = findViewById(R.id.login_btnid);
        signuptext = findViewById(R.id.signuptext_id);
        resetpassword = findViewById(R.id.resetpsswordtext);

        auth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Login your Account");

        signuptext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity2.this,MainActivity.class));
            }
        });

        resetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String E = email.getText().toString();

                if (E.isEmpty()){
                    Toast.makeText(MainActivity2.this, "Enter Email ", Toast.LENGTH_SHORT).show();
                }else {
                    auth.sendPasswordResetEmail(E).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {

                            Toast.makeText(MainActivity2.this, "email send", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Email = email.getText().toString();
                String Pass = password.getText().toString();

                if (Email.isEmpty() || Pass.isEmpty()){

                    Toast.makeText(MainActivity2.this, "Fill the Field", Toast.LENGTH_SHORT).show();
                }else {
                    progressDialog.show();
                    auth.signInWithEmailAndPassword(Email,Pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()){
                                progressDialog.dismiss();
                                Toast.makeText(MainActivity2.this, "Login Success", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(MainActivity2.this,HomeActivity3.class));

                                SharedPreferences preferences = getSharedPreferences("userdata",MODE_PRIVATE);
                                SharedPreferences.Editor editor = preferences.edit();
                                editor.putBoolean("open",true);
                                editor.apply();

                                email.setText("");
                                password.setText("");
                                finish();
                            }
                        }
                    });
                }
            }
        });
    }
}