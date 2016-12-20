package com.muhandjumah.autoclicker;

import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //Private Members
    private boolean detectLocation = false;
    private boolean startTouching = false;
    private float currentX = -3;
    private float currentY = -1;

    //Private controls
    private Button locationBtn;
    private Button startTouchingBtn;

    //Finals
    final Handler ha = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        locationBtn = (Button) findViewById(R.id.locationBtn);
        startTouchingBtn = (Button) findViewById(R.id.startTouching);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = (float) event.getX();
        float y = (float) event.getY();


            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    break;
                case MotionEvent.ACTION_MOVE:

                    break;
                case MotionEvent.ACTION_UP:
                    if(detectLocation) {
                        currentX = x;
                        currentY = y;
                    }
                    Log.d("test", "test");
//                    Log.d("X", "currentX: " + currentX);
//                    Log.d("Y", "currentY: " + currentY);
//                    Log.d("X", "x: " + x);
//                    Log.d("Y", "y: " + y);
                    break;
            }

        return false;
    }

    public void enableLocationDetection(View view)
    {
        if(detectLocation) {
            detectLocation = false;
            locationBtn.setText("Get Location");
        }
        else {
            detectLocation = true;
            locationBtn.setText("Disable Location");
        }
    }

    public void startAutoTouch(View view){
        if(startTouching) {
            stop();
            startTouching = false;
            startTouchingBtn.setText("Start Auto Touch");
        }
        else {
            start();
            startTouching = true;
            startTouchingBtn.setText("Stop Auto Touch");
        }
    }
    private void stop()
    {
        ha.removeCallbacksAndMessages(null);
    }
    private void start()
    {
        updateEvent();

        ha.postDelayed(new Runnable() {
            @Override
            public void run() {
                //call function
                if(startTouching && (currentY > -1 && currentX > -1))
                    onTouchEvent(event);
                ha.postDelayed(this, 1000);
            }
        }, 1000);
    }

    private void updateEvent()
    {
        event = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis()+100, MotionEvent.ACTION_UP,
                currentX, currentY, 0, 0,
                0, 0, 0,
                0, 0x0);

    }


    // List of meta states found here:     developer.android.com/reference/android/view/KeyEvent.html#getMetaState()
    //These are the even parameters:
    //(downtime, eventTime, Action, x, y, pressure, size, metaState, xPrecision, yPrecision, deviceID, edgeFlags
    MotionEvent event = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis()+100, MotionEvent.ACTION_UP,
            currentX, currentY, 0, 0,
            0, 0, 0,
            0, 0x0);
}
