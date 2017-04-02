package com.irfankhoirul.apps.tatravel.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

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
import com.irfankhoirul.apps.tatravel.view.activity.RegisterActivity;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

import static com.facebook.FacebookSdk.getApplicationContext;
import static com.irfankhoirul.apps.tatravel.util.ConstantUtils.LOGIN_GOOGLE_REQUEST;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends BaseFragment<RegisterActivity> implements GoogleApiClient.OnConnectionFailedListener {

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
    @BindView(R.id.cvLoginGoogle)
    CardView cvLoginGoogle;
    @BindView(R.id.cvLoginFacebook)
    CardView cvLoginFacebook;
    @BindView(R.id.loginFacebook)
    LoginButton loginFacebook;
    @BindView(R.id.loginGoogle)
    SignInButton loginGoogle;

    private CallbackManager callbackManager;
    private GoogleApiClient mGoogleApiClient;

    public RegisterFragment() {
        // Required empty public constructor
    }

    @Override
    protected void setTitle() {
        title = "Daftar";
    }

    @Override
    protected void setPresenter() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        unbinder = ButterKnife.bind(this, view);
        setupFacebook();
        setupGoogle();

        return view;
    }

    @OnClick(R.id.btLogin)
    public void btLogin() {

    }

    private void setupFacebook() {
        if (AccessToken.getCurrentAccessToken() != null) {
            handleFacebookResult(AccessToken.getCurrentAccessToken());
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
        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        Log.v("reqCode", String.valueOf(mGoogleApiClient));
        if (requestCode == LOGIN_GOOGLE_REQUEST) {
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

    @OnClick(R.id.cvLoginFacebook)
    public void cvLoginFacebook() {
        loginFacebook.performClick();
    }

    @OnClick(R.id.cvLoginGoogle)
    public void cvLoginGoogle() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, LOGIN_GOOGLE_REQUEST);
    }

}
