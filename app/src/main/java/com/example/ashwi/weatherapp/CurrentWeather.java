package com.example.ashwi.weatherapp;

/**
 * Created by ashwi on 9/18/2017.
 */

public class CurrentWeather {
    private String mIcon;
    private long mTime;
    private double mTeamperature;
    private double mHumidty;
    private double mPrecipitation;
    private String mSummery;

    public String getmIcon() {
        return mIcon;
    }

    public void setmIcon(String mIcon) {
        this.mIcon = mIcon;
    }

    public long getmTime() {
        return mTime;
    }

    public void setmTime(long mTime) {
        this.mTime = mTime;
    }

    public double getmTeamperature() {
        return mTeamperature;
    }

    public void setmTeamperature(double mTeamperature) {
        this.mTeamperature = mTeamperature;
    }

    public double getmHumidty() {
        return mHumidty;
    }

    public void setmHumidty(double mHumidty) {
        this.mHumidty = mHumidty;
    }

    public double getmPrecipitation() {
        return mPrecipitation;
    }

    public void setmPrecipitation(double mPrecipitation) {
        this.mPrecipitation = mPrecipitation;
    }

    public String getmSummery() {
        return mSummery;
    }

    public void setmSummery(String mSummery) {
        this.mSummery = mSummery;
    }
}
