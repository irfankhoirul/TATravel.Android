package com.irfankhoirul.apps.tatravel.view.fragment;


import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.irfankhoirul.apps.tatravel.R;
import com.irfankhoirul.apps.tatravel.contract.ProfileContract;
import com.irfankhoirul.apps.tatravel.model.data.local.Session;
import com.irfankhoirul.apps.tatravel.model.pojo.User;
import com.irfankhoirul.apps.tatravel.presenter.ProfileFragmentPresenter;
import com.irfankhoirul.apps.tatravel.view.activity.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends BaseFragment<MainActivity> implements ProfileContract.View {

    @BindView(R.id.tilName)
    TextInputLayout tilName;
    @BindView(R.id.etName)
    EditText etName;
    @BindView(R.id.tilPhone)
    TextInputLayout tilPhone;
    @BindView(R.id.etPhone)
    EditText etPhone;
    @BindView(R.id.tilEmail)
    TextInputLayout tilEmail;
    @BindView(R.id.etEmail)
    EditText etEmail;
    @BindView(R.id.tilAddress)
    TextInputLayout tilAddress;
    @BindView(R.id.etAddress)
    EditText etAddress;
    @BindView(R.id.tilCity)
    TextInputLayout tilCity;
    @BindView(R.id.etCity)
    EditText etCity;
    @BindView(R.id.tilProvince)
    TextInputLayout tilProvince;
    @BindView(R.id.etProvince)
    EditText etProvince;
    @BindView(R.id.btChangeProfile)
    Button btChangeProfile;

    private ProfileFragmentPresenter mPresenter;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_profile, container, false);
        unbinder = ButterKnife.bind(this, fragmentView);
        mPresenter.start();

        return fragmentView;
    }

    @Override
    protected void setTitle() {
        title = "Profil";
    }

    @Override
    public void setPresenter() {
        mPresenter = new ProfileFragmentPresenter(this);
    }

    @Override
    public void showStatus(int type, String message) {

    }

    @Override
    public void showProfile() {
        Log.v("ShowProfile", "Start");
        Session<User> session = Session.initialize(activity, User.class);
        User user = session.getSessionData();
        if (user != null) {
            Log.v("ShowProfile", "UserIsNotNull");
            if (user.getNama() != null)
                etName.setText(user.getNama());
            else
                etName.setText("-");
            if (user.getNomorHandphone() != null)
                etPhone.setText(user.getNomorHandphone());
            else
                etPhone.setText("-");
            if (user.getEmail() != null)
                etEmail.setText(user.getEmail());
            else
                etEmail.setText("-");
            if (user.getAlamat() != null)
                etAddress.setText(user.getAlamat());
            else
                etAddress.setText("-");
            if (user.getKota() != null && user.getKota().getNama() != null)
                etCity.setText(user.getKota().getNama());
            else
                etCity.setText("-");
            if (user.getProvinsi() != null && user.getProvinsi().getNama() != null)
                etProvince.setText(user.getProvinsi().getNama());
            else
                etProvince.setText("-");
        } else {
            Log.v("ShowProfile", "UserIsNull");
        }
    }
}
