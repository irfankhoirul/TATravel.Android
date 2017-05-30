package com.irfankhoirul.apps.tatravel.data.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.irfankhoirul.mvp_core.base.BaseModel;

import org.parceler.Parcel;

/**
 * Merupakan model dari tabel Provinsi
 *
 * @author  Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since   1.0
 */

@Parcel
public class Provinsi extends BaseModel {
    @SerializedName("id_super_admin")
    @Expose
    protected int idSuperAdmin;

    @SerializedName("nama")
    @Expose
    protected String nama;

    @SerializedName("super_admin")
    @Expose
    protected SuperAdmin superAdmin;

    public int getIdSuperAdmin() {
        return idSuperAdmin;
    }

    public void setIdSuperAdmin(int idSuperAdmin) {
        this.idSuperAdmin = idSuperAdmin;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public SuperAdmin getSuperAdmin() {
        return superAdmin;
    }

    public void setSuperAdmin(SuperAdmin superAdmin) {
        this.superAdmin = superAdmin;
    }

    @Override
    public String toString() {
        return "Provinsi{" +
                "idSuperAdmin=" + idSuperAdmin +
                ", nama='" + nama + '\'' +
                ", superAdmin=" + superAdmin +
                '}';
    }
}
