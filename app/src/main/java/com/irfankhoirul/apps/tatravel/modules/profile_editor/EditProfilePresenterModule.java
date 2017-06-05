package com.irfankhoirul.apps.tatravel.modules.profile_editor;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */

@Module
public class EditProfilePresenterModule {

    private final EditProfileContract.View mView;

    public EditProfilePresenterModule(EditProfileContract.View view) {
        mView = view;
    }

    @Provides
    EditProfileContract.View provideEditProfileContractView() {
        return mView;
    }
}
