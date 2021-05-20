package com.example.dell.dailyplanner;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class WebViewPhysics extends AppCompatActivity {

    ConstraintLayout constraintLayout;
    AnimationDrawable animationDrawable ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_physics);

        constraintLayout = (ConstraintLayout) findViewById(R.id.MainRootLayout);

        animationDrawable = (AnimationDrawable) constraintLayout.getBackground();

        animationDrawable.setEnterFadeDuration(10);

        animationDrawable.setExitFadeDuration(4500);

        animationDrawable.start();
    }

    public void msr(View view) {
        Intent intent = new Intent(WebViewPhysics.this, MSR.class);
        startActivity(intent);
    }

    public void fhh(View view) {
        Intent intent = new Intent(WebViewPhysics.this, FHH.class);
        startActivity(intent);
    }

    public void mlr(View view) {
        Intent intent = new Intent(WebViewPhysics.this, MLR.class);
        startActivity(intent);
    }

    public void msb(View view) {
        Intent intent = new Intent(WebViewPhysics.this, MSB.class);
        startActivity(intent);
    }
}
