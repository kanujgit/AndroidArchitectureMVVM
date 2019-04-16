package com.algoworks.architectureapp.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

import com.algoworks.architectureapp.R;
import com.algoworks.architectureapp.utils.FontManager;


public class CustomEditText extends AppCompatEditText {

    private final Context context;
    private String typeface;

    public CustomEditText(Context context, String typeface) {
        super(context);
        this.context = context;
        this.typeface = typeface;
    }

    public CustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.context = context;
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.TextView);

        typeface = a.getString(R.styleable.TextView_ctypeface);
        setCTypeFace(typeface);
    }

    @Override
    public void setInputType(int type) {
        super.setInputType(type);
        setCTypeFace(typeface);
    }

    public void setCTypeFace(String tf) {
        typeface = tf;
        if (tf != null) {
            FontManager.getInstance(context).setTypeFace(this, tf);
        }
    }

}
