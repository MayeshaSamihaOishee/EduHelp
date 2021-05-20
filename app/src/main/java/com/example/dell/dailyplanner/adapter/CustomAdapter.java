package com.example.dell.dailyplanner.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.dailyplanner.R;
import com.example.dell.dailyplanner.model.TypesOfCourses;
import java.util.ArrayList;


public class CustomAdapter extends BaseAdapter {

    Context c;
    ArrayList<TypesOfCourses> arrayList;

    public CustomAdapter(Context c, ArrayList<TypesOfCourses> arrayList) {
        this.c = c;
        this.arrayList = arrayList;
    }

    public CustomAdapter(Context context) {
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View custom_view= inflater.inflate(R.layout.activity_course_grid_items, null);

        ImageView iVtod=custom_view.findViewById(R.id.imageViewTypesOfCourse);
        TextView tVtod=custom_view.findViewById(R.id.textViewTypesOfCourse);

        iVtod.setImageResource(arrayList.get(position).getImageID());
        tVtod.setText(arrayList.get(position).getName());

        return custom_view;
    }
}
