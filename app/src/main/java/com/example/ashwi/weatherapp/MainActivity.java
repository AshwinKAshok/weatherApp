package com.example.ashwi.weatherapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {
    final String TAG = MainActivity.class.getSimpleName();
    private CurrentWeather mCurrentWeather;


    @BindView(R.id.timeLabel) TextView mTimeLabel;
    @BindView(R.id.temperatureLabel) TextView mTemperatureLabel;
    @BindView(R.id.humidityValue) TextView mHumidityValue;
    @BindView(R.id.precipValue) TextView mPrecipValue;
    @BindView(R.id.summary) TextView mSummaryLabel;
    @BindView(R.id.iconImageView) ImageView mIconImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        String apiKEY="ce1ee29102b40e836ba66130b2053d01";

        double latitude=37.8267;
        double longitude=-122.4233;

        String forecastURL="https://api.darksky.net/forecast/" + apiKEY + "/"+latitude+","+longitude;
        if(isNetworkAvailable()) {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url(forecastURL).build();



            Call call = client.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    try {
                        String jsonData = response.body().string();
                        Log.v(TAG,"Hello");
                        Log.v(TAG, jsonData);
                        if (response.isSuccessful()) {
                            mCurrentWeather = getCurrentDetails(jsonData);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                   updateDisplay();
                                }
                            });

                        } else {
                            onErrorAlert();
                        }
                    } catch (IOException e) {
                        Log.e(TAG, "Exception caught", e);
                    }
                    catch (JSONException e)
                    {
                        Log.e(TAG, "Exception caught", e);
                    }

                }
            });
        }
        else{
            Toast.makeText(this, "Network is unavailable", Toast.LENGTH_LONG).show();
        }



    }

    private void updateDisplay() {
        mTemperatureLabel.setText(mCurrentWeather.getmTeamperature()+"");
        mTimeLabel.setText("At "+ mCurrentWeather.getFormattedTime() + " it will be");
        mHumidityValue.setText(mCurrentWeather.getmHumidity()+"");
        mPrecipValue.setText(mCurrentWeather.getmPrecipitation() +"%");
        mSummaryLabel.setText(mCurrentWeather.getmSummery());

        Drawable drawable = getResources().getDrawable(mCurrentWeather.getIconId());
        mIconImageView.setImageDrawable(drawable);


    }

    private CurrentWeather getCurrentDetails(String jsonData) throws JSONException{
        JSONObject forecast = new JSONObject(jsonData);
        String timezone = forecast.getString("timezone");
        Log.i(TAG,"From JSON :"+ timezone);

        JSONObject currently = forecast.getJSONObject("currently");
        CurrentWeather currentWeather= new CurrentWeather();
        currentWeather.setmHumidity(currently.getDouble("humidity"));
        currentWeather.setmTime(currently.getLong("time"));
        currentWeather.setmPrecipitation(currently.getDouble("precipProbability"));
        currentWeather.setmIcon(currently.getString("icon"));
        currentWeather.setmSummery(currently.getString("summary"));
        currentWeather.setmTeamperature(currently.getDouble("temperature"));
        currentWeather.setmTimeZone(timezone);

        try{
            Log.d(TAG,currentWeather.getFormattedTime());
        }
        catch (Exception e)
        {
            Log.e(TAG,"Exception is :",e);
        }

        return currentWeather;

    }

    private boolean isNetworkAvailable() {
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        boolean isAvailable = false;
        if(networkInfo != null && networkInfo.isConnected())
        {
            isAvailable=true;
        }
        return isAvailable;
    }

    private void onErrorAlert() {
        AlertDialogFragment dialog = new AlertDialogFragment();
        dialog.show(getFragmentManager(),"Erro_dialog");
    }
}
