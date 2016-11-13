package com.irfankhoirul.apps.tatravel.model.pojo;

import com.irfankhoirul.apps.tatravel.core.CoreModel;

/**
 * Merupakan model dari tabel SuperAdmin
 *
 * @author  Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since   1.0
 */

public class SuperAdmin extends CoreModel {
    private int idUser;
    private User user;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
