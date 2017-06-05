package com.irfankhoirul.apps.tatravel.modules.register;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RadioButton;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.irfankhoirul.apps.tatravel.R;
import com.irfankhoirul.apps.tatravel.components.ConstantUtils;
import com.irfankhoirul.apps.tatravel.modules.verification.VerifyActivity;
import com.irfankhoirul.mvp_core.base.BaseFragment;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

import static com.basgeekball.awesomevalidation.ValidationStyle.TEXT_INPUT_LAYOUT;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.irfankhoirul.apps.tatravel.components.ConstantUtils.REGISTER_GOOGLE_REQUEST;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends BaseFragment<RegisterActivity, RegisterContract.Presenter>
        implements RegisterContract.View, GoogleApiClient.OnConnectionFailedListener {

    @BindView(R.id.rbRegisterWithPhoneNumber)
    RadioButton rbRegisterWithPhoneNumber;
    @BindView(R.id.rbRegisterWithEmailAddress)
    RadioButton rbRegisterWithEmailAddress;
    @BindView(R.id.tilPhoneNumber)
    TextInputLayout tilPhoneNumber;
    @BindView(R.id.etPhoneNumber)
    EditText etPhoneNumber;
    @BindView(R.id.tilEmailAddress)
    TextInputLayout tilEmailAddress;
    @BindView(R.id.etEmailAddress)
    EditText etEmailAddress;
    @BindView(R.id.tilPassword)
    TextInputLayout tilPassword;
    @BindView(R.id.etPassword)
    EditText etPassword;
    @BindView(R.id.tilName)
    TextInputLayout tilName;
    @BindView(R.id.etName)
    EditText etName;

    @BindView(R.id.cvRegisterWithGoogle)
    CardView cvRegisterWithGoogle;
    @BindView(R.id.cvRegisterWithFacebook)
    CardView cvRegisterWithFacebook;
    @BindView(R.id.registerFacebook)
    LoginButton registerFacebook;
    @BindView(R.id.registerGoogle)
    SignInButton registerGoogle;

    private CallbackManager callbackManager;
    private GoogleApiClient mGoogleApiClient;

//    @Inject
//    FormValidation formValidation;

    public RegisterFragment() {
        // Required empty public constructor
    }

    @Override
    protected void setTitle() {
        title = "Daftar";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_register, container, false);
        unbinder = ButterKnife.bind(this, fragmentView);
        setupFacebook();
        setupGoogle();

        return fragmentView;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mGoogleApiClient != null) {
            mGoogleApiClient.stopAutoManage(activity);
            mGoogleApiClient.disconnect();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mGoogleApiClient != null) {
            mGoogleApiClient.stopAutoManage(activity);
            mGoogleApiClient.disconnect();
        }
    }

    private void setupFacebook() {
        if (AccessToken.getCurrentAccessToken() != null) {
            registerFacebook.performClick();
        }

        callbackManager = CallbackManager.Factory.create();
        registerFacebook.setReadPermissions("email");
        registerFacebook.setFragment(this);
        registerFacebook.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                handleFacebookResult(loginResult.getAccessToken());
            }

            @Override
            public void onCancel() {
            }

            @Override
            public void onError(FacebookException exception) {
            }
        });
    }

    private void handleFacebookResult(final AccessToken accessToken) {
        GraphRequest req = GraphRequest.newMeRequest(accessToken, new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {
                try {
                    mPresenter.handleSocialRegister(object.getString("email"), object.getString("name"),
                            Settings.Secure.getString(activity.getContentResolver(), Settings.Secure.ANDROID_ID));
                } catch (JSONException e) {
                    showStatus(ConstantUtils.STATUS_ERROR, "Registrasi Gagal");
                }
            }
        });
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,name,email,gender,birthday,picture.type(large)");
        req.setParameters(parameters);
        req.executeAsync();
    }

    private void setupGoogle() {
        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder(activity)
                .enableAutoManage(activity, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, googleSignInOptions)
                .build();
    }

    private void handleGoogleResult(GoogleSignInResult result) {
        if (result.isSuccess()) {
            GoogleSignInAccount account = result.getSignInAccount();
            if (account != null) {
                mPresenter.handleSocialRegister(account.getEmail(), account.getDisplayName(),
                        Settings.Secure.getString(activity.getContentResolver(), Settings.Secure.ANDROID_ID));
            } else {
                showStatus(ConstantUtils.STATUS_ERROR, "Registrasi Gagal");
            }
        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        showStatus(ConstantUtils.STATUS_ERROR, "Gagal menghubungkan akun Google Anda");
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ConstantUtils.INTENT_REQUEST_REGISTER_TO_VALIDATION) {
            if (resultCode == ConstantUtils.REQUEST_RESULT_SUCCESS) {
                activity.setResult(ConstantUtils.REQUEST_RESULT_SUCCESS);
                activity.finish();
            }
        } else if (requestCode == REGISTER_GOOGLE_REQUEST) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleGoogleResult(result);
        } else {
            callbackManager.onActivityResult(requestCode, resultCode, data);
        }
    }

    private boolean validateRegisterForm() {
        AwesomeValidation formValidation = new AwesomeValidation(TEXT_INPUT_LAYOUT);
        if (rbRegisterWithPhoneNumber.isChecked()) {
            formValidation.addValidation(activity, R.id.tilPhoneNumber, Patterns.PHONE, R.string.validation_phone_valid);
            formValidation.addValidation(activity, R.id.tilPhoneNumber, RegexTemplate.NOT_EMPTY, R.string.validation_phone_not_empty);
        } else if (rbRegisterWithEmailAddress.isChecked()) {
            formValidation.addValidation(activity, R.id.tilEmailAddress, Patterns.EMAIL_ADDRESS, R.string.validation_email_valid);
            formValidation.addValidation(activity, R.id.tilEmailAddress, RegexTemplate.NOT_EMPTY, R.string.validation_email_not_empty);
        }
        formValidation.addValidation(activity, R.id.tilName, RegexTemplate.NOT_EMPTY, R.string.validation_name_not_empty);
        formValidation.addValidation(activity, R.id.tilPassword, RegexTemplate.NOT_EMPTY, R.string.validation_password_not_empty);

        return formValidation.validate();
    }

    @OnCheckedChanged(R.id.rbRegisterWithPhoneNumber)
    public void rbRegisterWithPhoneNumber() {
        if (rbRegisterWithPhoneNumber.isChecked()) {
            rbRegisterWithEmailAddress.setChecked(false);
            etEmailAddress.setEnabled(false);
            etPhoneNumber.setEnabled(true);
            etPhoneNumber.requestFocus();
        }
    }

    @OnCheckedChanged(R.id.rbRegisterWithEmailAddress)
    public void rbRegisterWithEmailAddress() {
        if (rbRegisterWithEmailAddress.isChecked()) {
            rbRegisterWithPhoneNumber.setChecked(false);
            etPhoneNumber.setEnabled(false);
            etEmailAddress.setEnabled(true);
            etEmailAddress.requestFocus();
        }
    }

    @OnClick(R.id.btRegister)
    public void btRegister() {
        View view = activity.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

        if (validateRegisterForm()) {
            Map<String, String> params = new HashMap<>();
            params.put("name", etName.getText().toString());
            if (rbRegisterWithEmailAddress.isChecked()) {
                params.put("email", etEmailAddress.getText().toString());
            } else if (rbRegisterWithPhoneNumber.isChecked()) {
                params.put("phone", etPhoneNumber.getText().toString());
            }
            params.put("password", etPassword.getText().toString());
            params.put("deviceSecretId", Settings.Secure.getString(activity.getContentResolver(),
                    Settings.Secure.ANDROID_ID));

            mPresenter.register(params);
        }
    }

    @OnClick(R.id.cvRegisterWithFacebook)
    public void cvRegisterWithFacebook() {
        registerFacebook.performClick();
    }

    @OnClick(R.id.cvRegisterWithGoogle)
    public void cvRegisterWithGoogle() {
        Auth.GoogleSignInApi.revokeAccess(mGoogleApiClient).setResultCallback(
                new ResultCallback<Status>() {
                    @Override
                    public void onResult(Status status) {
                        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
                        startActivityForResult(signInIntent, REGISTER_GOOGLE_REQUEST);
                    }
                });
    }

    @Override
    public void redirectToVerification(String phone, String email) {
        Intent intent = new Intent(activity, VerifyActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("phone", phone);
        bundle.putString("email", email);
        startActivityForResult(intent, ConstantUtils.INTENT_REQUEST_REGISTER_TO_VALIDATION);
    }

    @Override
    public void redirectToProfile() {
        activity.setResult(ConstantUtils.STATUS_SUCCESS);
        activity.finish();
    }

    @Override
    public void setPresenter(RegisterContract.Presenter presenter) {
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
}
