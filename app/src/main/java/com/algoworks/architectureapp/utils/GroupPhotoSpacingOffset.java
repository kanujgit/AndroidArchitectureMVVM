package com.algoworks.architectureapp.utils;


import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.DimenRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class GroupPhotoSpacingOffset extends RecyclerView.ItemDecoration {

    private final int mItemOffset;
    private  int  colVal;

    public GroupPhotoSpacingOffset(int itemOffset ) {
        mItemOffset = itemOffset;
    }

    public void setColumnValue(int column)
    {
        this.colVal = column;
    }
    public GroupPhotoSpacingOffset(@NonNull Context context, @DimenRes int itemOffsetId) {
        this(context.getResources().getDimensionPixelSize(itemOffsetId));
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                               RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);


        int position = parent.getChildLayoutPosition(view);

       /* if(position%colVal==0)
        {
            // set left side , top , right , bottom
            outRect.set(2*mItemOffset, 2*mItemOffset, mItemOffset, mItemOffset);
        }
        else if(position%colVal==1)
        {
            // set top right , bottom
            outRect.set(mItemOffset, 2*mItemOffset, mItemOffset, mItemOffset);
        }
        else if(position%colVal==2)
        {
            // set top bottom
            outRect.set(0, 2*mItemOffset, 0, mItemOffset);
        }
        else*/
            outRect.set(mItemOffset, mItemOffset, mItemOffset, mItemOffset);
    }
}
