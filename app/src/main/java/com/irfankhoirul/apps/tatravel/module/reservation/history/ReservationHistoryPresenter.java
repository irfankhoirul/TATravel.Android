package com.irfankhoirul.apps.tatravel.module.reservation.history;

import com.irfankhoirul.apps.tatravel.core.components.util.ConstantUtils;
import com.irfankhoirul.apps.tatravel.core.data.DataResult;
import com.irfankhoirul.apps.tatravel.core.data.IRequestResponseListener;
import com.irfankhoirul.apps.tatravel.data.pojo.Pemesanan;
import com.irfankhoirul.apps.tatravel.data.source.locale.session.SessionRepository;
import com.irfankhoirul.apps.tatravel.data.source.remote.reservation.ReservationRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by Irfan Khoirul on 4/2/2017.
 */

public class ReservationHistoryPresenter implements ReservationHistoryContract.Presenter {

    private final ReservationHistoryContract.View view;
    private final ReservationRepository reservationRepository;
    private final SessionRepository sessionRepository;
    private List<Pemesanan> reservations = new ArrayList<>();

    @Inject
    public ReservationHistoryPresenter(SessionRepository sessionRepository,
                                       ReservationRepository reservationRepository,
                                       ReservationHistoryContract.View view) {
        this.view = view;
        this.reservationRepository = reservationRepository;
        this.sessionRepository = sessionRepository;
    }

    @Inject
    void setupListeners() {
        view.setPresenter(this);
    }

    @Override
    public void start() {
        reservations.clear();
        Map<String, String> params = new HashMap<>();
        listReservation(params);
    }

    @Override
    public void listReservation(final Map<String, String> params) {
        if (sessionRepository.getSessionData() == null) {
            view.redirectToLoginOrRegister();
        } else {
            if (params.get("page") == null) {
                params.put("page", String.valueOf(1));
            } else {
                int page = Integer.parseInt(params.get("page"));
                params.put("page", String.valueOf(++page));
            }

            if (Integer.parseInt(params.get("page")) == 1) {
                view.setLoadingDialog(true, "Memuat data...");
            }

            params.put("token", sessionRepository.getSessionData().getUserToken().getToken());
            reservationRepository.reservationList(new IRequestResponseListener<Pemesanan>() {
                @Override
                public void onSuccess(DataResult<Pemesanan> result) {
                    view.setLoadingDialog(false, null);
                    if (result.getCode() == ConstantUtils.REQUEST_RESULT_SUCCESS) {
                        if (result.getDatas() != null && result.getDatas().size() > 0) {
                            view.showDataExist();
                            view.updateReservationList(result.getDatas(), result.getDataPage(), params);
                        } else {
                            view.showDataNotExist();
                        }
                    } else {
                        view.setLoadingDialog(false, null);
                        view.showStatus(ConstantUtils.STATUS_ERROR, result.getMessage());
                    }
                }

                @Override
                public void onFailure(Throwable throwable) {
                    view.setLoadingDialog(false, null);
                    view.showStatus(ConstantUtils.STATUS_ERROR, "Terjadi kesalahan");
                }
            }, params);
        }
    }

    @Override
    public List<Pemesanan> getReservations() {
        return reservations;
    }
}
