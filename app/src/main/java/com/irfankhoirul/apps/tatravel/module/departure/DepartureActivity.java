package com.irfankhoirul.apps.tatravel.module.departure;

import com.irfankhoirul.apps.tatravel.core.base.BaseFragmentHolderActivity;

public class DepartureActivity extends BaseFragmentHolderActivity {

    @Override
    protected void initializeFragment() {
        setCurrentFragment(new DepartureFragment(), true);
    }

}
