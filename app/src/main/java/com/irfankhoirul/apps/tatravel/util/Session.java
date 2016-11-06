package com.irfankhoirul.apps.tatravel.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.irfankhoirul.apps.tatravel.model.UserToken;

/**
 * Digunakan untuk memanage User Session. Menggunakan Singleton karena token yang terdapat pada
 * session digunakan pada setiap request ke server.
 *
 * @author  Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since   1.0
 * @version 1.0 (6 November 2016)
 */

public class Session {
    private static String USER_TOKEN = "UserToken";
    private static String SHARED_PREFERENCE_NAME = "Session";

    private static Session session = null;

    private UserToken userToken;

    private Session(UserToken userToken) {
        this.userToken = userToken;
    }

    /**
     * Menginisialisasi Session. Dipanggil pada saat user berhasil melakukan login atau pada
     * saat aplikasi pertamakali dijalankan (dipanggil dari method load).
     *
     * @param   activity    Activity saat ini. dignakan untuk mengambil shared preference.
     * @param   userToken   hasil request login ke server.
     * @return  Object singleton Session
     * */
    public static Session initialize(Activity activity, UserToken userToken) {
        SharedPreferences sharedPref = activity.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(USER_TOKEN, new Gson().toJson(userToken));
        editor.apply();

        String userTokenJson = sharedPref.getString(USER_TOKEN, null);

        session = new Session(new Gson().fromJson(userTokenJson, UserToken.class));

        return session;
    }

    /**
     * Meload SharedPreference berisi data session dan memanggil method initialize untuk
     * menginisialisasi Session.
     *
     * @param   activity    Activity saat ini. dignakan untuk mengambil shared preference.
     * @return  Session yang merupakan return value method initialize. Null jika tidak ada shared
     *          preference.
     * */
    public static Session load(Activity activity) {
        SharedPreferences sharedPref = activity.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        if (sharedPref.getString(USER_TOKEN, null) != null) {
            return initialize(activity, new Gson().fromJson(sharedPref.getString(USER_TOKEN, null), UserToken.class));
        } else {
            return null;
        }
    }

    /**
     * Mengembalikan object singleton Session jika session sudah diinisialisasi atau Runtime
     * Exception jika session belum diinisialisasi.
     *
     * @param   activity    Activity saat ini. dignakan untuk mengambil shared preference.
     * @return  object singleton Session jika session sudah diinisialisasi atau Runtime
     * Exception jika session belum diinisialisasi.
     * */
    public static Session getInstance(Activity activity) {
        if (session != null) {
            return session;
        } else {
            throw new RuntimeException("Session has not been created! Try to initialize session first.");
        }
    }

    /**
    * Menghapus session ketika user melakukan logout.
    *
    * @param    activity    Activity saat ini. dignakan untuk mengambil shared preference.i
    * */
    public static void destroy(Activity activity) {
        if (session != null) {
            SharedPreferences sharedPref = activity.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
            sharedPref.edit().clear().apply();
        }
    }

}