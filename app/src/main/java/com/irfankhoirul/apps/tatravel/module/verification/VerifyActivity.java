package com.irfankhoirul.apps.tatravel.module.verification;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.irfankhoirul.apps.tatravel.core.base.BaseFragmentHolderActivity;
import com.irfankhoirul.apps.tatravel.core.components.receiver.SmsReceiver;
import com.irfankhoirul.apps.tatravel.data.source.user.DaggerUserDataSourceComponent;

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
        VerifyFragment verifyFragment = VerifyFragment.newInstance(getIntent().getStringExtra("phone"));
        setCurrentFragment(verifyFragment, false);
        DaggerVerifyComponent.builder()
                .verifyPresenterModule(new VerifyPresenterModule(verifyFragment))
                .userDataSourceComponent(DaggerUserDataSourceComponent.builder().build())
                .build().inject(this);
    }
}
