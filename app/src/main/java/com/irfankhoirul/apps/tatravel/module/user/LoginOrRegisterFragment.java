package com.irfankhoirul.apps.tatravel.module.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.irfankhoirul.apps.tatravel.MainActivity;
import com.irfankhoirul.apps.tatravel.R;
import com.irfankhoirul.apps.tatravel.core.base.BaseFragment;
import com.irfankhoirul.apps.tatravel.core.components.util.ConstantUtils;
import com.irfankhoirul.apps.tatravel.module.login.LoginActivity;
import com.irfankhoirul.apps.tatravel.module.register.RegisterActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginOrRegisterFragment extends BaseFragment<MainActivity> {

    private FragmentListener listener;

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
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (FragmentListener) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @Override
    protected void setTitle() {
        title = "Profil";
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
            if (resultCode == ConstantUtils.STATUS_SUCCESS) {
                listener.onRegisterSuccess();
            }
        } else if (requestCode == ConstantUtils.INTENT_REQUEST_LOGIN_OR_REGISTER_TO_LOGIN) {
            if (resultCode == ConstantUtils.STATUS_SUCCESS) {
                listener.onLoginSuccess();
            }
        }
    }

    public interface FragmentListener {
        void onRegisterSuccess();

        void onLoginSuccess();
    }
}