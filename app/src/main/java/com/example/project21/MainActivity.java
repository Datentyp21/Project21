package com.example.project21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //irgendeine Scheiße; HIHIHI ; HAHAHAHAHAHAHAHAHAHA
        setContentView(null);
    }
}