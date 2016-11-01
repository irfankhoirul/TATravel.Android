package com.irfankhoirul.apps.tatravel.model;

import com.irfankhoirul.apps.tatravel.core.CoreModel;

/**
 * @author Irfan Khoirul Muhlishin
 * @since 11/1/2016
 */

public class PenumpangPerjalanan extends CoreModel {
    private int idPenumpang;
    private int idPemesan;

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
}
