package com.irfankhoirul.apps.tatravel.view.activity;

import com.irfankhoirul.apps.tatravel.aaa.core.base.BaseFragmentHolderActivity;
import com.irfankhoirul.apps.tatravel.view.fragment.LoginFragment;

public class LoginActivity extends BaseFragmentHolderActivity {

    @Override
    protected void initializeFragment() {
        setCurrentFragment(new LoginFragment(), false);
    }

}
