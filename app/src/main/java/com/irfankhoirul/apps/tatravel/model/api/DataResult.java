package com.irfankhoirul.apps.tatravel.model.api;

import java.util.List;

/**
 * Merupakan model dari setiap hasil query Retrofit
 *
 * @author Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @version 1.0 (13 November 2016)
 * @since 1.0
 */

public class DataResult<T> {
    /**
     * Kode hasil query
     */
    private int code;

    /**
     * Pesan hasil query
     */
    private String message;

    /**
     * Data hasil query (single)
     */
    private T data;

    /**
     * Data hasil query (multiple)
     */
    private List<T> datas;

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
