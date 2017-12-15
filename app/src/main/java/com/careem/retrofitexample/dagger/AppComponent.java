package com.careem.retrofitexample.dagger;


import com.careem.retrofitexample.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by hp on 12/15/2017.
 */
@Singleton
@Component (modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {

    void inject(MainActivity mainActivity);

}
