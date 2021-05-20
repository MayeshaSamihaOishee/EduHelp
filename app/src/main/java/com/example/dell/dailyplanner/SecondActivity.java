package com.example.dell.dailyplanner;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

    ConstraintLayout constraintLayout;
    AnimationDrawable animationDrawable ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);

        constraintLayout = (ConstraintLayout) findViewById(R.id.MainRootLayout);

        animationDrawable = (AnimationDrawable) constraintLayout.getBackground();

        animationDrawable.setEnterFadeDuration(500);

        animationDrawable.setExitFadeDuration(4500);

        animationDrawable.start();

    }

    public void morningclick(View view) {
        Intent intent = new Intent(SecondActivity.this, CourseList.class);
        startActivity(intent);
    }
    public void marksclick(View view) {
        Intent intent = new Intent(SecondActivity.this, Recycler.class);
        startActivity(intent);
    }

    public void attendanceclick(View view) {
        Intent intent = new Intent(SecondActivity.this, TabLayoutAttendance.class);
        startActivity(intent);
    }
}
