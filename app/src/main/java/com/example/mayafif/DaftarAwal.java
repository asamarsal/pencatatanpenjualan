package com.example.mayafif;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;


import androidx.appcompat.app.AppCompatActivity;

public class DaftarAwal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_awal);

        //Set ke fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    //Pindah ke layout login
    public void pindahkelogin(View view) {
        Intent intent = new Intent(DaftarAwal.this, LoginActivity.class);
        startActivity(intent);
    }
}