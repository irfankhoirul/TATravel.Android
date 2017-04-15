package com.irfankhoirul.apps.tatravel.module.verification;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.irfankhoirul.apps.tatravel.core.base.BaseFragmentHolderActivity;
import com.irfankhoirul.apps.tatravel.core.components.receiver.SmsReceiver;

public class VerifyActivity extends BaseFragmentHolderActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SmsReceiver.bindListener(new SmsReceiver.SmsListener() {
            @Override
            public void messageReceived(String messageText) {
                Log.d("Text", messageText);
                Toast.makeText(VerifyActivity.this, "Message: " + messageText, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void initializeFragment() {
        setCurrentFragment(VerifyFragment.newInstance(getIntent().getStringExtra("phone")), false);
    }
}
