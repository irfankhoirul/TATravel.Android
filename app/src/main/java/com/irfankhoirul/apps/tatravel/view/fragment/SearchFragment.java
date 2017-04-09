package com.irfankhoirul.apps.tatravel.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.irfankhoirul.apps.tatravel.R;
import com.irfankhoirul.apps.tatravel.contract.SearchContract;
import com.irfankhoirul.apps.tatravel.model.pojo.JadwalPerjalanan;
import com.irfankhoirul.apps.tatravel.model.pojo.Lokasi;
import com.irfankhoirul.apps.tatravel.presenter.SearchPresenter;
import com.irfankhoirul.apps.tatravel.util.ConstantUtils;
import com.irfankhoirul.apps.tatravel.util.DisplayMetricUtils;
import com.irfankhoirul.apps.tatravel.view.activity.DepartureActivity;
import com.irfankhoirul.apps.tatravel.view.activity.MainActivity;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @version 1.0 (7 November 2016)
 * @since 1.0
 */
public class SearchFragment extends BaseFragment<MainActivity> implements SearchContract.View {

    @BindView(R.id.sliderPromotion)
    SliderLayout sliderPromotion;
    @BindView(R.id.tvDeparture)
    TextView tvDeparture;
    @BindView(R.id.tvDestination)
    TextView tvDestination;
    @BindView(R.id.tvDateGo)
    TextView tvDateGo;
    @BindView(R.id.tvPassenger)
    TextView tvPassenger;

    private SearchPresenter searchPresenter;

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

        searchPresenter = new SearchPresenter(this);

        searchPresenter.getPromo();
//        searchPresenter.searchJadwalPerjalanan();

        return view;
    }

    @Override
    public void setPresenter() {

    }

    @Override
    public void showStatus(int type, String message) {

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

    @Override
    public void updateLocationSpinner(List<Lokasi> lokasi) {
        if (lokasi != null) {
            if (lokasi.size() > 0) {
                for (int i = 0; i < lokasi.size(); i++) {
                    Log.v("DataLokasi[" + i + "]", lokasi.get(i).toString());
                }
            } else {
                Log.v("DataLokasi", "isEmpty");
            }
        } else {
            Log.v("DataLokasi", "isNull");
        }
    }

    @OnClick(R.id.tvDeparture)
    public void actvDeparture() {
        Intent intent = new Intent(activity, DepartureActivity.class);
        startActivityForResult(intent, ConstantUtils.ACTIVITY_REQUEST_CODE_DEPARTURE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ConstantUtils.ACTIVITY_REQUEST_CODE_DEPARTURE && resultCode == ConstantUtils.ACTIVITY_RESULT_CODE_DEPARTURE) {
            tvDeparture.setText(data.getStringExtra(ConstantUtils.INTENT_SEARCH_FRAGMENT_DEPARTURE_CITY));
        }
    }


}
