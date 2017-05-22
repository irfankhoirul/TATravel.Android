package com.irfankhoirul.apps.tatravel.module.login_or_register;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */

@Module
public class LoginOrRegisterPresenterModule {

    private final LoginOrRegisterContract.View mView;

    public LoginOrRegisterPresenterModule(LoginOrRegisterContract.View view) {
        mView = view;
    }

    @Provides
    LoginOrRegisterContract.View provideLoginOrRegisterContractView() {
        return mView;
    }
}
