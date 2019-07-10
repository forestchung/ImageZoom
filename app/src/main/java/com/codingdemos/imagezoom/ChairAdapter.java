package com.codingdemos.imagezoom;

import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.chrisbanes.photoview.OnPhotoTapListener;
import com.github.chrisbanes.photoview.OnViewTapListener;
import com.github.chrisbanes.photoview.PhotoView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.time.Instant;
import java.util.List;

public class ChairAdapter extends ExpandableRecyclerViewAdapter<ChairCatalogViewHolder, ChairViewHolder> {

    MyPhotoAttacher photoViewAttacher;
    public static final String TAG = "MainActivity";
    //Context context;
   // Context context = getApplicationContext();

        public ChairAdapter(List<? extends ExpandableGroup> groups) {
            super(groups);
        }

        @Override
        public ChairCatalogViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.expandable_recyclerview_chair_catalog, parent, false);
            return new ChairCatalogViewHolder(v);
        }

        @Override
        public ChairViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.expandable_recyclerview_chair_details, parent, false);
            return new ChairViewHolder(v);
        }

        @Override
        public void onBindChildViewHolder(ChairViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
            final Chair chair = (Chair) group.getItems().get(childIndex);
            holder.bind(chair);

            //---------------------------------------------------------------------------------------------------------
            // set the data in items

            //holder.name.setText(chair.getItems().(childIndex));
            //holder.image.setImageResource(chairImages.get(position));
            // implement setOnClickListener event on item view.
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    Toast.makeText(view.getContext(), chair.name, Toast.LENGTH_SHORT).show();

                    // Write a message to the database
                    Instant instant = Instant.now(); // Current moment in UTC.
                    Log.d("Touch","Timestamp: -"+instant.toEpochMilli());
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference(String.valueOf(instant.toEpochMilli()));
                    myRef.setValue("Touch " + chair.name);

                    // display a toast with person name on item click
                    //Toast.makeText(context, personNames.get(position), Toast.LENGTH_SHORT).show();
                    //Toast.makeText(context, chairImages.get(position), Toast.LENGTH_SHORT).show();

                   AlertDialog.Builder mBuilder = new AlertDialog.Builder(view.getContext());


                    // View mView = getLayoutInflater().inflate(R.layout.dialog_custom_layout, null);
                    //View mView = inflater.inflate(R.layout.dialog_custom_layout, null);
                    LayoutInflater inflater = LayoutInflater.from(view.getContext());
                    //View view = inflater.inflate( R.layout.myNewInflatedLayout, null );
                    View mView = inflater.inflate(R.layout.dialog_custom_layout, null);

                    Log.d(TAG, "Custom Adapter  onClick"  );

                    PhotoView photoView = mView.findViewById(R.id.imageView);
                    //photoView.setImageResource(R.drawable.nature);
                    //String name = "R.drawable." + personImages.get(position);
                    //photoView.setImageResource(chairImages.get(position));
                    photoView.setImageResource(chair.photo);

                    //photoViewAttacher = new PhotoViewAttacher(photoView);
                    photoViewAttacher = new MyPhotoAttacher(photoView);
                    // photoViewAttacher = new PhotoViewAttacher(imageView);

                    photoViewAttacher.setOnViewTapListener(new OnViewTapListener() {
                        @Override
                        public void onViewTap(View view, float x, float y) {
                            Instant instant = Instant.now(); // Current moment in UTC.
                           // Log.d(TAG, "onViewTap" + x + " " + y + " " + instant.toEpochMilli() );
                            String temp = Long.toString(instant.toEpochMilli());
                          //  Toast.makeText(view.getContext(), temp, Toast.LENGTH_SHORT).show();
                            // Log.d(TAG, "motionEvent: " + event.toString());
                        }
                    });

                    photoViewAttacher.setOnPhotoTapListener(new OnPhotoTapListener() {
                        @Override
                        public void onPhotoTap(ImageView view, float x, float y) {
                            Instant instant = Instant.now(); // Current moment in UTC.
                            //Log.d(TAG, "onPhotoTap" + x + " " + y + " " +  instant.toEpochMilli());
                            String temp = Long.toString(instant.toEpochMilli());
                            //Toast.makeText(context, temp, Toast.LENGTH_SHORT).show();
                        }
                    });
                    photoViewAttacher.update();
                    mBuilder.setView(mView);
                    AlertDialog mDialog = mBuilder.create();
                    mDialog.show();
                }
            });
            //---------------------------------------------------------------------------------------------------------

        }

        @Override
        public void onBindGroupViewHolder(ChairCatalogViewHolder holder, int flatPosition, ExpandableGroup group) {
            final ChairCatalog chairCatalog = (ChairCatalog) group;
            holder.bind(chairCatalog);
        }
    }



