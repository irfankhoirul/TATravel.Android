package com.irfankhoirul.apps.tatravel.aaa.core.components.view;

import android.app.Activity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.irfankhoirul.apps.tatravel.R;
import com.irfankhoirul.apps.tatravel.aaa.core.components.util.ConstantUtils;
import com.irfankhoirul.apps.tatravel.aaa.core.components.util.DisplayMetricUtils;

/**
 * Created by Irfan Khoirul on 4/10/2017.
 */

public class Toaster {

    private Toaster instance;
    private int length = Toast.LENGTH_SHORT;
    private int imageSource = -1;
    private int type;
    private String message;
    private Activity activity;

    public Toaster() {

    }

    public Toaster builder(Activity activity) {
        instance = new Toaster();
        instance.activity = activity;
        return instance;
    }

    public Toaster setMessage(String message) {
        this.message = message;
        return this;
    }

    public Toaster setType(int type) {
        this.type = type;
        return this;
    }

    public Toaster setLength(int length) {
        this.length = length;
        return this;
    }

    public Toaster setImageSource(int imageSource) {
        this.imageSource = imageSource;
        return this;
    }

    public void show() {
        LayoutInflater inflater = activity.getLayoutInflater();
        View layout = inflater.inflate(R.layout.layout_toaster, (ViewGroup) activity.findViewById(R.id.llLayoutToaster));
        TextView text = (TextView) layout.findViewById(R.id.tvMessage);
        text.setText(message);
        ImageView image = (ImageView) layout.findViewById(R.id.ivIcon);
        switch (type) {
            case ConstantUtils.STATUS_INFO:
                if (imageSource == -1)
                    image.setImageResource(R.drawable.ic_info_black_24dp);
                layout.setBackgroundResource(R.drawable.bg_toast_info);
                break;
            case ConstantUtils.STATUS_SUCCESS:
                if (imageSource == -1)
                    image.setImageResource(R.drawable.ic_check_black_24dp);
                layout.setBackgroundResource(R.drawable.bg_toast_success);
                break;
            case ConstantUtils.STATUS_WARNING:
                if (imageSource == -1)
                    image.setImageResource(R.drawable.ic_warning_black_24dp);
                layout.setBackgroundResource(R.drawable.bg_toast_warning);
                break;
            case ConstantUtils.STATUS_ERROR:
                if (imageSource == -1)
                    image.setImageResource(R.drawable.ic_close_black_24dp);
                layout.setBackgroundResource(R.drawable.bg_toast_error);
                break;
        }
        Toast toast = new Toast(activity);
        toast.setGravity(Gravity.BOTTOM, 0, DisplayMetricUtils.convertDpToPixel(32));
        toast.setDuration(length);
        toast.setView(layout);
        toast.show();
    }
}
