package com.irfankhoirul.apps.tatravel.module.login;

import com.irfankhoirul.apps.tatravel.core.base.BaseFragmentHolderActivity;
import com.irfankhoirul.apps.tatravel.data.api.source.user.DaggerUserDataSourceComponent;

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
                .userDataSourceComponent(DaggerUserDataSourceComponent.builder().build())
//                .sessionRepositoryComponent(DaggerRegisterComponent.builder().build())
                .build().inject(this);

    }

}
