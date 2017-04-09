package com.irfankhoirul.apps.tatravel.view.fragment;


import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.irfankhoirul.apps.tatravel.R;
import com.irfankhoirul.apps.tatravel.contract.VerifyContract;
import com.irfankhoirul.apps.tatravel.model.data.local.Session;
import com.irfankhoirul.apps.tatravel.model.pojo.User;
import com.irfankhoirul.apps.tatravel.presenter.VerifyPresenter;
import com.irfankhoirul.apps.tatravel.util.ConstantUtils;
import com.irfankhoirul.apps.tatravel.view.activity.VerifyActivity;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.basgeekball.awesomevalidation.ValidationStyle.TEXT_INPUT_LAYOUT;

/**
 * A simple {@link Fragment} subclass.
 */
public class VerifyFragment extends BaseFragment<VerifyActivity> implements VerifyContract.View {

    @BindView(R.id.tilVerificationCode)
    TextInputLayout tilVerificationCode;
    @BindView(R.id.etVerificationCode)
    EditText etVerificationCode;

    private VerifyPresenter mPresenter;

    public VerifyFragment() {
        // Required empty public constructor
    }

    public static VerifyFragment newInstance(String phone) {
        Bundle bundle = new Bundle();
        bundle.putString("phone", phone);
        VerifyFragment verifyFragment = new VerifyFragment();
        verifyFragment.setArguments(bundle);

        return verifyFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_verification, container, false);
        unbinder = ButterKnife.bind(this, fragmentView);
        mPresenter.start();

        return fragmentView;
    }

    @Override
    public void redirectToProfile(User user) {
        activity.setResult(ConstantUtils.STATUS_SUCCESS);
        Session.initialize(activity, user);
        activity.setResult(ConstantUtils.STATUS_SUCCESS);
        activity.finish();
    }

    @Override
    public void setPresenter() {
        mPresenter = new VerifyPresenter(this);
    }

    @Override
    public void showStatus(int type, String message) {
        showSnackBar(type, message, null, null);
    }

    @Override
    protected void setTitle() {

    }

    @OnClick(R.id.btVerify)
    public void btVerify() {
        View view = activity.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

        AwesomeValidation mAwesomeValidation = new AwesomeValidation(TEXT_INPUT_LAYOUT);
        mAwesomeValidation.addValidation(activity, R.id.tilVerificationCode, RegexTemplate.NOT_EMPTY, R.string.validation_verification_code_not_empty);

        if (mAwesomeValidation.validate()) {
            Map<String, String> params = new HashMap<>();
            params.put("registrationCode", etVerificationCode.getText().toString());
            params.put("phone", getArguments().getString("phone"));
            params.put("deviceSecretId", Settings.Secure.getString(getActivity().getContentResolver(), Settings.Secure.ANDROID_ID));
            Log.v("Validation", "Pass");

            mPresenter.verify(params);
        } else {
            Log.v("Validation", "Failed");
        }
    }

}
