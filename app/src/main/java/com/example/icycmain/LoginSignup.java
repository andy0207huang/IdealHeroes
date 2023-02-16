package com.example.icycmain;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class LoginSignup extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth mAuth;
    EditText editTextUsername, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_signup);

        editTextUsername = (EditText) findViewById((R.id.editTextUsername));
        editTextPassword = (EditText) findViewById((R.id.editTextPassword));

        mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.buttonSignup).setOnClickListener(this);
        findViewById(R.id.textViewLogin).setOnClickListener(this);
    }

    private void registerUser() {
        String email = editTextUsername.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if(email.isEmpty()) {
            editTextUsername.setError("Email is required");
            editTextUsername.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextUsername.setError("Please enter a valid email");
            editTextUsername.requestFocus();
            return;
        }

        if(password.isEmpty()) {
            editTextPassword.setError("Password is required");
            editTextPassword.requestFocus();
            return;
        }
        if(password.length()<6) {
            editTextPassword.setError("Minimum length of password should be 6 characters");
            editTextPassword.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    finish();

                    Toast.makeText(getApplicationContext(),"User Registration Successful",Toast.LENGTH_SHORT).show();
                    Intent intent3 = new Intent(LoginSignup.this, LoginMain.class);
                    startActivity(intent3);
                    //intent3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent3);
                }
                else {
                    if(task.getException() instanceof FirebaseAuthUserCollisionException) {
                        Toast.makeText(getApplicationContext(),"This email has already been registered", Toast.LENGTH_SHORT).show();;
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Error occurred", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });




    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.buttonSignup:
                registerUser();
                break;

            case R.id.textViewLogin:
                startActivity(new Intent(this, LoginMain.class));
                finish();
                break;
        }
    }
}
