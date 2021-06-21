package com.example.firebaselab01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.jetbrains.annotations.NotNull;

public class DashboardActivity extends AppCompatActivity implements View.OnClickListener {
    //TODO (5) get data from current user
//    private FirebaseAuth firebaseAuth;
//    private FirebaseUser currentUser;

    private TextView tvDisplayName;
    private EditText edEmail;
    private EditText edPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initInstance();
    }

    private void initInstance() {
        // TODO (5) get data from current user
//        firebaseAuth = FirebaseAuth.getInstance();
//        currentUser = firebaseAuth.getCurrentUser();

        tvDisplayName = findViewById(R.id.tv_display_name);
//        tvDisplayName.setText(currentUser.getEmail());

        edEmail = findViewById(R.id.ed_email);
        edPassword = findViewById(R.id.ed_password);

        findViewById(R.id.btn_edit_email).setOnClickListener(this);
        findViewById(R.id.btn_edit_password).setOnClickListener(this);
        findViewById(R.id.btn_fire_store).setOnClickListener(this);
        findViewById(R.id.btn_rtdb).setOnClickListener(this);
        findViewById(R.id.btn_sign_out).setOnClickListener(this);
        findViewById(R.id.btn_delete).setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_sign_out:
                logout();
                break;
            case R.id.btn_edit_email:
                //TODO: (8) editEmail
//                editEmail(edEmail.getText().toString());
                break;
            case R.id.btn_edit_password:
                //TODO: (9) editPassword
//                editPassword(edPassword.getText().toString());
                break;
            case R.id.btn_delete:
                //TODO: (10) deleteEmail
//                deleteEmail();
                break;
            case R.id.btn_rtdb:
                goToRtdbActivity();
                break;
            case R.id.btn_fire_store:
                goToFirestoreActivity();
                break;
        }
    }


    private void logout() {
        // TODO (6) Firebase sign out

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("confirm");
        alert.setCancelable(false);
        alert.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
//                firebaseAuth.signOut();
//                Intent intent = new Intent(getBaseContext(), LoginActivity.class);
//                startActivity(intent);
//                finish();
                // TODO (7.5)
//                googleProviderSignOut();
            }
        });
        alert.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        alert.show();
    }

    // TODO (7.6)
    private void googleProviderSignOut() {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .build();

        GoogleSignIn.getClient(this, gso)
                .signOut().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Intent intent = new Intent(getBaseContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

//    private void editEmail(String email) {
//        if (email.isEmpty()) {
//            Toast.makeText(this, "email is empty", Toast.LENGTH_LONG).show();
//            return;
//        }
//        currentUser.updateEmail(email)
//                .addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(Task<Void> task) {
//                        if (task.isSuccessful()) {
//                            Log.d("update email", "User email address updated.");
//                            Toast.makeText(getApplicationContext(), "update success", Toast.LENGTH_SHORT).show();
//                            FirebaseUser user = firebaseAuth.getCurrentUser();
//                            tvDisplayName.setText(user.getEmail());
//                        }
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull @NotNull Exception e) {
//                // todo something
//            }
//        });
//    }

//    private void editPassword(String password) {
//        if (password.isEmpty()) {
//            Toast.makeText(this, "password is empty", Toast.LENGTH_LONG).show();
//            return;
//        }
//
//        currentUser.updatePassword(password)
//                .addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(Task<Void> task) {
//                        if (task.isSuccessful()) {
//                            Log.d("update password", "User email address updated.");
//                            Toast.makeText(getApplicationContext(), "update password", Toast.LENGTH_SHORT).show();
//
//                        }
//                    }
//                });
//    }

//    private void deleteEmail() {
//
//        AlertDialog.Builder alert = new AlertDialog.Builder(this);
//        alert.setMessage("confirm delete user");
//        alert.setCancelable(false);
//        alert.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                currentUser.delete()
//                        .addOnCompleteListener(new OnCompleteListener<Void>() {
//                            @Override
//                            public void onComplete(Task<Void> task) {
//                                if (task.isSuccessful()) {
//                                    Log.d("delete email", "User account deleted.");
//                                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
//                                    startActivity(intent);
//                                    finish();
//                                }
//                            }
//                        });
//            }
//        });
//        alert.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                dialogInterface.dismiss();
//            }
//        });
//        alert.show();
//
//    }

    private void goToRtdbActivity() {
        Intent intent = new Intent(this, RealTimeDbActivity.class);
        startActivity(intent);
    }

    private void goToFirestoreActivity() {
        Intent intent = new Intent(this, FirestoreActivity.class);
        startActivity(intent);
    }

}