package com.example.mayafif;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set ke fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public void pindahkedaftar(View view) {
        Intent intent = new Intent(MainActivity.this,DaftarAwal.class);
        startActivity(intent);
    }

    //public void pindahkemenuutama(View view) {
    //    Intent intent = new Intent(MainActivity.this,Homelayout.class);
    //    startActivity(intent);
    //}

    public void pindahkeinputcode(View view) {
        Intent intent = new Intent(MainActivity.this, InputCode.class);
        startActivity(intent);
    }
}