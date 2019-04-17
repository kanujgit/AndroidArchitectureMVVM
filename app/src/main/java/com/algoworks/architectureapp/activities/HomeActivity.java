package com.algoworks.architectureapp.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.algoworks.architectureapp.R;
import com.algoworks.architectureapp.adapters.HomeRecAdapter;
import com.algoworks.architectureapp.viewmodels.HomeViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.act_rev_view)
    RecyclerView home_rec_view;
    private HomeRecAdapter mAdapter;
    HomeViewModel homeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);

        initRecyclerView();


    }


    private void initRecyclerView() {
        mAdapter = new HomeRecAdapter(this);
        VerticalSpacingItemDecorator itemDecorator = new VerticalSpacingItemDecorator(30);
        mRecyclerView.addItemDecoration(itemDecorator);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {

                if (!mRecyclerView.canScrollVertically(1)) {
                    // search the next page
                    mRecipeListViewModel.searchNextPage();
                }
            }
        });
    }
}
