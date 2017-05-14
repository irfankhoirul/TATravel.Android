package com.irfankhoirul.apps.tatravel.data.source.remote.reservation;

import com.irfankhoirul.apps.tatravel.core.base.BaseRemoteDataSource;
import com.irfankhoirul.apps.tatravel.core.data.DataResult;
import com.irfankhoirul.apps.tatravel.core.data.IRequestResponseListener;
import com.irfankhoirul.apps.tatravel.data.pojo.Pemesanan;

import java.util.Map;

import retrofit2.Call;

/**
 * Created by Irfan Khoirul on 3/11/2017.
 */

public class ReservationRepositoryImpl extends BaseRemoteDataSource implements ReservationRepository {

    @Override
    public void setEndPoint() {
        endPoint = retrofit.create(IPemesananEndPoints.class);
    }

    @Override
    public void makeReservation(IRequestResponseListener listener, Map<String, String> param) {
        Call<DataResult> call = ((IPemesananEndPoints) endPoint).reservasi(param);
        execute(call, listener);
    }

    @Override
    public void reservationDetail(IRequestResponseListener listener, int reservationId, Map<String, String> param) {
        Call<DataResult<Pemesanan>> call = ((IPemesananEndPoints) endPoint).getReservasi(reservationId, param);
        execute(call, listener);
    }

    @Override
    public void reservationList(IRequestResponseListener listener, Map<String, String> param) {
        Call<DataResult<Pemesanan>> call = ((IPemesananEndPoints) endPoint).listReservasi(param);
        execute(call, listener);
    }
}
