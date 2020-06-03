package umn.ac.id.minipro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class add extends AppCompatActivity {

    Button btncancel, btnadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        btnadd = findViewById(R.id.buttonadd);
        btncancel = findViewById(R.id.buttonCancel);



        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),home.class));
            }
        });

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),home.class));
            }
        });
    }
}

/*
userID = fAuth.getCurrentUser().getUid();
                        DocumentReference documentReference = fstore.collection("users").document(userID);
                        Map<String,Object> user = new HashMap<>();
                        user.put("fullname",name);
                        user.put("email",email);
                        documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d(TAG,"onSuccess: user Profile is created for "+userID);
                            }
                        });
* */