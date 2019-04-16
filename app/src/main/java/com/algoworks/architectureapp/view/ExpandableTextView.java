package com.algoworks.architectureapp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class ExpandableTextView extends TextView {

    public ExpandableTextView(Context context) {
        super(context);
    }

    public ExpandableTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public ExpandableTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public interface OnLayoutListener {
        void onLayouted(TextView view);
    }

    private OnLayoutListener mOnLayoutListener;

    public void setOnLayoutListener(OnLayoutListener listener) {
        mOnLayoutListener = listener;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right,
                            int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (mOnLayoutListener != null) {
            mOnLayoutListener.onLayouted(this);
        }
    }

    @Override
    public void setMaxLines(int maxLines) {
        super.setMaxLines(maxLines);
    }
}