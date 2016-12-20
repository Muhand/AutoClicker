package com.muhandjumah.autoclicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //Private Members
    private boolean detectLocation = false;
    private int currentX = -1;
    private int currentY = -1;

    //Private controls
    private Button locationBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        locationBtn = (Button) findViewById(R.id.locationBtn);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(detectLocation) {
            int x = (int) event.getX();
            int y = (int) event.getY();
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                case MotionEvent.ACTION_MOVE:
                case MotionEvent.ACTION_UP:
                    currentX = x;
                    currentY = y;
                    Log.d("X", "x: " + currentX);
                    Log.d("Y", "y: " + currentY);
            }
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
}
