package com.irfankhoirul.apps.tatravel.util;

import android.app.Activity;
import android.util.DisplayMetrics;

/**
 * Created by Irfan Khoirul on 11/7/2016.
 */

public class DisplayMetricUtil {
    public static int getDeviceWidth(Activity activity) {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        return displaymetrics.widthPixels;
    }

    public static int getDeviceHeight(Activity activity) {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        return displaymetrics.heightPixels;
    }
}
