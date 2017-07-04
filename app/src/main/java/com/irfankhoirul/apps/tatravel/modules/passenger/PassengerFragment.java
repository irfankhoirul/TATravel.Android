package com.irfankhoirul.apps.tatravel.modules.passenger;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.irfankhoirul.apps.tatravel.R;
import com.irfankhoirul.apps.tatravel.components.ConstantUtils;
import com.irfankhoirul.apps.tatravel.components.DisplayMetricUtils;
import com.irfankhoirul.apps.tatravel.components.FormValidation;
import com.irfankhoirul.apps.tatravel.data.pojo.Penumpang;
import com.irfankhoirul.mvp_core.base.BaseFragment;
import com.irfankhoirul.mvp_core.data.DataPage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.basgeekball.awesomevalidation.ValidationStyle.TEXT_INPUT_LAYOUT;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * A simple {@link Fragment} subclass.
 */

public class PassengerFragment extends BaseFragment<PassengerActivity, PassengerContract.Presenter>
        implements PassengerContract.View {

    private static final String ADD_PASSENGER = "Tambah Penumpang";
    private static final String UPDATE_PASSENGER = "Ubah Penumpang";

    @BindView(R.id.rvPassenger)
    RecyclerView rvPassenger;
    @BindView(R.id.llEmptyMessage)
    LinearLayout llEmptyMessage;
    @BindView(R.id.btSetPassenger)
    Button btSetPassenger;

    private PassengerAdapter passengerAdapter;

    public PassengerFragment() {
        // Required empty public constructor
    }

    public static PassengerFragment newInstance(ArrayList<Penumpang> selectedPassengers) {
        PassengerFragment passengerFragment = new PassengerFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("selectedPassengers", selectedPassengers);
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
        ArrayList<Penumpang> selectedPassengers = getArguments().getParcelableArrayList("selectedPassengers");
        mPresenter.setSelectedPassenger(selectedPassengers);

        passengerAdapter = new PassengerAdapter(mPresenter.getPassenger(), new PassengerAdapter.OnSpecificItemClick() {
            @Override
            public void onItemClick(Penumpang passenger, boolean isSelected) {
                mPresenter.onPassengerItemClick(passenger, isSelected);
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
                                mPresenter.deletePassenger(passenger.getId(), position, mPresenter.getPassenger());
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
                        showPassengerCreatorDialog(UPDATE_PASSENGER, passenger, position);
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
    public void onResume() {
        super.onResume();
        mPresenter.start();
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
        intent.putParcelableArrayListExtra("selectedPassengers", mPresenter.getSelectedPassengers());
        activity.setResult(ConstantUtils.REQUEST_RESULT_SUCCESS, intent);
        activity.finish();
    }

    @Override
    public void updatePassengerList(List<Penumpang> passengers, final DataPage dataPage, final Map<String, String> params) {
        mPresenter.getPassenger().addAll(passengers);
        passengerAdapter.notifyDataSetChanged();

        int toolbarHeight = DisplayMetricUtils.convertDpToPixel(56);
        int btSetPassengerHeightAndPassing = DisplayMetricUtils.convertDpToPixel(btSetPassenger.getHeight()) + DisplayMetricUtils.convertDpToPixel(16 + 16);
        int rvPassengerMaxHeight = DisplayMetricUtils.getDeviceHeight(activity) - toolbarHeight - btSetPassengerHeightAndPassing;

        int rvPassengerHeight = rvPassenger.getHeight();
        if (rvPassengerHeight < rvPassengerMaxHeight && dataPage.getCurrentPage() < dataPage.getTotalPage()
                && passengers.size() < ConstantUtils.PAGINATION_LIMIT * 2 && dataPage.getNextPage() != -1) {
            mPresenter.listPassenger(params);
        }

        rvPassenger.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (DisplayMetricUtils.isMaxScrollReached(rvPassenger) && dataPage.getNextPage() != -1) {
                    if (dataPage.getCurrentPage() < dataPage.getTotalPage() && !isLoading()) {
                        mPresenter.listPassenger(params);
                    }
                }
            }
        });

    }

    @Override
    public void onCreatePassengerClick() {
        showPassengerCreatorDialog(ADD_PASSENGER, null, 0);
    }

    @Override
    public void removePassengerItem(int position) {
        passengerAdapter.notifyItemRemoved(position);
    }

    @Override
    public void updatePassengerItem(int position) {
        passengerAdapter.notifyItemChanged(position);
    }

    @Override
    public void addPassengerItem() {
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
    public void showPassengerCreatorDialog(final String title, final Penumpang passenger, final int position) {
        AlertDialog.Builder builder = createAlert(null, null);
        LayoutInflater inflater = getLayoutInflater(null);
        View dialogView = inflater.inflate(R.layout.dialog_passenger_creator, null);
        builder.setView(dialogView);
        final TextInputLayout tilPassengerName = (TextInputLayout) dialogView.findViewById(R.id.tilPassengerName);
        final EditText etPassengerName = (EditText) dialogView.findViewById(R.id.etPassengerName);
        if (passenger != null) {
            etPassengerName.setText(passenger.getNama());
        }
        builder.setCancelable(true);
        builder.setPositiveButton("Simpan", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (validatePassengerNameForm(tilPassengerName.getId())) {
                    Map<String, String> params = new HashMap<>();
                    params.put("name", etPassengerName.getText().toString());
                    if (title.equalsIgnoreCase(ADD_PASSENGER)) {
                        mPresenter.createPassenger(params);
                    } else if (title.equalsIgnoreCase(UPDATE_PASSENGER)) {
                        mPresenter.updatePassenger(position, passenger, params);
                    }
                    dialog.dismiss();
                }
            }
        });
        builder.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    private boolean validatePassengerNameForm(int textInputLayoutId) {
        FormValidation formValidation = new FormValidation(TEXT_INPUT_LAYOUT);
        formValidation.addValidation(activity, textInputLayoutId, RegexTemplate.NOT_EMPTY,
                R.string.validation_passenger_name_not_empty);

        return formValidation.validate();
    }
}
