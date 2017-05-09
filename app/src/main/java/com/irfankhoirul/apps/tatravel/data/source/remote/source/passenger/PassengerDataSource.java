package com.irfankhoirul.apps.tatravel.data.source.remote.source.passenger;

import com.irfankhoirul.apps.tatravel.core.base.BaseRemoteDataSource;
import com.irfankhoirul.apps.tatravel.core.data.DataResult;
import com.irfankhoirul.apps.tatravel.core.data.IRequestResponseListener;
import com.irfankhoirul.apps.tatravel.data.pojo.Penumpang;

import java.util.Map;

import retrofit2.Call;

/**
 * Created by Irfan Khoirul on 3/11/2017.
 */

public class PassengerDataSource extends BaseRemoteDataSource {

    @Override
    public void setEndPoint() {
        endPoint = retrofit.create(IPassengerUseCase.class);
    }

    public void createPassenger(IRequestResponseListener listener, String userId, Map<String, String> param) {
        Call<DataResult> call = ((IPassengerUseCase) endPoint).createPenumpang(userId, param);
        execute(call, listener);
    }

    public void updatePassenger(IRequestResponseListener listener, String userId, String idPenumpang, Map<String, String> param) {
        Call<DataResult> call = ((IPassengerUseCase) endPoint).updatePenumpang(userId, idPenumpang, param);
        execute(call, listener);
    }

    public void deletePassenger(IRequestResponseListener listener, String userId, String idPenumpang) {
        Call<DataResult> call = ((IPassengerUseCase) endPoint).deletePenumpang(userId, idPenumpang);
        execute(call, listener);
    }

    public void listPassenger(IRequestResponseListener listener, String userId, Map<String, String> param) {
        Call<DataResult<Penumpang>> call = ((IPassengerUseCase) endPoint).listPenumpang(userId, param);
        execute(call, listener);
    }

}
