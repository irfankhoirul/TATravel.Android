package com.irfankhoirul.apps.tatravel.data.source.remote;

/**
 * Merupakan kelas helper yamg berisi konstanta end point API
 *
 * @author Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @version 1.0 (13 November 2016)
 * @since 1.0
 */

public class EndPoints {
    public static final String BASE_API_URL = "http://192.168.8.100/api/";

    // User End Point
    public static final String DO_REGISTER = "register";
    public static final String DO_VERIFY = "verifyUser";
    public static final String DO_LOGIN = "login";
    public static final String DO_LOGIN_DRIVER = "login-driver";
    public static final String DO_LOGOUT = "logout";
    public static final String GET_PROFILE = "user/{id}";
    public static final String UPDATE_PROFILE = "user/update/{id}";

    // User Device End Point
    public static final String UPDATE_FCM_TOKEN = "update-fcm-token";

    // Penumpang End Point
    public static final String CREATE_PENUMPANG = "user/{userId}/penumpang/create";
    public static final String UPDATE_PENUMPANG = "user/{userId}/penumpang/update/{id}";
    public static final String DELETE_PENUMPANG = "user/{userId}/penumpang/delete/{id}";
    public static final String LIST_PENUMPANG = "user/{userId}/penumpang/list";

    // Kota End Point
    public static final String LIST_KOTA = "province/{id}/city/list";

    // Provinsi End Point
    public static final String LIST_PROVINSI = "province/list";

    // Operator Travel End Point
    public static final String LIST_OPERATOR_TRAVEL = "operator-travel/list";
    public static final String GET_OPERATOR_TRAVEL = "operator-travel/{id}";

    // Lokasi End Point
    public static final String LIST_TERMINAL = "operator-travel/{id}/location";

    // Jadwal Perjalanan End Point
    public static final String LIST_DEPARTURE_AVAILABILITY = "operator-travel/departure-availability";
    public static final String LIST_DESTINATION_AVAILABILITY = "operator-travel/destination-availability";
    public static final String LIST_SCHEDULE = "operator-travel/{id}/schedule/list";
    public static final String GET_SCHEDULE = "schedule/{id}";
    public static final String LIST_DRIVER_SCHEDULE = "driver/schedule/list";
    public static final String GET_DRIVER_SCHEDULE = "driver/schedule/{id}";
    public static final String UPDATE_SCHEDULE_STATUS = "driver/schedule/status/set/{id}";

    // Kursi Perjalanan End Point
    public static final String LIST_SEAT = "schedule/{id}/seat/list";
    public static final String DO_BOOK_SEAT = "seat/book";

    // Pemesanan End Point
    public static final String DO_RESERVATION = "reservation";
    public static final String GET_RESERVATION = "reservation/{id}";
    public static final String LIST_RESERVATION = "order/list";

    // Rating Perjalanan End Point
    public static final String CREATE_RATING_OPERATOR_TRAVEL = "rate/add";
    public static final String UPDATE_RATING_OPERATOR_TRAVEL = "rate/update/{id}";
    public static final String DELETE_RATING_OPERATOR_TRAVEL = "rate/delete/{id}";
}
