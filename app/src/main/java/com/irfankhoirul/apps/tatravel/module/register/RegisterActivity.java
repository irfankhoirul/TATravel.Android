package com.irfankhoirul.apps.tatravel.module.register;

import com.irfankhoirul.apps.tatravel.core.base.BaseFragmentHolderActivity;
import com.irfankhoirul.apps.tatravel.data.api.source.user.DaggerUserDataSourceComponent;

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
                .userDataSourceComponent(DaggerUserDataSourceComponent.builder().build())
                .build().inject(this);
    }

}
