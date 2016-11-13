package com.irfankhoirul.apps.tatravel.core;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Merupakan Super Class dari kelas model dalam aplikasi. Berisi atribut standar yaitu id,
 * createdAt, dan updatedAt
 *
 * @author  Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since 1.0 (7 November 2016)
 */

public class CoreModel {
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("created_at")
    @Expose
    private String createdAt;

    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
