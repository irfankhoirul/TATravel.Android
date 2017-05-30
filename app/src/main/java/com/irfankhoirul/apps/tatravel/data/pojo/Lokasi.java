package com.irfankhoirul.apps.tatravel.data.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.irfankhoirul.mvp_core.base.BaseModel;

import org.parceler.Parcel;

/**
 * Merupakan model dari tabel Lokasi
 *
 * @author  Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since   1.0
 */

@Parcel
public class Lokasi extends BaseModel {
    @SerializedName("nama")
    @Expose
    protected String nama;

    @SerializedName("id_admin")
    @Expose
    protected int idAdmin;

    @SerializedName("id_operator_travel")
    @Expose
    protected int idOperatorTravel;

    @SerializedName("id_kota")
    @Expose
    protected int idKota;

    @SerializedName("alamat")
    @Expose
    protected String alamat;

    @SerializedName("admin")
    @Expose
    protected Admin admin;

    @SerializedName("operator_travel")
    @Expose
    protected OperatorTravel operatorTravel;

    @SerializedName("kota")
    @Expose
    protected Kota kota;

    @SerializedName("latitude")
    @Expose
    protected String latitude;

    @SerializedName("longitude")
    @Expose
    protected String longitude;

    @SerializedName("distance")
    @Expose
    protected String distance;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

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

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
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
