package com.irfankhoirul.apps.tatravel.module.register;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */

@Module
public class RegisterPresenterModule {

    private final RegisterContract.View mView;

    public RegisterPresenterModule(RegisterContract.View view) {
        mView = view;
    }

    @Provides
    RegisterContract.View provideRegisterContractView() {
        return mView;
    }
}
