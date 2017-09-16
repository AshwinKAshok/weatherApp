package com.example.ashwi.weatherapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;

/**
 * Created by ashwi on 9/16/2017.
 */

public class AlertDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //return super.onCreateDialog(savedInstanceState);
        Context context= getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setTitle("Oop! Sorry!")
                .setMessage("There was an error pleasee try again")
                .setPositiveButton("OK",null);
        AlertDialog dialog = builder.create();
        return dialog;
    }
}
