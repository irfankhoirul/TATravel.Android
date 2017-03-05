package com.irfankhoirul.apps.tatravel.model.api;

/**
 * Merupakan kelas helper yamg berisi konstanta end point API
 *
 * @author Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @version 1.0 (13 November 2016)
 * @since 1.0
 */

class EndPoints {
    /*NEW*/
    static final String DO_REGISTER = "register";
    static final String DO_VERIFY = "verify";
    static final String DO_LOGIN = "login";
    static final String DO_LOGIN_DRIVER = "login-driver";
    static final String UPDATE_FCM_TOKEN = "update-fcm-token";
    static final String UPDATE_PROFILE = "user/update/{id}";
    static final String GET_PROFILE = "user/{id}";
    static final String CREATE_PENUMPANG = "user/{userId}/penumpang/create";
    static final String UPDATE_PENUMPANG = "user/{userId}/penumpang/update/{id}";
    static final String DELETE_PENUMPANG = "user/{userId}/penumpang/delete/{id}";
    static final String LIST_PENUMPANG = "user/{userId}/penumpang/list";
    static final String LIST_KOTA = "city/list";
    static final String LIST_OPERATOR_TRAVEL = "operator-travel/list";
    static final String GET_OPERATOR_TRAVEL = "operator-travel/{id}";
    static final String LIST_TERMINAL = "operator-travel/{id}/location";
    static final String LIST_SCHEDULE = "operator-travel/{id}/schedule/list";
    static final String GET_SCHEDULE = "schedule/{id}";
    static final String LIST_SEAT = "schedule/{id}/seat/list";
    static final String DO_BOOK_SEAT = "seat/book/{id}";
    static final String DO_RESERVATION = "reservation";
    static final String GET_RESERVATION = "reservation/{id}";
    static final String LIST_RESERVATION = "order/list";
    static final String CREATE_RATING_OPERATOR_TRAVEL = "rate/add";
    static final String UPDATE_RATING_OPERATOR_TRAVEL = "rate/update/{id}";
    static final String DELETE_RATING_OPERATOR_TRAVEL = "rate/delete/{id}";
    static final String LIST_DRIVER_SCHEDULE = "driver/schedule/list";
    static final String GET_DRIVER_SCHEDULE = "driver/schedule/{id}";
    static final String UPDATE_SCHEDULE_STATUS = "driver/schedule/status/set/{id}";


    /*OLD*/
    static final String GET_SCHEDULE_OLD = "search";
    static final String GET_LOCATION_OLD = "location";
    static final String GET_CITY_OLD = "city";
}
