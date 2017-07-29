package com.irfankhoirul.apps.tatravel.data.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.irfankhoirul.mvp_core.base.BasePojo;

/**
 * Merupakan model dari tabel GeraiPembayaran
 *
 * @author  Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since   1.0
 */

public class GeraiPembayaran extends BasePojo implements Parcelable {
    public static final Creator<GeraiPembayaran> CREATOR = new Creator<GeraiPembayaran>() {
        @Override
        public GeraiPembayaran createFromParcel(Parcel in) {
            return new GeraiPembayaran(in);
        }

        @Override
        public GeraiPembayaran[] newArray(int size) {
            return new GeraiPembayaran[size];
        }
    };
    @SerializedName("nama")
    @Expose
    private String nama;

    protected GeraiPembayaran(Parcel in) {
        id = in.readInt();
        createdAt = in.readString();
        updatedAt = in.readString();
        nama = in.readString();
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
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
        dest.writeString(nama);
    }

    @Override
    public String toString() {
        return "GeraiPembayaran{" +
                "nama='" + nama + '\'' +
                '}';
    }
}
