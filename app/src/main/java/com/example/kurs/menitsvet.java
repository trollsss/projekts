package com.example.kurs;
import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterViewFlipper;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ViewFlipper;

import androidx.core.content.ContextCompat;

public class menitsvet<mageButton> extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.glavnoe);
        final Button[] prevButton = {null};

        Button buttonRed = findViewById(R.id.button_1);
        buttonRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Если была нажата другая кнопка, сбрасываем ее цвет фона
                if (prevButton[0] != null) {
                    prevButton[0].setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getApplicationContext(), R.color.design_default_color_background1)));
                }
                // Устанавливаем новый цвет фона кнопки
                buttonRed.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getApplicationContext(), R.color.blue)));
                prevButton[0] = buttonRed;
            }
        });

        Button buttonGreen = findViewById(R.id.button_2);
        buttonGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Если была нажата другая кнопка, сбрасываем ее цвет фона
                if (prevButton[0] != null) {
                    prevButton[0].setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getApplicationContext(), R.color.design_default_color_background1)));
                }
                // Устанавливаем новый цвет фона кнопки
                buttonGreen.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getApplicationContext(), R.color.blue)));
                prevButton[0] = buttonGreen;
            }
        });
        Button buttonBlue = findViewById(R.id.button_3);
        buttonBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Если была нажата другая кнопка, сбрасываем ее цвет фона
                if (prevButton[0] != null) {
                    prevButton[0].setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getApplicationContext(), R.color.design_default_color_background1)));
                }
                // Устанавливаем новый цвет фона кнопки
                buttonBlue.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getApplicationContext(), R.color.blue)));
                prevButton[0] = buttonBlue;
            }
        });
        ImageButton imageButton1 = findViewById(R.id.image_Button1);
        ImageButton imageButton2 = findViewById(R.id.image_Button_2);
        ColorFilter originalColorFilter1 = imageButton1.getColorFilter();
        ColorFilter originalColorFilter2 = imageButton2.getColorFilter();

        View.OnClickListener onClickListener = new View.OnClickListener() {
            ImageButton prevButton = null;
            @Override
            public void onClick(View v) {
                if (prevButton != null) {
                    prevButton.setColorFilter(originalColorFilter1);
                }
                if (prevButton != v) {
                    ((ImageButton) v).setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_ATOP);
                    prevButton = (ImageButton) v;
                } else {
                    prevButton = null;
                }
            }
        };

        imageButton1.setOnClickListener(onClickListener);
        imageButton2.setOnClickListener(onClickListener);
    }

}
