package com.irfankhoirul.apps.tatravel.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.irfankhoirul.apps.tatravel.R;
import com.irfankhoirul.apps.tatravel.view.activity.LoginActivity;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */

public class LoginFragment extends BaseFragment<LoginActivity> {

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    protected void setTitle() {
        title = "Login";
    }

    @Override
    protected void setPresenter() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        unbinder = ButterKnife.bind(this, view);

        return view;
    }

}
