package com.xcode.onboarding;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class OnBoardingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onbording);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        if (getSupportActionBar() != null)
            getSupportActionBar().hide();

        Button next = findViewById(R.id.next);
        ViewPager2 pager = findViewById(R.id.viewpager);
        LinearLayout indicator = findViewById(R.id.indicator);

        ArrayList<OnBoardingPage> pages = getIntent().getParcelableArrayListExtra("pages");
        ViewPagerAdapter adapter = new ViewPagerAdapter(pages);
        TextView[] dots = new TextView[pages.size()];
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText("•");
            dots[i].setTextSize(40);
            indicator.addView(dots[i]);
        }

        pager.setAdapter(adapter);
        pager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                if (position != 0)
                    dots[position - 1].setTextColor(Color.GRAY);
                if (position < pages.size() - 1)
                    dots[position + 1].setTextColor(Color.GRAY);
                if (position == pages.size() - 1)
                    next.setText("Finish");
                else
                    next.setText("Next");
                dots[position].setTextColor(Color.BLUE);
            }
        });

        next.setOnClickListener(v -> {
            SharedPreferences.Editor pref = getSharedPreferences("main", Context.MODE_PRIVATE).edit();
            int currentPage = pager.getCurrentItem();
            if (currentPage == pages.size() - 1){
                pref.putBoolean("hasIntroduced",true).apply();
                if (MaterialOnBoarding.callback != null){
                    MaterialOnBoarding.callback.onNext();
                }
                finish();
            } else
                pager.setCurrentItem(currentPage + 1);
        });
    }
}