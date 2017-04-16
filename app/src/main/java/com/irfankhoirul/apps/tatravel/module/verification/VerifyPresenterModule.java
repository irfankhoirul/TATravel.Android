package com.irfankhoirul.apps.tatravel.module.verification;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */

@Module
public class VerifyPresenterModule {

    private final VerifyContract.View mView;

    public VerifyPresenterModule(VerifyContract.View view) {
        mView = view;
    }

    @Provides
    VerifyContract.View provideVerifyContractView() {
        return mView;
    }
}
