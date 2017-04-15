package com.irfankhoirul.apps.tatravel.module.login;

import com.irfankhoirul.apps.tatravel.core.base.BaseFragmentHolderActivity;

public class LoginActivity extends BaseFragmentHolderActivity {

    @Override
    protected void initializeFragment() {
        setCurrentFragment(new LoginFragment(), false);
    }

}
