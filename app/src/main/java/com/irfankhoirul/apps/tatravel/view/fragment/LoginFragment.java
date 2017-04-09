package com.irfankhoirul.apps.tatravel.view.fragment;


import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.irfankhoirul.apps.tatravel.R;
import com.irfankhoirul.apps.tatravel.contract.LoginContract;
import com.irfankhoirul.apps.tatravel.model.data.local.Session;
import com.irfankhoirul.apps.tatravel.model.pojo.User;
import com.irfankhoirul.apps.tatravel.presenter.LoginPresenter;
import com.irfankhoirul.apps.tatravel.util.ConstantUtils;
import com.irfankhoirul.apps.tatravel.view.activity.LoginActivity;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

import static com.basgeekball.awesomevalidation.ValidationStyle.TEXT_INPUT_LAYOUT;

/**
 * A simple {@link Fragment} subclass.
 */

public class LoginFragment extends BaseFragment<LoginActivity> implements LoginContract.View {

    @BindView(R.id.rbLoginWithPhoneNumber)
    RadioButton rbLoginWithPhoneNumber;
    @BindView(R.id.tilPhoneNumber)
    TextInputLayout tilPhoneNumber;
    @BindView(R.id.etPhoneNumber)
    EditText etPhoneNumber;
    @BindView(R.id.rbLoginWithEmailAddress)
    RadioButton rbLoginWithEmailAddress;
    @BindView(R.id.tilEmailAddress)
    TextInputLayout tilEmailAddress;
    @BindView(R.id.etEmailAddress)
    EditText etEmailAddress;
    @BindView(R.id.tilPassword)
    TextInputLayout tilPassword;
    @BindView(R.id.etPassword)
    EditText etPassword;
    @BindView(R.id.btLogin)
    Button btLogin;
    @BindView(R.id.btForgotPassword)
    Button btForgotPassword;

    private LoginPresenter mPresenter;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    protected void setTitle() {
        title = "Login";
    }

    @Override
    public void setPresenter() {
        mPresenter = new LoginPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_login, container, false);
        unbinder = ButterKnife.bind(this, fragmentView);
        mPresenter.start();

        return fragmentView;
    }

    @Override
    public void redirectToProfile(User user) {
        Session.initialize(activity, user);
        activity.setResult(ConstantUtils.STATUS_SUCCESS);
        activity.finish();
    }

    @OnCheckedChanged(R.id.rbLoginWithPhoneNumber)
    public void rbLoginWithPhoneNumber() {
        if (rbLoginWithPhoneNumber.isChecked()) {
            rbLoginWithEmailAddress.setChecked(false);
            etEmailAddress.setEnabled(false);
            etPhoneNumber.setEnabled(true);
            etPhoneNumber.requestFocus();
        }
    }

    @OnCheckedChanged(R.id.rbLoginWithEmailAddress)
    public void rbLoginWithEmailAddress() {
        if (rbLoginWithEmailAddress.isChecked()) {
            rbLoginWithPhoneNumber.setChecked(false);
            etPhoneNumber.setEnabled(false);
            etEmailAddress.setEnabled(true);
            etEmailAddress.requestFocus();
        }
    }

    @OnClick(R.id.btLogin)
    public void btLogin() {
        View view = activity.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

        AwesomeValidation mAwesomeValidation = new AwesomeValidation(TEXT_INPUT_LAYOUT);
        if (rbLoginWithPhoneNumber.isChecked()) {
            mAwesomeValidation.addValidation(activity, R.id.tilPhoneNumber, Patterns.PHONE, R.string.validation_phone_valid);
            mAwesomeValidation.addValidation(activity, R.id.tilPhoneNumber, RegexTemplate.NOT_EMPTY, R.string.validation_phone_not_empty);
        } else if (rbLoginWithEmailAddress.isChecked()) {
            mAwesomeValidation.addValidation(activity, R.id.tilEmailAddress, Patterns.PHONE, R.string.validation_phone_valid);
            mAwesomeValidation.addValidation(activity, R.id.tilEmailAddress, RegexTemplate.NOT_EMPTY, R.string.validation_phone_not_empty);
        }
        mAwesomeValidation.addValidation(activity, R.id.tilName, RegexTemplate.NOT_EMPTY, R.string.validation_name_not_empty);
        mAwesomeValidation.addValidation(activity, R.id.tilPassword, RegexTemplate.NOT_EMPTY, R.string.validation_password_not_empty);

        if (mAwesomeValidation.validate()) {
            Map<String, String> params = new HashMap<>();
            params.put("phone", etPhoneNumber.getText().toString());
            params.put("password", etPassword.getText().toString());
            params.put("deviceSecretId", Settings.Secure.getString(getActivity().getContentResolver(), Settings.Secure.ANDROID_ID));
            Log.v("Validation", "Pass");

            mPresenter.login(params);
        } else {
            Log.v("Validation", "Failed");
        }
    }
}
