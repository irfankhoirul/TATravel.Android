package com.irfankhoirul.apps.tatravel.data.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.irfankhoirul.mvp_core.base.BasePojo;

/**
 * Merupakan model dari tabel Provinsi
 *
 * @author  Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since   1.0
 */

public class Provinsi extends BasePojo implements Parcelable {
    public static final Creator<Provinsi> CREATOR = new Creator<Provinsi>() {
        @Override
        public Provinsi createFromParcel(Parcel in) {
            return new Provinsi(in);
        }

        @Override
        public Provinsi[] newArray(int size) {
            return new Provinsi[size];
        }
    };
    @SerializedName("id_super_admin")
    @Expose
    private int idSuperAdmin;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("super_admin")
    @Expose
    private SuperAdmin superAdmin;

    protected Provinsi(Parcel in) {
        idSuperAdmin = in.readInt();
        nama = in.readString();
    }

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idSuperAdmin);
        dest.writeString(nama);
    }
}
