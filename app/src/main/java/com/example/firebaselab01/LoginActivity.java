package com.example.firebaselab01;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import org.jetbrains.annotations.NotNull;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    private static int GOOGLE_SIGN_IN_CODE = 1;


    private TextInputEditText edEmail;
    private TextInputEditText edPassword;
    // TODO:1 Declare variable
//    private FirebaseAuth firebaseAuth;
//    private FirebaseAuth.AuthStateListener mAuthListener;

//    TODO (7.0) init googleAuth provider
//    private GoogleSignInClient signInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initInstance();
    }

    private void initInstance() {
        edEmail = (TextInputEditText) findViewById(R.id.ed_email);
        edPassword = (TextInputEditText) findViewById(R.id.ed_password);

        // TODO(2) GetInstance FirebaseAuth & [getCurrentUser]
//        firebaseAuth = FirebaseAuth.getInstance();
//        mAuthListener = new FirebaseAuth.AuthStateListener() {
//            @Override
//            public void onAuthStateChanged(FirebaseAuth firebaseAuth) {
//                FirebaseUser user = firebaseAuth.getCurrentUser();
//                if (user != null) {
//                    // User is signed in
//                    Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
//                    startActivity(intent);
//                    finish();
//                }
//            }
//        };

        findViewById(R.id.btn_signup).setOnClickListener(this);
        findViewById(R.id.btn_signin).setOnClickListener(this);
        findViewById(R.id.btn_google_sign_in).setOnClickListener(this);
        findViewById(R.id.btn_reset_password).setOnClickListener(this);

        // TODO (7.0) init googleAuth provider
        initGoogleAuthProvider();

    }

    // TODO (2.1) life cycler
    @Override
    public void onStart() {
        super.onStart();
//        firebaseAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
//        if (mAuthListener != null) {
//            firebaseAuth.removeAuthStateListener(mAuthListener);
//        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_signup:
                if (!validateForm()) {
                    return;
                }
                // TODO (3.1) SignUpButton
//                signUpWithEmail(edEmail.getText().toString(), edPassword.getText().toString());
                break;
            case R.id.btn_signin:
                if (!validateForm()) {
                    return;
                }
                //TODO (4.1) SignInButton
//                signInWithEmail(edEmail.getText().toString(), edPassword.getText().toString());
                break;
            case R.id.btn_google_sign_in:
               // TODO (7.2) SingInGoogleProviderButton
//                Intent intent = signInClient.getSignInIntent();
//                startActivityForResult(intent, GOOGLE_SIGN_IN_CODE);
                break;
            case R.id.btn_reset_password:
                Intent intentResetPass = new Intent(this, ResetPasswordActivity.class);
                startActivity(intentResetPass);
                break;
        }
    }

    // TODO (7.1) set up google SignIn
    private void initGoogleAuthProvider() {
//        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestIdToken("649047026425-lobd3eeod6urgcq3svg928dvj80qpgcp.apps.googleusercontent.com")
//                .requestEmail()
//                .build();
        // TODO (7.1) set up google SignIn
//        signInClient = GoogleSignIn.getClient(this, gso);

//     check login
//        GoogleSignInAccount signInAccount = GoogleSignIn.getLastSignedInAccount(this);
//        if (signInAccount != null) {
//            Toast.makeText(this, "user is logined", Toast.LENGTH_LONG).show();
//            Intent intent = new Intent(this, DashboardActivity.class);
//            startActivity(intent);
//            finish();
//        }
    }
    // TODO(3) FirebaseSingUpWithEmail
    private void signUpWithEmail(String email, String password) {
//        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
//                if (task.isSuccessful()) {
//                    Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
//                    startActivity(intent);
//                    finish();
//                } else {
//                    Toast.makeText(getApplicationContext(), "email & password wrong", Toast.LENGTH_LONG).show();
//                }
//
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull @NotNull Exception e) {
//                Toast.makeText(getApplicationContext(), "email & password wrong" + e.toString(), Toast.LENGTH_LONG).show();
//            }
//        });
    }

    // TODO (4) FirebaseSingInWithEmail
//    private void signInWithEmail(String email, String password) {
//        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
//                if (task.isSuccessful()) {
//                    Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
//                    startActivity(intent);
//                } else {
//                    Toast.makeText(getApplicationContext(), "email & password not found", Toast.LENGTH_LONG).show();
//                }
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull @NotNull Exception e) {
//                Toast.makeText(getApplicationContext(), "email & password not found", Toast.LENGTH_LONG).show();
//            }
//        });
//    }

    // TODO (7.4) SignUp in FirebaseAuth
//    private void firebaseAuth(AuthCredential authCredential) {
//        firebaseAuth.signInWithCredential(authCredential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
//                if (task.isSuccessful()) {
//                    Toast.makeText(getApplicationContext(), "google account connect to app", Toast.LENGTH_LONG).show();
//                    Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
//                    startActivity(intent);
//                    finish();
//                } else {
//                    Toast.makeText(getApplicationContext(), "email & password not found", Toast.LENGTH_LONG).show();
//                }
//
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull @NotNull Exception e) {
//                Toast.makeText(getApplicationContext(), "google account cannot connect to app", Toast.LENGTH_LONG).show();
//
//            }
//        });
//    }

    private boolean validateForm() {
        if (TextUtils.isEmpty(edEmail.getText().toString())) {
            edEmail.setError("Required.");
            return false;
        } else if (TextUtils.isEmpty(edPassword.getText().toString())) {
            edPassword.setError("Required.");
            return false;
        } else {
            edEmail.setError(null);
            edPassword.setError(null);
            return true;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // TODO (7.3) Handle GoogleSignIn
        if (requestCode == GOOGLE_SIGN_IN_CODE) {
//            Task<GoogleSignInAccount> signInAccountTask = GoogleSignIn.getSignedInAccountFromIntent(data);
//            try {
//                GoogleSignInAccount signInAccount = signInAccountTask.getResult(ApiException.class);
//                AuthCredential authCredential = GoogleAuthProvider.getCredential(signInAccount.getIdToken(), null);
//                firebaseAuth(authCredential);
//            } catch (ApiException e) {
//                Toast.makeText(this, "Login not success", Toast.LENGTH_LONG).show();
//                Log.d("login e", e.getMessage());
//                e.printStackTrace();
//            }
        }

    }
}