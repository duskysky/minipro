package umn.ac.id.minipro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class registers extends AppCompatActivity {

    EditText mFullName, mEmail, mPassword, mConfirmPassword;
    FirebaseAuth fAuth;
    Button mRegister;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registers);

        mFullName = findViewById(R.id.input_nama);
        mEmail = findViewById(R.id.input_email);
        mPassword = findViewById(R.id.input_pass);
        mConfirmPassword = findViewById(R.id.input_c_pass);
        mRegister = findViewById(R.id.btnRegisdiRegis);

        fAuth = FirebaseAuth.getInstance();

        if (fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),home.class));
            finish();
        }

    mRegister.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String email = mEmail.getText().toString().trim();
            String password = mPassword.getText().toString().trim();
            String confpass = mConfirmPassword.getText().toString().trim();

            if (TextUtils.isEmpty(email)){
                mEmail.setError("Email required!");
                return;
            }

            if(TextUtils.isEmpty(password)){
                mPassword.setError("Password required!");
                return;
            }

            if (password.length() < 4){
                mPassword.setError("Password must be more than 4 character");
            }

            if(!password.equals(confpass)){
                mConfirmPassword.setError("Wrong Password!");
                return;
            }

            fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        startActivity(new Intent(getApplicationContext(),home.class));
                    }
                }
            });

        }
    });

    }




    public void loginnn (View view){
        Intent intentLo = new Intent(registers.this, MainActivity.class);
        startActivityForResult(intentLo, 1);
    }

}
