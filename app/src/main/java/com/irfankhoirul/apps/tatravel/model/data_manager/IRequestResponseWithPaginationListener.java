package com.irfankhoirul.apps.tatravel.model.data_manager;

import com.irfankhoirul.apps.tatravel.model.api.DataPage;

/**
 * Merupakan interface yang berfungsi sebagai listener hasil query menggunakan retrofit
 * yang membutuhkan pagination
 *
 * @author Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @version 1.0 (13 November 2016)
 * @since 1.0
 */

public interface IRequestResponseWithPaginationListener<T> {
    void onSuccess(DataPage dataPageManager, T data);

    void onFailure();
}
