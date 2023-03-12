package com.xcode.onboarding;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class MaterialOnBoarding {
    protected static OnFinishLastPage callback;
    protected static boolean isSuppressed;

    public static void setupOnBoarding(@NonNull Activity activity, @NonNull ArrayList<OnBoardingPage> pages, @Nullable OnFinishLastPage callback){
        SharedPreferences pref = activity.getSharedPreferences("main", Context.MODE_PRIVATE);
        MaterialOnBoarding.callback = callback;

        if (!isSuppressed && (pages.size() < 3 || pages.size() > 6))
            throw new MaterialGuidelinesViolationException("A good On-boarding screen must be of at least 3 & at most 6 pages");
        else {
            if (!pref.getBoolean("hasIntroduced",false))
                activity.startActivity(new Intent(activity,OnBoardingActivity.class).putParcelableArrayListExtra("pages", pages));
        }
    }

    public static void suppressGuidelines(){
        isSuppressed = true;
    }
}

