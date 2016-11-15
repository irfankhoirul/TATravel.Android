package com.irfankhoirul.apps.tatravel.base;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

/**
 * Super class fragment setiap fragment dalam aplikasi. Digunakan untuk mengeset Activity
 * pada saat onAttach dan meng-unset / menghilangkan reference activity pada saat onDetach
 *
 * @author Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since 1.0
 * @version 1.0 (7 November 2016)
 */

public class BaseFragment<T extends Activity> extends Fragment {

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
