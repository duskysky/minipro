package umn.ac.id.minipro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class home extends AppCompatActivity {

    Button btnAd,btnout,btnbout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnAd = findViewById(R.id.button2);
        btnout = findViewById(R.id.button3);
        btnbout = findViewById(R.id.button);

        btnbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),about.class));
            }
        });

        btnout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        });
        btnAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),add.class));
            }
        });





//



    }



    /*userID = fAuth.getCurrentUser().getUid();
    DocumentReference documentReference = fstore.collection("users").document(userID);
    Map<String,Object> user = new HashMap<>();
                        user.put("fullname",name);
                        user.put("email",email);
                        documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
        @Override
        public void onSuccess(Void aVoid) {
            Log.d(TAG,"onSuccess: user Profile is created for "+userID);
        }
    });*/

}
/* FirebaseAuth.getInstance().signOut();
* getApplicationContext(), intent ke login
* finish(); */