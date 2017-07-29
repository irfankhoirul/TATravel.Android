package com.irfankhoirul.apps.tatravel.modules.verification;

import com.irfankhoirul.apps.tatravel.app.TAApplication;
import com.irfankhoirul.mvp_core.base.BaseFragmentHolderActivity;

import javax.inject.Inject;

public class VerifyActivity extends BaseFragmentHolderActivity {

    @Inject
    VerifyPresenter verifyPresenter;

    @Override
    protected void initializeFragment() {
        VerifyFragment verifyFragment = VerifyFragment.newInstance(
                getIntent().getStringExtra("phone"),
                getIntent().getStringExtra("email")
        );
        setCurrentFragment(verifyFragment, false);

        DaggerVerifyComponent.builder()
                .verifyPresenterModule(new VerifyPresenterModule(verifyFragment))
                .appComponent(((TAApplication) getApplication()).getAppComponent())
                .build().inject(this);
    }
}
