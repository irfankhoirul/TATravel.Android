package com.irfankhoirul.apps.tatravel.view.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.irfankhoirul.apps.tatravel.base.IBaseView;

import butterknife.Unbinder;

/**
 * Created by Irfan Khoirul on 12/25/2016.
 */

public abstract class BaseDialog<T extends Activity> extends DialogFragment implements IBaseView {

    protected Unbinder unbinder;
    protected Activity activity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        setPresenter();

        return view;
    }

    @SuppressWarnings("unchecked")
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

    @Override
    public void showStatus(int type, String message) {

    }
}
