package com.irfankhoirul.apps.tatravel.data.source.remote.seat;

import com.irfankhoirul.apps.tatravel.data.pojo.KursiPerjalanan;
import com.irfankhoirul.mvp_core.base.BaseRemoteRepository;
import com.irfankhoirul.mvp_core.data.DataResult;
import com.irfankhoirul.mvp_core.data.RequestResponseListener;

import java.util.Map;

import retrofit2.Call;

import static com.irfankhoirul.apps.tatravel.data.source.remote.EndPoints.BASE_API_URL;

/**
 * Created by Irfan Khoirul on 3/11/2017.
 */

public class SeatRepositoryImpl extends BaseRemoteRepository<KursiPerjalananEndPoints> implements SeatRepository {

    @Override
    public String setBaseUrl() {
        return BASE_API_URL;
    }

    @Override
    public void setEndPoint() {
        endPoint = retrofit.create(KursiPerjalananEndPoints.class);
    }

    @Override
    public boolean enableLogging() {
        return true;
    }

    @Override
    public void scheduleSeat(RequestResponseListener listener, int scheduleId, Map<String, String> param) {
        Call<DataResult<KursiPerjalanan>> call = ((KursiPerjalananEndPoints) endPoint).listKursiPerjalanan(scheduleId, param);
        execute(call, listener);
    }

    @Override
    public void bookSeat(RequestResponseListener listener, Map<String, String> param) {
        Call<DataResult> call = ((KursiPerjalananEndPoints) endPoint).bookKursiPerjalanan(param);
        execute(call, listener);
    }
}
