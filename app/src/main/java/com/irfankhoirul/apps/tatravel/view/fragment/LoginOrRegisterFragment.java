package com.irfankhoirul.apps.tatravel.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.irfankhoirul.apps.tatravel.R;
import com.irfankhoirul.apps.tatravel.model.data.local.Session;
import com.irfankhoirul.apps.tatravel.model.pojo.User;
import com.irfankhoirul.apps.tatravel.util.ConstantUtils;
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
    public void setPresenter() {

    }

    @Override
    public void showStatus(int type, String message) {

    }

    @OnClick(R.id.btLogin)
    public void btLogin() {
        Intent intent = new Intent(activity, LoginActivity.class);
        startActivityForResult(intent, ConstantUtils.INTENT_REQUEST_LOGIN_OR_REGISTER_TO_LOGIN);
    }

    @OnClick(R.id.btRegister)
    public void btRegister() {
        Intent intent = new Intent(activity, RegisterActivity.class);
        startActivityForResult(intent, ConstantUtils.INTENT_REQUEST_LOGIN_OR_REGISTER_TO_REGISTER);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ConstantUtils.INTENT_REQUEST_LOGIN_OR_REGISTER_TO_REGISTER) {
            if (resultCode == ConstantUtils.REQUEST_RESULT_SUCCESS) {
                Session<User> session = Session.getInstance(activity);
                Log.v("User Nama", session.getSessionData().getNama());
                Log.v("ChangeFragment", "Profile");
            }
        }
    }
}
