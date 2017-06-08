package com.irfankhoirul.apps.tatravel.data.source.locale.session;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.irfankhoirul.apps.tatravel.data.pojo.User;

/**
 * Digunakan untuk memanage User SessionRepositoryImpl. Menggunakan Singleton karena token yang terdapat pada
 * session digunakan pada setiap request ke server.
 *
 * @author Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @version 1.0 (6 November 2016)
 * @since 1.0
 */

public class SessionRepositoryImpl implements SessionRepository {
    private static String SESSION_DATA_KEY = "UserToken";
    private static String SHARED_PREFERENCE_NAME = "SessionRepositoryImpl";

    private SharedPreferences sharedPref;

    public SessionRepositoryImpl(Context context) {
        sharedPref = context.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public User initialize(User sessionData) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(SESSION_DATA_KEY, new Gson().toJson(sessionData));
        editor.apply();
        String sessionDataJson = sharedPref.getString(SESSION_DATA_KEY, null);
        return new Gson().fromJson(sessionDataJson, User.class);
    }

    @Override
    public User getSessionData() {
        String sessionDataJson = sharedPref.getString(SESSION_DATA_KEY, null);
        if (sessionDataJson != null) {
            return new Gson().fromJson(sessionDataJson, User.class);
        }
        return null;
    }

    @Override
    public void setSessionData(User newSessionData) {
        newSessionData.setUserToken(getSessionData().getUserToken());
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(SESSION_DATA_KEY, new Gson().toJson(newSessionData));
        editor.apply();
    }

    @Override
    public void destroy() {
        sharedPref.edit().clear().apply();
    }

}