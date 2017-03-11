package com.irfankhoirul.apps.tatravel.view.dialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.irfankhoirul.apps.tatravel.R;
import com.irfankhoirul.apps.tatravel.base.BaseDialogFragment;
import com.irfankhoirul.apps.tatravel.contract.TravelLocationDialogContract;
import com.irfankhoirul.apps.tatravel.model.api.DataPage;
import com.irfankhoirul.apps.tatravel.model.pojo.Kota;
import com.irfankhoirul.apps.tatravel.model.pojo.Lokasi;
import com.irfankhoirul.apps.tatravel.presenter.TravelLocationDialogPresenter;
import com.irfankhoirul.apps.tatravel.util.ConstantUtils;
import com.irfankhoirul.apps.tatravel.util.DisplayMetricUtils;
import com.irfankhoirul.apps.tatravel.view.adapter.TravelLocationAdapter;
import com.wang.avi.AVLoadingIndicatorView;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Irfan Khoirul on 12/25/2016.
 */

public class TravelLocationDialog extends BaseDialogFragment implements TravelLocationDialogContract.View {

    @BindView(R.id.rvTravelLocation)
    RecyclerView rvTravelLocation;
    @BindView(R.id.loadingIndicator)
    AVLoadingIndicatorView loadingIndicator;

    private TravelLocationDialogPresenter travelLocationDialogPresenter;
    private TravelLocationAdapter travelLocationAdapter;
    private List<Lokasi> locationList = new ArrayList<>();
    private DataPage dataPageManager;
    private Lokasi selectedLocation;
    private Kota kota;

    public TravelLocationDialog() {
        // Empty constructor required for DialogFragment
    }

    public static TravelLocationDialog newInstance(Kota city) {
        TravelLocationDialog travelLocationDialog = new TravelLocationDialog();
        Bundle bundle = new Bundle();
        bundle.putParcelable("city", Parcels.wrap(city));
        travelLocationDialog.setArguments(bundle);
        return travelLocationDialog;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_travel_location, container);
        unbinder = ButterKnife.bind(this, view);

        travelLocationDialogPresenter = new TravelLocationDialogPresenter(this);
        kota = Parcels.unwrap(getArguments().getParcelable("city"));

        travelLocationAdapter = new TravelLocationAdapter(locationList, new TravelLocationAdapter.OnSpecificItemClick() {
            @Override
            public void onItemClick(Lokasi lokasi) {
                selectedLocation = lokasi;
                TravelLocationDialog.this.dismiss();
            }
        }, kota.getNama());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(activity);
        rvTravelLocation.setLayoutManager(layoutManager);
        rvTravelLocation.setItemAnimator(new DefaultItemAnimator());
        rvTravelLocation.setAdapter(travelLocationAdapter);

        Log.v("RequestPage", String.valueOf(ConstantUtils.INITIAL_PAGE));
        travelLocationDialogPresenter.getTravelLocationData(ConstantUtils.INITIAL_PAGE, kota.getId());

        return view;
    }

    @Override
    public void setPresenter() {

    }

    @Override
    public void onResume() {
        ViewGroup.LayoutParams params = getDialog().getWindow().getAttributes();
        params.width = LinearLayout.LayoutParams.MATCH_PARENT;
        params.height = DisplayMetricUtils.getDeviceHeight(activity) * 2 / 3;
        getDialog().getWindow().setAttributes((android.view.WindowManager.LayoutParams) params);

        super.onResume();
    }

    @Override
    public void updateTravelLocationList(DataPage newDataPageManager, List<Lokasi> data) {
        dataPageManager = newDataPageManager;
        Log.v("DataPage", dataPageManager.toString());
        locationList.addAll(data);
        travelLocationAdapter.notifyDataSetChanged();
        Log.v("Height", rvTravelLocation.getHeight() + "|" + DisplayMetricUtils.getDeviceHeight(activity) * 2 / 3);
        int rvTravelLocationHeight = rvTravelLocation.getHeight();
        int dialogHeight = DisplayMetricUtils.getDeviceHeight(activity) * 2 / 3;
        if (rvTravelLocationHeight < dialogHeight && dataPageManager.getCurrentPage() < dataPageManager.getTotalPage()
                && locationList.size() < ConstantUtils.PAGINATION_LIMIT * 2) {
            Log.v("RequestPageFillingSpace", String.valueOf(dataPageManager.getNextPage()));
            travelLocationDialogPresenter.getTravelLocationData(dataPageManager.getNextPage(), kota.getId());
        }

        rvTravelLocation.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (isMaxScrollReached(rvTravelLocation)) {
                    if (dataPageManager.getCurrentPage() < dataPageManager.getTotalPage() && !travelLocationDialogPresenter.isLoadingData()) {
                        Log.v("RequestPage", String.valueOf(dataPageManager.getNextPage()));
                        travelLocationDialogPresenter.getTravelLocationData(dataPageManager.getNextPage(), kota.getId());
                    }
                }
            }
        });

    }

    @Override
    public void setProgressBarVisibility(boolean visible) {
        if (visible) {
            loadingIndicator.smoothToShow();
        } else {
            loadingIndicator.smoothToHide();
        }
    }

    private boolean isMaxScrollReached(RecyclerView recyclerView) {
        int maxScroll = recyclerView.computeVerticalScrollRange();
        int currentScroll = recyclerView.computeVerticalScrollOffset() + recyclerView.computeVerticalScrollExtent();
        return currentScroll >= maxScroll;
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        if (selectedLocation != null) {
            Intent intent = new Intent();
            intent.putExtra("location", Parcels.wrap(selectedLocation));
            getTargetFragment().onActivityResult(getTargetRequestCode(), ConstantUtils.DIALOG_LOCATION_RESULT_CODE, intent);
        }
        super.onDismiss(dialog);
    }
}
