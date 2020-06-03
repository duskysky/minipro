package umn.ac.id.minipro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


public class add extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


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