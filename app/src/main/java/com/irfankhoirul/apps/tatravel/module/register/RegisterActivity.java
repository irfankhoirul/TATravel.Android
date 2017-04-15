package com.irfankhoirul.apps.tatravel.module.register;

import com.irfankhoirul.apps.tatravel.core.base.BaseFragmentHolderActivity;

public class RegisterActivity extends BaseFragmentHolderActivity {

    @Override
    protected void initializeFragment() {
        setCurrentFragment(new RegisterFragment(), false);
    }

}
