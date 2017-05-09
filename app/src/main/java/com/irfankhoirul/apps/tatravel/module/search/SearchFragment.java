package com.irfankhoirul.apps.tatravel.module.search;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.irfankhoirul.apps.tatravel.R;
import com.irfankhoirul.apps.tatravel.core.activity.MainActivity;
import com.irfankhoirul.apps.tatravel.core.base.BaseFragment;
import com.irfankhoirul.apps.tatravel.core.components.util.ConstantUtils;
import com.irfankhoirul.apps.tatravel.core.components.util.DateUtils;
import com.irfankhoirul.apps.tatravel.core.components.util.DisplayMetricUtils;
import com.irfankhoirul.apps.tatravel.data.pojo.JadwalPerjalanan;
import com.irfankhoirul.apps.tatravel.data.source.locale.cart.Cart;
import com.irfankhoirul.apps.tatravel.module.departure.DepartureActivity;
import com.irfankhoirul.apps.tatravel.module.destination.DestinationActivity;
import com.irfankhoirul.apps.tatravel.module.passenger.PassengerActivity;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

/**
 * @author Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @version 1.0 (7 November 2016)
 * @since 1.0
 */
public class SearchFragment extends BaseFragment<MainActivity> implements SearchContract.View {

    @BindView(R.id.sliderPromotion)
    SliderLayout sliderPromotion;
    @BindView(R.id.llDeparture)
    LinearLayout llDeparture;
    @BindView(R.id.llDestination)
    LinearLayout llDestination;
    @BindView(R.id.tvDeparture)
    TextView tvDeparture;
    @BindView(R.id.tvDestination)
    TextView tvDestination;
    @BindView(R.id.tvDateGo)
    TextView tvDateGo;
    @BindView(R.id.tvPassenger)
    TextView tvPassenger;
    @BindView(R.id.llDepartureDate)
    LinearLayout llDepartureDate;
    @BindView(R.id.llReturnDate)
    LinearLayout llReturnDate;
    @BindView(R.id.llPassenger)
    LinearLayout llPassenger;

    private int idOperatorTravelDeparture;
    private double departureLatitude;
    private double departureLongitude;
    private double destinationLatitude;
    private double destinationLongitude;
    private SearchPresenter searchPresenter;
    private Cart cart;

    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    protected void setTitle() {
        title = getString(R.string.app_name);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        unbinder = ButterKnife.bind(this, view);
        cart = new Cart(activity);

        searchPresenter = new SearchPresenter(this);

        searchPresenter.getPromo();
//        searchPresenter.searchJadwalPerjalanan();

        return view;
    }

