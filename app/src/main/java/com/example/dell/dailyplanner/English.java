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


public class English extends AppCompatActivity {
    PieChart pieChart;
    ArrayList<Entry> entries;
    ArrayList<String> PieEntryLabels;
    PieDataSet pieDataSet;
    PieData pieData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english);

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

        entries.add(new BarEntry(10f, 0));
        entries.add(new BarEntry(10f, 1));
        entries.add(new BarEntry(20f, 2));
        entries.add(new BarEntry(30f, 3));
        entries.add(new BarEntry(6f, 4));
        entries.add(new BarEntry(6f, 5));
        entries.add(new BarEntry(5f, 6));
        entries.add(new BarEntry(8f, 7));
        entries.add(new BarEntry(5f, 8));
    }

    public void AddValuesToPieEntryLabels() {

        PieEntryLabels.add("Portfolio");
        PieEntryLabels.add("Assignment");
        PieEntryLabels.add("Midterm Exam");
        PieEntryLabels.add("Final Exam");
        PieEntryLabels.add("MidTerm (SpeakingTest)");
        PieEntryLabels.add("Group Presentation (Average)");
        PieEntryLabels.add("Listening Quiz");
        PieEntryLabels.add("Final Presentation (Individual)");
        PieEntryLabels.add("Attendance");
    }

    public void buttontowebview(View view) {
        Intent intent = new Intent(English.this, WebViewEnglish.class);
        startActivity(intent);
    }
}
