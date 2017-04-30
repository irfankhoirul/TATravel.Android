package com.irfankhoirul.apps.tatravel.data.api.source.jadwal_perjalanan;

import com.irfankhoirul.apps.tatravel.core.base.BaseRemoteDataSource;

/**
 * Created by Irfan Khoirul on 3/11/2017.
 */

public class JadwalPerjalananDataSource extends BaseRemoteDataSource {

    @Override
    public void setEndPoint() {
        endPoint = retrofit.create(IJadwalPerjalananEndPoints.class);
    }

}
