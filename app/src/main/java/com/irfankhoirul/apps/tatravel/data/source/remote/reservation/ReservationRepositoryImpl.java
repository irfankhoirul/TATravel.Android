package com.irfankhoirul.apps.tatravel.data.source.remote.reservation;

import com.irfankhoirul.apps.tatravel.core.base.BaseRemoteRepository;
import com.irfankhoirul.apps.tatravel.core.data.DataResult;
import com.irfankhoirul.apps.tatravel.core.data.IRequestResponseListener;
import com.irfankhoirul.apps.tatravel.data.pojo.Pemesanan;

import java.util.Map;

import retrofit2.Call;

import static com.irfankhoirul.apps.tatravel.data.source.remote.EndPoints.BASE_API_URL;

/**
 * Created by Irfan Khoirul on 3/11/2017.
 */

public class ReservationRepositoryImpl extends BaseRemoteRepository implements ReservationRepository {

    @Override
    public String setBaseUrl() {
        return BASE_API_URL;
    }

    @Override
    public void setEndPoint() {
        endPoint = retrofit.create(IPemesananEndPoints.class);
    }

    @Override
    public boolean enableLogging() {
        return true;
    }

    @Override
    public void makeReservation(IRequestResponseListener listener, Map<String, String> param) {
        Call<DataResult<Pemesanan>> call = ((IPemesananEndPoints) endPoint).reservasi(param);
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
