package com.example.project21;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ProgressBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bar = findViewById(R.id.progressBar);


        this.initialiseBar();

    }
    private void initialiseBar(){

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                try {

                    while(i < 100) {
                        Thread.sleep(1000);
                        i += 10;
                        bar.setProgress(i);
                    }


                } catch(Exception exc){
                    exc.printStackTrace();
                }

            }
        });

        thread.start();

    }
}