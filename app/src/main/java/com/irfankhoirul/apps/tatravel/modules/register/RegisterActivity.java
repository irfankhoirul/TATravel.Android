package com.irfankhoirul.apps.tatravel.modules.register;

import com.irfankhoirul.apps.tatravel.app.TAApplication;
import com.irfankhoirul.mvp_core.base.BaseFragmentHolderActivity;

import javax.inject.Inject;

public class RegisterActivity extends BaseFragmentHolderActivity {

    @Inject
    RegisterPresenter registerPresenter;

    @Override
    protected void initializeFragment() {
        RegisterFragment registerFragment = new RegisterFragment();
        setCurrentFragment(registerFragment, false);

        DaggerRegisterComponent.builder()
                .registerPresenterModule(new RegisterPresenterModule(registerFragment))
                .appComponent(((TAApplication) getApplication()).getAppComponent())
                .build().inject(this);
    }

}
