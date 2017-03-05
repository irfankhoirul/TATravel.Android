package com.irfankhoirul.apps.tatravel.view.fragment;


import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;

import com.irfankhoirul.apps.tatravel.R;
import com.irfankhoirul.apps.tatravel.base.BaseFragment;
import com.irfankhoirul.apps.tatravel.view.activity.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends BaseFragment<MainActivity> {

    @BindView(R.id.rbRegisterWithPhoneNumber)
    RadioButton rbRegisterWithPhoneNumber;
    @BindView(R.id.rbRegisterWithEmailAddress)
    RadioButton rbRegisterWithEmailAddress;
    @BindView(R.id.tilPhoneNumber)
    TextInputLayout tilPhoneNumber;
    @BindView(R.id.etPhoneNumber)
    EditText etPhoneNumber;
    @BindView(R.id.tilEmailAddress)
    TextInputLayout tilEmailAddress;
    @BindView(R.id.etEmailAddress)
    EditText etEmailAddress;

    public RegisterFragment() {
        // Required empty public constructor
    }

    @Override
    protected void setLabel() {
        label = this.getClass().getSimpleName();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @OnCheckedChanged(R.id.rbRegisterWithPhoneNumber)
    public void rbRegisterWithPhoneNumber() {
        if (rbRegisterWithPhoneNumber.isChecked()) {
            rbRegisterWithEmailAddress.setChecked(false);
            etPhoneNumber.setEnabled(true);
            etEmailAddress.setEnabled(false);
        }
    }

    @OnCheckedChanged(R.id.rbRegisterWithEmailAddress)
    public void rbRegisterWithEmailAddress() {
        if (rbRegisterWithEmailAddress.isChecked()) {
            rbRegisterWithPhoneNumber.setChecked(false);
            etEmailAddress.setEnabled(true);
            etPhoneNumber.setEnabled(false);
        }
    }

}
