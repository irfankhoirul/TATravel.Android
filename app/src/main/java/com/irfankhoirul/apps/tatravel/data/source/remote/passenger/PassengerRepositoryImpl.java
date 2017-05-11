package com.irfankhoirul.apps.tatravel.data.source.remote.passenger;

import com.irfankhoirul.apps.tatravel.core.base.BaseRemoteDataSource;
import com.irfankhoirul.apps.tatravel.core.data.DataResult;
import com.irfankhoirul.apps.tatravel.core.data.IRequestResponseListener;
import com.irfankhoirul.apps.tatravel.data.pojo.Penumpang;

import java.util.Map;

import retrofit2.Call;

/**
 * Created by Irfan Khoirul on 3/11/2017.
 */

public class PassengerRepositoryImpl extends BaseRemoteDataSource implements PassengerRepository {

    @Override
    public void setEndPoint() {
        endPoint = retrofit.create(IPassengerEndPoints.class);
    }

    @Override
    public void createPassenger(IRequestResponseListener listener, int userId, Map<String, String> param) {
        Call<DataResult> call = ((IPassengerEndPoints) endPoint).createPenumpang(userId, param);
        execute(call, listener);
    }

    @Override
    public void updatePassenger(IRequestResponseListener listener, int userId, int idPenumpang, Map<String, String> param) {
        Call<DataResult> call = ((IPassengerEndPoints) endPoint).updatePenumpang(userId, idPenumpang, param);
        execute(call, listener);
    }

    @Override
    public void deletePassenger(IRequestResponseListener listener, int userId, int idPenumpang, Map<String, String> param) {
        Call<DataResult> call = ((IPassengerEndPoints) endPoint).deletePenumpang(userId, idPenumpang, param);
        execute(call, listener);
    }

    @Override
    public void listPassenger(IRequestResponseListener listener, int userId, Map<String, String> param) {
        Call<DataResult<Penumpang>> call = ((IPassengerEndPoints) endPoint).listPenumpang(userId, param);
        execute(call, listener);
    }

}
