package com.example.ashwi.weatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String apiKEY="ce1ee29102b40e836ba66130b2053d01";
        double lattitude=37.8267;
        double longitude=-122.4233;

        String forecastURL="https://api.darksky.net/forecast/" + apiKEY + "/"+lattitude+","+longitude;

        OkHttpClient client = new OkHttpClient();
    }
}
