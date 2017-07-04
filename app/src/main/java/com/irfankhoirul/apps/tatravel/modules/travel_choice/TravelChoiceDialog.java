package com.irfankhoirul.apps.tatravel.modules.travel_choice;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.irfankhoirul.apps.tatravel.R;
import com.irfankhoirul.apps.tatravel.data.pojo.Lokasi;
import com.irfankhoirul.apps.tatravel.data.pojo.OperatorTravel;
import com.irfankhoirul.apps.tatravel.modules.departure.DepartureActivity;
import com.irfankhoirul.mvp_core.base.BaseDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Irfan Khoirul on 12/25/2016.
 */

public class TravelChoiceDialog extends BaseDialog<DepartureActivity, TravelChoiceContract.Presenter>
        implements TravelChoiceContract.View {

    @BindView(R.id.rvTravelLocation)
    RecyclerView rvTravelLocation;

    private DialogListener listener;

    private TravelChoiceAdapter cityAdapter;
    private List<Lokasi> lokasiList = new ArrayList<>();

    public TravelChoiceDialog() {
        // Empty constructor required for DialogFragment
    }

    public static TravelChoiceDialog newInstance(ArrayList<Lokasi> lokasiList) {
        TravelChoiceDialog travelChoiceDialog = new TravelChoiceDialog();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("lokasiList", lokasiList);
        travelChoiceDialog.setArguments(bundle);

        return travelChoiceDialog;
    }

    public void setListener(DialogListener listener) {
        this.listener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.dialog_travel_choice, container);
        unbinder = ButterKnife.bind(this, fragmentView);

        mPresenter.start();

        final List<Lokasi> operatorTravelLocations = getArguments().getParcelableArrayList("lokasiList");

        cityAdapter = new TravelChoiceAdapter(mPresenter.prepareData(operatorTravelLocations),
                new TravelChoiceAdapter.OnSpecificItemClick() {
                    @Override
                    public void onItemClick(OperatorTravel operatorTravel) {
                        ArrayList<Integer> operatorTravelLocationIds = new ArrayList<>();
                        for (int i = 0; i < operatorTravelLocations.size(); i++) {
                            if (operatorTravelLocations.get(i).getOperatorTravel().getId() == operatorTravel.getId()) {
                                operatorTravelLocationIds.add(operatorTravelLocations.get(i).getId());
                            }
                        }
                        listener.onOperatorTravelChoose(TravelChoiceDialog.this, operatorTravel, operatorTravelLocationIds);
                    }
                });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(activity);
        rvTravelLocation.setLayoutManager(layoutManager);
        rvTravelLocation.setItemAnimator(new DefaultItemAnimator());
        rvTravelLocation.setAdapter(cityAdapter);

        return fragmentView;
    }

    @Override
    public void onResume() {
        ViewGroup.LayoutParams params = getDialog().getWindow().getAttributes();
        params.width = LinearLayout.LayoutParams.MATCH_PARENT;
        params.height = LinearLayout.LayoutParams.WRAP_CONTENT;
        getDialog().getWindow().setAttributes((android.view.WindowManager.LayoutParams) params);

        super.onResume();
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
    }

    @Override
    public void setPresenter(TravelChoiceContract.Presenter presenter) {
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

    public interface DialogListener {
        void onOperatorTravelChoose(TravelChoiceDialog travelChoiceDialog,
                                    OperatorTravel operatorTravel,
                                    ArrayList<Integer> operatorTravelLocationIds);
    }
}
