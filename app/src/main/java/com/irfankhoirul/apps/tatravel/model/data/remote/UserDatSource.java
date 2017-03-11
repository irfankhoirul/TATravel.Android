package com.irfankhoirul.apps.tatravel.model.data.remote;

import com.irfankhoirul.apps.tatravel.model.api.endpoint.IUserEndPoints;

/**
 * Created by Irfan Khoirul on 3/11/2017.
 */

public class UserDatSource extends BaseRemoteDataSource {

    @Override
    public void setEndPoint() {
        endPoint = retrofit.create(IUserEndPoints.class);
    }

}
