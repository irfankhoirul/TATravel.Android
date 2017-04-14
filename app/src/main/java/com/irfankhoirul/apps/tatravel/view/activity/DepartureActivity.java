package com.irfankhoirul.apps.tatravel.view.activity;

import com.irfankhoirul.apps.tatravel.aaa.core.base.BaseFragmentHolderActivity;
import com.irfankhoirul.apps.tatravel.view.fragment.DepartureFragment;

public class DepartureActivity extends BaseFragmentHolderActivity {

    @Override
    protected void initializeFragment() {
        setCurrentFragment(new DepartureFragment(), true);
    }

}
