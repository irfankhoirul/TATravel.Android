package com.irfankhoirul.apps.tatravel.data.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.irfankhoirul.mvp_core.base.BasePojo;

import java.util.List;

/**
 * Merupakan model dari tabel Pemesanan
 *
 * @author Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since 1.0
 */

public class Pemesanan extends BasePojo implements Parcelable {
    public static final Creator<Pemesanan> CREATOR = new Creator<Pemesanan>() {
        @Override
        public Pemesanan createFromParcel(Parcel in) {
            return new Pemesanan(in);
        }

        @Override
        public Pemesanan[] newArray(int size) {
            return new Pemesanan[size];
        }
    };
    @SerializedName("id_user")
    @Expose
    private int idUser;
    @SerializedName("id_jadwal_perjalanan")
    @Expose
    private int idJadwalPerjalanan;
    @SerializedName("kode_pemesanan")
    @Expose
    private String kodePemesanan;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("jadwal_perjalanan")
    @Expose
    private JadwalPerjalanan jadwalPerjalanan;
    @SerializedName("pembayaran")
    @Expose
    private Pembayaran pembayaran;

    @SerializedName("lokasi_penjemputan")
    @Expose
    private LokasiDetail lokasiPenjemputan;

    @SerializedName("lokasi_pengantaran")
    @Expose
    private LokasiDetail lokasiPengantaran;
    @SerializedName("penumpang_perjalanan")
    @Expose
    private List<PenumpangPerjalanan> penumpangPerjalanan;

    protected Pemesanan(Parcel in) {
        id = in.readInt();
        createdAt = in.readString();
        updatedAt = in.readString();
        idUser = in.readInt();
        idJadwalPerjalanan = in.readInt();
        kodePemesanan = in.readString();
        jadwalPerjalanan = in.readParcelable(JadwalPerjalanan.class.getClassLoader());
        pembayaran = in.readParcelable(Pembayaran.class.getClassLoader());
        lokasiPenjemputan = in.readParcelable(LokasiDetail.class.getClassLoader());
        lokasiPengantaran = in.readParcelable(LokasiDetail.class.getClassLoader());
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdJadwalPerjalanan() {
        return idJadwalPerjalanan;
    }

    public void setIdJadwalPerjalanan(int idJadwalPerjalanan) {
        this.idJadwalPerjalanan = idJadwalPerjalanan;
    }

    public String getKodePemesanan() {
        return kodePemesanan;
    }

    public void setKodePemesanan(String kodePemesanan) {
        this.kodePemesanan = kodePemesanan;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public JadwalPerjalanan getJadwalPerjalanan() {
        return jadwalPerjalanan;
    }

    public void setJadwalPerjalanan(JadwalPerjalanan jadwalPerjalanan) {
        this.jadwalPerjalanan = jadwalPerjalanan;
    }

    public Pembayaran getPembayaran() {
        return pembayaran;
    }

    public void setPembayaran(Pembayaran pembayaran) {
        this.pembayaran = pembayaran;
    }

    public LokasiDetail getLokasiPenjemputan() {
        return lokasiPenjemputan;
    }

    public void setLokasiPenjemputan(LokasiDetail lokasiPenjemputan) {
        this.lokasiPenjemputan = lokasiPenjemputan;
    }

    public LokasiDetail getLokasiPengantaran() {
        return lokasiPengantaran;
    }

    public void setLokasiPengantaran(LokasiDetail lokasiPengantaran) {
        this.lokasiPengantaran = lokasiPengantaran;
    }

    public List<PenumpangPerjalanan> getPenumpangPerjalanan() {
        return penumpangPerjalanan;
    }

    public void setPenumpangPerjalanan(List<PenumpangPerjalanan> penumpangPerjalanan) {
        this.penumpangPerjalanan = penumpangPerjalanan;
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
        dest.writeInt(idUser);
        dest.writeInt(idJadwalPerjalanan);
        dest.writeString(kodePemesanan);
        dest.writeParcelable(jadwalPerjalanan, flags);
        dest.writeParcelable(pembayaran, flags);
        dest.writeParcelable(lokasiPenjemputan, flags);
        dest.writeParcelable(lokasiPengantaran, flags);
    }

    @Override
    public String toString() {
        return "Pemesanan{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", idUser=" + idUser +
                ", idJadwalPerjalanan=" + idJadwalPerjalanan +
                ", kodePemesanan='" + kodePemesanan + '\'' +
                ", user=" + user.toString() +
                ", jadwalPerjalanan=" + jadwalPerjalanan.toString() +
                ", pembayaran=" + pembayaran.toString() +
                ", lokasiPenjemputan=" + lokasiPenjemputan.toString() +
                ", lokasiPengantaran=" + lokasiPengantaran.toString() +
                ", penumpangPerjalanan=" + penumpangPerjalanan +
                '}';
    }
}
