package com.irfankhoirul.apps.tatravel.model.pojo;

import com.irfankhoirul.apps.tatravel.core.CoreModel;

/**
 * Merupakan model dari tabel Pembayaran
 *
 * @author  Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since   1.0
 */

public class Pembayaran extends CoreModel {
    private int idPembayaran;
    private String kodePemesanan;
    private String status;
    private Pembayaran pembayaran;

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
}
