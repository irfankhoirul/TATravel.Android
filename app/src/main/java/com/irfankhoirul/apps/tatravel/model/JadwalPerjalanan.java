package com.irfankhoirul.apps.tatravel.model;

import com.irfankhoirul.apps.tatravel.core.CoreModel;

/**
 * @author Irfan Khoirul Muhlishin
 * @since 11/1/2016
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
}
