package com.careem.retrofitexample.activity;

import android.view.View;

import com.careem.retrofitexample.model.Flower;

import java.util.List;

import retrofit2.Call;

/**
 * Created by hp on 12/15/2017.
 */

public interface MainContract {

    interface MainViewBehavior {
        void setAdapter(List<Flower> flowerList);
        void showErrorMessage(Call<List<Flower>> call, Throwable t);
        void showDetailViewOfListItem(Flower flower);
    }
    interface MainPresenterBehavior {
        void fetchFlowersDataAsync(Call<List<Flower>> call);
        void handleItemTouchEvent(View v, int position);
    }
}
