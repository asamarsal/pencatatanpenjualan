package com.example.mayafif;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Set ke fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public void pindahkedaftar(View view) {
        Intent intent = new Intent(LoginActivity.this,DaftarAwal.class);
        startActivity(intent);
    }

    //public void pindahkemenuutama(View view) {
    //    Intent intent = new Intent(LoginActivity.this,Homelayout.class);
    //    startActivity(intent);
    //}

    public void pindahkeinputcode(View view) {
        Intent intent = new Intent(LoginActivity.this, InputCode.class);
        startActivity(intent);
    }
}