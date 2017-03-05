package com.irfankhoirul.apps.tatravel.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.irfankhoirul.apps.tatravel.base.BaseModel;

import org.parceler.Parcel;

/**
 * Merupakan model dari tabel Penumpang
 *
 * @author  Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since   1.0
 */

@Parcel
public class Penumpang extends BaseModel {
    @SerializedName("id_user")
    @Expose
    private int idUser;

    @SerializedName("nama")
    @Expose
    private String nama;

    @SerializedName("user")
    @Expose
    private User user;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
