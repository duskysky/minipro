package umn.ac.id.minipro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void registerr (View view){
        Intent intentR = new Intent(MainActivity.this, registers.class);
        startActivityForResult(intentR, 1);
    }

    public void loginn (View view){
        Intent intentL = new Intent(MainActivity.this, home.class);
        startActivityForResult(intentL, 1);
    }




}
