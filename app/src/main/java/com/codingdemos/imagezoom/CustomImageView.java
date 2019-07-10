package com.codingdemos.imagezoom;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.Log;
import android.view.MotionEvent;

class CustomImageView extends AppCompatImageView {

    public static final String TAG = "MainActivity";

    public CustomImageView(Context context) {
        super(context);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getActionMasked();

        Log.d(TAG, "onTouchEvent: " + String.valueOf(action));

        return super.onTouchEvent(event);
    }
}
