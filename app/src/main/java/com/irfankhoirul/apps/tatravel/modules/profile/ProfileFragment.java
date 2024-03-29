package com.irfankhoirul.apps.tatravel.modules.profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.irfankhoirul.apps.tatravel.R;
import com.irfankhoirul.apps.tatravel.components.ConstantUtils;
import com.irfankhoirul.apps.tatravel.data.pojo.User;
import com.irfankhoirul.apps.tatravel.modules.MainActivity;
import com.irfankhoirul.apps.tatravel.modules.profile_editor.ProfileEditorActivity;
import com.irfankhoirul.mvp_core.base.BaseFragment;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends BaseFragment<MainActivity, ProfileContract.Presenter> implements ProfileContract.View {

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

    private FragmentListener listener;

    public ProfileFragment() {
        // Required empty public constructor
    }

    public ProfileContract.Presenter getPresenter() {
        return mPresenter;
    }

    @Override
    public void setPresenter(ProfileContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_profile, container, false);
        unbinder = ButterKnife.bind(this, fragmentView);

        return fragmentView;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (FragmentListener) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        mPresenter.handleActivityResult(requestCode, resultCode);
    }

    @Override
    protected void setTitle() {
        title = "Profil";
    }

    @Override
    public void showProfile() {
        User user = mPresenter.getSessionData();
        if (user != null) {
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
        }
    }

    @Override
    public void redirectToLoginOrRegister() {
        mPresenter.destroySession();
        listener.onLogoutSuccess();
    }

    public void doLogout() {
        User loggedInUser = mPresenter.getSessionData();
        Map<String, String> param = new HashMap<>();
        param.put("token", loggedInUser.getUserToken().getToken());
        mPresenter.logout(param);
    }

    public void doUpdateProfile() {
        Intent intent = new Intent(activity, ProfileEditorActivity.class);
        startActivityForResult(intent, ConstantUtils.ACTIVITY_REQUEST_CODE_EDIT_PROFILE);
    }

    @Override
    public void setLoadingDialog(boolean isLoading, @Nullable String message) {
        super.setLoadingDialog(isLoading, message);
    }

    @Override
    public void showStatus(int type, String message) {
        super.showStatus(type, message);
    }

    public interface FragmentListener {
        void onLogoutSuccess();
    }
}
