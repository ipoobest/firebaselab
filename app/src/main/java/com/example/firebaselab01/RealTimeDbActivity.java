package com.example.firebaselab01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firebaselab01.model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import static java.lang.Thread.sleep;

public class RealTimeDbActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference myRef;

    private TextView tvData;
    Handler h;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_time_db);

        findViewById(R.id.btn_set_value).setOnClickListener(this);
        findViewById(R.id.btn_stop).setOnClickListener(this);
        tvData = findViewById(R.id.tv_data);

        firebaseDatabase = FirebaseDatabase.getInstance("https://fir-codelab101-default-rtdb.asia-southeast1.firebasedatabase.app/");
        myRef = firebaseDatabase.getReference("simpledata/text/");


    }
//----------------------------------------Write--------------------------------------//

    // setValue
    private void setValue() {
        myRef = firebaseDatabase.getReference("simpledata");
        myRef.child("text").setValue("test value");
    }

    // push
    private void pushValue(){
        myRef = firebaseDatabase.getReference("users_test");
        User user = new User();
        user.setId("1");
        user.setUsername("username01");
        myRef.push().setValue(user);

    }
    // updateChildren

    private void updateChildrenValue(){
        Toast.makeText(this, "x", Toast.LENGTH_SHORT).show();
        myRef = firebaseDatabase.getReference();
        String key = myRef.push().getKey();

        User user = new User();
        user.setId("0001");
        user.setUsername("update");

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/users/test/" + key, user);
        childUpdates.put("/users_test/user/ssss" + key, user);


        myRef.updateChildren(childUpdates);

    }

    // runTransaction
    private void runTransaction() {

    }

    //----------------------------------------Delete--------------------------------------//

    private void removeValue() {
        myRef.removeValue();
    }

    private void setNullValue() {
        myRef.setValue(null);
    }


    //----------------------------------------Read--------------------------------------//

    private void readValueEventListener() {
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String dataChange = snapshot.getValue(String.class);
                tvData.setText(dataChange );
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void readAddListenerForSingleValueEvent() {
        myRef.child("users").child("userId").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                if (user == null) {
                    // do something
                } else {
                    // do something
                }
                finish();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("TAG", databaseError.getMessage());
            }
        });
    }

    private void readChildEventListener() {

    }

    //


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_set_value:
                setValue();
//                pushValue();
//                updateChildrenValue();
                break;
        }

    }
}