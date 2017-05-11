package com.irfankhoirul.apps.tatravel.data.source.remote.schedule;

import com.irfankhoirul.apps.tatravel.core.base.BaseRemoteDataSource;
import com.irfankhoirul.apps.tatravel.core.data.DataResult;
import com.irfankhoirul.apps.tatravel.core.data.IRequestResponseListener;
import com.irfankhoirul.apps.tatravel.data.pojo.Lokasi;

import java.util.Map;

import retrofit2.Call;

/**
 * Created by Irfan Khoirul on 3/11/2017.
 */

public class ScheduleRepositoryImpl extends BaseRemoteDataSource implements ScheduleRepository {

    @Override
    public void setEndPoint() {
        endPoint = retrofit.create(IScheduleEndPoints.class);
    }

    @Override
    public void getDepartureAvailability(IRequestResponseListener listener, Map<String, String> param) {
        Call<DataResult<Lokasi>> call = ((IScheduleEndPoints) endPoint).getDepartureAvailability(param);
        execute(call, listener);
    }

    @Override
    public void getDestinationAvailability(IRequestResponseListener listener, Map<String, String> param) {
        Call<DataResult<Lokasi>> call = ((IScheduleEndPoints) endPoint).getDestinationAvailability(param);
        execute(call, listener);
    }

}
