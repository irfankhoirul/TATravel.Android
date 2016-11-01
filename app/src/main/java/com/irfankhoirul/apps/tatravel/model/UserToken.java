package com.irfankhoirul.apps.tatravel.model;

import com.irfankhoirul.apps.tatravel.core.CoreModel;

/**
 * @author Irfan Khoirul Muhlishin
 * @since 11/1/2016
 */

public class UserToken extends CoreModel {
    private long expiredAt;
    private int idUser;
    private int idUserDevice;
    private String status;
    private String token;
    private int totalRequest;

    public long getExpiredAt() {
        return expiredAt;
    }

    public void setExpiredAt(long expiredAt) {
        this.expiredAt = expiredAt;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdUserDevice() {
        return idUserDevice;
    }

    public void setIdUserDevice(int idUserDevice) {
        this.idUserDevice = idUserDevice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getTotalRequest() {
        return totalRequest;
    }

    public void setTotalRequest(int totalRequest) {
        this.totalRequest = totalRequest;
    }
}
