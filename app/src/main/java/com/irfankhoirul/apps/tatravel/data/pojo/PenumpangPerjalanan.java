package com.irfankhoirul.apps.tatravel.data.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.irfankhoirul.mvp_core.base.BasePojo;

/**
 * Merupakan model dari tabel PenumpangPerjalanan
 *
 * @author  Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since   1.0
 */

public class PenumpangPerjalanan extends BasePojo implements Parcelable {
    public static final Creator<PenumpangPerjalanan> CREATOR = new Creator<PenumpangPerjalanan>() {
        @Override
        public PenumpangPerjalanan createFromParcel(Parcel in) {
            return new PenumpangPerjalanan(in);
        }

        @Override
        public PenumpangPerjalanan[] newArray(int size) {
            return new PenumpangPerjalanan[size];
        }
    };
    @SerializedName("id_penumpang")
    @Expose
    private int idPenumpang;
    @SerializedName("id_pemesan")
    @Expose
    private int idPemesan;
    @SerializedName("penumpang")
    @Expose
    private Penumpang penumpang;
    @SerializedName("pemesanan")
    @Expose
    private Pemesanan pemesanan;
    @SerializedName("kursi_perjalanan")
    @Expose
    private KursiPerjalanan kursiPerjalanan;

    protected PenumpangPerjalanan(Parcel in) {
        id = in.readInt();
        createdAt = in.readString();
        updatedAt = in.readString();
        idPenumpang = in.readInt();
        idPemesan = in.readInt();
        penumpang = in.readParcelable(Penumpang.class.getClassLoader());
        pemesanan = in.readParcelable(Pemesanan.class.getClassLoader());
        kursiPerjalanan = in.readParcelable(KursiPerjalanan.class.getClassLoader());
    }

    public int getIdPenumpang() {
        return idPenumpang;
    }

    public void setIdPenumpang(int idPenumpang) {
        this.idPenumpang = idPenumpang;
    }

    public int getIdPemesan() {
        return idPemesan;
    }

    public void setIdPemesan(int idPemesan) {
        this.idPemesan = idPemesan;
    }

    public Penumpang getPenumpang() {
        return penumpang;
    }

    public void setPenumpang(Penumpang penumpang) {
        this.penumpang = penumpang;
    }

    public Pemesanan getPemesanan() {
        return pemesanan;
    }

    public void setPemesanan(Pemesanan pemesanan) {
        this.pemesanan = pemesanan;
    }

    public KursiPerjalanan getKursiPerjalanan() {
        return kursiPerjalanan;
    }

    public void setKursiPerjalanan(KursiPerjalanan kursiPerjalanan) {
        this.kursiPerjalanan = kursiPerjalanan;
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
        dest.writeInt(idPenumpang);
        dest.writeInt(idPemesan);
        dest.writeParcelable(penumpang, flags);
        dest.writeParcelable(pemesanan, flags);
        dest.writeParcelable(kursiPerjalanan, flags);
    }
}
