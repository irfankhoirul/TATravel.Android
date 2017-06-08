package com.irfankhoirul.apps.tatravel.modules.profile_editor;

import com.irfankhoirul.apps.tatravel.app.TAApplication;
import com.irfankhoirul.mvp_core.base.BaseFragmentHolderActivity;

import javax.inject.Inject;

public class ProfileEditorActivity extends BaseFragmentHolderActivity {

    @Inject
    ProfileEditorPresenter mPresenter;

    @Override
    protected void initializeFragment() {
        ProfileEditorFragment profileEditorFragment = new ProfileEditorFragment();
        setCurrentFragment(profileEditorFragment, false);

        DaggerProfileEditorComponent.builder()
                .profileEditorPresenterModule(new ProfileEditorPresenterModule(profileEditorFragment))
                .appComponent(((TAApplication) getApplication()).getAppComponent())
                .build().inject(this);

    }

}
