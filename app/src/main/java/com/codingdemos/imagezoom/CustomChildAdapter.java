package com.codingdemos.imagezoom;


import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.chrisbanes.photoview.OnPhotoTapListener;
import com.github.chrisbanes.photoview.OnViewTapListener;
import com.github.chrisbanes.photoview.PhotoView;

import java.time.Instant;
import java.util.ArrayList;


public class CustomChildAdapter extends RecyclerView.Adapter<CustomChildAdapter.MyViewHolder> {

    ArrayList<String> chairNames;
    ArrayList<Integer> chairImages;
    Context context;
    MyPhotoAttacher photoViewAttacher;

    public static final String TAG = "MainActivity";

    public CustomChildAdapter(Context context, ArrayList<String> chairNames, ArrayList<Integer> chairImages) {
        this.context = context;
        this.chairNames = chairNames;
        this.chairImages = chairImages;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        // set the data in items
        holder.name.setText(chairNames.get(position));
        holder.image.setImageResource(chairImages.get(position));
        // implement setOnClickListener event on item view.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // display a toast with person name on item click
                //Toast.makeText(context, personNames.get(position), Toast.LENGTH_SHORT).show();
                //Toast.makeText(context, chairImages.get(position), Toast.LENGTH_SHORT).show();

                AlertDialog.Builder mBuilder = new AlertDialog.Builder(context);
                // View mView = getLayoutInflater().inflate(R.layout.dialog_custom_layout, null);
                //View mView = inflater.inflate(R.layout.dialog_custom_layout, null);
                LayoutInflater inflater = LayoutInflater.from(context);
                //View view = inflater.inflate( R.layout.myNewInflatedLayout, null );
                View mView = inflater.inflate(R.layout.dialog_custom_layout, null);

                Log.d(TAG, "Custom Adapter  onClick"  );

                PhotoView photoView = mView.findViewById(R.id.imageView);
                //photoView.setImageResource(R.drawable.nature);
                //String name = "R.drawable." + personImages.get(position);
                photoView.setImageResource(chairImages.get(position));


                //photoViewAttacher = new PhotoViewAttacher(photoView);
                photoViewAttacher = new MyPhotoAttacher(photoView);
                // photoViewAttacher = new PhotoViewAttacher(imageView);

                photoViewAttacher.setOnViewTapListener(new OnViewTapListener() {
                    @Override
                    public void onViewTap(View view, float x, float y) {
                        Instant instant = Instant.now(); // Current moment in UTC.
                        Log.d(TAG, "onViewTap" + x + " " + y + " " + instant.toEpochMilli() );
                        String temp = Long.toString(instant.toEpochMilli());
                        Toast.makeText(context, temp, Toast.LENGTH_SHORT).show();
                        // Log.d(TAG, "motionEvent: " + event.toString());
                    }
                });

                photoViewAttacher.setOnPhotoTapListener(new OnPhotoTapListener() {
                    @Override
                    public void onPhotoTap(ImageView view, float x, float y) {
                        Instant instant = Instant.now(); // Current moment in UTC.
                        Log.d(TAG, "onPhotoTap" + x + " " + y + " " +  instant.toEpochMilli());
                        String temp = Long.toString(instant.toEpochMilli());
                        Toast.makeText(context, temp, Toast.LENGTH_SHORT).show();
                    }
                });
                photoViewAttacher.update();
                mBuilder.setView(mView);
                AlertDialog mDialog = mBuilder.create();
                mDialog.show();




            }
        });

    }


    @Override
    public int getItemCount() {
        return chairNames.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // init the item view's
        TextView name;
        ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);

            // get the reference of item view's
            name = (TextView) itemView.findViewById(R.id.name);
            image = (ImageView) itemView.findViewById(R.id.image);

        }
    }
}
