package com.example.vserp.clock;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private FrameLayout frameLayout;
    private Date currentDate;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            frameLayout.removeAllViews();
            frameLayout.addView(new ClockView(MainActivity.this,currentDate));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout = (FrameLayout) findViewById(R.id.fl_clock);

        Timer timer = new Timer();
        MyTime myTime = new MyTime();
        timer.schedule(myTime,1,1000);

    }

    class MyTime extends TimerTask{

        @Override
        public void run() {

            currentDate = new Date();
            handler.sendEmptyMessage(0);

        }
    }
}
