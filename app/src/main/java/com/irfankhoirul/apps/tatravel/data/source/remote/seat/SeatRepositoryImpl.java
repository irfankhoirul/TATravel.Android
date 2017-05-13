package com.irfankhoirul.apps.tatravel.data.source.remote.seat;

import com.irfankhoirul.apps.tatravel.core.base.BaseRemoteDataSource;
import com.irfankhoirul.apps.tatravel.core.data.DataResult;
import com.irfankhoirul.apps.tatravel.core.data.IRequestResponseListener;
import com.irfankhoirul.apps.tatravel.data.pojo.KursiPerjalanan;

import java.util.Map;

import retrofit2.Call;

/**
 * Created by Irfan Khoirul on 3/11/2017.
 */

public class SeatRepositoryImpl extends BaseRemoteDataSource implements SeatRepository {

    @Override
    public void setEndPoint() {
        endPoint = retrofit.create(IKursiPerjalananEndPoints.class);
    }

    @Override
    public void scheduleSeat(IRequestResponseListener listener, int scheduleId, Map<String, String> param) {
        Call<DataResult<KursiPerjalanan>> call = ((IKursiPerjalananEndPoints) endPoint).listKursiPerjalanan(scheduleId, param);
        execute(call, listener);
    }

    @Override
    public void bookSeat(IRequestResponseListener listener, int seatId, Map<String, String> param) {
        Call<DataResult> call = ((IKursiPerjalananEndPoints) endPoint).bookKursiPerjalanan(seatId, param);
        execute(call, listener);
    }
}