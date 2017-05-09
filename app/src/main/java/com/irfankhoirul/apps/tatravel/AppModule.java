package com.irfankhoirul.apps.tatravel;

import android.content.Context;

import com.irfankhoirul.apps.tatravel.data.api.source.user.UserDataSource;
import com.irfankhoirul.apps.tatravel.data.locale.session.Session;
import com.irfankhoirul.apps.tatravel.data.locale.session.SessionRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Irfan Khoirul on 5/8/2017.
 */

@Module
public final class AppModule {

    private final Context mContext;
    private TAApplication taApplication;

    AppModule(TAApplication taApplication, Context context) {
        mContext = context;
        this.taApplication = taApplication;
    }

    @Provides
    Context provideContext() {
        return mContext;
    }

    @Singleton
    @Provides
    SessionRepository provideSessionRepository(Context context) {
        return new Session(context);
    }

    @Singleton
    @Provides
    UserDataSource provideUserDataSource() {
        return new UserDataSource();
    }
}
