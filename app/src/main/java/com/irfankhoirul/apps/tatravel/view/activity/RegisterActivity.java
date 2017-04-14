package com.irfankhoirul.apps.tatravel.view.activity;

import com.irfankhoirul.apps.tatravel.aaa.core.base.BaseFragmentHolderActivity;
import com.irfankhoirul.apps.tatravel.aaa.module.user.register.RegisterFragment;

public class RegisterActivity extends BaseFragmentHolderActivity {

    @Override
    protected void initializeFragment() {
        setCurrentFragment(new RegisterFragment(), false);
    }

}
