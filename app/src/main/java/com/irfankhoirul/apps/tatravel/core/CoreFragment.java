package com.irfankhoirul.apps.tatravel.core;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

/**
 * Created by Irfan Khoirul on 11/7/2016.
 */

public class CoreFragment<T extends Activity> extends Fragment {

    protected Activity activity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = (T) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.activity = null;
    }
}
