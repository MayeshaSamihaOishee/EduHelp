package com.example.dell.dailyplanner;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

public class Recycler extends AppCompatActivity {

    RecyclerView recyclerView;

    Context context;

    RecyclerView.Adapter recyclerView_Adapter;

    RecyclerView.LayoutManager recyclerViewLayoutManager;

    String[] numbers = {
            "CSE110",
            "MAT110",
            "PHY111",
            "ENG101",
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_recycler);

        context = getApplicationContext();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view1);

        //Change 2 to your choice because here 2 is the number of Grid layout Columns in each row.
        recyclerViewLayoutManager = new GridLayoutManager(context, 1);

        recyclerView.setLayoutManager(recyclerViewLayoutManager);

        recyclerView_Adapter = new RecyclerViewAdapter(context,numbers);

        recyclerView.setAdapter(recyclerView_Adapter);

    }
}