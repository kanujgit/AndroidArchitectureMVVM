package com.algoworks.architectureapp.utils;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public abstract class EndlessScrollListener extends RecyclerView.OnScrollListener {


    public static final String TAG = EndlessScrollListener.class.getSimpleName();
    private boolean loading = false;
    private int visibleItemCount;
    private int totalItemCount;
    private final LinearLayoutManager mLinearLayoutManager;

    public EndlessScrollListener(LinearLayoutManager linearLayoutManager) {
        this.mLinearLayoutManager = linearLayoutManager;
    }

    public void updateLoading(boolean isLoading) {
        this.loading = isLoading;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        if (dy > 0) {
//            Log.i(TAG, "onScrolled..L !  " + totalItemCount + loading);
            visibleItemCount = mLinearLayoutManager.getChildCount();
            totalItemCount = mLinearLayoutManager.getItemCount();
            int previousTotal = mLinearLayoutManager.findFirstVisibleItemPosition();
            if (loading) {
                if ((visibleItemCount + previousTotal) == totalItemCount) {
                    loading = false;
//                    Log.i(TAG, "onScrolled..Last Item Wow !  " + totalItemCount);
                    onLoadMore(totalItemCount);
                }
            }
        }
    }

    public abstract void onLoadMore(int totalItemCount);

}