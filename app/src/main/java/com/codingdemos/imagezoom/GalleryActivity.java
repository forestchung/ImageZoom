package com.codingdemos.imagezoom;


import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

import junit.framework.Assert;

import java.time.Instant;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;



public class GalleryActivity extends AppCompatActivity {
    public static final String TAG = "GalleryActivity";
    public static final String EXTRA_NAME = "images";

    private ArrayList<String> _images;
    private GalleryPagerAdapter _adapter;

   Logger logger = Logger.getInstance();

    @BindView(R.id.pager) ViewPager _pager;
    @BindView(R.id.thumbnails) LinearLayout _thumbnails;
    @BindView(R.id.btn_close) ImageButton _closeButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        ButterKnife.bind(this);

       _images = (ArrayList<String>) getIntent().getSerializableExtra(EXTRA_NAME);

        Assert.assertNotNull(_images);

        _adapter = new GalleryPagerAdapter(this);
        _pager.setAdapter(_adapter);
        _pager.setOffscreenPageLimit(6); // how many images to load into memory

        _closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Instant instant = Instant.now(); // Current moment in UTC.
                Log.d(TAG, "Close photo zoom Timestamp: -"+instant.toEpochMilli());
logger.log("Close photo zoom Timestamp: -"+instant.toEpochMilli());

                finish();
            }
        });
    }

    class GalleryPagerAdapter extends PagerAdapter {

        Context _context;
        LayoutInflater _inflater;

        public GalleryPagerAdapter(Context context) {
            _context = context;
            _inflater = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return _images.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((LinearLayout) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            View itemView = _inflater.inflate(R.layout.pager_gallery_item, container, false);
            container.addView(itemView);

            // Get the border size to show around each image
            int borderSize = _thumbnails.getPaddingTop();

            // Get the size of the actual thumbnail image
            int thumbnailSize = ((FrameLayout.LayoutParams)
                    _pager.getLayoutParams()).bottomMargin - (borderSize*2);

            // Set the thumbnail layout parameters. Adjust as required
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(thumbnailSize, thumbnailSize);
            params.setMargins(0, 0, borderSize, 0);

            // You could also set like so to remove borders
            //ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
            //        ViewGroup.LayoutParams.WRAP_CONTENT,
            //        ViewGroup.LayoutParams.WRAP_CONTENT);

            final ImageView thumbView = new ImageView(_context);
            thumbView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            thumbView.setLayoutParams(params);
            thumbView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  //  Log.d(TAG, "Thumbnail clicked position: " + position );

                    // Write a message to the database
                    Instant instant = Instant.now(); // Current moment in UTC.
                   // Log.d("Touch","Timestamp: -"+instant.toEpochMilli());
                    Log.d(TAG, " Timestamp: -"+instant.toEpochMilli() + " Thumbnail clicked position: " + position );
logger.log(" Timestamp: -"+instant.toEpochMilli() + " Thumbnail clicked position: " + position );

                    _pager.setCurrentItem(position);
                }
            });
            _thumbnails.addView(thumbView);

            //--------------------------------

            final SubsamplingScaleImageView imageView =
                    (SubsamplingScaleImageView) itemView.findViewById(R.id.image_gallery);



            // Asynchronously load the image and set the thumbnail and pager view
            Glide.with(_context)
                    .load(_images.get(position))
                    .asBitmap()
                    .into(new SimpleTarget<Bitmap>() {
                        @Override
                        public void onResourceReady(Bitmap bitmap, GlideAnimation anim) {
                            imageView.setImage(ImageSource.bitmap(bitmap));
                            thumbView.setImageBitmap(bitmap);
                            //important-----------------------------------------------------
                            // imageView.setOnTouchListener(handleTouch);
                        }
                    });
            //important-----------------------------------------------------
            imageView.setOnTouchListener(handleTouch);
            return itemView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((LinearLayout) object);

        }
    }



    private View.OnTouchListener handleTouch = new View.OnTouchListener() {

        @Override
        public boolean onTouch(View v, MotionEvent event) {

            int x = (int) event.getX();
            int y = (int) event.getY();

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    Log.i("TAG", "touched down");
                    break;

                    /* cannot use action move, otherwise the zoom will not work
                case MotionEvent.ACTION_MOVE:
                    Log.i("TAG", "moving: (" + x + ", " + y + ")");
                    break;
                    */
                case MotionEvent.ACTION_UP:
                   Log.i("TAG", "touched up");
                    break;
                default:
                   // Log.d("TAG", "moving: (" + x + ", " + y + ")");
                    return false;
            }


            Instant instant = Instant.now(); // Current moment in UTC.


Log.d(TAG, "Action: " + event.getAction() + " Event: " + event.toString() + " Pressure: " + event.getSize() + " moving: (" + x + ", " + y + ")");
         logger.log("Action: " + event.getAction() + " Event: " + event.toString() + " Pressure: " + event.getSize() + " moving: (" + x + ", " + y + ")");

            return true;
        }
    };


}
