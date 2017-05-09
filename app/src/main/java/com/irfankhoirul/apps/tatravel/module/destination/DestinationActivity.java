package com.irfankhoirul.apps.tatravel.module.destination;

import com.irfankhoirul.apps.tatravel.core.base.BaseFragmentHolderActivity;
import com.irfankhoirul.apps.tatravel.data.source.remote.source.jadwal.DaggerJadwalPerjalananDataSourceComponent;

import javax.inject.Inject;

public class DestinationActivity extends BaseFragmentHolderActivity {

    @Inject
    DestinationPresenter mPresenter;

    @Override
    protected void initializeFragment() {
        DestinationFragment destinationFragment = DestinationFragment.newInstance(getIntent().getIntExtra("id_operator_travel", -1));
        setCurrentFragment(destinationFragment, true);

        DaggerDestinationComponent.builder()
                .destinationPresenterModule(new DestinationPresenterModule(destinationFragment))
                .jadwalPerjalananDataSourceComponent(DaggerJadwalPerjalananDataSourceComponent.builder().build())
                .build().inject(this);
    }

}
