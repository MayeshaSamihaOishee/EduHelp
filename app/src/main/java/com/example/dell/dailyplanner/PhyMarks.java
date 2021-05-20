package com.example.dell.dailyplanner;

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

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class PhyMarks extends AppCompatActivity {

    ListView listView;
    ArrayAdapter<String> adapter;
    ArrayList<String> arrayList;

    public static final String GET_URL= "http://jachaibd.com/lict_brac/Eduhelp/PHY111marks_getData.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phy_marks);

        arrayList=new ArrayList<>();
        listView=findViewById(R.id.list_View_call_history);
        adapter=new ArrayAdapter<String>(PhyMarks.this, R.layout.list_view_text_color, arrayList);

        listView.setAdapter(adapter);
        RequestQueue queue = Volley.newRequestQueue(PhyMarks.this);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, GET_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                int length=response.length();

                for (int i=0; i<length; i++){
                    try {
                        String name=response.getJSONObject(i).getString("name");
                        String student_id=response.getJSONObject(i).getString("student_id");
                        String quiz=response.getJSONObject(i).getString("quiz");
                        String mid=response.getJSONObject(i).getString("mid");
                        String f=response.getJSONObject(i).getString("final");
                        String lab=response.getJSONObject(i).getString("lab");
                        String assignment=response.getJSONObject(i).getString("assignment");

                        arrayList.add("Student's Name: " + name + "\n" +  "Student ID: " + student_id +
                                "\n"  + "Quiz Marks (20): " + quiz +  "\n"  + "Midterm Marks (20): " + mid +
                                "\n"  + "Assignment Marks (5): " + assignment
                                +  "\n"  + "Final Marks (40): " + f +  "\n"  + "Lab Marks (10): " + lab);
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
    }
}

