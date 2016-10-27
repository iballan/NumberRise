package com.mbh.numberrise.sample;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.mbh.numberrise.NumberRiseTextView;

public class MainActivity extends AppCompatActivity {
    NumberRiseTextView tv_1, tv_2, tv_3, tv_4;
    NumberRiseTextView tv_5, tv_6, tv_7, tv_8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_1 = (NumberRiseTextView) findViewById(R.id.tv_1);
        tv_2 = (NumberRiseTextView) findViewById(R.id.tv_2);
        tv_3 = (NumberRiseTextView) findViewById(R.id.tv_3);
        tv_4 = (NumberRiseTextView) findViewById(R.id.tv_4);
        tv_5 = (NumberRiseTextView) findViewById(R.id.tv_5);
        tv_6 = (NumberRiseTextView) findViewById(R.id.tv_6);
        tv_7 = (NumberRiseTextView) findViewById(R.id.tv_7);
        tv_8 = (NumberRiseTextView) findViewById(R.id.tv_8);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                animateTvs();
            }
        }, 1000);
    }

    void animateTvs(){
        tv_1.setDuration(5000).animate(0,10);
        tv_2.setDuration(2000).animate(100,0);
        tv_3.setDuration(6000).animate(0.5f,1.5f);
        tv_4.setDuration(4500).animate(4.5f,0.0f);

        tv_5.setDuration(1500).animate(1.1,2.2);
        tv_6.setDuration(5500).animate(0,4000);
        tv_7.setDuration(4000).animate(50,-88);
        tv_8.setDuration(2500).animate(-1.0,+1.0f);
    }

    public void onRestartClicked(View view) {
        animateTvs();
    }
}
