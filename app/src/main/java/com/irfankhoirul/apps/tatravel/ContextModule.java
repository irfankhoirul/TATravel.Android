package com.irfankhoirul.apps.tatravel;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Irfan Khoirul on 5/8/2017.
 */

@Module
public final class ContextModule {

    private final Context mContext;

    ContextModule(Context context) {
        mContext = context;
    }

    @Provides
    Context provideContext() {
        return mContext;
    }
}
