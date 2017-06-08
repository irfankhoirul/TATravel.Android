package com.irfankhoirul.apps.tatravel.modules.auth_choice;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */

@Module
public class AuthChoicePresenterModule {

    private final AuthChoiceContract.View mView;

    public AuthChoicePresenterModule(AuthChoiceContract.View view) {
        mView = view;
    }

    @Provides
    AuthChoiceContract.View provideLoginOrRegisterContractView() {
        return mView;
    }
}
