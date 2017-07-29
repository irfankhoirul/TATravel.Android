package com.irfankhoirul.apps.tatravel.data.pojo;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.irfankhoirul.mvp_core.base.BasePojo;

import java.util.Map;

/**
 * Merupakan model dari tabel OperatorTravel
 *
 * @author  Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since   1.0
 */

public class OperatorTravel extends BasePojo implements Parcelable {
    public static final Creator<OperatorTravel> CREATOR = new Creator<OperatorTravel>() {
        @Override
        public OperatorTravel createFromParcel(android.os.Parcel in) {
            return new OperatorTravel(in);
        }

        @Override
        public OperatorTravel[] newArray(int size) {
            return new OperatorTravel[size];
        }
    };
    @SerializedName("id_super_admin")
    @Expose
    private int idSuperAdmin;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("id_kota")
    @Expose
    private int idKota;
    @SerializedName("alamat")
    @Expose
    private String alamat;
    @SerializedName("telepon")
    @Expose
    private String telepon;
    @SerializedName("penanggung_jawab")
    @Expose
    private String penanggungJawab;
    @SerializedName("telepon_penanggung_jawab")
    @Expose
    private String teleponPenanggungJawab;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("super_admin")
    @Expose
    private SuperAdmin superAdmin;
    @SerializedName("kota")
    @Expose
    private Kota kota;
    @SerializedName("logo")
    @Expose
    private String logo;
    @SerializedName("izinkan_lokasi_khusus")
    @Expose
    private boolean izinkanLokasiKhusus;
    @SerializedName("jarak_penjemputan_maksimum")
    @Expose
    private int jarakPenjemputanMaksimum;
    @SerializedName("biaya_lokasi_khusus")
    @Expose
    private int biayaLokasiKhusus;
    // Tambahan
    private Map<String, String> keterangan;

    protected OperatorTravel(android.os.Parcel in) {
        id = in.readInt();
        createdAt = in.readString();
        updatedAt = in.readString();
        idSuperAdmin = in.readInt();
        nama = in.readString();
        idKota = in.readInt();
        alamat = in.readString();
        telepon = in.readString();
        penanggungJawab = in.readString();
        teleponPenanggungJawab = in.readString();
        status = in.readString();
        kota = in.readParcelable(Kota.class.getClassLoader());
        logo = in.readString();
        izinkanLokasiKhusus = in.readByte() != 0;
        jarakPenjemputanMaksimum = in.readInt();
        biayaLokasiKhusus = in.readInt();
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

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getPenanggungJawab() {
        return penanggungJawab;
    }

    public void setPenanggungJawab(String penanggungJawab) {
        this.penanggungJawab = penanggungJawab;
    }

    public String getTeleponPenanggungJawab() {
        return teleponPenanggungJawab;
    }

    public void setTeleponPenanggungJawab(String teleponPenanggungJawab) {
        this.teleponPenanggungJawab = teleponPenanggungJawab;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public SuperAdmin getSuperAdmin() {
        return superAdmin;
    }

    public void setSuperAdmin(SuperAdmin superAdmin) {
        this.superAdmin = superAdmin;
    }

    public Kota getKota() {
        return kota;
    }

    public void setKota(Kota kota) {
        this.kota = kota;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public boolean isIzinkanLokasiKhusus() {
        return izinkanLokasiKhusus;
    }

    public void setIzinkanLokasiKhusus(boolean izinkanLokasiKhusus) {
        this.izinkanLokasiKhusus = izinkanLokasiKhusus;
    }

    public int getJarakPenjemputanMaksimum() {
        return jarakPenjemputanMaksimum;
    }

    public void setJarakPenjemputanMaksimum(int jarakPenjemputanMaksimum) {
        this.jarakPenjemputanMaksimum = jarakPenjemputanMaksimum;
    }

    public int getBiayaLokasiKhusus() {
        return biayaLokasiKhusus;
    }

    public void setBiayaLokasiKhusus(int biayaLokasiKhusus) {
        this.biayaLokasiKhusus = biayaLokasiKhusus;
    }

    public Map<String, String> getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(Map<String, String> keterangan) {
        this.keterangan = keterangan;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(createdAt);
        dest.writeString(updatedAt);
        dest.writeInt(idSuperAdmin);
        dest.writeString(nama);
        dest.writeInt(idKota);
        dest.writeString(alamat);
        dest.writeString(telepon);
        dest.writeString(penanggungJawab);
        dest.writeString(teleponPenanggungJawab);
        dest.writeString(status);
        dest.writeParcelable(kota, flags);
        dest.writeString(logo);
        dest.writeByte((byte) (izinkanLokasiKhusus ? 1 : 0));
        dest.writeInt(jarakPenjemputanMaksimum);
        dest.writeInt(biayaLokasiKhusus);
    }

    @Override
    public String toString() {
        return "OperatorTravel{" +
                "idSuperAdmin=" + idSuperAdmin +
                ", nama='" + nama + '\'' +
                ", idKota=" + idKota +
                ", alamat='" + alamat + '\'' +
                ", telepon='" + telepon + '\'' +
                ", penanggungJawab='" + penanggungJawab + '\'' +
                ", teleponPenanggungJawab='" + teleponPenanggungJawab + '\'' +
                ", status='" + status + '\'' +
                ", superAdmin=" + superAdmin.toString() +
                ", kota=" + kota.toString() +
                ", logo='" + logo + '\'' +
                ", izinkanLokasiKhusus=" + izinkanLokasiKhusus +
                ", jarakPenjemputanMaksimum=" + jarakPenjemputanMaksimum +
                ", biayaLokasiKhusus=" + biayaLokasiKhusus +
                ", keterangan=" + keterangan +
                '}';
    }
}
