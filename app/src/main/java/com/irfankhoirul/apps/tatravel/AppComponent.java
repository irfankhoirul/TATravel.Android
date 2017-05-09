package com.irfankhoirul.apps.tatravel;

import com.irfankhoirul.apps.tatravel.data.api.source.user.UserDataSource;
import com.irfankhoirul.apps.tatravel.data.locale.session.SessionRepository;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Irfan Khoirul on 5/9/2017.
 */

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(TAApplication taApplication);

    SessionRepository session();

    UserDataSource userdataSource();
}