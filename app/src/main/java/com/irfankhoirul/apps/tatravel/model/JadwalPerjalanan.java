package com.irfankhoirul.apps.tatravel.model;

import com.irfankhoirul.apps.tatravel.core.CoreModel;

/**
 * @author  Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since   1.0
 */

public class JadwalPerjalanan extends CoreModel {
    private int idAdmin;
    private int idOperatorTravel;
    private int idLokasiPemberangkatan;
    private int idLokasiTujuan;
    private int idMobil;
    private int idSupir;
    private long waktuKeberangkatan;
    private long waktuKedatangan;
    private String status;
    private int harga;
    private int jumlahKursiTersedia;
    private boolean izinkanLokasiKhusus;
    private int biayaLokasiKhusus;
    private Admin admin;
    private OperatorTravel operatorTravel;
    private Lokasi lokasiPemberangkatan;
    private Lokasi lokasiTujuan;
    private Mobil mobil;
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

    public long getWaktuKeberangkatan() {
        return waktuKeberangkatan;
    }

    public void setWaktuKeberangkatan(long waktuKeberangkatan) {
        this.waktuKeberangkatan = waktuKeberangkatan;
    }

    public long getWaktuKedatangan() {
        return waktuKedatangan;
    }

    public void setWaktuKedatangan(long waktuKedatangan) {
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
}
