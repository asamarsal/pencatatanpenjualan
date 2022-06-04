package com.example.mayafif;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Homelayout extends AppCompatActivity {

    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homelayout);

        bottomNavigation = findViewById(R.id.navigationbawah);

        //Set ke fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Membuat Layar Default Awal
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new PelangganFragment()).commit();

        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                //Memanggil Fragment
                switch (item.getItemId()){
                    case R.id.nav_pelanggan:
                        selectedFragment = new PelangganFragment();
                        break;
                    case R.id.nav_customharga:
                        selectedFragment = new CustomhargaFragment();
                        break;
                    case R.id.nav_transaksi:
                        selectedFragment = new TransaksiFragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

                return true;
            }
        });
    }
}