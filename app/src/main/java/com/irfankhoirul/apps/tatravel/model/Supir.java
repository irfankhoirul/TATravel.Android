package com.irfankhoirul.apps.tatravel.model;

import com.irfankhoirul.apps.tatravel.core.CoreModel;

/**
 * @author  Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since   1.0
 */

public class Supir extends CoreModel {
    private int idAdmin;
    private int idOperatorTravel;
    private String kodeRegistrasi;
    private int idUser;
    private Admin admin;
    private OperatorTravel operatorTravel;
    private User user;

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public int getIdOperatorTravel() {
        return idOperatorTravel;
    }

    public void setIdOperatorTravel(int idOperatorTravel) {
        this.idOperatorTravel = idOperatorTravel;
    }

    public String getKodeRegistrasi() {
        return kodeRegistrasi;
    }

    public void setKodeRegistrasi(String kodeRegistrasi) {
        this.kodeRegistrasi = kodeRegistrasi;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public OperatorTravel getOperatorTravel() {
        return operatorTravel;
    }

    public void setOperatorTravel(OperatorTravel operatorTravel) {
        this.operatorTravel = operatorTravel;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
