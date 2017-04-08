package com.irfankhoirul.apps.tatravel.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.irfankhoirul.apps.tatravel.model.data.local.Session;
import com.irfankhoirul.apps.tatravel.model.pojo.User;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Session<User> session = Session.initialize(this, User.class);
        if (session.getSessionData() != null) {
            Log.v("User Nama", session.getSessionData().getNama());
        }
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
