package com.irfankhoirul.apps.tatravel.module.login;

import com.irfankhoirul.apps.tatravel.core.app.TAApplication;
import com.irfankhoirul.apps.tatravel.core.base.BaseFragmentHolderActivity;

import javax.inject.Inject;

public class LoginActivity extends BaseFragmentHolderActivity {

    @Inject
    LoginPresenter mPresenter;

    @Override
    protected void initializeFragment() {
        LoginFragment loginFragment = new LoginFragment();
        setCurrentFragment(loginFragment, false);

        DaggerLoginComponent.builder()
                .loginPresenterModule(new LoginPresenterModule(loginFragment))
                .appComponent(((TAApplication) getApplication()).getAppComponent())
                .build().inject(this);

    }

}
