package com.irfankhoirul.apps.tatravel.aaa.module.user.register;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
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
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.irfankhoirul.apps.tatravel.R;
import com.irfankhoirul.apps.tatravel.aaa.core.base.BaseFragment;
import com.irfankhoirul.apps.tatravel.aaa.core.components.util.ConstantUtils;
import com.irfankhoirul.apps.tatravel.contract.RegisterContract;
import com.irfankhoirul.apps.tatravel.presenter.RegisterPresenter;
import com.irfankhoirul.apps.tatravel.view.activity.RegisterActivity;
import com.irfankhoirul.apps.tatravel.view.activity.VerifyActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

import static com.basgeekball.awesomevalidation.ValidationStyle.TEXT_INPUT_LAYOUT;
import static com.facebook.FacebookSdk.getApplicationContext;
import static com.irfankhoirul.apps.tatravel.aaa.core.components.util.ConstantUtils.REGISTER_GOOGLE_REQUEST;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends BaseFragment<RegisterActivity> implements
        RegisterContract.View,
        GoogleApiClient.OnConnectionFailedListener {

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

    private RegisterPresenter mPresenter;

    public RegisterFragment() {
        // Required empty public constructor
    }

    @Override
    protected void setTitle() {
        title = "Daftar";
    }

    @Override
    public void setPresenter() {
        mPresenter = new RegisterPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_register, container, false);
        unbinder = ButterKnife.bind(this, fragmentView);
        mPresenter.start();
        setupFacebook();
        setupGoogle();

        return fragmentView;
    }

    @OnClick(R.id.btRegister)
    public void btRegister() {
        View view = activity.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

        AwesomeValidation mAwesomeValidation = new AwesomeValidation(TEXT_INPUT_LAYOUT);
        if (rbRegisterWithPhoneNumber.isChecked()) {
            mAwesomeValidation.addValidation(activity, R.id.tilPhoneNumber, Patterns.PHONE, R.string.validation_phone_valid);
            mAwesomeValidation.addValidation(activity, R.id.tilPhoneNumber, RegexTemplate.NOT_EMPTY, R.string.validation_phone_not_empty);
        } else if (rbRegisterWithEmailAddress.isChecked()) {
            mAwesomeValidation.addValidation(activity, R.id.tilEmailAddress, Patterns.PHONE, R.string.validation_phone_valid);
            mAwesomeValidation.addValidation(activity, R.id.tilEmailAddress, RegexTemplate.NOT_EMPTY, R.string.validation_phone_not_empty);
        }
        mAwesomeValidation.addValidation(activity, R.id.tilName, RegexTemplate.NOT_EMPTY, R.string.validation_name_not_empty);
        mAwesomeValidation.addValidation(activity, R.id.tilPassword, RegexTemplate.NOT_EMPTY, R.string.validation_password_not_empty);

        if (mAwesomeValidation.validate()) {
            Map<String, String> params = new HashMap<>();
            params.put("name", etName.getText().toString());
            params.put("phone", etPhoneNumber.getText().toString());
            params.put("password", etPassword.getText().toString());
            params.put("deviceSecretId", Settings.Secure.getString(getActivity().getContentResolver(), Settings.Secure.ANDROID_ID));
            Log.v("Validation", "Pass");

            mPresenter.register(params);
        } else {
            Log.v("Validation", "Failed");
        }
    }

    private void setupFacebook() {
        if (AccessToken.getCurrentAccessToken() != null) {
            handleFacebookResult(AccessToken.getCurrentAccessToken());
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
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });
    }

    private void handleFacebookResult(final AccessToken accessToken) {
        GraphRequest req = GraphRequest.newMeRequest(accessToken, new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {
                try {
                    String email = object.getString("email");
                    Log.v("Facebook Email", email);
                    String name = object.getString("name");
                    Log.v("Facebook Name", name);
                    String token = accessToken.getToken();
                    Log.v("Facebook Token", token);
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

        if (mGoogleApiClient.isConnected()) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient));
            handleGoogleResult(result);
        }
    }

    private void handleGoogleResult(GoogleSignInResult result) {
        if (result.isSuccess()) {
            // Signed in successfully, show authenticated UI.
            GoogleSignInAccount account = result.getSignInAccount();
            String email = account.getEmail();
            Log.v("Google Email", email);
            String name = account.getDisplayName();
            Log.v("Google Name", name);
//            String token = account.getIdToken();
//            Log.v("Google Token", token);
//            updateUI(true);
        } else {
            // Signed out, show unauthenticated UI.
//            updateUI(false);
        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

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

    @OnClick(R.id.cvRegisterWithFacebook)
    public void cvRegisterWithFacebook() {
        registerFacebook.performClick();
    }

    @OnClick(R.id.cvRegisterWithGoogle)
    public void cvRegisterWithGoogle() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, REGISTER_GOOGLE_REQUEST);
    }

    @Override
    public void redirectToVerification() {
        Intent intent = new Intent(activity, VerifyActivity.class);
        intent.putExtra("phone", etPhoneNumber.getText().toString());
        startActivityForResult(intent, ConstantUtils.INTENT_REQUEST_REGISTER_TO_VALIDATION);
    }

}
