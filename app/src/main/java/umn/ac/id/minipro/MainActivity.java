package umn.ac.id.minipro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    EditText mEmail, mPassword;
    Button mLogin, mRegis;
    FirebaseAuth fAuth;
    Switch dms;
  //  String langEng[] = {"English","Bahasa Indonesia"};
    Spinner sp;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadLocale();
        mEmail = findViewById(R.id.input_email);
        mPassword = findViewById(R.id.input_pass);
        mLogin = findViewById(R.id.btnLoginDiLogin);
        mRegis = findViewById(R.id.btnRegisDiLogin);
        fAuth = FirebaseAuth.getInstance();
        sp = findViewById(R.id.spinnerLanguage);
        dms = findViewById(R.id.darkmodeswitch);

        Resources res = getResources();
        String[] langEng = res.getStringArray(R.array.langEng);
        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_selectable_list_item, langEng);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sp.setAdapter(adapter);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                if (i ==0){
                    setLocale("en-rUS");

                } else if (i == 1){
                    setLocale("in");

                }

                //switch(i){
                  //  case 0:
                //        setLocale("en-rUS");
                //        return;
                    //case 1:
                      //  setLocale("in");
                        //return;
                //}

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


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
                startActivity(new Intent(getApplicationContext(),registers.class));
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

    public void setLocale(String language){
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = getSharedPreferences("MainActivity", MODE_PRIVATE).edit();
        editor.putString("My_Lang", language);
        editor.apply();

    }

    public void loadLocale(){
        SharedPreferences prefs = getSharedPreferences("MainActivity", Activity.MODE_PRIVATE);
        String language = prefs.getString("My_Lang", "");
        setLocale(language);
    }
}
