package com.irfankhoirul.apps.tatravel.data.source.remote.seat;

import com.irfankhoirul.apps.tatravel.core.base.BaseRemoteRepository;
import com.irfankhoirul.apps.tatravel.core.data.DataResult;
import com.irfankhoirul.apps.tatravel.core.data.IRequestResponseListener;
import com.irfankhoirul.apps.tatravel.data.pojo.KursiPerjalanan;

import java.util.Map;

import retrofit2.Call;

import static com.irfankhoirul.apps.tatravel.data.source.remote.EndPoints.BASE_API_URL;

/**
 * Created by Irfan Khoirul on 3/11/2017.
 */

public class SeatRepositoryImpl extends BaseRemoteRepository implements SeatRepository {

    @Override
    public String setBaseUrl() {
        return BASE_API_URL;
    }

    @Override
    public void setEndPoint() {
        endPoint = retrofit.create(IKursiPerjalananEndPoints.class);
    }

    @Override
    public boolean enableLogging() {
        return true;
    }

    @Override
    public void scheduleSeat(IRequestResponseListener listener, int scheduleId, Map<String, String> param) {
        Call<DataResult<KursiPerjalanan>> call = ((IKursiPerjalananEndPoints) endPoint).listKursiPerjalanan(scheduleId, param);
        execute(call, listener);
    }

    @Override
    public void bookSeat(IRequestResponseListener listener, Map<String, String> param) {
        Call<DataResult> call = ((IKursiPerjalananEndPoints) endPoint).bookKursiPerjalanan(param);
        execute(call, listener);
    }
}
