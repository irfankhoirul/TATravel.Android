package com.irfankhoirul.apps.tatravel.data.locale.session;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Irfan Khoirul on 4/16/2017.
 */

@Module
public class SessionRepositoryModule {

    @Singleton
    @Provides
    SessionRepository provideSessionRepository(Context context) {
        return new Session(context);
    }

}
