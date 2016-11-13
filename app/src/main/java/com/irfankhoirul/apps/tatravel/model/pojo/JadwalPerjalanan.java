package com.irfankhoirul.apps.tatravel.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.irfankhoirul.apps.tatravel.core.CoreModel;

/**
 * Merupakan model dari tabel JadwalPerjalanan
 *
 * @author Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since 1.0
 */

public class JadwalPerjalanan extends CoreModel {
    @SerializedName("id_admin")
    @Expose
    private int idAdmin;

    @SerializedName("id_operator_travel")
    @Expose
    private int idOperatorTravel;

    @SerializedName("id_lokasi_pemberangkatan")
    @Expose
    private int idLokasiPemberangkatan;

    @SerializedName("id_lokasi_tujuan")
    @Expose
    private int idLokasiTujuan;

    @SerializedName("id_mobil")
    @Expose
    private int idMobil;

    @SerializedName("is_supir")
    @Expose
    private int idSupir;

    @SerializedName("waktu_keberangkatan")
    @Expose
    private String waktuKeberangkatan;

    @SerializedName("waktu_kedatangan")
    @Expose
    private String waktuKedatangan;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("harga")
    @Expose
    private int harga;

    @SerializedName("jumlah_kursi_tersedia")
    @Expose
    private int jumlahKursiTersedia;

    @SerializedName("izinkan_lokasi_khusus")
    @Expose
    private boolean izinkanLokasiKhusus;

    @SerializedName("biaya_lokasi_khusus")
    @Expose
    private int biayaLokasiKhusus;

    @SerializedName("admin")
    @Expose
    private Admin admin;

    @SerializedName("operator_travel")
    @Expose
    private OperatorTravel operatorTravel;

    @SerializedName("lokasi_pemberangkatan")
    @Expose
    private Lokasi lokasiPemberangkatan;

    @SerializedName("lokasi_tujuan")
    @Expose
    private Lokasi lokasiTujuan;

    @SerializedName("mobil")
    @Expose
    private Mobil mobil;

    @SerializedName("supir")
    @Expose
    private Supir supir;

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public int getIdOperatorTravel() {
        return idOperatorTravel;
    }

    public void setIdOperatorTravel(int idOperatorTravel) {
        this.idOperatorTravel = idOperatorTravel;
    }

    public int getIdLokasiPemberangkatan() {
        return idLokasiPemberangkatan;
    }

    public void setIdLokasiPemberangkatan(int idLokasiPemberangkatan) {
        this.idLokasiPemberangkatan = idLokasiPemberangkatan;
    }

    public int getIdLokasiTujuan() {
        return idLokasiTujuan;
    }

    public void setIdLokasiTujuan(int idLokasiTujuan) {
        this.idLokasiTujuan = idLokasiTujuan;
    }

    public int getIdMobil() {
        return idMobil;
    }

    public void setIdMobil(int idMobil) {
        this.idMobil = idMobil;
    }

    public int getIdSupir() {
        return idSupir;
    }

    public void setIdSupir(int idSupir) {
        this.idSupir = idSupir;
    }

    public String getWaktuKeberangkatan() {
        return waktuKeberangkatan;
    }

    public void setWaktuKeberangkatan(String waktuKeberangkatan) {
        this.waktuKeberangkatan = waktuKeberangkatan;
    }

    public String getWaktuKedatangan() {
        return waktuKedatangan;
    }

    public void setWaktuKedatangan(String waktuKedatangan) {
        this.waktuKedatangan = waktuKedatangan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getJumlahKursiTersedia() {
        return jumlahKursiTersedia;
    }

    public void setJumlahKursiTersedia(int jumlahKursiTersedia) {
        this.jumlahKursiTersedia = jumlahKursiTersedia;
    }

    public boolean isIzinkanLokasiKhusus() {
        return izinkanLokasiKhusus;
    }

    public void setIzinkanLokasiKhusus(boolean izinkanLokasiKhusus) {
        this.izinkanLokasiKhusus = izinkanLokasiKhusus;
    }

    public int getBiayaLokasiKhusus() {
        return biayaLokasiKhusus;
    }

    public void setBiayaLokasiKhusus(int biayaLokasiKhusus) {
        this.biayaLokasiKhusus = biayaLokasiKhusus;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public OperatorTravel getOperatorTravel() {
        return operatorTravel;
    }

    public void setOperatorTravel(OperatorTravel operatorTravel) {
        this.operatorTravel = operatorTravel;
    }

    public Lokasi getLokasiPemberangkatan() {
        return lokasiPemberangkatan;
    }

    public void setLokasiPemberangkatan(Lokasi lokasiPemberangkatan) {
        this.lokasiPemberangkatan = lokasiPemberangkatan;
    }

    public Lokasi getLokasiTujuan() {
        return lokasiTujuan;
    }

    public void setLokasiTujuan(Lokasi lokasiTujuan) {
        this.lokasiTujuan = lokasiTujuan;
    }

    public Mobil getMobil() {
        return mobil;
    }

    public void setMobil(Mobil mobil) {
        this.mobil = mobil;
    }

    public Supir getSupir() {
        return supir;
    }

    public void setSupir(Supir supir) {
        this.supir = supir;
    }

    @Override
    public String toString() {
        return "JadwalPerjalanan{" +
                "id=" + getId() +
                ", createdAt=" + getCreatedAt() +
                ", updatedAt=" + getUpdatedAt() +

                ", idAdmin=" + idAdmin +
                ", idOperatorTravel=" + idOperatorTravel +
                ", idLokasiPemberangkatan=" + idLokasiPemberangkatan +
                ", idLokasiTujuan=" + idLokasiTujuan +
                ", idMobil=" + idMobil +
                ", idSupir=" + idSupir +
                ", waktuKeberangkatan=" + waktuKeberangkatan +
                ", waktuKedatangan=" + waktuKedatangan +
                ", status='" + status + '\'' +
                ", harga=" + harga +
                ", jumlahKursiTersedia=" + jumlahKursiTersedia +
                ", izinkanLokasiKhusus=" + izinkanLokasiKhusus +
                ", biayaLokasiKhusus=" + biayaLokasiKhusus +
                ", admin=" + admin.toString() +
                ", operatorTravel=" + operatorTravel +
                ", lokasiPemberangkatan=" + lokasiPemberangkatan +
                ", lokasiTujuan=" + lokasiTujuan +
                ", mobil=" + mobil +
                ", supir=" + supir +
                '}';

    }
}
