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
import android.widget.Button;
import android.widget.LinearLayout;

import com.irfankhoirul.apps.tatravel.R;
import com.irfankhoirul.apps.tatravel.core.base.BaseFragment;
import com.irfankhoirul.apps.tatravel.core.components.util.ConstantUtils;
import com.irfankhoirul.apps.tatravel.core.components.util.DisplayMetricUtils;
import com.irfankhoirul.apps.tatravel.core.data.DataPage;
import com.irfankhoirul.apps.tatravel.data.pojo.Penumpang;
import com.irfankhoirul.apps.tatravel.module.passenger.creator.DaggerPassengerCreatorDialogComponent;
import com.irfankhoirul.apps.tatravel.module.passenger.creator.PassengerCreatorDialog;
import com.irfankhoirul.apps.tatravel.module.passenger.creator.PassengerCreatorDialogPresenter;
import com.irfankhoirul.apps.tatravel.module.passenger.creator.PassengerCreatorPresenterModule;

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

public class PassengerFragment extends BaseFragment<PassengerActivity, PassengerContract.Presenter>
        implements PassengerContract.View, PassengerCreatorDialog.DialogListener {

    @BindView(R.id.rvPassenger)
    RecyclerView rvPassenger;
    @BindView(R.id.llEmptyMessage)
    LinearLayout llEmptyMessage;
    @BindView(R.id.btSetPassenger)
    Button btSetPassenger;

    @Inject
    PassengerCreatorDialogPresenter passengerCreatorDialogPresenter;

    private PassengerAdapter passengerAdapter;
    private List<Penumpang> passengers = new ArrayList<>();
    private List<Penumpang> selectedPassengers = new ArrayList<>();

    public PassengerFragment() {
        // Required empty public constructor
    }

    public static PassengerFragment newInstance(List<Penumpang> selectedPassengers) {
        PassengerFragment passengerFragment = new PassengerFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("selectedPassengers", Parcels.wrap(selectedPassengers));
        passengerFragment.setArguments(bundle);

        return passengerFragment;
    }

    @Override
    protected void setTitle() {
        title = "Penumpang";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_passenger, container, false);
        unbinder = ButterKnife.bind(this, fragmentView);

        selectedPassengers = Parcels.unwrap(getArguments().getParcelable("selectedPassengers"));

        passengerAdapter = new PassengerAdapter(passengers, new PassengerAdapter.OnSpecificItemClick() {
            @Override
            public void onItemClick(Penumpang passenger, boolean isSelected) {
                if (!selectedPassengers.contains(passenger)) {
                    if (isSelected) {
                        selectedPassengers.add(passenger);
                    } else {
                        for (int i = 0; i < selectedPassengers.size(); i++) {
                            if (selectedPassengers.get(i).getId() == passenger.getId()) {
                                selectedPassengers.remove(i);
                            }
                        }
                    }
                }
            }

            @Override
            public void oItemLongClick(final Penumpang passenger, final int position) {
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
                                mPresenter.deletePassenger(passenger.getId(), position, passengers);
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
                        PassengerCreatorDialog passengerCreatorDialog = PassengerCreatorDialog.newInstance(position, passenger);
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
    public void updatePassengerList(List<Penumpang> passengers, final DataPage dataPage, final Map<String, String> params) {
        this.passengers.addAll(passengers);
        for (int i = 0; i < this.passengers.size(); i++) {
            for (int j = 0; j < this.selectedPassengers.size(); j++) {
                if (this.passengers.get(i).getId() == selectedPassengers.get(j).getId()) {
                    this.passengers.get(i).setSelected(true);
                }
            }
        }
        passengerAdapter.notifyDataSetChanged();

        int toolbarHeight = DisplayMetricUtils.convertDpToPixel(56);
        int btSetPassengerHeightAndPassing = DisplayMetricUtils.convertDpToPixel(btSetPassenger.getHeight()) + DisplayMetricUtils.convertDpToPixel(16 + 16);
        int rvPassengerMaxHeight = DisplayMetricUtils.getDeviceHeight(activity) - toolbarHeight - btSetPassengerHeightAndPassing;
        Log.v("rvPassengerMaxHeight", String.valueOf(rvPassengerMaxHeight));

        int rvPassengerHeight = rvPassenger.getHeight();
        Log.v("rvPassengerHeight", String.valueOf(rvPassengerHeight));
        if (rvPassengerHeight < rvPassengerMaxHeight && dataPage.getCurrentPage() < dataPage.getTotalPage()
                && passengers.size() < ConstantUtils.PAGINATION_LIMIT * 2 && dataPage.getNextPage() != -1) {
            Log.v("RequestPageFillingSpace", String.valueOf(dataPage.getNextPage()));
            mPresenter.listPassenger(params);
        }

        rvPassenger.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (DisplayMetricUtils.isMaxScrollReached(rvPassenger) && dataPage.getNextPage() != -1) {
                    if (dataPage.getCurrentPage() < dataPage.getTotalPage() && !isLoading()/* &&
                            dataPage.getCurrentPage() + 1 < dataPage.getNextPage()*/) {
                        Log.v("RequestPage", String.valueOf(dataPage.getNextPage()));
                        Log.v("CurrentPage", String.valueOf(dataPage.getCurrentPage()));
                        mPresenter.listPassenger(params);
                    }
                }
            }
        });

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
    public void removePassengerItem(int position) {
        Penumpang tmpPassenger = passengers.get(position);
        for (int i = 0; i < selectedPassengers.size(); i++) {
            if (selectedPassengers.get(i).getId() == tmpPassenger.getId()) {
                selectedPassengers.remove(i);
            }
        }
        passengers.remove(position);
        passengerAdapter.notifyItemRemoved(position);
    }

    @Override
    public void updatePassengerItem(int position, Penumpang passenger) {
        Penumpang tmpPassenger = passengers.get(position);
        for (int i = 0; i < selectedPassengers.size(); i++) {
            if (selectedPassengers.get(i).getId() == tmpPassenger.getId()) {
                selectedPassengers.set(i, passenger);
            }
        }
        passengers.set(position, passenger);
        passengerAdapter.notifyItemChanged(position);
    }

    @Override
    public void addPassengerItem(Penumpang passenger) {
        passengers.add(passenger);
        passengerAdapter.notifyDataSetChanged();
    }

    @Override
    public void showDataNotExist() {
        rvPassenger.setVisibility(View.GONE);
        llEmptyMessage.setVisibility(View.VISIBLE);
    }

    @Override
    public void showDataExist() {
        llEmptyMessage.setVisibility(View.GONE);
        rvPassenger.setVisibility(View.VISIBLE);
    }

    @Override
    public void onPassengerCreated(String passengerName) {
        Map<String, String> params = new HashMap<>();
        params.put("name", passengerName);
        mPresenter.createPassenger(params);
    }

    @Override
    public void onPassengerUpdated(int position, Penumpang passenger) {
        Map<String, String> params = new HashMap<>();
        params.put("name", passenger.getNama());
        mPresenter.updatePassenger(position, passenger, params);
    }
}
