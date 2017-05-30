package com.irfankhoirul.apps.tatravel.data.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.irfankhoirul.mvp_core.base.BaseModel;

import org.parceler.Parcel;

/**
 * Merupakan model dari tabel JadwalPerjalanan
 *
 * @author Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since 1.0
 */

@Parcel
public class JadwalPerjalanan extends BaseModel {
    @SerializedName("id_admin")
    @Expose
    protected int idAdmin;

    @SerializedName("id_operator_travel")
    @Expose
    protected int idOperatorTravel;

    @SerializedName("id_lokasi_pemberangkatan")
    @Expose
    protected int idLokasiPemberangkatan;

    @SerializedName("id_lokasi_tujuan")
    @Expose
    protected int idLokasiTujuan;

    @SerializedName("id_mobil")
    @Expose
    protected int idMobil;

    @SerializedName("is_supir")
    @Expose
    protected int idSupir;

    @SerializedName("waktu_keberangkatan")
    @Expose
    protected String waktuKeberangkatan;

    @SerializedName("waktu_kedatangan")
    @Expose
    protected String waktuKedatangan;

    @SerializedName("tanggal_keberangkatan")
    @Expose
    protected String tanggalKeberangkatan;

    @SerializedName("tanggal_kedatangan")
    @Expose
    protected String tanggalKedatangan;

    @SerializedName("timezone")
    @Expose
    protected String timezone;

    @SerializedName("status")
    @Expose
    protected String status;

    @SerializedName("harga")
    @Expose
    protected int harga;

    @SerializedName("jumlah_kursi_tersedia")
    @Expose
    protected int jumlahKursiTersedia;

    @SerializedName("biaya_lokasi_khusus")
    @Expose
    protected int biayaLokasiKhusus;

    @SerializedName("admin")
    @Expose
    protected Admin admin;

    @SerializedName("operator_travel")
    @Expose
    protected OperatorTravel operatorTravel;

    @SerializedName("lokasi_pemberangkatan")
    @Expose
    protected Lokasi lokasiPemberangkatan;

    @SerializedName("lokasi_tujuan")
    @Expose
    protected Lokasi lokasiTujuan;

    @SerializedName("mobil")
    @Expose
    protected Mobil mobil;

    @SerializedName("supir")
    @Expose
    protected Supir supir;

    @SerializedName("jarakPenjemputan")
    @Expose
    protected double jarakPenjemputan;

    @SerializedName("jarakPengantaran")
    @Expose
    protected double jarakPengantaran;

    @SerializedName("quota")
    @Expose
    protected int quota;

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

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public double getJarakPenjemputan() {
        return jarakPenjemputan;
    }

    public void setJarakPenjemputan(double jarakPenjemputan) {
        this.jarakPenjemputan = jarakPenjemputan;
    }

    public double getJarakPengantaran() {
        return jarakPengantaran;
    }

    public void setJarakPengantaran(double jarakPengantaran) {
        this.jarakPengantaran = jarakPengantaran;
    }

    public String getTanggalKeberangkatan() {
        return tanggalKeberangkatan;
    }

    public void setTanggalKeberangkatan(String tanggalKeberangkatan) {
        this.tanggalKeberangkatan = tanggalKeberangkatan;
    }

    public String getTanggalKedatangan() {
        return tanggalKedatangan;
    }

    public void setTanggalKedatangan(String tanggalKedatangan) {
        this.tanggalKedatangan = tanggalKedatangan;
    }

    public int getQuota() {
        return quota;
    }

    public void setQuota(int quota) {
        this.quota = quota;
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
