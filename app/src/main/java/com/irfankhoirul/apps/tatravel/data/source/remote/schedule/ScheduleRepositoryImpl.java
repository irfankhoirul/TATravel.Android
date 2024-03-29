package com.irfankhoirul.apps.tatravel.data.source.remote.schedule;

import com.irfankhoirul.apps.tatravel.data.pojo.JadwalPerjalanan;
import com.irfankhoirul.apps.tatravel.data.pojo.Lokasi;
import com.irfankhoirul.mvp_core.base.BaseRemoteRepository;
import com.irfankhoirul.mvp_core.data.DataResult;
import com.irfankhoirul.mvp_core.data.RequestResponseListener;

import java.util.Map;

import retrofit2.Call;

import static com.irfankhoirul.apps.tatravel.data.source.remote.EndPoints.BASE_API_URL;

/**
 * Created by Irfan Khoirul on 3/11/2017.
 */

public class ScheduleRepositoryImpl extends BaseRemoteRepository<IScheduleEndPoints> implements ScheduleRepository {

    @Override
    public String setBaseUrl() {
        return BASE_API_URL;
    }

    @Override
    public void setEndPoint() {
        endPoint = retrofit.create(IScheduleEndPoints.class);
    }

    @Override
    public boolean enableLogging() {
        return true;
    }

    @Override
    public void getDepartureAvailability(RequestResponseListener listener, Map<String, String> param) {
        Call<DataResult<Lokasi>> call = ((IScheduleEndPoints) endPoint).getDepartureAvailability(param);
        execute(call, listener);
    }

    @Override
    public void getDestinationAvailability(RequestResponseListener listener, Map<String, String> param) {
        Call<DataResult<Lokasi>> call = ((IScheduleEndPoints) endPoint).getDestinationAvailability(param);
        execute(call, listener);
    }

    @Override
    public void searchSchedule(RequestResponseListener listener, int operatorTravelId, Map<String, String> param) {
        Call<DataResult<JadwalPerjalanan>> call = ((IScheduleEndPoints) endPoint).listJadwalPerjalanan(operatorTravelId, param);
        execute(call, listener);
    }

}
