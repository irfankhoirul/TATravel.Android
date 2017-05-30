package com.irfankhoirul.apps.tatravel.module.login_or_register;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.irfankhoirul.apps.tatravel.R;
import com.irfankhoirul.apps.tatravel.activity.MainActivity;
import com.irfankhoirul.apps.tatravel.components.ConstantUtils;
import com.irfankhoirul.apps.tatravel.module.login.LoginActivity;
import com.irfankhoirul.apps.tatravel.module.register.RegisterActivity;
import com.irfankhoirul.mvp_core.base.BaseFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginOrRegisterFragment extends BaseFragment<MainActivity, LoginOrRegisterContract.Presenter>
        implements LoginOrRegisterContract.View {

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
    public void onResume() {
        super.onResume();
        mPresenter.start();
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
        mPresenter.handleActivityResult(requestCode, resultCode);
    }

    @Override
    public void setPresenter(LoginOrRegisterContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public void notifyListenerLoginSuccess() {
        listener.onLoginSuccess();
    }

    @Override
    public void notifyListenerRegisterSuccess() {
        listener.onRegisterSuccess();
    }

    @Override
    public void setLoadingDialog(boolean isLoading, @Nullable String message) {
        super.setLoadingDialog(isLoading, message);
    }

    @Override
    public void showStatus(int type, String message) {
        super.showStatus(type, message);
    }

    public interface FragmentListener {
        void onRegisterSuccess();

        void onLoginSuccess();
    }
}
