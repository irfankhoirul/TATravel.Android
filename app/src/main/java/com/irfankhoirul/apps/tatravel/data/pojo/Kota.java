package com.irfankhoirul.apps.tatravel.data.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.irfankhoirul.mvp_core.base.BasePojo;

/**
 * Merupakan model dari tabel Kota
 *
 * @author  Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since   1.0
 */

public class Kota extends BasePojo implements Parcelable {
    public static final Creator<Kota> CREATOR = new Creator<Kota>() {
        @Override
        public Kota createFromParcel(Parcel in) {
            return new Kota(in);
        }

        @Override
        public Kota[] newArray(int size) {
            return new Kota[size];
        }
    };
    @SerializedName("id_super_admin")
    @Expose
    private int idSuperAdmin;
    @SerializedName("id_provinsi")
    @Expose
    private int idProvinsi;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("kode")
    @Expose
    private String kode;
    @SerializedName("super_admin")
    @Expose
    private SuperAdmin superAdmin;
    @SerializedName("provinsi")
    @Expose
    private Provinsi provinsi;

    protected Kota(Parcel in) {
        id = in.readInt();
        createdAt = in.readString();
        updatedAt = in.readString();
        idSuperAdmin = in.readInt();
        idProvinsi = in.readInt();
        nama = in.readString();
        kode = in.readString();
    }

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
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(createdAt);
        dest.writeString(updatedAt);
        dest.writeInt(idSuperAdmin);
        dest.writeInt(idProvinsi);
        dest.writeString(nama);
        dest.writeString(kode);
    }

    @Override
    public String toString() {
        return "Kota{" +
                "idSuperAdmin=" + idSuperAdmin +
                ", idProvinsi=" + idProvinsi +
                ", nama='" + nama + '\'' +
                ", kode='" + kode + '\'' +
                ", superAdmin=" + superAdmin.toString() +
                ", provinsi=" + provinsi.toString() +
                '}';
    }
}
