package com.irfankhoirul.apps.tatravel.view.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.irfankhoirul.apps.tatravel.R;
import com.irfankhoirul.apps.tatravel.base.BaseFragment;
import com.irfankhoirul.apps.tatravel.contract.SearchContract;
import com.irfankhoirul.apps.tatravel.model.pojo.JadwalPerjalanan;
import com.irfankhoirul.apps.tatravel.model.pojo.Lokasi;
import com.irfankhoirul.apps.tatravel.presenter.SearchPresenter;
import com.irfankhoirul.apps.tatravel.util.DisplayMetricUtils;
import com.irfankhoirul.apps.tatravel.view.activity.MainActivity;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @version 1.0 (7 November 2016)
 * @since 1.0
 */
public class SearchFragment extends BaseFragment<MainActivity> implements SearchContract.View {

    @BindView(R.id.sliderPromotion)
    SliderLayout sliderPromotion;
    @BindView(R.id.actvDeparture)
    AutoCompleteTextView actvDeparture;
    @BindView(R.id.actvDestination)
    AutoCompleteTextView actvDestination;
    @BindView(R.id.etDate)
    EditText etDate;
    @BindView(R.id.etPassenger)
    EditText etPassenger;

    private SearchPresenter searchPresenter;

    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    protected void setLabel() {
        label = this.getClass().getSimpleName();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        unbinder = ButterKnife.bind(this, view);

        searchPresenter = new SearchPresenter(this);

        showSliderPromo();
        searchPresenter.getLocation();
        searchPresenter.searchJadwalPerjalanan();

        return view;
    }

    @Override
    public void onStop() {
        sliderPromotion.stopAutoCycle();
        super.onStop();
    }

    public void showSliderPromo() {
        int width = DisplayMetricUtils.getDeviceWidth(activity);
        sliderPromotion.getLayoutParams().width = width;
        sliderPromotion.getLayoutParams().height = (int) (9.0f / 16.0f * width);
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
}
