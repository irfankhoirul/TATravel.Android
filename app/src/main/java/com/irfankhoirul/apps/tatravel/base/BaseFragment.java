package com.irfankhoirul.apps.tatravel.base;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

import butterknife.Unbinder;

/**
 * Super class fragment setiap fragment dalam aplikasi. Digunakan untuk mengeset Activity
 * pada saat onAttach dan meng-unset / menghilangkan reference activity pada saat onDetach
 *
 * @author Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @version 1.0 (7 November 2016)
 * @since 1.0
 */

public abstract class BaseFragment<T extends Activity> extends Fragment {

    protected String label;
    protected Activity activity;
    protected Unbinder unbinder;

    protected abstract void setLabel();

    public String getLabel() {
        return label;
    }

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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

}
