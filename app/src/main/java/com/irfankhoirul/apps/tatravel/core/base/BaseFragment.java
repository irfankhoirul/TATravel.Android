package com.irfankhoirul.apps.tatravel.core.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.irfankhoirul.apps.tatravel.R;
import com.irfankhoirul.apps.tatravel.core.components.view.SnakeBar;
import com.irfankhoirul.apps.tatravel.core.components.view.Toaster;

import butterknife.Unbinder;

/**
 * Super class fragment setiap fragment dalam aplikasi. Digunakan untuk mengeset Activity
 * pada saat onAttach dan meng-unset / menghilangkan reference activity pada saat onDetach
 *
 * @author Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @version 1.0 (7 November 2016)
 * @since 1.0
 */

public abstract class BaseFragment<T extends FragmentActivity, U extends IBasePresenter> extends Fragment {

    protected String title;
    protected FragmentActivity activity;
    protected Unbinder unbinder;
    protected AlertDialog loadingDialog;
    protected View fragmentView;
    protected U mPresenter;
    private FragmentListener fragmentListener;
    private boolean loading;

    protected abstract void setTitle();

    public String getTitle() {
        return title;
    }

    public boolean isLoading() {
        return loading;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        title = getResources().getString(R.string.app_name);
        setTitle();
        fragmentListener.setTitle(title);

        return view;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = (T) context;
        this.fragmentListener = (FragmentListener) context;
    }

    @Override
    public void onDetach() {
        this.activity = null;
        this.fragmentListener = null;
        super.onDetach();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    protected void setLoadingDialog(boolean isLoading, @Nullable String message) {
        loading = isLoading;
        if (isLoading) {
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(activity);
            LayoutInflater inflater = this.getLayoutInflater(null);
            View dialogView = inflater.inflate(R.layout.dialog_loading, null);
            TextView tvMessage = (TextView) dialogView.findViewById(R.id.tvMessage);
            tvMessage.setText(message);
            dialogBuilder.setView(dialogView);
            loadingDialog = dialogBuilder.create();
            loadingDialog.setCancelable(false);
            loadingDialog.show();
        } else {
            if (loadingDialog != null && loadingDialog.isShowing()) {
                loadingDialog.dismiss();
            }
        }
    }

    protected void showStatus(int type, String message) {
//        showSnackBar(type, message, null, null, null);
        showToast(type, message);
    }

    protected void showSnackBar(int type, String message, String action, View root, android.view.View.OnClickListener listener) {
        new SnakeBar().builder(activity)
                .setMessage(message)
                .setActionName(action)
                .setLength(Snackbar.LENGTH_SHORT)
                .setRoot(fragmentView)
                .setType(type)
                .setActionListener(listener)
                .show();
    }

    protected void showToast(int type, String message) {
        new Toaster().builder(activity)
                .setType(type)
                .setMessage(message)
                .show();
    }

    protected AlertDialog.Builder createAlert(String title, String message) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(activity);
        alertDialogBuilder
                .setTitle(title)
                .setMessage(message);
        return alertDialogBuilder;
    }

    public interface FragmentListener {
        void setTitle(String title);
    }

}
