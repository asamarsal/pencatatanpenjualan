package com.example.mayafif;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.concurrent.Executor;

public class InputCode extends AppCompatActivity implements View.OnClickListener{

    View kolomangka1, kolomangka2, kolomangka3, kolomangka4;
    Button angka1, angka2, angka3, angka4, angka5, angka6, angka7, angka8, angka9, angka0, tekanhapus;


    ArrayList<String> numbers_list = new ArrayList<>();
    String passCode = "";
    String kolom1, kolom2, kolom3, kolom4;

    private Executor executor;
    private BiometricPrompt biometricPrompt;
    private BiometricPrompt.PromptInfo promptInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inputcode);
        initializeComponents();

        //Set ke fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        executor = ContextCompat.getMainExecutor(this);
        biometricPrompt = new BiometricPrompt(InputCode.this,
                executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode,
                                              @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                Toast.makeText(getApplicationContext(),
                                "Authentication error: " + errString, Toast.LENGTH_SHORT)
                        .show();

            }

            @Override
            public void onAuthenticationSucceeded(
                    @NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                Toast.makeText(getApplicationContext(),
                        "Berhasil Masuk", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(InputCode.this, Homelayout.class);
                startActivity(intent);

            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                Toast.makeText(getApplicationContext(), "Authentication failed",
                                Toast.LENGTH_SHORT)
                        .show();
            }

        });

        promptInfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("Login Dengan Menggunakan Biometric")
                .setSubtitle("Letakkan Fingerprint Anda")
                .setNegativeButtonText("Cancel")
                .build();

        // Prompt appears when user clicks "Log in".
        // Consider integrating with the keystore to unlock cryptographic operations,
        // if needed by your app.
        Button biometricLoginButton = findViewById(R.id.buttonfingerprint);
        biometricLoginButton.setOnClickListener(view -> {
            biometricPrompt.authenticate(promptInfo);
        });

    }

    private void initializeComponents() {
        kolomangka1 = findViewById(R.id.kolomangka1);
        kolomangka2 = findViewById(R.id.kolomangka2);
        kolomangka3 = findViewById(R.id.kolomangka3);
        kolomangka4 = findViewById(R.id.kolomangka4);

        angka1 = findViewById(R.id.angka1);
        angka2 = findViewById(R.id.angka2);
        angka3 = findViewById(R.id.angka3);
        angka4 = findViewById(R.id.angka4);
        angka5 = findViewById(R.id.angka5);
        angka6 = findViewById(R.id.angka6);
        angka7 = findViewById(R.id.angka7);
        angka8 = findViewById(R.id.angka8);
        angka9 = findViewById(R.id.angka9);
        angka0 = findViewById(R.id.angka0);

        tekanhapus = findViewById(R.id.tekanhapus);

        angka1.setOnClickListener(this);
        angka2.setOnClickListener(this);
        angka3.setOnClickListener(this);
        angka4.setOnClickListener(this);
        angka5.setOnClickListener(this);
        angka6.setOnClickListener(this);
        angka7.setOnClickListener(this);
        angka8.setOnClickListener(this);
        angka9.setOnClickListener(this);
        angka0.setOnClickListener(this);
        tekanhapus.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.angka0:
                numbers_list.add("0");
                passNumber(numbers_list);
                break;
            case R.id.angka1:
                numbers_list.add("1");
                passNumber(numbers_list);
                break;
            case R.id.angka2:
                numbers_list.add("2");
                passNumber(numbers_list);
                break;
            case R.id.angka3:
                numbers_list.add("3");
                passNumber(numbers_list);
                break;
            case R.id.angka4:
                numbers_list.add("4");
                passNumber(numbers_list);
                break;
            case R.id.angka5:
                numbers_list.add("5");
                passNumber(numbers_list);
                break;
            case R.id.angka6:
                numbers_list.add("6");
                passNumber(numbers_list);
                break;
            case R.id.angka7:
                numbers_list.add("7");
                passNumber(numbers_list);
                break;
            case R.id.angka8:
                numbers_list.add("8");
                passNumber(numbers_list);
                break;
            case R.id.angka9:
                numbers_list.add("9");
                passNumber(numbers_list);
                break;
            case R.id.tekanhapus:
                numbers_list.clear();
                passNumber(numbers_list);
                break;
        }
    }

    private void passNumber(ArrayList<String> numbers_list) {
        if (numbers_list.size() == 0){
            kolomangka1.setBackgroundResource(R.drawable.bentukbulatputih);
            kolomangka2.setBackgroundResource(R.drawable.bentukbulatputih);
            kolomangka3.setBackgroundResource(R.drawable.bentukbulatputih);
            kolomangka4.setBackgroundResource(R.drawable.bentukbulatputih);
        }
        else{
            switch (numbers_list.size()){
                case 1:
                    kolom1 = numbers_list.get(0);
                    kolomangka1.setBackgroundResource(R.drawable.bentukbulatbiru);
                    break;
                case 2:
                    kolom1 = numbers_list.get(1);
                    kolomangka2.setBackgroundResource(R.drawable.bentukbulatbiru);
                    break;
                case 3:
                    kolom1 = numbers_list.get(2);
                    kolomangka3.setBackgroundResource(R.drawable.bentukbulatbiru);
                    break;
                case 4:
                    kolom1 = numbers_list.get(3);
                    kolomangka4.setBackgroundResource(R.drawable.bentukbulatbiru);
                    passCode = kolom1 + kolom2 + kolom3 + kolom4;
                    if (getPassCode().length() == 0){
                        savePassCode(passCode);
                    } else {
                        matchPasscode();
                    }
                    break;
            }
        }
    }

    private void matchPasscode() {
        if (getPassCode().equals(passCode)){
            Intent intent = new Intent(InputCode.this,Homelayout.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Passcode Tidak Cocok", Toast.LENGTH_SHORT).show();
        }
    }

    private SharedPreferences.Editor savePassCode(String passCode){
        SharedPreferences preferences = getSharedPreferences("passcode_pref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("passcode", passCode);
        editor.commit();

        return editor;
    }

    private String getPassCode(){
        SharedPreferences preferences = getSharedPreferences("passcode_pref",Context.MODE_PRIVATE);
        return preferences.getString("passcode","");
    }
}