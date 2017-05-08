package com.irfankhoirul.apps.tatravel.data.locale.session;

import com.irfankhoirul.apps.tatravel.data.pojo.User;

/**
 * Created by Irfan Khoirul on 5/8/2017.
 */

public interface SessionRepository {
    User initialize(User sessionData);

    User getSessionData();

    void setSessionData(User sessionData);

    void destroy();
}
