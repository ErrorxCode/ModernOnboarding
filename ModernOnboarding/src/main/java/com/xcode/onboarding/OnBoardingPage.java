package com.xcode.onboarding;

import android.graphics.Color;

public class OnBoardingPage {
    private int image;
    private int bgColor;
    private int txtColor;
    private String title;
    private String description;


    public OnBoardingPage(int image, int bgColor, int txtColor, String title, String description) {
        this.title = title;
        this.bgColor = bgColor;
        this.txtColor = txtColor;
        this.image = image;
        this.description = description;
    }

    public OnBoardingPage(int image, String title, String description) {
        this.title = title;
        this.image = image;
        bgColor = Color.WHITE;
        this.description = description;
    }

    public int getBgColor() {
        return bgColor;
    }

    public void setBgColor(int bgColor) {
        this.bgColor = bgColor;
    }

    public int getTxtColor() {
        return txtColor;
    }

    public void setTxtColor(int txtColor) {
        this.txtColor = txtColor;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
