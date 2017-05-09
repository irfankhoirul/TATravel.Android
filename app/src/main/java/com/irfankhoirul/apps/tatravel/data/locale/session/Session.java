package com.irfankhoirul.apps.tatravel.data.locale.session;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.irfankhoirul.apps.tatravel.data.pojo.User;

/**
 * Digunakan untuk memanage User Session. Menggunakan Singleton karena token yang terdapat pada
 * session digunakan pada setiap request ke server.
 *
 * @author Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @version 1.0 (6 November 2016)
 * @since 1.0
 */

public class Session implements SessionRepository {
    private static String USER_TOKEN = "UserToken";
    private static String SHARED_PREFERENCE_NAME = "Session";

    private SharedPreferences sharedPref;

    public Session(Context context) {
        sharedPref = context.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public User initialize(User sessionData) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(USER_TOKEN, new Gson().toJson(sessionData));
        editor.apply();
        String sessionDataJson = sharedPref.getString(USER_TOKEN, null);
        return new Gson().fromJson(sessionDataJson, User.class);
    }

    @Override
    public User getSessionData() {
        String sessionDataJson = sharedPref.getString(USER_TOKEN, null);
        if (sessionDataJson != null) {
            return new Gson().fromJson(sessionDataJson, User.class);
        }
        return null;
    }

    @Override
    public void setSessionData(User sessionData) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(USER_TOKEN, new Gson().toJson(sessionData));
        editor.apply();
    }

    @Override
    public void destroy() {
        sharedPref.edit().clear().apply();
    }

}