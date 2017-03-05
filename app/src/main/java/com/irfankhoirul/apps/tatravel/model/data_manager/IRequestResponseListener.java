package com.irfankhoirul.apps.tatravel.model.data_manager;

/**
 * Merupakan interface yang berfungsi sebagai listener hasil query menggunakan retrofit
 *
 * @author Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @version 1.0 (13 November 2016)
 * @since 1.0
 */

public interface IRequestResponseListener<T> {
    void onSuccess(T data);

    void onFailure();
}