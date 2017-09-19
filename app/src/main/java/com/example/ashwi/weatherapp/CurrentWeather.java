package com.example.ashwi.weatherapp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by ashwi on 9/18/2017.
 */

public class CurrentWeather {
    private String mIcon;
    private long mTime;
    private double mTeamperature;
    private double mHumidity;
    private double mPrecipitation;
    private String mSummery;
    private String mTimeZone;

    public String getmTimeZone() {
        return mTimeZone;
    }

    public void setmTimeZone(String mTimeZone) {
        this.mTimeZone = mTimeZone;
    }

    public String getmIcon() {
        return mIcon;
    }

    public void setmIcon(String mIcon) {
        this.mIcon = mIcon;
    }

    public long getmTime() {
        return mTime;
    }

    public int getIconId()
    {
        int iconId = R.drawable.clear_day;
        if (mIcon.equals("clear-day")) {
            iconId = R.drawable.clear_day;
        }
        else if (mIcon.equals("clear-night")) {
            iconId = R.drawable.clear_night;
        }
        else if (mIcon.equals("rain")) {
            iconId = R.drawable.rain;
        }
        else if (mIcon.equals("snow")) {
            iconId = R.drawable.snow;
        }
        else if (mIcon.equals("sleet")) {
            iconId = R.drawable.sleet;
        }
        else if (mIcon.equals("wind")) {
            iconId = R.drawable.wind;
        }
        else if (mIcon.equals("fog")) {
            iconId = R.drawable.fog;
        }
        else if (mIcon.equals("cloudy")) {
            iconId = R.drawable.cloudy;
        }
        else if (mIcon.equals("partly-cloudy-day")) {
            iconId = R.drawable.partly_cloudy;
        }
        else if (mIcon.equals("partly-cloudy-night")) {
            iconId = R.drawable.cloudy_night;
        }

        return iconId;
    }




    public void setmTime(long mTime) {
        this.mTime = mTime;
    }

    public String getFormattedTime()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("h:mm a");
        formatter.setTimeZone(TimeZone.getTimeZone(getmTimeZone()));
        Date dateTime = new Date(getmTime()*1000);
        String timeString = formatter.format(dateTime);
        return timeString;
    }

    public int getmTeamperature() {
        return (int)Math.round(mTeamperature);
    }

    public void setmTeamperature(double mTeamperature) {
        this.mTeamperature = mTeamperature;
    }

    public double getmHumidity() {
        return mHumidity;
    }

    public void setmHumidity(double mHumidity) {
        this.mHumidity = mHumidity;
    }

    public int getmPrecipitation() {
        double precipChance = mPrecipitation*100;

        return (int)Math.round(precipChance);
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
