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

import java.time.Instant;
import java.util.ArrayList;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    ArrayList<String> chairNames;
    ArrayList<Integer> chairImages;
    Context context;
    Logger logger = Logger.getInstance();


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
                Log.d(TAG,"Timestamp: -"+instant.toEpochMilli() + "Touch " + chairNames.get(position));
                logger.log("Timestamp: -"+instant.toEpochMilli() + "Touch " + chairNames.get(position));

                switch (chairNames.get(position)) {
                    case "c01":
                        startGalleryActivity(1);

                               break;
                    case "c02":
                        startGalleryActivity(2);

                        break;
                    case "c03":
                        startGalleryActivity(3);

                        break;
                    case "c04":
                        startGalleryActivity(4);

                        break;
                    case "c05":
                        startGalleryActivity(5);

                        break;
                    default:
                        break;

                }

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

        switch (i){
            case 1:

                images.add("https://res.cloudinary.com/dj0tzyjwc/image/upload/v1562905376/AlvinProject/sample_1.jpg");
                //images.add("https://res.cloudinary.com/dj0tzyjwc/image/upload/v1553145165/aztckmp4m05bqoxgfc5i.jpg");
                images.add("https://res.cloudinary.com/dj0tzyjwc/image/upload/v1562905376/AlvinProject/sample_12.jpg");
                images.add("https://res.cloudinary.com/dj0tzyjwc/image/upload/v1562905377/AlvinProject/sample_13.jpg");
                images.add("https://res.cloudinary.com/dj0tzyjwc/image/upload/v1562905377/AlvinProject/sample_14.jpg");
                             break;
            case 2:

                images.add("https://res.cloudinary.com/dj0tzyjwc/image/upload/v1562905400/AlvinProject/sample_2.jpg");
                images.add("https://res.cloudinary.com/dj0tzyjwc/image/upload/v1562905400/AlvinProject/sample_21.jpg");
                images.add("https://res.cloudinary.com/dj0tzyjwc/image/upload/v1562905400/AlvinProject/sample_23.jpg");
                images.add("https://res.cloudinary.com/dj0tzyjwc/image/upload/v1562905400/AlvinProject/sample_24.jpg");
                break;
            case 3:

                images.add("https://res.cloudinary.com/dj0tzyjwc/image/upload/v1562905420/AlvinProject/sample_3.jpg");
                images.add("https://res.cloudinary.com/dj0tzyjwc/image/upload/v1562905420/AlvinProject/sample_31.jpg");
                images.add("https://res.cloudinary.com/dj0tzyjwc/image/upload/v1562905421/AlvinProject/sample_33.jpg");
                images.add("https://res.cloudinary.com/dj0tzyjwc/image/upload/v1562905421/AlvinProject/sample_34.jpg");
                break;
            case 4:

                images.add("https://res.cloudinary.com/dj0tzyjwc/image/upload/v1562905440/AlvinProject/sample_4.jpg");
                images.add("https://res.cloudinary.com/dj0tzyjwc/image/upload/v1562905440/AlvinProject/sample_41.jpg");
                images.add("https://res.cloudinary.com/dj0tzyjwc/image/upload/v1562905440/AlvinProject/sample_43.jpg");
                images.add("https://res.cloudinary.com/dj0tzyjwc/image/upload/v1562905440/AlvinProject/sample_44.jpg");
                break;
            case 5:

                images.add("https://res.cloudinary.com/dj0tzyjwc/image/upload/v1562905456/AlvinProject/sample_5.jpg");
                images.add("https://res.cloudinary.com/dj0tzyjwc/image/upload/v1562905456/AlvinProject/sample_51.jpg");
                images.add("https://res.cloudinary.com/dj0tzyjwc/image/upload/v1562905456/AlvinProject/sample_53.jpg");
                images.add("https://res.cloudinary.com/dj0tzyjwc/image/upload/v1562905456/AlvinProject/sample_54.jpg");
                break;
        }

             Intent intent = new Intent(context, GalleryActivity.class);
        intent.putStringArrayListExtra(GalleryActivity.EXTRA_NAME, images);
              context.startActivity(intent);
    }
}

