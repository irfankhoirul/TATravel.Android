package com.irfankhoirul.apps.tatravel.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.irfankhoirul.apps.tatravel.R;
import com.irfankhoirul.apps.tatravel.view.activity.LoginActivity;
import com.irfankhoirul.apps.tatravel.view.activity.MainActivity;
import com.irfankhoirul.apps.tatravel.view.activity.RegisterActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginOrRegisterFragment extends BaseFragment<MainActivity> {

    public LoginOrRegisterFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_login_or_register, container, false);
        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    protected void setTitle() {
        title = "Profil";
    }

    @Override
    protected void setPresenter() {

    }

    @OnClick(R.id.btLogin)
    public void btLogin() {
        Intent intent = new Intent(activity, LoginActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btRegister)
    public void btRegister() {
        Intent intent = new Intent(activity, RegisterActivity.class);
        startActivity(intent);
    }
}
