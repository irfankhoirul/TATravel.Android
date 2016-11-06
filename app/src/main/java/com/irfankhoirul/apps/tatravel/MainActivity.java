package com.irfankhoirul.apps.tatravel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.irfankhoirul.apps.tatravel.util.Session;
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
