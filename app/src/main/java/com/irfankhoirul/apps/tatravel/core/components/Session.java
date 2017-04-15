package com.irfankhoirul.apps.tatravel.core.components;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

/**
 * Digunakan untuk memanage User Session. Menggunakan Singleton karena token yang terdapat pada
 * session digunakan pada setiap request ke server.
 *
 * @author Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @version 1.0 (6 November 2016)
 * @since 1.0
 */

public class Session<T> {
    private static String USER_TOKEN = "UserToken";
    private static String SHARED_PREFERENCE_NAME = "Session";

    private static Session session = null;

    private T sessionData;

    private Session(T sessionData) {
        this.sessionData = sessionData;
    }

    /**
     * Menginisialisasi Session. Dipanggil pada saat user berhasil melakukan login atau pada
     * saat aplikasi pertamakali dijalankan (dipanggil dari method load).
     *
     * @param activity    Activity saat ini. dignakan untuk mengambil shared preference.
     * @param sessionData data session
     * @return Object singleton Session
     */
    public static <U> Session initialize(Activity activity, U sessionData) {
        SharedPreferences sharedPref = activity.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(USER_TOKEN, new Gson().toJson(sessionData));
        editor.apply();

        String sessionDataJson = sharedPref.getString(USER_TOKEN, null);

        session = new Session(new Gson().fromJson(sessionDataJson, sessionData.getClass()));

        return session;
    }

    public static Session initialize(Activity activity, Class classType) {
        SharedPreferences sharedPref = activity.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        String sessionDataJson = sharedPref.getString(USER_TOKEN, null);

        session = new Session(new Gson().fromJson(sessionDataJson, classType));

        return session;
    }

    /**
     * Mengembalikan object singleton Session jika session sudah diinisialisasi atau Runtime
     * Exception jika session belum diinisialisasi.
     *
     * @param activity Activity saat ini. dignakan untuk mengambil shared preference.
     * @return object singleton Session jika session sudah diinisialisasi atau Runtime
     * Exception jika session belum diinisialisasi.
     */
    public static Session getInstance(Activity activity) {
        if (session != null) {
            return session;
        } else {
            return null;
        }
    }

    public static <T> Session update(Activity activity, T sessionData) {
        destroy(activity);
        return initialize(activity, sessionData);
    }

    /**
     * Menghapus session ketika user melakukan logout.
     *
     * @param activity Activity saat ini. dignakan untuk mengambil shared preference.i
     */
    public static void destroy(Activity activity) {
        SharedPreferences sharedPref = activity.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        sharedPref.edit().clear().apply();
        session = null;
    }

    public T getSessionData() {
        return sessionData;
    }

    public void setSessionData(T sessionData) {
        this.sessionData = sessionData;
    }

}