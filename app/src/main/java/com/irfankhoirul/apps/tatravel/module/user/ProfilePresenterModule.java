package com.irfankhoirul.apps.tatravel.module.user;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */

@Module
public class ProfilePresenterModule {

    private final ProfileContract.View mView;

    public ProfilePresenterModule(ProfileContract.View view) {
        mView = view;
    }

    @Provides
    ProfileContract.View provideProfileContractView() {
        return mView;
    }
}
