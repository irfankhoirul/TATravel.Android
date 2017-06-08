package com.irfankhoirul.apps.tatravel.modules.profile_editor;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */

@Module
public class ProfileEditorPresenterModule {

    private final ProfileEditorContract.View mView;

    public ProfileEditorPresenterModule(ProfileEditorContract.View view) {
        mView = view;
    }

    @Provides
    ProfileEditorContract.View provideEditProfileContractView() {
        return mView;
    }
}
