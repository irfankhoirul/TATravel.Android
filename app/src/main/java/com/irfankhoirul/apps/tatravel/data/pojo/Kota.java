package com.irfankhoirul.apps.tatravel.data.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Merupakan model dari tabel Kota
 *
 * @author  Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since   1.0
 */

@Parcel
public class Kota extends BaseModel {
    @SerializedName("id_super_admin")
    @Expose
    protected int idSuperAdmin;

    @SerializedName("id_provinsi")
    @Expose
    protected int idProvinsi;

    @SerializedName("nama")
    @Expose
    protected String nama;

    @SerializedName("kode")
    @Expose
    protected String kode;

    @SerializedName("super_admin")
    @Expose
    protected SuperAdmin superAdmin;

    @SerializedName("provinsi")
    @Expose
    protected Provinsi provinsi;

    public int getIdSuperAdmin() {
        return idSuperAdmin;
    }

    public void setIdSuperAdmin(int idSuperAdmin) {
        this.idSuperAdmin = idSuperAdmin;
    }

    public int getIdProvinsi() {
        return idProvinsi;
    }

    public void setIdProvinsi(int idProvinsi) {
        this.idProvinsi = idProvinsi;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
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

    public Provinsi getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(Provinsi provinsi) {
        this.provinsi = provinsi;
    }

    @Override
    public String toString() {
        return "Kota{" +
                "idSuperAdmin=" + idSuperAdmin +
                ", idProvinsi=" + idProvinsi +
                ", nama='" + nama + '\'' +
                ", kode='" + kode + '\'' +
                ", superAdmin=" + superAdmin +
                ", provinsi=" + provinsi +
                '}';
    }
}
