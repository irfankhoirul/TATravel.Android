package com.irfankhoirul.apps.tatravel.module.search;

import com.irfankhoirul.apps.tatravel.module.login.LoginContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */

@Module
public class SearchPresenterModule {

    private final LoginContract.View mView;

    public SearchPresenterModule(LoginContract.View view) {
        mView = view;
    }

    @Provides
    LoginContract.View provideLoginContractView() {
        return mView;
    }
}
