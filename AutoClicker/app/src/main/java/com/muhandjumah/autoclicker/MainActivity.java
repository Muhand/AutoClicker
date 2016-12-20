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
    private float currentX = -1;
    private float currentY = -1;
    long downTime;
    long eventTime;
    float x;
    float y;

    //Private controls
    private Button locationBtn;
    private Button startTouchingBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        locationBtn = (Button) findViewById(R.id.locationBtn);
        startTouchingBtn = (Button) findViewById(R.id.startTouching);

        final Handler ha = new Handler();
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
                    Log.d("X", "x: " + currentX);
                    Log.d("Y", "y: " + currentY);
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

    public void startAutoTouch(View view) throws InterruptedException {
        if(startTouching) {
            startTouching = false;
            startTouchingBtn.setText("Start Auto Touch");
        }
        else {
            startTouching = true;

            startTouchingBtn.setText("Stop Auto Touch");
        }
//        if(currentX != -1 || currentY != -1) {
            // Obtain MotionEvent object
//            downTime =
//            eventTime = SystemClock.uptimeMillis() + 1000;
//            Log.d("t", Long.toString(downTime));
//            Log.d("t",Long.toString(eventTime));
//            x = 0;
//            y = 0;

//            // Dispatch touch event to view
//        while(true) {

//            view.dispatchTouchEvent(event);
//        final Handler ha=new Handler();
//        ha.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                //call function
//                Log.d("s", "test1");
//                ha.postDelayed(this, 1000);
//            }
//        }, 1000);

//            Thread.sleep(10000);
//        }
//        }

    }
    private void autoTouch()
    {
        final Handler ha = new Handler();
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



    // List of meta states found here:     developer.android.com/reference/android/view/KeyEvent.html#getMetaState()
    int metaState = 0;
//    MotionEvent motionEvent = MotionEvent.obtain(
//            SystemClock.uptimeMillis(),
//            SystemClock.uptimeMillis() + 100,
//            MotionEvent.ACTION_UP,
//            0,
//            0,
//            0
//    );
MotionEvent event = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis()+100, MotionEvent.ACTION_UP,
        0, 0, 0, 0,
        0, 0, 0,
        0, 0x0);


}
