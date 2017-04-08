package com.irfankhoirul.apps.tatravel.util;

/**
 * Berisi konstanta yang digunakan pada lebih dari 1 kelas
 *
 * @author Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since 1.0
 */

public class ConstantUtils {
    public static final String BASE_API_URL = "http://192.168.8.101:81/api/";
    public static final int PAGINATION_LIMIT = 10;
    public static final int INITIAL_PAGE = 1;

    public static final int REQUEST_RESULT_SUCCESS = 1;
    public static final int REQUEST_RESULT_ERROR = 0;

    public static final int STATUS_INFO = 0;    // Blue
    public static final int STATUS_SUCCESS = 1; // Green
    public static final int STATUS_WARNING = 2; // Orange
    public static final int STATUS_ERROR = 3;   // Red

    public static final int PERMISSION_REQUEST_LOCATIONS = 100;


    public static final int ACTIVITY_REQUEST_CODE_DEPARTURE = 1000;
    public static final int ACTIVITY_RESULT_CODE_DEPARTURE = 1001;


    public static final int DIALOG_CITY_REQUEST_CODE = 2000;
    public static final int DIALOG_CITY_RESULT_CODE = 2001;
    public static final int DIALOG_LOCATION_REQUEST_CODE = 2002;
    public static final int DIALOG_LOCATION_RESULT_CODE = 2003;

    public static final int LOGIN_GOOGLE_REQUEST = 3000;
    public static final String INTENT_SEARCH_FRAGMENT_DEPARTURE_CITY = "departure";

    public static final int INTENT_REQUEST_REGISTER_TO_VALIDATION = 4000;
    public static final int INTENT_REQUEST_LOGIN_OR_REGISTER_TO_REGISTER = 4001;
    public static final int INTENT_REQUEST_LOGIN_OR_REGISTER_TO_LOGIN = 4002;
}
