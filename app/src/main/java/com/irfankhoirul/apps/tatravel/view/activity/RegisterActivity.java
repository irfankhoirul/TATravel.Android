package com.irfankhoirul.apps.tatravel.view.activity;

import com.irfankhoirul.apps.tatravel.view.fragment.RegisterFragment;

public class RegisterActivity extends BaseFragmentHolderActivity {

    @Override
    protected void initializeFragment() {
        setCurrentFragment(new RegisterFragment(), false);
    }

}
