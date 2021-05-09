package com.android.materialprogressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;

import com.lsjwzh.widget.materialloadingprogressbar.CircleProgressBar;

public class MainActivity extends AppCompatActivity {

    CircleProgressBar circleProgressBar;
    Button btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        circleProgressBar = findViewById(R.id.progress);
        circleProgressBar.setColorSchemeResources(R.color.teal_700);
        btnShow = findViewById(R.id.btnShow);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final int[] progressValue = {0};
                circleProgressBar.setVisibility(View.VISIBLE);
                CountDownTimer countDownTimer = new CountDownTimer(11000,1000) {
                    @Override
                    public void onTick(long l) {
                        progressValue[0] +=10;
                        circleProgressBar.setProgress(progressValue[0]);
                        if (progressValue[0] >=100){
                            circleProgressBar.setVisibility(View.INVISIBLE);
                        }
                    }

                    @Override
                    public void onFinish() {
                        circleProgressBar.setVisibility(View.INVISIBLE);
                    }
                }.start();
            }
        });
    }
}