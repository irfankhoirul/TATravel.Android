package com.irfankhoirul.apps.tatravel.modules.reservation_history;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.irfankhoirul.apps.tatravel.R;
import com.irfankhoirul.apps.tatravel.activity.MainActivity;
import com.irfankhoirul.apps.tatravel.components.ConstantUtils;
import com.irfankhoirul.apps.tatravel.components.DisplayMetricUtils;
import com.irfankhoirul.apps.tatravel.data.pojo.Pemesanan;
import com.irfankhoirul.apps.tatravel.modules.reservation_detail.ReservationDetailActivity;
import com.irfankhoirul.mvp_core.base.BaseFragment;
import com.irfankhoirul.mvp_core.data.DataPage;

import org.parceler.Parcels;

import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * A simple {@link Fragment} subclass.
 */

public class ReservationHistoryFragment extends BaseFragment<MainActivity, ReservationHistoryContract.Presenter>
        implements ReservationHistoryContract.View {

    @BindView(R.id.rlFragmentContainer)
    RelativeLayout rlFragmentContainer;
    @BindView(R.id.rvReservationHistory)
    RecyclerView rvReservationHistory;
    @BindView(R.id.llEmptyMessage)
    LinearLayout llEmptyMessage;

    private FragmentListener listener;
    private ReservationHistoryAdapter reservationHistoryAdapter;

    public ReservationHistoryFragment() {
        // Required empty public constructor
    }

    @Override
    protected void setTitle() {
        title = "Reservasi Saya";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_reservation_history, container, false);
        unbinder = ButterKnife.bind(this, fragmentView);

        reservationHistoryAdapter = new ReservationHistoryAdapter(mPresenter.getReservations(), new ReservationHistoryAdapter.OnSpecificItemClick() {
            @Override
            public void onItemClick(Pemesanan reservation) {
                // Show detail
                Intent intent = new Intent(activity, ReservationDetailActivity.class);
                intent.putExtra("reservation", Parcels.wrap(reservation));
                startActivityForResult(intent, ConstantUtils.ACTIVITY_REQUEST_CODE_DETAIL_RESERVATION);
            }
        });
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(activity);
        rvReservationHistory.setLayoutManager(layoutManager);
        rvReservationHistory.setItemAnimator(new DefaultItemAnimator());
        rvReservationHistory.setAdapter(reservationHistoryAdapter);

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
    public void setPresenter(ReservationHistoryContract.Presenter presenter) {
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
    public void updateReservationList(List<Pemesanan> reservations, final DataPage dataPage, final Map<String, String> params) {
        mPresenter.getReservations().addAll(reservations);
        reservationHistoryAdapter.notifyDataSetChanged();

        int rvPassengerMaxHeight = DisplayMetricUtils.convertDpToPixel(rlFragmentContainer.getHeight());
        int rvPassengerHeight = rvReservationHistory.getHeight();
        if (rvPassengerHeight < rvPassengerMaxHeight && dataPage.getCurrentPage() < dataPage.getTotalPage()
                && reservations.size() < ConstantUtils.PAGINATION_LIMIT * 2 && dataPage.getNextPage() != -1) {
            mPresenter.listReservation(params);
        }

        rvReservationHistory.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (DisplayMetricUtils.isMaxScrollReached(rvReservationHistory) && dataPage.getNextPage() != -1) {
                    if (dataPage.getCurrentPage() < dataPage.getTotalPage() && !isLoading()) {
                        mPresenter.listReservation(params);
                    }
                }
            }
        });
    }

    @Override
    public void showDataExist() {
        llEmptyMessage.setVisibility(View.GONE);
        rvReservationHistory.setVisibility(View.VISIBLE);
    }

    @Override
    public void showDataNotExist() {
        rvReservationHistory.setVisibility(View.GONE);
        llEmptyMessage.setVisibility(View.VISIBLE);
    }

    @Override
    public void redirectToLoginOrRegister() {
        AlertDialog.Builder builder = createAlert("Login", "Anda harus login untuk melihat daftar pemesanan Anda");
        builder.setCancelable(false);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                listener.redirectToLoginOrRegister();
            }
        });
        builder.create().show();
    }

    public interface FragmentListener {
        void redirectToLoginOrRegister();
    }
}
