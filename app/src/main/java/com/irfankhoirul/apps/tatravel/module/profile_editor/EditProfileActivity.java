package com.irfankhoirul.apps.tatravel.module.profile_editor;

import com.irfankhoirul.apps.tatravel.app.TAApplication;
import com.irfankhoirul.apps.tatravel.core.base.BaseFragmentHolderActivity;

import javax.inject.Inject;

public class EditProfileActivity extends BaseFragmentHolderActivity {

    @Inject
    EditProfilePresenter mPresenter;

    @Override
    protected void initializeFragment() {
        EditProfileFragment editProfileFragment = new EditProfileFragment();
        setCurrentFragment(editProfileFragment, false);

        DaggerEditProfileComponent.builder()
                .editProfilePresenterModule(new EditProfilePresenterModule(editProfileFragment))
                .appComponent(((TAApplication) getApplication()).getAppComponent())
                .build().inject(this);

    }

}
