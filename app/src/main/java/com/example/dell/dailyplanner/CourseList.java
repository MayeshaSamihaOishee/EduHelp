package com.example.dell.dailyplanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.dell.dailyplanner.adapter.CustomAdapter;
import com.example.dell.dailyplanner.model.TypesOfCourses;

import java.util.ArrayList;

public class CourseList extends AppCompatActivity {

    GridView grid_view;
    ArrayList<TypesOfCourses> typesOfCourses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);

        GridView grid_view = (GridView)findViewById(R.id.grid_view);

        typesOfCourses=new ArrayList<>();
        setData();

        CustomAdapter adapter = new CustomAdapter(CourseList.this, typesOfCourses);
        grid_view.setAdapter(adapter);

        grid_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Intent intent = null;
                switch(position)
                {
                    case 0:
                        intent =  new Intent( CourseList.this,MorningActivity.class);
                        break;
                    case 1:
                        intent =  new Intent( CourseList.this,Physics.class);
                        break;
                    case 2:
                        intent =  new Intent( CourseList.this,English.class);
                        break;
                    case 3:
                        intent =  new Intent(CourseList.this,Mat.class);
                        break;
                }
                startActivity(intent);
            }
        });

    }

    private void setData() {
        TypesOfCourses CSE110 = new TypesOfCourses(R.drawable.cse, "CSE110");
        TypesOfCourses PHY111 = new TypesOfCourses(R.drawable.phy, "PHY111");
        TypesOfCourses ENG101 = new TypesOfCourses(R.drawable.eng, "ENG101");
        TypesOfCourses MAT110 = new TypesOfCourses(R.drawable.mat, "MAT110");

        typesOfCourses.add(CSE110);
        typesOfCourses.add(PHY111);
        typesOfCourses.add(ENG101);
        typesOfCourses.add(MAT110);
    }
}
