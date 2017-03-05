package com.irfankhoirul.apps.tatravel.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.irfankhoirul.apps.tatravel.base.BaseModel;

import org.parceler.Parcel;

/**
 * Merupakan model dari tabel Lokasi
 *
 * @author  Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since   1.0
 */

@Parcel
public class Lokasi extends BaseModel {
    @SerializedName("id_admin")
    @Expose
    private int idAdmin;

    @SerializedName("id_operator_travel")
    @Expose
    private int idOperatorTravel;

    @SerializedName("id_kota")
    @Expose
    private int idKota;

    @SerializedName("alamat")
    @Expose
    private String alamat;

    @SerializedName("admin")
    @Expose
    private Admin admin;

    @SerializedName("operator_travel")
    @Expose
    private OperatorTravel operatorTravel;

    @SerializedName("kota")
    @Expose
    private Kota kota;

    @SerializedName("latitude")
    @Expose
    private String latitude;

    @SerializedName("longitude")
    @Expose
    private String longitude;

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

    public int getIdKota() {
        return idKota;
    }

    public void setIdKota(int idKota) {
        this.idKota = idKota;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
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

    public Kota getKota() {
        return kota;
    }

    public void setKota(Kota kota) {
        this.kota = kota;
    }

    @Override
    public String toString() {
        return "Lokasi{" +
                "idAdmin=" + idAdmin +
                ", idOperatorTravel=" + idOperatorTravel +
                ", idKota=" + idKota +
                ", alamat='" + alamat + '\'' +
                ", admin=" + admin +
                ", operatorTravel=" + operatorTravel +
                ", kota=" + kota +
                '}';
    }
}
