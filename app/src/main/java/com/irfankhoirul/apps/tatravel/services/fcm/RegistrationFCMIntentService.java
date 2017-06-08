package com.irfankhoirul.apps.tatravel.services.fcm;

import android.app.IntentService;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.irfankhoirul.apps.tatravel.data.source.locale.session.SessionRepositoryImpl;
import com.irfankhoirul.apps.tatravel.data.source.remote.user.UserRepositoryImpl;
import com.irfankhoirul.mvp_core.data.DataResult;
import com.irfankhoirul.mvp_core.data.IRequestResponseListener;

import java.util.HashMap;
import java.util.Map;

public class RegistrationFCMIntentService extends IntentService {

    public static final String SENT_TOKEN_TO_SERVER = "sentTokenToServer";
    public static final String REGISTRATION_COMPLETE = "registrationComplete";
    private static final String TAG = "RegIntentService";
    private SessionRepositoryImpl sessionRepositoryImpl;

    public RegistrationFCMIntentService() {
        super(TAG);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sessionRepositoryImpl = new SessionRepositoryImpl(this);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        try {
            // Get updated InstanceID token.
            String token = FirebaseInstanceId.getInstance().getToken();
            Log.v(TAG, "FCM token: " + token);

            if (sessionRepositoryImpl.getSessionData() != null && sessionRepositoryImpl.getSessionData().getUserToken() != null
                    && sessionRepositoryImpl.getSessionData().getUserToken().getToken() != null) {
                sendRegistrationToServer();
            }

            // Subscribe to topic channels
//            subscribeTopics(token);

            // You should store a boolean that indicates whether the generated token has been
            // sent to your server. If the boolean is false, send the token to your server,
            // otherwise your server should have already received the token.
            sharedPreferences.edit().putBoolean(SENT_TOKEN_TO_SERVER, true).apply();
            // [END register_for_gcm]
        } catch (Exception e) {
            Log.d(TAG, "Failed to complete token refresh", e);
            // If an exception happens while fetching the new token or updating our registration data
            // on a third-party server, this ensures that we'll attempt the update at a later time.
            sharedPreferences.edit().putBoolean(SENT_TOKEN_TO_SERVER, false).apply();
        }
        // Notify UI that registration has completed, so the progress indicator can be hidden.
        Intent registrationComplete = new Intent(REGISTRATION_COMPLETE);
        LocalBroadcastManager.getInstance(this).sendBroadcast(registrationComplete);
    }

    private void sendRegistrationToServer() {
        Map<String, String> params = new HashMap<>();
        params.put("token", sessionRepositoryImpl.getSessionData().getUserToken().getToken());
        params.put("FCMToken", FirebaseInstanceId.getInstance().getToken());
//        params.put("secretCode", Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID));
        UserRepositoryImpl userRepositoryImpl = new UserRepositoryImpl();
        userRepositoryImpl.updateFcmToken(new IRequestResponseListener() {
            @Override
            public void onSuccess(DataResult result) {
            }

            @Override
            public void onFailure(Throwable throwable) {
            }
        }, params);
    }

}
