package umn.ac.id.minipro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class registers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registers);
    }

    public void loginnn (View view){
        Intent intentLo = new Intent(registers.this, MainActivity.class);
        startActivityForResult(intentLo, 1);
    }

    public void reg (View view){
        Intent intentHo = new Intent(registers.this, home.class);
        startActivityForResult(intentHo, 1);
    }
}
