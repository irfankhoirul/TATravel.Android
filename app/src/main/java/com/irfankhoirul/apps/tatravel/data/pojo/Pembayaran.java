package com.irfankhoirul.apps.tatravel.data.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.irfankhoirul.mvp_core.base.BasePojo;

/**
 * Merupakan model dari tabel Pembayaran
 *
 * @author  Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since   1.0
 */

public class Pembayaran extends BasePojo implements Parcelable {
    public static final String PAYMENT_STATUS_PAID = "P";
    public static final String PAYMENT_STATUS_UNPAID = "U";
    public static final String PAYMENT_STATUS_TIMEOUT = "O";
    public static final Creator<Pembayaran> CREATOR = new Creator<Pembayaran>() {
        @Override
        public Pembayaran createFromParcel(Parcel in) {
            return new Pembayaran(in);
        }

        @Override
        public Pembayaran[] newArray(int size) {
            return new Pembayaran[size];
        }
    };
    @SerializedName("id_pembayaran")
    @Expose
    private int idPembayaran;
    @SerializedName("kode_pemesanan")
    @Expose
    private String kodePemesanan;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("pembayaran")
    @Expose
    private Pembayaran pembayaran;

    protected Pembayaran(Parcel in) {
        id = in.readInt();
        createdAt = in.readString();
        updatedAt = in.readString();
        idPembayaran = in.readInt();
        kodePemesanan = in.readString();
        status = in.readString();
        pembayaran = in.readParcelable(Pembayaran.class.getClassLoader());
    }

    public int getIdPembayaran() {
        return idPembayaran;
    }

    public void setIdPembayaran(int idPembayaran) {
        this.idPembayaran = idPembayaran;
    }

    public String getKodePemesanan() {
        return kodePemesanan;
    }

    public void setKodePemesanan(String kodePemesanan) {
        this.kodePemesanan = kodePemesanan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Pembayaran getPembayaran() {
        return pembayaran;
    }

    public void setPembayaran(Pembayaran pembayaran) {
        this.pembayaran = pembayaran;
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
        dest.writeInt(idPembayaran);
        dest.writeString(kodePemesanan);
        dest.writeString(status);
        dest.writeParcelable(pembayaran, flags);
    }

    @Override
    public String toString() {
        return "Pembayaran{" +
                "idPembayaran=" + idPembayaran +
                ", kodePemesanan='" + kodePemesanan + '\'' +
                ", status='" + status + '\'' +
                ", pembayaran=" + pembayaran.toString() +
                '}';
    }
}
