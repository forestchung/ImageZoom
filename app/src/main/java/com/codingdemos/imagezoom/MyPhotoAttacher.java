package com.codingdemos.imagezoom;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.github.chrisbanes.photoview.PhotoViewAttacher;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.time.Instant;

public class MyPhotoAttacher extends PhotoViewAttacher implements View.OnLongClickListener,View.OnTouchListener {
    public MyPhotoAttacher(ImageView imageView) {
              super(imageView);
    }

    FirebaseDatabase database = FirebaseDatabase.getInstance();

    @Override
    public boolean onLongClick(View v) {
        return false;
    }


    public boolean onTouch(View view, MotionEvent event) {
        Log.d("Touch","touch happened -"+event.getAction());
        Instant instant = Instant.now(); // Current moment in UTC.
        Log.d("Touch","Timestamp: -"+instant.toEpochMilli());
        Log.d("Touch","MotionEvent: -"+event.toString() + " PressureSize: " +event.getSize());

        // Write a message to the database

        DatabaseReference myRef = database.getReference(String.valueOf(instant.toEpochMilli()));
        myRef.setValue("Action: " + event.getAction() + " Event: " + event.toString() + " Pressure: " + event.getSize());


       // Toast.makeText(, "MotionEvent: -"+event.toString() + " PressureSize: " +event.getSize(), Toast.LENGTH_SHORT).show();

        //Log.d(TAG, "Size: " + event.getSize());
        // Log.d(TAG, "motionEvent: " + event.toString());
        return super.onTouch(view, event);
    }

}
