package com.irfankhoirul.apps.tatravel.module.departure;

import com.irfankhoirul.apps.tatravel.core.base.BaseFragmentHolderActivity;
import com.irfankhoirul.apps.tatravel.data.api.source.jadwal.DaggerJadwalPerjalananDataSourceComponent;

import javax.inject.Inject;

public class DepartureActivity extends BaseFragmentHolderActivity {

    @Inject
    DeparturePresenter mPresenter;

    @Override
    protected void initializeFragment() {
        DepartureFragment departureFragment = new DepartureFragment();
        setCurrentFragment(departureFragment, true);

        DaggerDepartureComponent.builder()
                .departurePresenterModule(new DeparturePresenterModule(departureFragment))
                .jadwalPerjalananDataSourceComponent(DaggerJadwalPerjalananDataSourceComponent.builder().build())
                .build().inject(this);
    }

}
