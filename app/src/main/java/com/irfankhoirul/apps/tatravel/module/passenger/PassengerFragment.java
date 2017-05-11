package com.irfankhoirul.apps.tatravel.module.passenger;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.irfankhoirul.apps.tatravel.R;
import com.irfankhoirul.apps.tatravel.core.base.BaseFragment;
import com.irfankhoirul.apps.tatravel.core.components.util.ConstantUtils;
import com.irfankhoirul.apps.tatravel.data.pojo.Penumpang;
import com.irfankhoirul.apps.tatravel.module.passenger.create.DaggerPassengerCreatorDialogComponent;
import com.irfankhoirul.apps.tatravel.module.passenger.create.PassengerCreatorDialog;
import com.irfankhoirul.apps.tatravel.module.passenger.create.PassengerCreatorDialogPresenter;
import com.irfankhoirul.apps.tatravel.module.passenger.create.PassengerCreatorPresenterModule;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * A simple {@link Fragment} subclass.
 */

public class PassengerFragment extends BaseFragment<PassengerActivity> implements
        PassengerContract.View,
        PassengerCreatorDialog.DialogListener {

    @BindView(R.id.rvPassenger)
    RecyclerView rvPassenger;
    @BindView(R.id.llEmptyMessage)
    LinearLayout llEmptyMessage;
    @Inject
    PassengerCreatorDialogPresenter passengerCreatorDialogPresenter;
    PassengerContract.Presenter mPresenter;
    private PassengerAdapter passengerAdapter;
    private List<Penumpang> passengers = new ArrayList<>();
    private List<Penumpang> selectedPassengers = new ArrayList<>();

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

        passengerAdapter = new PassengerAdapter(passengers, new PassengerAdapter.OnSpecificItemClick() {
            @Override
            public void onItemClick(Penumpang passenger) {
                if (!selectedPassengers.contains(passenger)) {
                    selectedPassengers.add(passenger);
                }
            }

            @Override
            public void oItemLongClick(final Penumpang passenger) {
                AlertDialog.Builder builder = createAlert("Pilihan", null);
                builder.setCancelable(true);
                builder.setPositiveButton("Hapus", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        AlertDialog.Builder builder = createAlert("Hapus Penumpang", "Apakah anda ingin menghapus penumpang ini?");
                        builder.setCancelable(true);
                        builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mPresenter.deletePassenger(passenger.getId());
                            }
                        });
                        builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        builder.create().show();
                    }
                });
                builder.setNegativeButton("Ubah", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        PassengerCreatorDialog passengerCreatorDialog = PassengerCreatorDialog.newInstance(passenger);
                        passengerCreatorDialog.setListener(PassengerFragment.this);
                        passengerCreatorDialog.show(getFragmentManager(), "passengerCreatorDialog");

                        DaggerPassengerCreatorDialogComponent.builder()
                                .passengerCreatorPresenterModule(new PassengerCreatorPresenterModule(passengerCreatorDialog))
                                .build().inject(PassengerFragment.this);
                    }
                });
                builder.create().show();
            }
        });
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(activity);
        rvPassenger.setLayoutManager(layoutManager);
        rvPassenger.setItemAnimator(new DefaultItemAnimator());
        rvPassenger.setAdapter(passengerAdapter);

        rvPassenger.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                Log.v("onScrolled", String.valueOf(newState));
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                Log.v("onScrolled", dx + "; " + dy);
            }
        });

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
        Intent intent = new Intent();
        intent.putExtra("selectedPassengers", Parcels.wrap(selectedPassengers));
        activity.setResult(ConstantUtils.REQUEST_RESULT_SUCCESS, intent);
        activity.finish();
    }

    @Override
    public void updatePassengerList(List<Penumpang> passengers) {
        this.passengers.clear();
        this.passengers.addAll(passengers);
        passengerAdapter.notifyDataSetChanged();
    }

    @Override
    public void onCreatePassengerClick() {
        // Show Dialog
        PassengerCreatorDialog passengerCreatorDialog = new PassengerCreatorDialog();
        passengerCreatorDialog.setListener(this);
        passengerCreatorDialog.show(getFragmentManager(), "passengerCreatorDialog");

        DaggerPassengerCreatorDialogComponent.builder()
                .passengerCreatorPresenterModule(new PassengerCreatorPresenterModule(passengerCreatorDialog))
                .build().inject(this);
    }

    @Override
    public void onPassengerCreated(String passengerName) {
        Map<String, String> params = new HashMap<>();
        params.put("name", passengerName);
        mPresenter.createPassenger(params);
    }

    @Override
    public void onPassengerUpdated(Penumpang passenger) {
        Map<String, String> params = new HashMap<>();
        params.put("name", passenger.getNama());
        mPresenter.updatePassenger(passenger.getId(), params);
    }
}
