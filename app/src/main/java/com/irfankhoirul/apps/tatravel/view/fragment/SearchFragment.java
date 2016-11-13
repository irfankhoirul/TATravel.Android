package com.irfankhoirul.apps.tatravel.view.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.irfankhoirul.apps.tatravel.R;
import com.irfankhoirul.apps.tatravel.core.CoreFragment;
import com.irfankhoirul.apps.tatravel.model.pojo.JadwalPerjalanan;
import com.irfankhoirul.apps.tatravel.presenter.SearchPresenter;
import com.irfankhoirul.apps.tatravel.util.DisplayMetricUtil;
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
public class SearchFragment extends CoreFragment<MainActivity> implements SearchPresenter.IView {

    @BindView(R.id.sliderPromotion)
    SliderLayout sliderPromotion;

    private SearchPresenter searchPresenter;

    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        ButterKnife.bind(this, view);

        searchPresenter = new SearchPresenter(this);

        setSliderPromo();
        searchPresenter.search();

        return view;
    }

    @Override
    public void onStop() {
        sliderPromotion.stopAutoCycle();
        super.onStop();
    }

    private void setSliderPromo() {
        int width = DisplayMetricUtil.getDeviceWidth(activity);
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
    public void showSearchResult(List<JadwalPerjalanan> jadwalPerjalanen) {
        if (jadwalPerjalanen.size() > 0) {
            for (int i = 0; i < jadwalPerjalanen.size(); i++) {
                Log.v("Data[" + i + "]", jadwalPerjalanen.get(i).toString());
            }
        } else {
            Log.v("Data", "isNull");
        }
    }
}
