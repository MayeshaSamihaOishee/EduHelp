package com.example.dell.dailyplanner;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.daimajia.slider.library.SliderLayout;
import java.util.ArrayList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;


public class Mat extends AppCompatActivity {
    PieChart pieChart;
    ArrayList<Entry> entries;
    ArrayList<String> PieEntryLabels;
    PieDataSet pieDataSet;
    PieData pieData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mat);

        pieChart = (PieChart) findViewById(R.id.chart1);

        entries = new ArrayList<>();

        PieEntryLabels = new ArrayList<String>();

        AddValuesToPIEENTRY();

        AddValuesToPieEntryLabels();

        pieDataSet = new PieDataSet(entries, "");

        pieData = new PieData(PieEntryLabels, pieDataSet);

        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        pieChart.setData(pieData);

        pieChart.animateY(3000);

    }

    public void AddValuesToPIEENTRY() {

        entries.add(new BarEntry(5f, 0));
        entries.add(new BarEntry(5f, 1));
        entries.add(new BarEntry(25f, 2));
        entries.add(new BarEntry(20f, 3));
        entries.add(new BarEntry(45f, 4));
    }

    public void AddValuesToPieEntryLabels() {

        PieEntryLabels.add("Attendance");
        PieEntryLabels.add("Assignments");
        PieEntryLabels.add("Quizzes");
        PieEntryLabels.add("MidTerm Exam");
        PieEntryLabels.add("Final Exam");
    }

    public void buttontowebview(View view) {
        Intent intent = new Intent(Mat.this, WebViewMat.class);
        startActivity(intent);
    }
}
