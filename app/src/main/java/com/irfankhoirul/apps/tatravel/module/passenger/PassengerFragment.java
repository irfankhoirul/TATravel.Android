package com.irfankhoirul.apps.tatravel.module.passenger;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.irfankhoirul.apps.tatravel.R;
import com.irfankhoirul.apps.tatravel.core.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * A simple {@link Fragment} subclass.
 */

public class PassengerFragment extends BaseFragment<PassengerActivity> implements PassengerContract.View {

    @BindView(R.id.rvPassenger)
    RecyclerView rvPassenger;
    @BindView(R.id.llEmptyMessage)
    LinearLayout llEmptyMessage;

    PassengerContract.Presenter mPresenter;

    public PassengerFragment() {
        // Required empty public constructor
    }

    @Override
    protected void setTitle() {
        title = "Penumpang";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_passanger, container, false);
        unbinder = ButterKnife.bind(this, fragmentView);
        mPresenter.start();

        return fragmentView;
    }

    @Override
    public void setPresenter(PassengerContract.Presenter presenter) {
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

    @OnClick(R.id.btSetPassenger)
    public void btSetPassenger() {

    }
}
