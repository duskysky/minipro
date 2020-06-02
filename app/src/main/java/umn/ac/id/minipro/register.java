package umn.ac.id.minipro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void loginnn (View view){
        Intent intentLo = new Intent(register.this, MainActivity.class);
        startActivityForResult(intentLo, 1);
    }

    public void reg (View view){
        Intent intentHo = new Intent(register.this, home.class);
        startActivityForResult(intentHo, 1);
    }
}
