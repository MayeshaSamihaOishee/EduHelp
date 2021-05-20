package com.example.dell.dailyplanner;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.dell.dailyplanner.adapter.ViewPagerAdapter;
import com.example.dell.dailyplanner.fragment.LoginFragment;
import com.example.dell.dailyplanner.fragment.SignupFragment;

public class TabLayoutCourses extends AppCompatActivity {

    Toolbar toolBar;
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout_courses);

        tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        viewPager=(ViewPager) findViewById(R.id.viewPager);

        setSupportActionBar(toolBar);
        setDataToViewPager();
        tabLayout.setupWithViewPager(viewPager);
    }


    private void setDataToViewPager() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new LoginFragment(), "Login");
        adapter.addFragment(new SignupFragment(), "SignUp");
        viewPager.setAdapter(adapter);
    }
}
