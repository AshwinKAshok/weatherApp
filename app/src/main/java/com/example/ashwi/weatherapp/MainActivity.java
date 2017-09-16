package com.example.ashwi.weatherapp;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String apiKEY="ce1ee29102b40e836ba66130b2053d01";

        double latitude=37.8267;
        double longitude=-122.4233;

        String forecastURL="https://api.darksky.net/forecast/" + apiKEY + "/"+latitude+","+longitude;

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(forecastURL).build();

        final String TAG = MainActivity.class.getSimpleName();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    Log.v( TAG, response.body().string());
                    if(response.isSuccessful()){

                    }
                    else
                    {
                        onErrorAlert();
                    }
                } catch (IOException e) {
                    Log.e( TAG,"Exception caught",e);
                }

            }
        });



    }

    private void onErrorAlert() {
        AlertDialogFragment dialog = new AlertDialogFragment();
        dialog.show(getFragmentManager(),"Erro_dialog");
    }
}
