package com.irfankhoirul.apps.tatravel.modules.passenger;

import android.os.Bundle;
import android.view.View;

import com.irfankhoirul.apps.tatravel.R;
import com.irfankhoirul.apps.tatravel.app.TAApplication;
import com.irfankhoirul.apps.tatravel.data.pojo.Penumpang;
import com.irfankhoirul.mvp_core.base.BaseFragmentHolderActivity;

import org.parceler.Parcels;

import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class PassengerActivity extends BaseFragmentHolderActivity {

    @Inject
    PassengerPresenter mPresenter;

    private PassengerFragment passengerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        btOptionMenu.setVisibility(View.VISIBLE);
        btOptionMenu.setImageResource(R.drawable.ic_add_black_24dp);
    }

    @Override
    protected void initializeFragment() {
        passengerFragment = PassengerFragment.newInstance(
                (List<Penumpang>) Parcels.unwrap(getIntent().getParcelableExtra("selectedPassengers")));
        setCurrentFragment(passengerFragment, false);

        DaggerPassengerComponent.builder()
                .passengerPresenterModule(new PassengerPresenterModule(passengerFragment))
                .appComponent(((TAApplication) getApplication()).getAppComponent())
                .build().inject(this);
    }

    @OnClick(R.id.btOptionMenu)
    public void btOptionMenu() {
        if (passengerFragment != null) {
            passengerFragment.onCreatePassengerClick();
        }
    }

}
