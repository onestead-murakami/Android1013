package com.example.mytimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private final Handler mHandler = new Handler(Looper.getMainLooper());

    private Timer mTimer;
    private TextView mTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTime = (TextView) findViewById(R.id.textView0);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mTimer = new Timer();
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {

//                //メインスレッド以外からUI操作（異常終了）
//                int time = Integer.parseInt(mTime.getText().toString()) - 1;
//                if (time < 0) {
//                    mTimer.cancel();
//                    mTimer = null;
//                } else {
//                    String text = String.valueOf(time);
//                    mTime.setText(text);
//                }

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        int time = Integer.parseInt(mTime.getText().toString()) - 1;
                        if (time < 0) {
                            mTimer.cancel();
                            mTimer = null;
                        } else {
                            String text = String.valueOf(time);
                            mTime.setText(text);
                        }
                    }
                });
            }
        }, 1500, 1000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putCharSequence("time", mTime.getText());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle inState) {
        super.onRestoreInstanceState(inState);
        mTime.setText(inState.getCharSequence("time"));
    }

}