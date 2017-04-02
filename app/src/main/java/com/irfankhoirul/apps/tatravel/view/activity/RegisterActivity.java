package com.irfankhoirul.apps.tatravel.view.activity;

import com.irfankhoirul.apps.tatravel.view.fragment.RegisterFragment;

public class RegisterActivity extends BaseFragmentHolderActivity {

    @Override
    protected void initializeFragment() {
        setCurrentFragment(new RegisterFragment(), false);
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        Log.v("RequestCode", String.valueOf(requestCode));
//    }
}
