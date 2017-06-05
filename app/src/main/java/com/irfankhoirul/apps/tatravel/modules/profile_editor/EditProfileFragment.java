package com.irfankhoirul.apps.tatravel.modules.profile_editor;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;

import com.irfankhoirul.apps.tatravel.R;
import com.irfankhoirul.apps.tatravel.components.ConstantUtils;
import com.irfankhoirul.apps.tatravel.data.pojo.User;
import com.irfankhoirul.mvp_core.base.BaseFragment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * A simple {@link Fragment} subclass.
 */

public class EditProfileFragment extends BaseFragment<EditProfileActivity, EditProfileContract.Presenter> implements
        EditProfileContract.View {

    @BindView(R.id.etName)
    TextInputEditText etName;
    @BindView(R.id.tilName)
    TextInputLayout tilName;
    @BindView(R.id.etPhone)
    TextInputEditText etPhone;
    @BindView(R.id.tilPhone)
    TextInputLayout tilPhone;
    @BindView(R.id.etEmail)
    TextInputEditText etEmail;
    @BindView(R.id.tilEmail)
    TextInputLayout tilEmail;
    @BindView(R.id.etAddress)
    TextInputEditText etAddress;
    @BindView(R.id.tilAddress)
    TextInputLayout tilAddress;
    @BindView(R.id.actvProvince)
    AutoCompleteTextView actvProvince;
    @BindView(R.id.tilProvince)
    TextInputLayout tilProvince;
    @BindView(R.id.actvCity)
    AutoCompleteTextView actvCity;
    @BindView(R.id.tilCity)
    TextInputLayout tilCity;
    @BindView(R.id.btSave)
    Button btSave;
    @BindView(R.id.switchChangePassword)
    Switch switchChangePassword;
    @BindView(R.id.etOldPassword)
    TextInputEditText etOldPassword;
    @BindView(R.id.tilOldPassword)
    TextInputLayout tilOldPassword;
    @BindView(R.id.etNewPassword)
    TextInputEditText etNewPassword;
    @BindView(R.id.tilNewPassword)
    TextInputLayout tilNewPassword;
    @BindView(R.id.llChangePassword)
    LinearLayout llChangePassword;

    public EditProfileFragment() {
        // Required empty public constructor
    }

    @Override
    protected void setTitle() {
        title = "Ubah Profil";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_edit_profile, container, false);
        unbinder = ButterKnife.bind(this, fragmentView);

        tilOldPassword.setVisibility(View.GONE);
        tilNewPassword.setVisibility(View.GONE);

        switchChangePassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    tilOldPassword.setVisibility(View.VISIBLE);
                    tilNewPassword.setVisibility(View.VISIBLE);
                } else {
                    tilOldPassword.setVisibility(View.GONE);
                    tilNewPassword.setVisibility(View.GONE);
                }
            }
        });

        return fragmentView;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void setPresenter(EditProfileContract.Presenter presenter) {
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

    @Override
    public void showCurrentData(User user) {
        if (user.isUseSocialLogin()) {
            llChangePassword.setVisibility(View.GONE);
            tilOldPassword.setVisibility(View.GONE);
            tilNewPassword.setVisibility(View.GONE);
        }
        etName.setText(user.getNama());
        etPhone.setText(user.getNomorHandphone());
        etEmail.setText(user.getEmail());
        etAddress.setText(user.getAlamat());
        if (user.getProvinsi() != null) {
            actvProvince.setText(user.getProvinsi().getNama());
        }
        if (user.getKota() != null) {
            actvCity.setText(user.getKota().getNama());
        }
    }

    @Override
    public void updateProvinceList(final List<String> provinceNameList) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(activity, android.R.layout.simple_list_item_1, provinceNameList);
        actvProvince.setAdapter(adapter);

        actvProvince.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                actvCity.setText("");
                mPresenter.getCityList(actvProvince.getText().toString());
            }
        });

    }

    @Override
    public void updateCityList(List<String> cityNameList) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(activity, android.R.layout.simple_list_item_1, cityNameList);
        actvCity.setAdapter(adapter);
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }

    @Override
    public void finishActivity() {
        activity.setResult(ConstantUtils.REQUEST_RESULT_SUCCESS);
        activity.finish();
    }

    @OnClick(R.id.btSave)
    public void btSave() {
        Map<String, String> params = new HashMap<>();
        if (switchChangePassword.isChecked()) {
            params.put("old_password", etOldPassword.getText().toString());
            params.put("new_password", etNewPassword.getText().toString());
        }
        params.put("nomor_handphone", etPhone.getText().toString());
        params.put("nama", etName.getText().toString());
        params.put("email", etEmail.getText().toString());
        params.put("alamat", etAddress.getText().toString());
        if (actvCity.getText() != null) {
            params.put("kota", actvCity.getText().toString());
        }
        if (actvProvince.getText() != null) {
            params.put("provinsi", actvProvince.getText().toString());
        }
        mPresenter.updateUser(params);
    }
}
