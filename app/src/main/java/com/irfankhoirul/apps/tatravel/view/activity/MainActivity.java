package com.irfankhoirul.apps.tatravel.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.irfankhoirul.apps.tatravel.R;
import com.irfankhoirul.apps.tatravel.view.fragment.SearchFragment;

/**
 * @author  Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since   1.0
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.flMainContainer, new SearchFragment())
                    .commit();
        }

    }
}
