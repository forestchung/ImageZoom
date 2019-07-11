package com.codingdemos.imagezoom;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.time.Instant;
import java.util.ArrayList;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    ArrayList<String> chairNames;
    ArrayList<Integer> chairImages;
    Context context;
    MyPhotoAttacher photoViewAttacher;
/*
    ArrayList<String> chairNames1 = new ArrayList<>(Arrays.asList("c01", "c12", "c13", "c14"));
    ArrayList<Integer> chairImages1 = new ArrayList<>(Arrays.asList(R.drawable.sample_1, R.drawable.sample_12, R.drawable.sample_13, R.drawable.sample_14));
     ArrayList<String> chairNames2 = new ArrayList<>(Arrays.asList("c02", "c22", "c23", "c24"));
    ArrayList<Integer> chairImages2 = new ArrayList<>(Arrays.asList(R.drawable.sample_2, R.drawable.sample_22, R.drawable.sample_23, R.drawable.sample_24));
    ArrayList<String> chairNames3 = new ArrayList<>(Arrays.asList("c03", "c32", "c33", "c34"));
    ArrayList<Integer> chairImages3 = new ArrayList<>(Arrays.asList(R.drawable.sample_3, R.drawable.sample_32, R.drawable.sample_33, R.drawable.sample_34));
    ArrayList<String> chairNames4 = new ArrayList<>(Arrays.asList("c04", "c42", "c43", "c44"));
    ArrayList<Integer> chairImages4 = new ArrayList<>(Arrays.asList(R.drawable.sample_4, R.drawable.sample_42, R.drawable.sample_43, R.drawable.sample_44));
    ArrayList<String> chairNames5 = new ArrayList<>(Arrays.asList("c05", "c52", "c53", "c54"));
    ArrayList<Integer> chairImages5 = new ArrayList<>(Arrays.asList(R.drawable.sample_5, R.drawable.sample_53, R.drawable.sample_53, R.drawable.sample_54));
*/

    public static final String TAG = "MainActivity";

    public CustomAdapter(Context context, ArrayList<String> chairNames, ArrayList<Integer> chairImages) {
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

                // Write a message to the database
                Instant instant = Instant.now(); // Current moment in UTC.
                Log.d("Touch","Timestamp: -"+instant.toEpochMilli());
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference(String.valueOf(instant.toEpochMilli()));
                myRef.setValue("Touch " + chairNames.get(position));

                //Toast.makeText(context, position, Toast.LENGTH_SHORT).show();
                switch (chairNames.get(position)) {
                    case "c01":
                        startGalleryActivity(1);

                        /*
                        // clear old list
                        chairImages.clear();
                        chairNames.clear();
                        chairImages = chairImages1;
                        chairNames = chairNames1;
                        // notify adapter
                        // CustomChildAdapter customChildAdapter = new CustomChildAdapter(context, chairNames,chairImages);
                        //recyclerView.setAdapter(customChildAdapter); // set the Adapter to RecyclerView

                        notifyDataSetChanged();
*/
                        break;
                    case "c02":
                        startGalleryActivity(2);
                        /*
                        // clear old list
                        chairImages.clear();
                        chairNames.clear();
                        chairImages = chairImages2;
                        chairNames = chairNames2;
                        // notify adapter
                        notifyDataSetChanged();
                        */
                        break;
                    case "c03":
                        startGalleryActivity(3);
                        /*
                        // clear old list
                        chairImages.clear();
                        chairNames.clear();
                        chairImages = chairImages3;
                        chairNames = chairNames3;
                        // notify adapter
                        notifyDataSetChanged();
                        */
                        break;
                    case "c04":
                        startGalleryActivity(4);
                        /*
                        // clear old list
                        chairImages.clear();
                        chairNames.clear();
                        chairImages = chairImages4;
                        chairNames = chairNames4;
                        // notify adapter
                        notifyDataSetChanged();
                        */
                        break;
                    case "c05":
                        startGalleryActivity(5);
                        /*
                        // clear old list
                        chairImages.clear();
                        chairNames.clear();
                        chairImages = chairImages5;
                        chairNames = chairNames5;
                        // notify adapter
                        notifyDataSetChanged();
                        */
                        break;
                    default:
                        break;

                }
//----------------------------------------------------------------------------------------

/*
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(context);
                // View mView = getLayoutInflater().inflate(R.layout.dialog_custom_layout, null);
                //View mView = inflater.inflate(R.layout.dialog_custom_layout, null);
                LayoutInflater inflater = LayoutInflater.from(context);
                //View view = inflater.inflate( R.layout.myNewInflatedLayout, null );
                View mView = inflater.inflate(R.layout.dialog_custom_layout, null);

                Log.d(TAG, "Custom Adapter  onClick");

                PhotoView photoView = mView.findViewById(R.id.imageView);
                //photoView.setImageResource(R.drawable.nature);
                //String name = "R.drawable." + personImages.get(position);

                //this line crash
                Toast.makeText(context, chairImages.get(position), Toast.LENGTH_SHORT).show();
//if (position>=4) {photoView.setImageResource(chairImages.get(position-1));}
//else if (position<0){photoView.setImageResource(chairImages.get(position+1));}
//else
//{photoView.setImageResource(chairImages.get(position));}

                photoView.setImageResource(chairImages.get(position));

                //

                //photoViewAttacher = new PhotoViewAttacher(photoView);
                photoViewAttacher = new MyPhotoAttacher(photoView);
                // photoViewAttacher = new PhotoViewAttacher(imageView);

                photoViewAttacher.setOnViewTapListener(new OnViewTapListener() {
                    @Override
                    public void onViewTap(View view, float x, float y) {
                        Instant instant = Instant.now(); // Current moment in UTC.
                        Log.d(TAG, "onViewTap" + x + " " + y + " " + instant.toEpochMilli());
                        String temp = Long.toString(instant.toEpochMilli());
                        Toast.makeText(context, temp, Toast.LENGTH_SHORT).show();
                        // Log.d(TAG, "motionEvent: " + event.toString());
                    }
                });

                photoViewAttacher.setOnPhotoTapListener(new OnPhotoTapListener() {
                    @Override
                    public void onPhotoTap(ImageView view, float x, float y) {
                        Instant instant = Instant.now(); // Current moment in UTC.
                        Log.d(TAG, "onPhotoTap" + x + " " + y + " " + instant.toEpochMilli());
                        String temp = Long.toString(instant.toEpochMilli());
                        Toast.makeText(context, temp, Toast.LENGTH_SHORT).show();
                    }
                });
                photoViewAttacher.update();
                mBuilder.setView(mView);
                AlertDialog mDialog = mBuilder.create();
                mDialog.show();
                //-------------------------------------------------------------------
*/
                // get the reference of RecyclerView
                // RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
                // set a LinearLayoutManager with default vertical orientation
                //// LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context.getApplicationContext());
                // recyclerView.setLayoutManager(linearLayoutManager);
                //  call the constructor of CustomAdapter to send the reference and data to Adapter
                //CustomAdapter customAdapter = new CustomAdapter(MainActivity.this, chairNames,chairImages);
                //   CustomChildAdapter  customChildAdapter = new CustomChildAdapter(context, chairNames1,chairImages1);
                // recyclerView.setAdapter(customChildAdapter); // set the Adapter to RecyclerView
                /*
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



*/
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

    public void startGalleryActivity(Integer i) {
        ArrayList<String> images = new ArrayList<String>();
        //ArrayList<Integer> images = new ArrayList<Integer>();
/*
        ArrayList<Integer> chairImages1 = new ArrayList<>(Arrays.asList(R.drawable.sample_1, R.drawable.sample_12, R.drawable.sample_13, R.drawable.sample_14));
        ArrayList<String> chairNames2 = new ArrayList<>(Arrays.asList("c02", "c22", "c23", "c24"));
        ArrayList<Integer> chairImages2 = new ArrayList<>(Arrays.asList(R.drawable.sample_2, R.drawable.sample_22, R.drawable.sample_23, R.drawable.sample_24));
        ArrayList<String> chairNames3 = new ArrayList<>(Arrays.asList("c03", "c32", "c33", "c34"));
        ArrayList<Integer> chairImages3 = new ArrayList<>(Arrays.asList(R.drawable.sample_3, R.drawable.sample_32, R.drawable.sample_33, R.drawable.sample_34));
        ArrayList<String> chairNames4 = new ArrayList<>(Arrays.asList("c04", "c42", "c43", "c44"));
        ArrayList<Integer> chairImages4 = new ArrayList<>(Arrays.asList(R.drawable.sample_4, R.drawable.sample_42, R.drawable.sample_43, R.drawable.sample_44));
        ArrayList<String> chairNames5 = new ArrayList<>(Arrays.asList("c05", "c52", "c53", "c54"));
        ArrayList<Integer> chairImages5 = new ArrayList<>(Arrays.asList(R.drawable.sample_5, R.drawable.sample_53, R.drawable.sample_53, R.drawable.sample_54));
*/

        switch (i){
            case 1:
                //images = chairImages1;
               // https://res.cloudinary.com/dj0tzyjwc/image/upload/v1553086242/f5kcrvg1ck75n9nbuxwn.jpg

               // images.add("https://res.cloudinary.com/dj0tzyjwc/image/upload/v1562865369/AlvinProject/sample_1.jpg");
                images.add("https://res.cloudinary.com/dj0tzyjwc/image/upload/v1553145165/aztckmp4m05bqoxgfc5i.jpg");
                images.add("https://res.cloudinary.com/dj0tzyjwc/image/upload/v1562865369/AlvinProject/sample_12.jpg");
                images.add("https://res.cloudinary.com/dj0tzyjwc/image/upload/v1562865369/AlvinProject/sample_13.jpg");
                images.add("https://res.cloudinary.com/dj0tzyjwc/image/upload/v1562865369/AlvinProject/sample_14.jpg");
                             break;
            case 2:
                //images = chairImages2;
                images.add("https://res.cloudinary.com/dj0tzyjwc/image/upload/v1562865369/AlvinProject/sample_2.jpg");
                images.add("https://res.cloudinary.com/dj0tzyjwc/image/upload/v1562865369/AlvinProject/sample_22.jpg");
                images.add("https://res.cloudinary.com/dj0tzyjwc/image/upload/v1562865369/AlvinProject/sample_23.jpg");
                images.add("https://res.cloudinary.com/dj0tzyjwc/image/upload/v1562865369/AlvinProject/sample_24.jpg");
                break;
            case 3:
                //images = chairImages3;
                images.add("https://res.cloudinary.com/dj0tzyjwc/image/upload/v1562865370/AlvinProject/sample_3.jpg");
                images.add("https://res.cloudinary.com/dj0tzyjwc/image/upload/v1562865370/AlvinProject/sample_32.jpg");
                images.add("https://res.cloudinary.com/dj0tzyjwc/image/upload/v1562865370/AlvinProject/sample_33.jpg");
                images.add("https://res.cloudinary.com/dj0tzyjwc/image/upload/v1562865370/AlvinProject/sample_34.jpg");
                break;
            case 4:
                //images = chairImages4;
                images.add("https://res.cloudinary.com/dj0tzyjwc/image/upload/v1562865370/AlvinProject/sample_4.jpg");
                images.add("https://res.cloudinary.com/dj0tzyjwc/image/upload/v1562865370/AlvinProject/sample_42.jpg");
                images.add("https://res.cloudinary.com/dj0tzyjwc/image/upload/v1562865370/AlvinProject/sample_43.jpg");
                images.add("https://res.cloudinary.com/dj0tzyjwc/image/upload/v1562865370/AlvinProject/sample_44.jpg");
                break;
            case 5:
                //images = chairImages5;
                images.add("https://res.cloudinary.com/dj0tzyjwc/image/upload/v1562865371/AlvinProject/sample_5.jpg");
                images.add("https://res.cloudinary.com/dj0tzyjwc/image/upload/v1562865371/AlvinProject/sample_52.jpg");
                images.add("https://res.cloudinary.com/dj0tzyjwc/image/upload/v1562865371/AlvinProject/sample_53.jpg");
                images.add("https://res.cloudinary.com/dj0tzyjwc/image/upload/v1562865371/AlvinProject/sample_54.jpg");
                break;
        }

             // Intent intent = new Intent(MainActivity.this, GalleryActivity.class);https://res.cloudinary.com/dj0tzyjwc/image/upload/v1562865371/AlvinProject/sample_54.jpg
        Intent intent = new Intent(context, GalleryActivity.class);
        intent.putStringArrayListExtra(GalleryActivity.EXTRA_NAME, images);
        //intent.putIntegerArrayListExtra(GalleryActivity.EXTRA_NAME, images);
        context.startActivity(intent);
    }
}

