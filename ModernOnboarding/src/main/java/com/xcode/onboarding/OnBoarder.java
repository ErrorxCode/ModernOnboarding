package com.xcode.onboarding;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import java.util.List;

public class OnBoarder {

    public static void startOnBoarding(@NonNull Activity activity, @NonNull List<OnBoardingPage> pages, @Nullable OnFinishLastPage onFinishClick){
        if (pages.size() < 3 || pages.size() > 6)
            throw new MaterialGuidelinesViolationException("This library follows material design guidelines and according to that, On-boarding screen must be of at least 3 & at most 6 pages");
        activity.setContentView(R.layout.activity_onbording);
        activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        if (activity instanceof AppCompatActivity){
            AppCompatActivity app = (AppCompatActivity) activity;
            if (app.getSupportActionBar() != null)
                app.getSupportActionBar().hide();
        } else {
            if (activity.getActionBar() != null)
                activity.getActionBar().hide();
        }

        Button next = activity.findViewById(R.id.next);
        ViewPager2 pager = activity.findViewById(R.id.viewpager);
        LinearLayout indicator = activity.findViewById(R.id.indicator);
        ViewPagerAdapter adapter = new ViewPagerAdapter(pages);
        TextView[] dots = new TextView[pages.size()];
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(activity);
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
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentPage = pager.getCurrentItem();
                if (currentPage == pages.size() - 1){
                    if (onFinishClick != null){
                        onFinishClick.onNext();
                    } else {
                        activity.finish();
                    }
                } else
                    pager.setCurrentItem(currentPage + 1);
            }
        });
    }
}

class MaterialGuidelinesViolationException extends RuntimeException {
    public MaterialGuidelinesViolationException(String message){
        super(message);
    }
}
