package com.example.dell.dailyplanner;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class WebView extends AppCompatActivity {

    ConstraintLayout constraintLayout;
    AnimationDrawable animationDrawable ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        constraintLayout = (ConstraintLayout) findViewById(R.id.MainRootLayout);

        animationDrawable = (AnimationDrawable) constraintLayout.getBackground();

        animationDrawable.setEnterFadeDuration(10);

        animationDrawable.setExitFadeDuration(4500);

        animationDrawable.start();
    }

    public void dc(View view) {
        Intent intent = new Intent(WebView.this, DC.class);
        startActivity(intent);
    }

    public void sai(View view) {
        Intent intent = new Intent(WebView.this, SAI.class);
        startActivity(intent);
    }

    public void rak(View view) {
        Intent intent = new Intent(WebView.this, RAK.class);
        startActivity(intent);
    }
}
