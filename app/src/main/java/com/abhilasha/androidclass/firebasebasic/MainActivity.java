package com.abhilasha.androidclass.firebasebasic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText mail, pass;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mail = findViewById(R.id.email);
        pass = findViewById(R.id.pass);

        firebaseAuth = FirebaseAuth.getInstance();


    }

    public void Onclick(View view) {

        String email = mail.getText().toString().trim();
        String password = pass.getText().toString().trim();

        // Toast.makeText(this, "Email:"+email+"\n"+"Password:"+password, Toast.LENGTH_SHORT).show();

        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                }

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this, "Registration failed"+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });




    }

    public void LoginFirebase(View view) {

        startActivity(new Intent(MainActivity.this,LoginActivity.class));
    }
}
