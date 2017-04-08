package com.irfankhoirul.apps.tatravel.view.activity;

import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.irfankhoirul.apps.tatravel.R;
import com.irfankhoirul.apps.tatravel.model.data.local.Session;
import com.irfankhoirul.apps.tatravel.view.fragment.DepartureFragment;
import com.irfankhoirul.apps.tatravel.view.fragment.LoginOrRegisterFragment;
import com.irfankhoirul.apps.tatravel.view.fragment.SearchFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since 1.0
 */

public class MainActivity extends BaseActivity {

    @BindView(R.id.ivIcon)
    ImageView ivIcon;

    @BindView(R.id.llSearch)
    LinearLayout llSearch;
    @BindView(R.id.ivSearch)
    ImageView ivSearch;
    @BindView(R.id.tvSearch)
    TextView tvSearch;

    @BindView(R.id.llOrder)
    LinearLayout llOrder;
    @BindView(R.id.ivOrder)
    ImageView ivOrder;
    @BindView(R.id.tvOrder)
    TextView tvOrder;

    @BindView(R.id.llProfile)
    LinearLayout llProfile;
    @BindView(R.id.ivProfile)
    ImageView ivProfile;
    @BindView(R.id.tvProfile)
    TextView tvProfile;

    private SearchFragment searchFragment;
    private DepartureFragment departureFragment;
    private LoginOrRegisterFragment loginOrRegisterFragment;

    @Override
    protected void initializeFragment() {
        setCurrentFragment(new SearchFragment(), false);
    }

    @Override
    protected void initializeView() {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        btBack.setVisibility(View.GONE);
        ivIcon.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.llSearch)
    public void llSearch() {
        if (searchFragment != null) {
            setCurrentFragment(searchFragment, false);
        } else {
            this.searchFragment = new SearchFragment();
            setCurrentFragment(searchFragment, false);
        }
        resetIconColor();
        ivSearch.setColorFilter(ContextCompat.getColor(this, R.color.colorPrimary));
        tvSearch.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
    }

    @OnClick(R.id.llOrder)
    public void llOrder() {
        if (departureFragment != null) {
            setCurrentFragment(departureFragment, false);
        } else {
            this.departureFragment = new DepartureFragment();
            setCurrentFragment(departureFragment, false);
        }
        resetIconColor();
        ivOrder.setColorFilter(ContextCompat.getColor(this, R.color.colorPrimary));
        tvOrder.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
    }

    @OnClick(R.id.llProfile)
    public void llProfile() {
        if (Session.getInstance(this).getSessionData() != null) {
            // Load profile
        } else {
            // Load LoginOrRegister
            if (loginOrRegisterFragment != null) {
                setCurrentFragment(loginOrRegisterFragment, false);
            } else {
                this.loginOrRegisterFragment = new LoginOrRegisterFragment();
                setCurrentFragment(loginOrRegisterFragment, false);
            }
        }

        resetIconColor();
        ivProfile.setColorFilter(ContextCompat.getColor(this, R.color.colorPrimary));
        tvProfile.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
    }

    public void resetIconColor() {
        ivSearch.setColorFilter(ContextCompat.getColor(this, R.color.grey_500));
        tvSearch.setTextColor(ContextCompat.getColor(this, R.color.grey_500));
        ivOrder.setColorFilter(ContextCompat.getColor(this, R.color.grey_500));
        tvOrder.setTextColor(ContextCompat.getColor(this, R.color.grey_500));
        ivProfile.setColorFilter(ContextCompat.getColor(this, R.color.grey_500));
        tvProfile.setTextColor(ContextCompat.getColor(this, R.color.grey_500));
    }

}
