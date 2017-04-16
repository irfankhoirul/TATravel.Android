package com.irfankhoirul.apps.tatravel.module.login;

import android.util.Log;

import com.irfankhoirul.apps.tatravel.TAApplication;
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
                .userDataSourceComponent(((TAApplication) getApplication())
                        .getTasksRepositoryComponent())
                .build().inject(this);

        Log.v("LoginPresenterInjection", String.valueOf(mPresenter != null));
    }

}
