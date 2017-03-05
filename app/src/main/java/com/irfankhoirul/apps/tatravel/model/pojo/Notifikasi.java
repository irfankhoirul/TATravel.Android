package com.irfankhoirul.apps.tatravel.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.irfankhoirul.apps.tatravel.base.BaseModel;

import org.parceler.Parcel;

/**
 * Merupakan model dari tabel Notifikasi
 *
 * @author  Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since   1.0
 */

@Parcel
public class Notifikasi extends BaseModel {
    @SerializedName("id_user_device")
    @Expose
    private int idUserDevice;

    @SerializedName("pesan")
    @Expose
    private String pesan;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("tipe")
    @Expose
    private String tipe;

    @SerializedName("user_device")
    @Expose
    private UserDevice userDevice;

    public int getIdUserDevice() {
        return idUserDevice;
    }

    public void setIdUserDevice(int idUserDevice) {
        this.idUserDevice = idUserDevice;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public UserDevice getUserDevice() {
        return userDevice;
    }

    public void setUserDevice(UserDevice userDevice) {
        this.userDevice = userDevice;
    }

}
