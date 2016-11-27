package com.irfankhoirul.apps.tatravel.view.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.irfankhoirul.apps.tatravel.R;
import com.irfankhoirul.apps.tatravel.base.BaseFragment;
import com.irfankhoirul.apps.tatravel.view.fragment.DepartureFragment;
import com.irfankhoirul.apps.tatravel.view.fragment.LoginFragment;
import com.irfankhoirul.apps.tatravel.view.fragment.RegisterFragment;
import com.irfankhoirul.apps.tatravel.view.fragment.SearchFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since 1.0
 */

public class MainActivity extends FragmentActivity {

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
    private LoginFragment loginFragment;
    private RegisterFragment registerFragment;
    private BaseFragment currentFragment;
    private DepartureFragment departureFragment;

    @OnClick(R.id.llSearch)
    public void llSearch() {
        if (searchFragment != null) {
            setCurrentFragment(searchFragment, false);
        } else {
            this.searchFragment = new SearchFragment();
            setCurrentFragment(searchFragment, false);
        }
        resetIconColor();
        ivSearch.setColorFilter(ContextCompat.getColor(this, R.color.pure_white));
        tvSearch.setTextColor(ContextCompat.getColor(this, R.color.pure_white));
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
        ivOrder.setColorFilter(ContextCompat.getColor(this, R.color.pure_white));
        tvOrder.setTextColor(ContextCompat.getColor(this, R.color.pure_white));
    }

    @OnClick(R.id.llProfile)
    public void llProfile() {
        if (registerFragment != null) {
            setCurrentFragment(registerFragment, false);
        } else {
            this.registerFragment = new RegisterFragment();
            setCurrentFragment(registerFragment, false);
        }
        resetIconColor();
        ivProfile.setColorFilter(ContextCompat.getColor(this, R.color.pure_white));
        tvProfile.setTextColor(ContextCompat.getColor(this, R.color.pure_white));
    }

    public BaseFragment getFragment() {
        return currentFragment;
    }

    public void setFragment(BaseFragment currentFragment) {
        this.currentFragment = currentFragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setCurrentFragment(new SearchFragment(), false);
    }

    public void setCurrentFragment(BaseFragment fragment, boolean addToBackStack) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (currentFragment != null && addToBackStack) {
            fragmentTransaction.addToBackStack(currentFragment.getLabel());
        }

        fragmentTransaction.replace(R.id.flMainContainer, fragment, fragment.getLabel());
        fragmentTransaction.commit();

        this.currentFragment = fragment;
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
