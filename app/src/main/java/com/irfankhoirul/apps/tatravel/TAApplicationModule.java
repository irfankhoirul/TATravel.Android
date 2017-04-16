package com.irfankhoirul.apps.tatravel;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public final class TAApplicationModule {

    private final Context mContext;

    TAApplicationModule(Context context) {
        mContext = context;
    }

    @Provides
    Context provideContext() {
        return mContext;
    }
}