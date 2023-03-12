package com.xcode.onboarding;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;

public class OnBoardingPage implements Parcelable {
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
        txtColor = Color.BLACK;
        this.description = description;
    }

    protected OnBoardingPage(Parcel in) {
        image = in.readInt();
        bgColor = in.readInt();
        txtColor = in.readInt();
        title = in.readString();
        description = in.readString();
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(image);
        dest.writeInt(bgColor);
        dest.writeInt(txtColor);
        dest.writeString(title);
        dest.writeString(description);
    }

    public static final Creator<OnBoardingPage> CREATOR = new Creator<OnBoardingPage>() {
        @Override
        public OnBoardingPage createFromParcel(Parcel in) {
            return new OnBoardingPage(in);
        }

        @Override
        public OnBoardingPage[] newArray(int size) {
            return new OnBoardingPage[size];
        }
    };
}
