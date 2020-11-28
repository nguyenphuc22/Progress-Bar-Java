package com.example.progressbarjavareal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;

    public void download(View view) {

        CountDownTimer countDownTimer = new CountDownTimer(10000,500) {
            @Override
            public void onTick(long millisUntilFinished) {

                int current = progressBar.getProgress();

                int secondsCurrent = progressBar.getSecondaryProgress();

                if (current < progressBar.getMax()) {

                    progressBar.setProgress(current + 10);

                } else {

                    progressBar.setProgress(0);

                }

                if (secondsCurrent < progressBar.getMax()) {

                    progressBar.setSecondaryProgress(current + 5);

                } else {

                    progressBar.setSecondaryProgress(0);

                }

            }

            @Override
            public void onFinish() {
                Toast.makeText(MainActivity.this,"Finish",Toast.LENGTH_SHORT).show();
            }
        };

        countDownTimer.start();

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);

    }
}