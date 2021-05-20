package com.example.dell.dailyplanner;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.dell.dailyplanner.adapter.ViewPagerAdapter;
import com.example.dell.dailyplanner.fragment.CseAttendanceFragment;
import com.example.dell.dailyplanner.fragment.EngAttendanceFragment;
import com.example.dell.dailyplanner.fragment.LoginFragment;
import com.example.dell.dailyplanner.fragment.MatAttendanceFragment;
import com.example.dell.dailyplanner.fragment.PhyAttendanceFragment;
import com.example.dell.dailyplanner.fragment.SignupFragment;

public class TabLayoutAttendance extends AppCompatActivity {

    Toolbar toolBar;
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout_attendance);

        tabLayout = (TabLayout)findViewById(R.id.tabLayout1);
        viewPager=(ViewPager) findViewById(R.id.viewPager1);

        setSupportActionBar(toolBar);
        setDataToViewPager();
        tabLayout.setupWithViewPager(viewPager);
    }


    private void setDataToViewPager() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment4(new CseAttendanceFragment(), "CSE110");
        adapter.addFragment4(new MatAttendanceFragment(), "MAT110");
        adapter.addFragment4(new PhyAttendanceFragment(), "PHY111");
        adapter.addFragment4(new EngAttendanceFragment(), "ENG101");
        viewPager.setAdapter(adapter);
    }
}
