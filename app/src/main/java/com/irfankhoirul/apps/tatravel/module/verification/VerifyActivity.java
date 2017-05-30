package com.irfankhoirul.apps.tatravel.module.verification;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.irfankhoirul.apps.tatravel.app.TAApplication;
import com.irfankhoirul.apps.tatravel.core.base.BaseFragmentHolderActivity;
import com.irfankhoirul.apps.tatravel.services.receiver.SmsReceiver;

import javax.inject.Inject;

public class VerifyActivity extends BaseFragmentHolderActivity {

    @Inject
    VerifyPresenter verifyPresenter;

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
        VerifyFragment verifyFragment = VerifyFragment.newInstance(getIntent().getStringExtra("phone"),
                getIntent().getStringExtra("email"));
        setCurrentFragment(verifyFragment, false);

        DaggerVerifyComponent.builder()
                .verifyPresenterModule(new VerifyPresenterModule(verifyFragment))
                .appComponent(((TAApplication) getApplication()).getAppComponent())
                .build().inject(this);
    }
}
