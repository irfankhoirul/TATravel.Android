package com.irfankhoirul.apps.tatravel.view.dialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.irfankhoirul.apps.tatravel.R;
import com.irfankhoirul.apps.tatravel.base.BaseDialogFragment;
import com.irfankhoirul.apps.tatravel.contract.CityDialogContract;
import com.irfankhoirul.apps.tatravel.model.api.DataPage;
import com.irfankhoirul.apps.tatravel.model.pojo.Kota;
import com.irfankhoirul.apps.tatravel.presenter.CityDialogPresenter;
import com.irfankhoirul.apps.tatravel.util.ConstantUtils;
import com.irfankhoirul.apps.tatravel.util.DisplayMetricUtils;
import com.irfankhoirul.apps.tatravel.view.adapter.CityAdapter;
import com.wang.avi.AVLoadingIndicatorView;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Irfan Khoirul on 12/25/2016.
 */

public class CityDialog extends BaseDialogFragment implements CityDialogContract.View {

    @BindView(R.id.rvCity)
    RecyclerView rvCity;
    @BindView(R.id.loadingIndicator)
    AVLoadingIndicatorView loadingIndicator;

    private CityDialogPresenter cityDialogPresenter;
    private CityAdapter cityAdapter;
    private List<Kota> cityList = new ArrayList<>();
    private DataPage dataPageManager;
    private Kota selectedCity;

    public CityDialog() {
        // Empty constructor required for DialogFragment
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_city, container);
        unbinder = ButterKnife.bind(this, view);

        cityDialogPresenter = new CityDialogPresenter(this);

        cityAdapter = new CityAdapter(cityList, new CityAdapter.OnSpecificItemClick() {
            @Override
            public void onItemClick(Kota city) {
                selectedCity = city;
                CityDialog.this.dismiss();
            }
        });
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(activity);
        rvCity.setLayoutManager(layoutManager);
        rvCity.setItemAnimator(new DefaultItemAnimator());
        rvCity.setAdapter(cityAdapter);

        cityDialogPresenter.getCityData(ConstantUtils.INITIAL_PAGE);

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
    public void updateCityList(DataPage newDataPageManager, List<Kota> data) {
        dataPageManager = newDataPageManager;
        cityList.addAll(data);
        cityAdapter.notifyDataSetChanged();
        int rvCityHeight = rvCity.getHeight();
        int dialogHeight = DisplayMetricUtils.getDeviceHeight(activity) * 2 / 3;
        if (rvCityHeight < dialogHeight && dataPageManager.getCurrentPage() < dataPageManager.getTotalPage()
                && cityList.size() < ConstantUtils.PAGINATION_LIMIT * 2) {
            cityDialogPresenter.getCityData(dataPageManager.getNextPage());
        }

        rvCity.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (isMaxScrollReached(rvCity)) {
                    if (dataPageManager.getCurrentPage() < dataPageManager.getTotalPage() && !cityDialogPresenter.isLoadingData()) {
                        cityDialogPresenter.getCityData(dataPageManager.getNextPage());
                    }
                }
            }
        });

    }

    @Override
    public void setProgressBarVisibility(boolean visible) {
        if (loadingIndicator != null) {
            if (visible) {
                loadingIndicator.smoothToShow();
            } else {
                loadingIndicator.smoothToHide();
            }
        }
    }

    private boolean isMaxScrollReached(RecyclerView recyclerView) {
        int maxScroll = recyclerView.computeVerticalScrollRange();
        int currentScroll = recyclerView.computeVerticalScrollOffset() + recyclerView.computeVerticalScrollExtent();
        return currentScroll >= maxScroll;
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        if (selectedCity != null) {
            Intent intent = new Intent();
            intent.putExtra("kota", Parcels.wrap(selectedCity));
            getTargetFragment().onActivityResult(getTargetRequestCode(), ConstantUtils.DIALOG_CITY_RESULT_CODE, intent);
        }
        super.onDismiss(dialog);
    }
}
