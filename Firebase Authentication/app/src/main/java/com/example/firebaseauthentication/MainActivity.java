package com.example.firebaseauthentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    TextInputEditText nameEd, emailEd, passEd;
    Button signupbtn;
    TextView logintext;
    FirebaseAuth auth;
    DatabaseReference reference;
    ProgressDialog dialog;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences("userdata", MODE_PRIVATE);
        boolean check = preferences.getBoolean("open", false);

        if (check) {
            startActivity(new Intent(MainActivity.this, HomeActivity3.class));
        }

        nameEd = findViewById(R.id.name_signup_id);
        emailEd = findViewById(R.id.email_signup_id);
        passEd = findViewById(R.id.password_signupid);
        signupbtn = findViewById(R.id.signup_btnid);
        logintext = findViewById(R.id.logintext_id);

        auth = FirebaseAuth.getInstance();
        reference = FirebaseDatabase.getInstance().getReference();

        dialog = new ProgressDialog(this);
        dialog.setMessage("Creating your Account");

        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
                checkAuth();
            }
        });

        logintext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MainActivity2.class));
            }
        });

    }

    private void checkAuth() {

        String Name = nameEd.getText().toString();
        String Email = emailEd.getText().toString();
        String Password = passEd.getText().toString();

        if (Name.isEmpty() || Email.isEmpty() || Password.isEmpty()) {

            Toast.makeText(this, "fill the field", Toast.LENGTH_SHORT).show();
        } else {

            auth.fetchSignInMethodsForEmail(Email).addOnCompleteListener(new OnCompleteListener<SignInMethodQueryResult>() {
                @Override
                public void onComplete(@NonNull Task<SignInMethodQueryResult> task) {
                    boolean check = task.getResult().getSignInMethods().isEmpty();

                    if (check) {

                        auth.createUserWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    dialog.dismiss();
                                    String uid = auth.getUid();
                                    UserModal modal = new UserModal(Name, Email, Password, uid);
                                    reference.child("Users").child(uid).setValue(modal);

                                    Toast.makeText(MainActivity.this, "Signup Success", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(MainActivity.this, MainActivity2.class));
                                    nameEd.setText("");
                                    emailEd.setText("");
                                    passEd.setText("");
                                    finish();
                                } else {
                                    dialog.dismiss();
                                    Toast.makeText(MainActivity.this, "task failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                dialog.dismiss();
                                Toast.makeText(MainActivity.this, "Error" + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });

                    } else {
                        dialog.dismiss();
                        Toast.makeText(MainActivity.this, "Email already exsist", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}