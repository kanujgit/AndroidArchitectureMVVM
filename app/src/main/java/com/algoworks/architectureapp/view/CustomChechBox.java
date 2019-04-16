package com.algoworks.architectureapp.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.CheckBox;

import com.algoworks.architectureapp.R;
import com.algoworks.architectureapp.utils.FontManager;

public class CustomChechBox extends CheckBox {

    private String typeFace;
    private final Context context;
    private final ColorStateList textColors;

    public CustomChechBox(Context context, String typeface) {
        super(context);
        this.context = context;
        setCTypeFace(typeface);
        textColors = getTextColors();
    }

    public CustomChechBox(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.TextView);

        String typeface = a.getString(R.styleable.TextView_ctypeface);
        setCTypeFace(typeface);
        textColors = getTextColors();
    }

    public String getCTypeFace() {
        return typeFace;
    }

    public void setCTypeFace(String tf) {
        typeFace = tf;
        if (tf != null) {
            FontManager.getInstance(context).setTypeFace(this, tf);
        }
    }
}
