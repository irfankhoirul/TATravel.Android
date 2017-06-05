package com.irfankhoirul.apps.tatravel.modules.verification;

import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.irfankhoirul.apps.tatravel.R;
import com.irfankhoirul.apps.tatravel.components.ConstantUtils;
import com.irfankhoirul.mvp_core.base.BaseFragment;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.basgeekball.awesomevalidation.ValidationStyle.TEXT_INPUT_LAYOUT;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * A simple {@link Fragment} subclass.
 */
public class VerifyFragment extends BaseFragment<VerifyActivity, VerifyContract.Presenter> implements VerifyContract.View {

    @BindView(R.id.tilVerificationCode)
    TextInputLayout tilVerificationCode;
    @BindView(R.id.etVerificationCode)
    EditText etVerificationCode;

//    @Inject
//    FormValidation formValidation;

    public VerifyFragment() {
        // Required empty public constructor
    }

    public static VerifyFragment newInstance(String phone, String email) {
        Bundle bundle = new Bundle();
        bundle.putString("phone", phone);
        bundle.putString("email", email);
        VerifyFragment verifyFragment = new VerifyFragment();
        verifyFragment.setArguments(bundle);

        return verifyFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_verification, container, false);
        unbinder = ButterKnife.bind(this, fragmentView);

        return fragmentView;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void redirectToProfile() {
        activity.setResult(ConstantUtils.STATUS_SUCCESS);
        activity.setResult(ConstantUtils.STATUS_SUCCESS);
        activity.finish();
    }

    @Override
    public void setPresenter(VerifyContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public void setLoadingDialog(boolean isLoading, @Nullable String message) {
        super.setLoadingDialog(isLoading, message);
    }

    @Override
    public void showStatus(int type, String message) {
        super.showStatus(type, message);
    }

    @Override
    protected void setTitle() {
        title = "Verifikasi";
    }

    private boolean verifyVerificationForm() {
        AwesomeValidation formValidation = new AwesomeValidation(TEXT_INPUT_LAYOUT);
        formValidation.addValidation(activity, R.id.tilVerificationCode, RegexTemplate.NOT_EMPTY, R.string.validation_verification_code_not_empty);

        return formValidation.validate();
    }

    @OnClick(R.id.btVerify)
    public void btVerify() {
        View view = activity.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

        if (verifyVerificationForm()) {
            Map<String, String> params = new HashMap<>();
            params.put("registrationCode", etVerificationCode.getText().toString());
            params.put("phone", getArguments().getString("phone"));
            params.put("email", getArguments().getString("email"));
            params.put("deviceSecretId", Settings.Secure.getString(getActivity().getContentResolver(), Settings.Secure.ANDROID_ID));

            mPresenter.verifyUser(params);
        }
    }

}
