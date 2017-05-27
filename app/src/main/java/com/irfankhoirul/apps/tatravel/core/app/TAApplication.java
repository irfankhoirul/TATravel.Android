package com.irfankhoirul.apps.tatravel.core.app;

import android.app.Application;

/**
 * Created by Irfan Khoirul on 4/16/2017.
 */

public class TAApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(getApplicationContext()))
                .build();
//        appComponent.inject(this);
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

}