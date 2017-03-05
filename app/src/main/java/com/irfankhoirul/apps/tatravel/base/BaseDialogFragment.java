package com.irfankhoirul.apps.tatravel.base;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.DialogFragment;

import butterknife.Unbinder;

/**
 * Created by Irfan Khoirul on 12/25/2016.
 */

public class BaseDialogFragment<T extends Activity> extends DialogFragment {

    protected Unbinder unbinder;
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

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}
