package com.irfankhoirul.apps.tatravel.view.activity;

import com.irfankhoirul.apps.tatravel.R;

import butterknife.ButterKnife;

public abstract class BaseFragmentHolderActivity extends BaseActivity {

    @Override
    protected void initializeView() {
        setContentView(R.layout.activity_fragment_holder);
        ButterKnife.bind(this);
    }

}