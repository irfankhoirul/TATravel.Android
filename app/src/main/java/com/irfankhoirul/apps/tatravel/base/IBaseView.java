package com.irfankhoirul.apps.tatravel.base;

/**
 * Berisi daftar method yang diimplementasikan oleh view dan dipanggil dari presenter
 * atau/dan view itu sendiri
 *
 * @author Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since 1.0 (7 November 2016)
 */

public interface IBaseView<T> {
    void setPresenter();
}
