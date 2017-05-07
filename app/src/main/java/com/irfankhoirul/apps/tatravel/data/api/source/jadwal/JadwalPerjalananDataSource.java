package com.irfankhoirul.apps.tatravel.data.api.source.jadwal;

import com.irfankhoirul.apps.tatravel.core.base.BaseRemoteDataSource;
import com.irfankhoirul.apps.tatravel.core.data.DataResult;
import com.irfankhoirul.apps.tatravel.core.data.IRequestResponseListener;
import com.irfankhoirul.apps.tatravel.data.pojo.Lokasi;

import java.util.Map;

import retrofit2.Call;

/**
 * Created by Irfan Khoirul on 3/11/2017.
 */

public class JadwalPerjalananDataSource extends BaseRemoteDataSource {

    @Override
    public void setEndPoint() {
        endPoint = retrofit.create(IJadwalPerjalananEndPoints.class);
    }

    public void getDepartureAvailability(IRequestResponseListener listener, Map<String, String> param) {
        Call<DataResult<Lokasi>> call = ((IJadwalPerjalananEndPoints) endPoint).getDepartureAvailability(param);
        execute(call, listener);
    }

    public void getDestinationAvailability(IRequestResponseListener listener, Map<String, String> param) {
        Call<DataResult<Lokasi>> call = ((IJadwalPerjalananEndPoints) endPoint).getDestinationAvailability(param);
        execute(call, listener);
    }

}
