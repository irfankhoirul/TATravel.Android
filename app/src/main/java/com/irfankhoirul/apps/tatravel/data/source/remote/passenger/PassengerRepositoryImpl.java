package com.irfankhoirul.apps.tatravel.data.source.remote.passenger;

import com.irfankhoirul.apps.tatravel.data.pojo.Penumpang;
import com.irfankhoirul.mvp_core.base.BaseRemoteRepository;
import com.irfankhoirul.mvp_core.data.DataResult;
import com.irfankhoirul.mvp_core.data.IRequestResponseListener;

import java.util.Map;

import retrofit2.Call;

import static com.irfankhoirul.apps.tatravel.data.source.remote.EndPoints.BASE_API_URL;

/**
 * Created by Irfan Khoirul on 3/11/2017.
 */

public class PassengerRepositoryImpl extends BaseRemoteRepository implements PassengerRepository {

    @Override
    public String setBaseUrl() {
        return BASE_API_URL;
    }

    @Override
    public void setEndPoint() {
        endPoint = retrofit.create(IPassengerEndPoints.class);
    }

    @Override
    public boolean enableLogging() {
        return true;
    }

    @Override
    public void createPassenger(IRequestResponseListener listener, int userId, Map<String, String> param) {
        Call<DataResult<Penumpang>> call = ((IPassengerEndPoints) endPoint).createPenumpang(userId, param);
        execute(call, listener);
    }

    @Override
    public void updatePassenger(IRequestResponseListener listener, int userId, int idPenumpang, Map<String, String> param) {
        Call<DataResult<Penumpang>> call = ((IPassengerEndPoints) endPoint).updatePenumpang(userId, idPenumpang, param);
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
