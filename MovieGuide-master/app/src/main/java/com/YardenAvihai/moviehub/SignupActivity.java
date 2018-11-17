package com.YardenAvihai.moviehub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.YardenAvihai.moviehub.listing.MoviesListingActivity;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    EditText emailText;
    EditText passwordText;
    EditText confirmPasswordText;
    TextView loginLink;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        firebaseAuth = FirebaseAuth.getInstance();
        emailText =  findViewById(R.id.input_email2);
        passwordText = findViewById(R.id.input_password2);
        confirmPasswordText =  findViewById(R.id.confirm_password);
        loginLink =  findViewById(R.id.link_login);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    public void register_click(View view) {
        if(!validate()){
            return;
        }
       String email = emailText.getText().toString();
       String password = passwordText.getText().toString();
        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(task -> {

            if(!task.isSuccessful()){

                Toast.makeText(SignupActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();

            }
            if(task.isSuccessful()){
               Intent intent = new Intent(getApplicationContext(), MoviesListingActivity.class);
               startActivity(intent);
            }

        });
    }

    private boolean validate() {
        boolean valid = true;
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();
        String confirmPassword = confirmPasswordText.getText().toString();
        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailText.setError("Enter a valid email address");
            valid = false;
        } else {
            emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            passwordText.setError("Between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            passwordText.setError(null);
        }

        if (!password.equals(confirmPassword)) {
            confirmPasswordText.setError("Confirmation failed");
            valid = false;
        } else {
            confirmPasswordText.setError(null);
        }
        return valid;
    }

    public void loginLinkClick(View view) {
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
    }
}
