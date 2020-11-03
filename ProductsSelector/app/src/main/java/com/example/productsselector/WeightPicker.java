package com.example.productsselector;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.app.AlertDialog;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.example.productsselector.databinding.WeightPickerBinding;

public class WeightPicker {


    public void show(Context context, final OnWeightPickedListener listener){
        WeightPickerBinding b = WeightPickerBinding.inflate(
                LayoutInflater.from(context)
        );

        new AlertDialog.Builder(context)
                .setTitle("Pick Weight")
                .setView(b.getRoot())
                .setPositiveButton("SELECT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                      //  int kg = 0, g = 0;
                        int kg = b.kgNumberpicker.getValue();
                        int g = b.gNumberPicker.getValue();

                        if(kg==0&&g==0){
                            return;
                        }


                        listener.onWeightPicked(kg, g);
                    }
                })
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        listener.onWeightPickerCancelled();
                    }
                })
                .show();

        setupNumberPickers(b.kgNumberpicker,b.gNumberPicker);


    }


    private void setupNumberPickers(NumberPicker numberPicker_kg,NumberPicker numberPicker_g) {
        //TODO 2 : Define this method to setup kg & g NumberPickers as per the given ranges
        //kg Range - 0kg to 10kg
        //g Range - 0g to 950g

        numberPicker_kg.setMinValue(0);
        numberPicker_kg.setMaxValue(10);

        numberPicker_g.setMinValue(0);
        numberPicker_g.setMaxValue(19);

        numberPicker_kg.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int value) {
                return value + " " + "kg";
            }
        });

        numberPicker_g.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int value) {
                return (value * 50) + " " + "g";
            }
        });

        View firstItemKg = numberPicker_g.getChildAt(0);
        if (firstItemKg != null) {
            firstItemKg.setVisibility(View.INVISIBLE);
        }

        View firstItemG = numberPicker_kg.getChildAt(0);
        if (firstItemG != null) {
            firstItemG.setVisibility(View.INVISIBLE);
        }

    }

    interface OnWeightPickedListener{
        void onWeightPicked(int kg, int g);
        void onWeightPickerCancelled();
    }



    }