    @Override
    public void onStop() {
        sliderPromotion.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void showPromo() {
        int width = DisplayMetricUtils.getDeviceWidth(activity);
        sliderPromotion.getLayoutParams().width = width;
        sliderPromotion.getLayoutParams().height = (int) (5.0f / 13.0f * width);
        sliderPromotion.requestLayout();

        HashMap<String, String> url_maps = new HashMap<>();
        url_maps.put("Hannibal", "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
        url_maps.put("Big Bang Theory", "http://tvfiles.alphacoders.com/100/hdclearart-10.png");
        url_maps.put("House of Cards", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
        url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");

        for (String name : url_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(activity);
            textSliderView
                    .description(name)
                    .image(url_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                        @Override
                        public void onSliderClick(BaseSliderView slider) {

                        }
                    });

            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);

            sliderPromotion.addSlider(textSliderView);
        }
        sliderPromotion.setPresetTransformer(SliderLayout.Transformer.Accordion);
        sliderPromotion.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderPromotion.setCustomAnimation(new DescriptionAnimation());
        sliderPromotion.setDuration(4000);
        sliderPromotion.addOnPageChangeListener(new ViewPagerEx.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public void showSearchResult(List<JadwalPerjalanan> jadwalPerjalanan) {
        if (jadwalPerjalanan != null) {
            if (jadwalPerjalanan.size() > 0) {
                for (int i = 0; i < jadwalPerjalanan.size(); i++) {
                    Log.v("DataJadwalPerjalanan[" + i + "]", jadwalPerjalanan.get(i).toString());
                }
            } else {
                Log.v("DataJadwalPerjalanan", "isEmpty");
            }
        } else {
            Log.v("DataJadwalPerjalanan", "isNull");
        }
    }

    @OnClick(R.id.llDeparture)
    public void llDeparture() {
        Intent intent = new Intent(activity, DepartureActivity.class);
        startActivityForResult(intent, ConstantUtils.ACTIVITY_REQUEST_CODE_DEPARTURE);
    }

    @OnClick(R.id.llDestination)
    public void llDestination() {
        if (cart.getDeparture() != null) {
            Intent intent = new Intent(activity, DestinationActivity.class);
            intent.putExtra("id_operator_travel", idOperatorTravelDeparture);
            startActivityForResult(intent, ConstantUtils.ACTIVITY_REQUEST_CODE_DESTINATION);
        } else {
            showStatus(ConstantUtils.STATUS_ERROR, "Anda belum memilih lokasi keberangkatan");
        }
    }

    @OnClick(R.id.llDepartureDate)
    public void llDepartureDate() {
        if (cart.getDestination() != null) {
            final Calendar newCalendar = Calendar.getInstance();
            DatePickerDialog fromDatePickerDialog = new DatePickerDialog(activity, new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    Calendar selectedDate = Calendar.getInstance();
                    selectedDate.set(year, monthOfYear, dayOfMonth);
                    newCalendar.setTimeInMillis(selectedDate.getTimeInMillis());
                    tvDateGo.setText(DateUtils.getStandardDayFormat(selectedDate.getTimeInMillis()));
                    tvDateGo.setTextColor(ContextCompat.getColor(activity, R.color.font_black_primary));
                }
            }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
            fromDatePickerDialog.show();
        } else {
            showStatus(ConstantUtils.STATUS_ERROR, "Anda belum memilih lokasi tujuan");
        }
    }

    @OnCheckedChanged(R.id.swPulangPergi)
    public void swPulangPergi(boolean isChecked) {
        if (isChecked) {
            llReturnDate.setVisibility(View.VISIBLE);
        } else {
            llReturnDate.setVisibility(View.GONE);
        }
    }

    @OnClick(R.id.llPassenger)
    public void llPassenger() {
        Intent intent = new Intent(activity, PassengerActivity.class);
        startActivityForResult(intent, ConstantUtils.ACTIVITY_REQUEST_CODE_PASSENGER);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ConstantUtils.ACTIVITY_REQUEST_CODE_DEPARTURE && resultCode == ConstantUtils.REQUEST_RESULT_SUCCESS) {
            String departureLocation = data.getStringExtra("thoroughfare") + ",  " +
                    data.getStringExtra("locality") + ", " +
                    data.getStringExtra("sub_admin");
            tvDeparture.setText(departureLocation);
            tvDeparture.setTextColor(ContextCompat.getColor(activity, R.color.font_black_primary));
            llDeparture.setBackgroundColor(ContextCompat.getColor(activity, R.color.pure_white));

            Map<String, String> departureData = new HashMap<>();
            departureData.put("address", departureLocation);
            departureData.put("latitude", String.valueOf(data.getDoubleExtra("departureLatitude", 0)));
            departureData.put("longitude", String.valueOf(data.getDoubleExtra("departureLongitude", 0)));
            departureData.put("operatorTravelId", String.valueOf(data.getIntExtra("id_operator_travel", -1)));
            cart.setDeparture(departureData);

            llDestination.setBackgroundColor(ContextCompat.getColor(activity, R.color.red_50));
            tvDestination.setText("Pilih Lokasi Tujuan");
            tvDestination.setTextColor(ContextCompat.getColor(activity, R.color.font_black_disabled));
            destinationLatitude = destinationLongitude = 0;
        } else if (requestCode == ConstantUtils.ACTIVITY_REQUEST_CODE_DESTINATION && resultCode == ConstantUtils.REQUEST_RESULT_SUCCESS) {
            String destinationLocation = data.getStringExtra("thoroughfare") + ",  " +
                    data.getStringExtra("locality") + ", " +
                    data.getStringExtra("sub_admin");
            tvDestination.setText(destinationLocation);
            tvDestination.setTextColor(ContextCompat.getColor(activity, R.color.font_black_primary));
            destinationLatitude = data.getDoubleExtra("departureLatitude", 0);
            destinationLongitude = data.getDoubleExtra("departureLongitude", 0);
            llDestination.setBackgroundColor(ContextCompat.getColor(activity, R.color.pure_white));
        }
    }

    @Override
    public void setPresenter(SearchContract.Presenter Presenter) {

    }

    @Override
    public void setLoadingDialog(boolean isLoading, @Nullable String message) {
        super.setLoadingDialog(isLoading, message);
    }

    @Override
    public void showStatus(int type, String message) {
        super.showStatus(type, message);
    }
}
