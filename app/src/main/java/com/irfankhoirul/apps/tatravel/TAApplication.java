package com.irfankhoirul.apps.tatravel;

import android.app.Application;

import com.irfankhoirul.apps.tatravel.data.api.source.user.DaggerUserDataSourceComponent;
import com.irfankhoirul.apps.tatravel.data.api.source.user.UserDataSourceComponent;
import com.irfankhoirul.apps.tatravel.data.locale.session.DaggerSessionRepositoryComponent;
import com.irfankhoirul.apps.tatravel.data.locale.session.SessionRepositoryComponent;

/**
 * Created by Irfan Khoirul on 4/16/2017.
 */

public class TAApplication extends Application {

    private SessionRepositoryComponent sessionRepositoryComponent;
    private UserDataSourceComponent userDataSourceComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        sessionRepositoryComponent = DaggerSessionRepositoryComponent.builder()
                .contextModule(new ContextModule((getApplicationContext())))
                .build();

        userDataSourceComponent = DaggerUserDataSourceComponent.builder().build();
    }

    public SessionRepositoryComponent getSessionRepositoryComponent() {
        return sessionRepositoryComponent;
    }

    public UserDataSourceComponent getUserDataSourceComponent() {
        return userDataSourceComponent;
    }
}