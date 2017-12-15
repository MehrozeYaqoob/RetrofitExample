package com.careem.retrofitexample.network;

import com.careem.retrofitexample.model.Flower;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by hp on 12/15/2017.
 */

public interface FlowerApiClient {

    @GET("/feeds/flowers.json")
    Call<List<Flower>> getFlowersData();

}
