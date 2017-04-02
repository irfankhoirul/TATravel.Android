package com.irfankhoirul.apps.tatravel.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Merupakan model dari tabel OperatorTravel
 *
 * @author  Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since   1.0
 */

@Parcel
public class OperatorTravel extends BaseModel {
    @SerializedName("id_super_admin")
    @Expose
    protected int idSuperAdmin;

    @SerializedName("nama")
    @Expose
    protected String nama;

    @SerializedName("id_kota")
    @Expose
    protected int idKota;

    @SerializedName("alamat")
    @Expose
    protected String alamat;

    @SerializedName("telepon")
    @Expose
    protected String telepon;

    @SerializedName("penanggung_jawab")
    @Expose
    protected String penanggungJawab;

    @SerializedName("telepon_penanggung_jawab")
    @Expose
    protected String teleponPenanggungJawab;

    @SerializedName("status")
    @Expose
    protected String status;

    @SerializedName("super_admin")
    @Expose
    protected SuperAdmin superAdmin;

    @SerializedName("kota")
    @Expose
    protected Kota kota;

    @SerializedName("logo")
    @Expose
    protected String logo;

    @SerializedName("izinkan_lokasi_khusus")
    @Expose
    protected boolean izinkanLokasiKhusus;

    @SerializedName("jarak_penjemputan_maksimum")
    @Expose
    protected int jarakPenjemputanMaksimum;


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
}
