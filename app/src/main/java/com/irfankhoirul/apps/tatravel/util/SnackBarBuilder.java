package com.irfankhoirul.apps.tatravel.util;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import com.irfankhoirul.apps.tatravel.R;

/**
 * Created by Irfan Khoirul on 12/25/2016.
 */

public class SnackBarBuilder {
    private View root;
    private String message;
    private String actionName;
    private int length;
    private View.OnClickListener listener;
    private int type;
    private Context context;

    public SnackBarBuilder(Context context) {
        this.context = context;
    }

    public SnackBarBuilder setRoot(View root) {
        this.root = root;
        return this;
    }

    public SnackBarBuilder setMessage(String message) {
        this.message = message;
        return this;
    }

    public SnackBarBuilder setActionName(String actionName) {
        this.actionName = actionName;
        return this;
    }

    public SnackBarBuilder setLength(int length) {
        this.length = length;
        return this;
    }

    public SnackBarBuilder setActionListener(View.OnClickListener listener) {
        this.listener = listener;
        return this;
    }

    public SnackBarBuilder setType(int type) {
        this.type = type;
        return this;
    }

    public void build() {
        Snackbar snackbar = Snackbar
                .make(root, message, length)
                .setAction(actionName, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        listener.onClick(view);
                    }
                });

        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);

        switch (type) {
            case ConstantUtils.STATUS_INFO:
                textView.setTextColor(ContextCompat.getColor(context, R.color.light_blue_500));
                break;

            case ConstantUtils.STATUS_SUCCESS:
                textView.setTextColor(ContextCompat.getColor(context, R.color.light_green_500));
                break;

            case ConstantUtils.STATUS_WARNING:
                textView.setTextColor(ContextCompat.getColor(context, R.color.orange_500));
                break;

            case ConstantUtils.STATUS_ERROR:
                textView.setTextColor(ContextCompat.getColor(context, R.color.red_500));
                break;
        }

        snackbar.setActionTextColor(ContextCompat.getColor(context, R.color.pure_white));
        snackbar.show();
    }

}
