package com.irfankhoirul.apps.tatravel.view.activity;

import com.irfankhoirul.apps.tatravel.view.fragment.DepartureFragment;

public class DepartureActivity extends FragmentHolderActivity {

    @Override
    protected void initializeFragment() {
        setCurrentFragment(new DepartureFragment(), true);
    }

    @Override
    protected void initializeView() {
        setTitle("Keberangkatan");
    }

}
