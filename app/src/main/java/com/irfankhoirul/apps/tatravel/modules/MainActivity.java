package com.irfankhoirul.apps.tatravel.modules;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.irfankhoirul.apps.tatravel.R;
import com.irfankhoirul.apps.tatravel.app.TAApplication;
import com.irfankhoirul.apps.tatravel.modules.auth_choice.AuthChoiceFragment;
import com.irfankhoirul.apps.tatravel.modules.auth_choice.AuthChoicePresenter;
import com.irfankhoirul.apps.tatravel.modules.auth_choice.AuthChoicePresenterModule;
import com.irfankhoirul.apps.tatravel.modules.profile.ProfileFragment;
import com.irfankhoirul.apps.tatravel.modules.profile.ProfilePresenter;
import com.irfankhoirul.apps.tatravel.modules.profile.ProfilePresenterModule;
import com.irfankhoirul.apps.tatravel.modules.reservation_history.ReservationHistoryFragment;
import com.irfankhoirul.apps.tatravel.modules.reservation_history.ReservationHistoryPresenter;
import com.irfankhoirul.apps.tatravel.modules.reservation_history.ReservationHistoryPresenterModule;
import com.irfankhoirul.apps.tatravel.modules.search.DaggerSearchComponent;
import com.irfankhoirul.apps.tatravel.modules.search.SearchFragment;
import com.irfankhoirul.apps.tatravel.modules.search.SearchPresenter;
import com.irfankhoirul.apps.tatravel.modules.search.SearchPresenterModule;
import com.irfankhoirul.mvp_core.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since 1.0
 */

