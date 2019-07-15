package com.codingdemos.imagezoom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    public static final String TAG = "MainActivity";
    Logger logger = Logger.getInstance();
    ArrayList<String> chairNames0 = new ArrayList<>(Arrays.asList("c01", "c02", "c03", "c04", "c05"));
   ArrayList<Integer> chairImages0 = new ArrayList<>(Arrays.asList(R.drawable.sample_1, R.drawable.sample_2, R.drawable.sample_3, R.drawable.sample_4, R.drawable.sample_5 ));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            logger.log("App started");
        // get the reference of RecyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        // set a LinearLayoutManager with default vertical orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        //switch to use new expandable adapter
        CustomAdapter customAdapter = new CustomAdapter(MainActivity.this, chairNames0,chairImages0);

        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView
    }

}
