package com.irfankhoirul.apps.tatravel.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.irfankhoirul.apps.tatravel.R;

import butterknife.Unbinder;

/**
 * Super class fragment setiap fragment dalam aplikasi. Digunakan untuk mengeset Activity
 * pada saat onAttach dan meng-unset / menghilangkan reference activity pada saat onDetach
 *
 * @author Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @version 1.0 (7 November 2016)
 * @since 1.0
 */

public abstract class BaseFragment<T extends FragmentActivity> extends Fragment {

    protected String title;
    protected FragmentActivity activity;
    protected Unbinder unbinder;
    private FragmentListener fragmentListener;

    protected abstract void setTitle();

    protected abstract void setPresenter();

    public String getTitle() {
        return title;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        title = getResources().getString(R.string.app_name);
        setTitle();
        fragmentListener.setTitle(title);
        setPresenter();

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
        super.onDetach();
        this.activity = null;
        this.fragmentListener = null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    public interface FragmentListener {
        void setTitle(String title);
    }

}
