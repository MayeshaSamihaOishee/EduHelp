package com.example.dell.dailyplanner;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class WebViewMat extends AppCompatActivity {

    ConstraintLayout constraintLayout;
    AnimationDrawable animationDrawable ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_mat);

        constraintLayout = (ConstraintLayout) findViewById(R.id.MainRootLayout);

        animationDrawable = (AnimationDrawable) constraintLayout.getBackground();

        animationDrawable.setEnterFadeDuration(10);

        animationDrawable.setExitFadeDuration(4500);

        animationDrawable.start();
    }

    public void amr(View view) {
        Intent intent = new Intent(WebViewMat.this, AMR.class);
        startActivity(intent);
    }

    public void san(View view) {
        Intent intent = new Intent(WebViewMat.this, SAN.class);
        startActivity(intent);
    }

    public void hna(View view) {
        Intent intent = new Intent(WebViewMat.this, HNA.class);
        startActivity(intent);
    }

    public void sdh(View view) {
        Intent intent = new Intent(WebViewMat.this, SDH.class);
        startActivity(intent);
    }

    public void mfa(View view) {
        Intent intent = new Intent(WebViewMat.this, MFA.class);
        startActivity(intent);
    }

    public void mhm(View view) {
        Intent intent = new Intent(WebViewMat.this, MHM.class);
        startActivity(intent);
    }

    public void aqd(View view) {
        Intent intent = new Intent(WebViewMat.this, AQD.class);
        startActivity(intent);
    }

    public void mzk(View view) {
        Intent intent = new Intent(WebViewMat.this, MZK.class);
        startActivity(intent);
    }
}
