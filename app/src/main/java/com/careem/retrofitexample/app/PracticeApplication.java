package com.careem.retrofitexample.app;

import android.app.Application;

import com.careem.retrofitexample.dagger.AppComponent;
import com.careem.retrofitexample.dagger.AppModule;
import com.careem.retrofitexample.dagger.DaggerAppComponent;


/**
 * Created by hp on 12/15/2017.
 */

public class PracticeApplication  extends Application{
    private  AppComponent appComponent;

    public AppComponent getAppComponent()
    {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = initDagger(this);
    }
    public AppComponent initDagger(PracticeApplication application) {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(application))
                .build();
    }

}
