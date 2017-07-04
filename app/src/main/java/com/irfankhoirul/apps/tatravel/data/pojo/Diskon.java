package com.irfankhoirul.apps.tatravel.data.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.irfankhoirul.mvp_core.base.BasePojo;

/**
 * Merupakan model dari tabel Diskon
 *
 * @author  Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since   1.0
 */

public class Diskon extends BasePojo implements Parcelable {
    public static final Creator<Diskon> CREATOR = new Creator<Diskon>() {
        @Override
        public Diskon createFromParcel(Parcel in) {
            return new Diskon(in);
        }

        @Override
        public Diskon[] newArray(int size) {
            return new Diskon[size];
        }
    };
    @SerializedName("id_jadwal_perjalanan")
    @Expose
    private int idJadwalPerjalanan;
    @SerializedName("nilai")
    @Expose
    private int nilai;
    @SerializedName("jadwal_perjalanan")
    @Expose
    private JadwalPerjalanan jadwalPerjalanan;

    protected Diskon(Parcel in) {
        idJadwalPerjalanan = in.readInt();
        nilai = in.readInt();
    }

    public int getIdJadwalPerjalanan() {
        return idJadwalPerjalanan;
    }

    public void setIdJadwalPerjalanan(int idJadwalPerjalanan) {
        this.idJadwalPerjalanan = idJadwalPerjalanan;
    }

    public int getNilai() {
        return nilai;
    }

    public void setNilai(int nilai) {
        this.nilai = nilai;
    }

    public JadwalPerjalanan getJadwalPerjalanan() {
        return jadwalPerjalanan;
    }

    public void setJadwalPerjalanan(JadwalPerjalanan jadwalPerjalanan) {
        this.jadwalPerjalanan = jadwalPerjalanan;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idJadwalPerjalanan);
        dest.writeInt(nilai);
    }
}
