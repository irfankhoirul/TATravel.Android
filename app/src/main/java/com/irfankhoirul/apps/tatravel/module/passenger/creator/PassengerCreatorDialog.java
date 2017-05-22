package com.irfankhoirul.apps.tatravel.module.passenger.creator;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.irfankhoirul.apps.tatravel.R;
import com.irfankhoirul.apps.tatravel.core.base.BaseDialog;
import com.irfankhoirul.apps.tatravel.data.pojo.Penumpang;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Irfan Khoirul on 12/25/2016.
 */

public class PassengerCreatorDialog extends BaseDialog implements PassengerCreatorDialogContract.View {

    @BindView(R.id.tilPassengerName)
    TextInputLayout tilPassengerName;
    @BindView(R.id.etPassengerName)
    EditText etPassengerName;
    PassengerCreatorDialogContract.Presenter mPresenter;
    private Penumpang passenger;
    private DialogListener listener;

    public PassengerCreatorDialog() {
        // Empty constructor required for DialogFragment
    }

    public static PassengerCreatorDialog newInstance(int position, Penumpang passenger) {
        PassengerCreatorDialog passengerCreatorDialog = new PassengerCreatorDialog();
        Bundle bundle = new Bundle();
        bundle.putParcelable("passenger", Parcels.wrap(passenger));
        bundle.putInt("position", position);
        passengerCreatorDialog.setArguments(bundle);

        return passengerCreatorDialog;
    }

    public void setListener(DialogListener listener) {
        this.listener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.dialog_passenger_creator, container);
        unbinder = ButterKnife.bind(this, fragmentView);

        if (getArguments() != null && getArguments().getParcelable("passenger") != null) {
            passenger = Parcels.unwrap(getArguments().getParcelable("passenger"));
            etPassengerName.setText(passenger.getNama());
        }

        return fragmentView;
    }

    @Override
    public void onResume() {
        ViewGroup.LayoutParams params = getDialog().getWindow().getAttributes();
        params.width = LinearLayout.LayoutParams.MATCH_PARENT;
        params.height = LinearLayout.LayoutParams.WRAP_CONTENT;
        getDialog().getWindow().setAttributes((android.view.WindowManager.LayoutParams) params);

        super.onResume();

        mPresenter.start();
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
    }

    @OnClick(R.id.btCancel)
    public void btCancel() {
        PassengerCreatorDialog.this.dismiss();
    }

    @OnClick(R.id.btSave)
    public void btSave() {
        if (getArguments() != null && getArguments().getParcelable("passenger") != null) {
            passenger.setNama(etPassengerName.getText().toString());
            listener.onPassengerUpdated(getArguments().getInt("position"), passenger);
        } else {
            listener.onPassengerCreated(etPassengerName.getText().toString());
        }
        PassengerCreatorDialog.this.dismiss();
    }

    @Override
    public void setPresenter(PassengerCreatorDialogContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public void setLoadingDialog(boolean isLoading, @Nullable String message) {
        super.setLoadingDialog(isLoading, message);
    }

    @Override
    public void showStatus(int type, String message) {
        super.showStatus(type, message);
    }

    public interface DialogListener {
        void onPassengerCreated(String passengerName);

        void onPassengerUpdated(int position, Penumpang passenger);
    }
}
