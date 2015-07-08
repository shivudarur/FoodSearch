package com.holmusk.foodsearch.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.holmusk.foodsearch.utils.Typefaces;


public class TextViewCustomFont extends TextView {
    private Typeface mTypeface;

    @SuppressLint("ResourceAsColor")
    public TextViewCustomFont(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (mTypeface == null)
            mTypeface = Typefaces
                    .get(context, "fonts/Volkswagen-Demi-Bold.ttf");
        setTypeface(mTypeface);
    }
}