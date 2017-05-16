package com.irfankhoirul.apps.tatravel.module.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
import android.widget.Toast;

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
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.common.hash.Hashing;
import com.irfankhoirul.apps.tatravel.R;
import com.irfankhoirul.apps.tatravel.core.base.BaseFragment;
import com.irfankhoirul.apps.tatravel.core.components.util.ConstantUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

import static com.basgeekball.awesomevalidation.ValidationStyle.TEXT_INPUT_LAYOUT;
import static com.facebook.FacebookSdk.getApplicationContext;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.irfankhoirul.apps.tatravel.core.components.util.ConstantUtils.REGISTER_GOOGLE_REQUEST;

/**
 * A simple {@link Fragment} subclass.
 */

public class LoginFragment extends BaseFragment<LoginActivity, LoginContract.Presenter> implements
        LoginContract.View, GoogleApiClient.OnConnectionFailedListener {

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
    @BindView(R.id.loginFacebook)
    LoginButton loginFacebook;

    private CallbackManager callbackManager;
    private GoogleApiClient mGoogleApiClient;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    protected void setTitle() {
        title = "Login";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_login, container, false);
        unbinder = ButterKnife.bind(this, fragmentView);
        setupFacebook();
        setupGoogle();

        return fragmentView;
    }

    private void setupFacebook() {
        if (AccessToken.getCurrentAccessToken() != null) {
            loginFacebook.performClick();
        }

        callbackManager = CallbackManager.Factory.create();
        loginFacebook.setReadPermissions("email");
        loginFacebook.setFragment(this);
        loginFacebook.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
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
                    String email = object.getString("email");
                    String name = object.getString("name");
                    String token = accessToken.getToken();

                    String hashedPassword1 = Hashing.md5()
                            .hashString(email, Charset.forName("UTF-8"))
                            .toString();
                    String hashedPassword2 = Hashing.sha1()
                            .hashString(hashedPassword1, Charset.forName("UTF-8"))
                            .toString();
                    String hashedPassword3 = Hashing.sha256()
                            .hashString(hashedPassword2, Charset.forName("UTF-8"))
                            .toString();

                    Map<String, String> params = new HashMap<>();
                    params.put("name", name);
                    params.put("email", email);
                    params.put("password", hashedPassword3);
                    params.put("deviceSecretId", Settings.Secure.getString(getActivity().getContentResolver(), Settings.Secure.ANDROID_ID));
                    params.put("socialMedia", "TRUE");
                    mPresenter.login(params);
                } catch (JSONException e) {
                    Toast.makeText(getApplicationContext(), "graph request error : " + e.getMessage(), Toast.LENGTH_SHORT).show();
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

        Log.v("LoginGoogleSetup", "TRUE");
    }

    private void handleGoogleResult(GoogleSignInResult result) {
        if (result.isSuccess()) {
            GoogleSignInAccount account = result.getSignInAccount();
            String email = account.getEmail();
            String name = account.getDisplayName();

            if (email != null && name != null) {
                String hashedPassword1 = Hashing.md5()
                        .hashString(email, Charset.forName("UTF-8"))
                        .toString();
                String hashedPassword2 = Hashing.sha1()
                        .hashString(hashedPassword1, Charset.forName("UTF-8"))
                        .toString();
                String hashedPassword3 = Hashing.sha256()
                        .hashString(hashedPassword2, Charset.forName("UTF-8"))
                        .toString();

                Map<String, String> params = new HashMap<>();
                params.put("name", name);
                params.put("email", email);
                params.put("password", hashedPassword3);
                params.put("deviceSecretId", Settings.Secure.getString(getActivity().getContentResolver(), Settings.Secure.ANDROID_ID));
                params.put("socialMedia", "TRUE");
                mPresenter.login(params);
            } else {
                showStatus(ConstantUtils.STATUS_ERROR, "Registrasi Gagal");
            }
        }
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

    @Override
    public void redirectToProfile() {
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
            mAwesomeValidation.addValidation(activity, R.id.tilEmailAddress, Patterns.EMAIL_ADDRESS, R.string.validation_email_valid);
            mAwesomeValidation.addValidation(activity, R.id.tilEmailAddress, RegexTemplate.NOT_EMPTY, R.string.validation_email_not_empty);
        }
        mAwesomeValidation.addValidation(activity, R.id.tilName, RegexTemplate.NOT_EMPTY, R.string.validation_name_not_empty);
        mAwesomeValidation.addValidation(activity, R.id.tilPassword, RegexTemplate.NOT_EMPTY, R.string.validation_password_not_empty);

        if (mAwesomeValidation.validate()) {
            Map<String, String> params = new HashMap<>();
            if (rbLoginWithPhoneNumber.isChecked()) {
                params.put("phone", etPhoneNumber.getText().toString());
            } else if (rbLoginWithEmailAddress.isChecked()) {
                params.put("email", etEmailAddress.getText().toString());
            }
            params.put("password", etPassword.getText().toString());
            params.put("deviceSecretId", Settings.Secure.getString(getActivity().getContentResolver(), Settings.Secure.ANDROID_ID));

            mPresenter.login(params);
        }
    }

    @OnClick(R.id.cvLoginWithFacebook)
    public void cvLoginWithFacebook() {
        Log.v("cvLoginWithFacebook", "Clicked!");
        loginFacebook.performClick();
    }

    @OnClick(R.id.cvLoginWithGoogle)
    public void cvLoginWithGoogle() {
        Log.v("cvLoginWithGoogle", "Clicked!");
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
    public void setPresenter(LoginContract.Presenter presenter) {
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
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        showStatus(ConstantUtils.STATUS_ERROR, "Gagal menghubungkan akun Google Anda");
    }
}
