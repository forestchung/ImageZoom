package com.codingdemos.imagezoom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

   // ImageView mIcon;

    //new
    //ImageView imageView;
    //PhotoViewAttacher photoViewAttacher;
   // MyPhotoAttacher photoViewAttacher;
    public static final String TAG = "MainActivity";

   //add more Motion Event

   // float initialX, initialY;

    // ArrayList for person names
    //ArrayList<String> personNames = new ArrayList<>(Arrays.asList("Chair 1", "C02", "Chair 3", "Chair 4", "Chair 5", "Chair 6", "Chair 7","Chair 8", "Chair 9", "Chair 10", "Chair 11", "Chair 12", "Chair 13", "Chair 14"));
    //ArrayList<Integer> personImages = new ArrayList<>(Arrays.asList(R.drawable.sample_1, R.drawable.sample_12, R.drawable.sample_13, R.drawable.sample_14, R.drawable.sample_2, R.drawable.sample_22, R.drawable.sample_23,R.drawable.sample_24, R.drawable.sample_3, R.drawable.sample_32, R.drawable.sample_33, R.drawable.sample_34, R.drawable.sample_4, R.drawable.sample_42));
   ArrayList<String> chairNames0 = new ArrayList<>(Arrays.asList("c01", "c02", "c03", "c04", "c05"));
   ArrayList<Integer> chairImages0 = new ArrayList<>(Arrays.asList(R.drawable.sample_1, R.drawable.sample_2, R.drawable.sample_3, R.drawable.sample_4, R.drawable.sample_5 ));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //MyListData[] myListData = new MyListData[3] ;
        //myListData[0] = new MyListData("Email", R.drawable.sample_1);
        //myListData[1] =new MyListData("Info", R.drawable.sample_12);
        //myListData[2] = new MyListData("Delete", R.drawable.sample_13);

        // get the reference of RecyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        // set a LinearLayoutManager with default vertical orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        //  call the constructor of CustomAdapter to send the reference and data to Adapter

        //switch to use new expandable adapter
        CustomAdapter customAdapter = new CustomAdapter(MainActivity.this, chairNames0,chairImages0);


        //-------------------------------------------------------------------------------------
        //remove the expandable list
        /*
        ArrayList<ChairCatalog> chairCatalog = new ArrayList();

        ArrayList<Chair> chairs1 = new ArrayList<>();
        chairs1.add(new Chair("c01",R.drawable.sample_1 ));
        chairs1.add(new Chair("c12", R.drawable.sample_12));
        chairs1.add(new Chair("c13", R.drawable.sample_13));
        chairs1.add(new Chair("c14", R.drawable.sample_14));
        ChairCatalog chairCatalog1 = new ChairCatalog("c01", chairs1);
        chairCatalog.add(chairCatalog1);

        ArrayList<Chair> chairs2 = new ArrayList<>();
        chairs2.add(new Chair("c02", R.drawable.sample_2));
        chairs2.add(new Chair("c21", R.drawable.sample_22));
        chairs2.add(new Chair("c22", R.drawable.sample_23));
        chairs2.add(new Chair("c23", R.drawable.sample_24));
        ChairCatalog chairCatalog2 = new ChairCatalog("c02", chairs2);
        chairCatalog.add(chairCatalog2);

        ArrayList<Chair> chairs3 = new ArrayList<>();
        chairs3.add(new Chair("c03", R.drawable.sample_3));
        chairs3.add(new Chair("c31", R.drawable.sample_32));
        chairs3.add(new Chair("c32", R.drawable.sample_33));
        chairs3.add(new Chair("c33", R.drawable.sample_34));
        ChairCatalog chairCatalog3 = new ChairCatalog("c03", chairs3);
        chairCatalog.add(chairCatalog3);

        ArrayList<Chair> chairs4 = new ArrayList<>();
        chairs4.add(new Chair("c04", R.drawable.sample_4));
        chairs4.add(new Chair("c41", R.drawable.sample_42));
        chairs4.add(new Chair("c42", R.drawable.sample_43));
        chairs4.add(new Chair("c43", R.drawable.sample_44));
        ChairCatalog chairCatalog4 = new ChairCatalog("c04", chairs4);
        chairCatalog.add(chairCatalog4);

        ArrayList<Chair> chairs5 = new ArrayList<>();
        chairs5.add(new Chair("c05", R.drawable.sample_5));
        chairs5.add(new Chair("c51", R.drawable.sample_52));
        chairs5.add(new Chair("c52", R.drawable.sample_53));
        chairs5.add(new Chair("c53", R.drawable.sample_54));
        ChairCatalog chairCatalog5 = new ChairCatalog("c05", chairs5);
        chairCatalog.add(chairCatalog5);

        ChairAdapter customAdapter = new ChairAdapter(chairCatalog);
        */
        //----------------------------------------------------

        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView


        //RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        //MyListAdapter adapter = new MyListAdapter(myListData);
        //recyclerView.setHasFixedSize(true);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setAdapter(adapter);

       // mIcon = findViewById(R.id.ivIcon);
        //Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.nature);
        //RoundedBitmapDrawable mDrawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
        //mDrawable.setCircular(true);
        //mIcon.setImageDrawable(mDrawable);
/*
        mIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.dialog_custom_layout, null);
                Log.d(TAG, "Main onCreate"  );

                PhotoView photoView = mView.findViewById(R.id.imageView);
                photoView.setImageResource(R.drawable.nature);

                //photoViewAttacher = new PhotoViewAttacher(photoView);
                photoViewAttacher = new MyPhotoAttacher(photoView);
               // photoViewAttacher = new PhotoViewAttacher(imageView);

                photoViewAttacher.setOnViewTapListener(new OnViewTapListener() {
                    @Override
                    public void onViewTap(View view, float x, float y) {
                        Instant instant = Instant.now(); // Current moment in UTC.
                        Log.d(TAG, "onViewTap" + x + " " + y + " " + instant.toEpochMilli() );
                       // Log.d(TAG, "motionEvent: " + event.toString());
                    }
                });

                photoViewAttacher.setOnPhotoTapListener(new OnPhotoTapListener() {
                    @Override
                    public void onPhotoTap(ImageView view, float x, float y) {
                        Instant instant = Instant.now(); // Current moment in UTC.
                        Log.d(TAG, "onPhotoTap" + x + " " + y + " " +  instant.toEpochMilli());
                    }
                });
                photoViewAttacher.update();
                mBuilder.setView(mView);
                AlertDialog mDialog = mBuilder.create();
                mDialog.show();
            }
        });
*/

    }
/*
    public void startGalleryActivity() {
        ArrayList<String> images = new ArrayList<String>();
        images.add("http://sourcey.com/images/stock/salvador-dali-metamorphosis-of-narcissus.jpg");
        images.add("http://sourcey.com/images/stock/salvador-dali-the-dream.jpg");
        images.add("http://sourcey.com/images/stock/salvador-dali-persistence-of-memory.jpg");
        images.add("http://sourcey.com/images/stock/simpsons-persistence-of-memory.jpg");
        images.add("http://sourcey.com/images/stock/salvador-dali-the-great-masturbator.jpg");
        Intent intent = new Intent(MainActivity.this, GalleryActivity.class);
        intent.putStringArrayListExtra(GalleryActivity.EXTRA_NAME, images);
        startActivity(intent);
    }
    */

}