public class MainActivity extends BaseActivity implements
        AuthChoiceFragment.FragmentListener,
        ReservationHistoryFragment.FragmentListener,
        SearchFragment.FragmentListener,
        ProfileFragment.FragmentListener {

    @BindView(R.id.btOptionMenu)
    ImageButton btOptionMenu;
    @BindView(R.id.flFragmentContainer)
    FrameLayout flFragmentContainer;
    @BindView(R.id.btBack)
    ImageButton btBack;
    @BindView(R.id.rlActivityMain)
    RelativeLayout rlActivityMain;
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

    @Inject
    AuthChoicePresenter authChoicePresenter;

    @Inject
    ProfilePresenter profilePresenter;

    @Inject
    ReservationHistoryPresenter reservationHistoryPresenter;

    @Inject
    SearchPresenter searchPresenter;

    int lastActiveFragment = 0;
    private SearchFragment searchFragment;
    private ReservationHistoryFragment reservationHistoryFragment;
    private AuthChoiceFragment authChoiceFragment;
    private ProfileFragment profileFragment;

    @Override
    protected void initializeFragment() {
        if (lastActiveFragment == 1) {
            llSearchOnClickListener();
        } else if (lastActiveFragment == 2) {
            llOrderOnClickListener();
        } else if (lastActiveFragment == 3) {
            llProfileOnClickListener();
        } else {
            searchFragment = new SearchFragment();
            currentFragment = searchFragment;
            setCurrentFragment(currentFragment, false);

            if (profileFragment == null) {
                profileFragment = new ProfileFragment();
            }

            if (authChoiceFragment == null) {
                authChoiceFragment = new AuthChoiceFragment();
            }

            if (reservationHistoryFragment == null) {
                reservationHistoryFragment = new ReservationHistoryFragment();
            }

            DaggerSearchComponent.builder()
                    .profilePresenterModule(new ProfilePresenterModule(profileFragment))
                    .searchPresenterModule(new SearchPresenterModule(searchFragment))
                    .authChoicePresenterModule(new AuthChoicePresenterModule(authChoiceFragment))
                    .reservationHistoryPresenterModule(new ReservationHistoryPresenterModule(reservationHistoryFragment))
                    .appComponent(((TAApplication) getApplication()).getAppComponent())
                    .build().inject(this);
        }
    }

    @Override
    protected void initializeView() {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        btBack.setVisibility(View.GONE);
        ivIcon.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.llSearch)
    public void llSearchOnClickListener() {
        btOptionMenu.setVisibility(View.GONE);
        lastActiveFragment = 1;
        if (!(currentFragment instanceof SearchFragment)) {
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
    }

    @OnClick(R.id.llOrder)
    public void llOrderOnClickListener() {
        btOptionMenu.setVisibility(View.GONE);
        lastActiveFragment = 2;
        if (!(currentFragment instanceof ReservationHistoryFragment)) {
            if (reservationHistoryFragment != null) {
                setCurrentFragment(reservationHistoryFragment, false);
            } else {
                this.reservationHistoryFragment = new ReservationHistoryFragment();
                setCurrentFragment(reservationHistoryFragment, false);
            }
            resetIconColor();
            ivOrder.setColorFilter(ContextCompat.getColor(this, R.color.colorPrimary));
            tvOrder.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
        }
    }

    @OnClick(R.id.llProfile)
    public void llProfileOnClickListener() {
        lastActiveFragment = 3;
        if (!(currentFragment instanceof ProfileFragment)) {
            if (profilePresenter.getSessionData() != null) {
                // Load profile
                if (profileFragment != null) {
                    setCurrentFragment(profileFragment, false);
                } else {
                    profileFragment = new ProfileFragment();
                    setCurrentFragment(profileFragment, false);
                }
                btOptionMenu.setVisibility(View.VISIBLE);
                btOptionMenu.setImageResource(R.drawable.ic_more_vert_black_24dp);
                btOptionMenu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        PopupMenu popup = new PopupMenu(MainActivity.this, btOptionMenu);
                        popup.getMenuInflater().inflate(R.menu.menu_profile, popup.getMenu());
                        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                            public boolean onMenuItemClick(MenuItem item) {
                                switch (item.getItemId()) {
                                    case R.id.menu_change_profile:
                                        profileFragment.doUpdateProfile();
                                        break;
                                    case R.id.menu_logout:
                                        profileFragment.doLogout();
                                        break;
                                }

                                return true;
                            }
                        });

                        popup.show();//showing popup menu
                    }
                });

            } else {
                // Load LoginOrRegister
                if (authChoiceFragment != null) {
                    setCurrentFragment(authChoiceFragment, false);
                } else {
                    this.authChoiceFragment = new AuthChoiceFragment();
                    setCurrentFragment(authChoiceFragment, false);
                }
            }

            resetIconColor();
            ivProfile.setColorFilter(ContextCompat.getColor(this, R.color.colorPrimary));
            tvProfile.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
        }
    }

    @OnClick(R.id.btBack)
    public void btBackOnClickListener() {
        onBackPressed();
    }

    public void resetIconColor() {
        ivSearch.setColorFilter(ContextCompat.getColor(this, R.color.grey_500));
        tvSearch.setTextColor(ContextCompat.getColor(this, R.color.grey_500));
        ivOrder.setColorFilter(ContextCompat.getColor(this, R.color.grey_500));
        tvOrder.setTextColor(ContextCompat.getColor(this, R.color.grey_500));
        ivProfile.setColorFilter(ContextCompat.getColor(this, R.color.grey_500));
        tvProfile.setTextColor(ContextCompat.getColor(this, R.color.grey_500));
    }

    private void resetOptionMenu() {
        btOptionMenu.setVisibility(View.GONE);
    }

    @Override
    public void onRegisterSuccess() {
        llProfileOnClickListener();
    }

    @Override
    public void onLoginSuccess() {
        llProfileOnClickListener();
    }

    @Override
    public void onLogoutSuccess() {
        resetOptionMenu();
        if (authChoiceFragment != null) {
            setCurrentFragment(authChoiceFragment, false);
        } else {
            this.authChoiceFragment = new AuthChoiceFragment();
            setCurrentFragment(authChoiceFragment, false);
        }
    }

    @Override
    public void redirectToLoginOrRegister() {
        llProfileOnClickListener();
    }

    @Override
    public void setTitle(String title) {
        tvToolbarTitle.setText(title);
    }
}
