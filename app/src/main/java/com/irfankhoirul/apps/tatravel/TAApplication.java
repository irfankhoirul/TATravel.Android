package com.irfankhoirul.apps.tatravel;

import android.app.Application;

import com.irfankhoirul.apps.tatravel.data.source.user.DaggerUserDataSourceComponent;
import com.irfankhoirul.apps.tatravel.data.source.user.UserDataSourceComponent;

/**
 * Created by Irfan Khoirul on 4/16/2017.
 */

public class TAApplication extends Application {

    private UserDataSourceComponent mRepositoryComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mRepositoryComponent = DaggerUserDataSourceComponent.builder()
//                .tAApplicationModule(new TAApplicationModule((getApplicationContext())))
                .build();

    }

    public UserDataSourceComponent getTasksRepositoryComponent() {
        return mRepositoryComponent;
    }

}