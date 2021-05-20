package com.example.dell.dailyplanner.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.dell.dailyplanner.R;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class PhyAttendanceFragment extends Fragment {

    ListView listView;
    ArrayAdapter <String> adapter;
    ArrayList <String> arrayList;

    public static final String GET_URL= "http://jachaibd.com/lict_brac/Eduhelp/Attendance_PHY111_getData.php";

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle){
        View v= inflater.inflate(R.layout.activity_phy_attendance_fragment, null);

        arrayList=new ArrayList<>();
        listView=v.findViewById(R.id.list_View_call_history);
        adapter=new ArrayAdapter<String>(getActivity(), R.layout.list_view_text_color, arrayList);

        listView.setAdapter(adapter);
        RequestQueue queue = Volley.newRequestQueue(getActivity());

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, GET_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                int length=response.length();

                for (int i=0; i<length; i++){
                    try {
                        String name=response.getJSONObject(i).getString("name");
                        String student_id=response.getJSONObject(i).getString("student_id");
                        String present=response.getJSONObject(i).getString("present");
                        String absent=response.getJSONObject(i).getString("absent");

                        arrayList.add("Student's Name: " + name + "\n" +  "Student ID: " + student_id +
                                "\n"  + "Total Present (40): " + present +  "\n"  + "Total Absent (40): " + absent);
                        adapter.notifyDataSetChanged();
                    }

                    catch (JSONException e) {
                        Log.e("Error", e.toString());
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.e("Error", error.toString());

            }
        });
        queue.add(jsonArrayRequest);
        return v;
    }
}

