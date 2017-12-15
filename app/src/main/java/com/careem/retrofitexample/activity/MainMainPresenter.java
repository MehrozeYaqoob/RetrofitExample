package com.careem.retrofitexample.activity;

import android.view.View;

import com.careem.retrofitexample.model.Flower;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by hp on 12/15/2017.
 */

public class MainMainPresenter implements MainContract.MainPresenterBehavior {

    private List<Flower> flowerList;
    private MainContract.MainViewBehavior mainViewBehavior;

    public MainMainPresenter(MainContract.MainViewBehavior view)
    {
        this.mainViewBehavior = view;
    }


    @Override
    public void fetchFlowersDataAsync(Call<List<Flower>> call) {
        call.enqueue(new Callback<List<Flower>>() {
            @Override
            public void onResponse(Call<List<Flower>> call, Response<List<Flower>> response) {
                flowerList = response.body();
                mainViewBehavior.setAdapter(response.body());
            }

            @Override
            public void onFailure(Call<List<Flower>> call, Throwable t) {
                mainViewBehavior.showErrorMessage(call,t);
            }
        });
    }

    @Override
    public void handleItemTouchEvent(View v, int position) {
        Flower flower = flowerList.get(position);
        mainViewBehavior.showDetailViewOfListItem(flower);
    }
}
