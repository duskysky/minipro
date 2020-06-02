package umn.ac.id.minipro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {

    EditText mEmail, mPassword;
    Button mLogin, mRegis;
    FirebaseAuth fAuth;
    Switch dms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEmail = findViewById(R.id.input_email);
        mPassword = findViewById(R.id.input_pass);
        mLogin = findViewById(R.id.btnLoginDiLogin);
        mRegis = findViewById(R.id.btnRegisDiLogin);
        fAuth = FirebaseAuth.getInstance();

        dms = findViewById(R.id.darkmodeswitch);




        dms.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }

            }
        });

        mRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentR = new Intent(MainActivity.this, registers.class);
                startActivityForResult(intentR, 1);
            }
        });

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString().trim();
                final String password = mPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    mEmail.setError("Email can't be empty!");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    mPassword.setError("Password can't be empty!");
                    return;
                }

                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            startActivity(new Intent(getApplicationContext(),home.class));
                        } else {
                            Toast.makeText(MainActivity.this,"Register if you don't have any account yet!",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
    }





}
