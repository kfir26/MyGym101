package com.example.mygym101;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    EditText etUserName;
    EditText etEmail;
    EditText etPassword;
    Button btnLogin;
    Button btnRegister;
    ProgressDialog progressDialog;

    OnSuccessListener<AuthResult> mSuccessListener = new OnSuccessListener<AuthResult>() {
        @Override
        public void onSuccess(AuthResult authResult) {
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }

            //goto Main Activity
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }
    };
    OnFailureListener mFailureListener = new OnFailureListener() {
        @Override
        public void onFailure(@NonNull Exception e) {
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }

            showError(e);
        }
    };
    private void showError(Exception e) {
        new AlertDialog.Builder(this).
                setTitle("An Error Occurred").
                setMessage(e.getLocalizedMessage()).
                setPositiveButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        etUserName = findViewById(R.id.et_username);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.button_login);
        btnRegister = findViewById(R.id.button_register);

        btnLogin.setOnClickListener(v -> login());
        btnRegister.setOnClickListener(v -> register());

    }

    private void register() {
        String email = getEmail();
        String password = getPassword();

        //don't continue if the details are not valid:
        if (email == null || password == null) {
            return;
        }

        showProgress();
        //register-> addOnSuccess -> addOnFailure
        FirebaseAuth.getInstance().
                createUserWithEmailAndPassword(email, password).
                addOnSuccessListener(mSuccessListener).
                addOnFailureListener(mFailureListener);

    }

    private void login() {
        String email = getEmail();
        String password = getPassword();

        //don't continue if the details are not valid:
        if (email == null || password == null) {
            return;
        }

        showProgress();
        //register-> addOnSuccess -> addOnFailure
        FirebaseAuth.getInstance().
                signInWithEmailAndPassword(email, password).
                addOnSuccessListener(mSuccessListener).
                addOnFailureListener(mFailureListener);
    }

    //returns null if the email is not valid
    private String getEmail() {
        String email = etEmail.getText().toString();

        Pattern emailAddressRegex = Patterns.EMAIL_ADDRESS;
        boolean isEmailValid = emailAddressRegex.matcher(email).matches();

        if (!isEmailValid) {
            etEmail.setError("Invalid email address");
            return null;
        }

        return email;
    }

    //returns null if the password is not valid
    private String getPassword() {
        String pass = etPassword.getText().toString();

        if (pass.length() < 6) {
            etPassword.setError("Password must contain at least 6 characters");
            return null;
        }
        return pass;
    }

    private void showProgress() {
        //before use if it's null -> init
        //lazy-variable: (lazy-loading design-pattern)
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Logging you in");
            progressDialog.setMessage("Please wait...");
        }

        progressDialog.show();
    }
}
