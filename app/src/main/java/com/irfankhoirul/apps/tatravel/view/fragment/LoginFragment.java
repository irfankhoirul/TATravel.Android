package com.irfankhoirul.apps.tatravel.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.irfankhoirul.apps.tatravel.R;
import com.irfankhoirul.apps.tatravel.base.BaseFragment;
import com.irfankhoirul.apps.tatravel.view.activity.MainActivity;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends BaseFragment<MainActivity> {

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    protected void setLabel() {
        label = this.getClass().getSimpleName();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        unbinder = ButterKnife.bind(this, view);

        return view;
    }

}
