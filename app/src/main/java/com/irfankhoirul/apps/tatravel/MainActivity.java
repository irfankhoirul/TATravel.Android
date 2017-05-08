package com.irfankhoirul.apps.tatravel;

import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.irfankhoirul.apps.tatravel.core.base.BaseActivity;
import com.irfankhoirul.apps.tatravel.module.departure.DepartureFragment;
import com.irfankhoirul.apps.tatravel.module.search.SearchFragment;
import com.irfankhoirul.apps.tatravel.module.user.LoginOrRegisterFragment;
import com.irfankhoirul.apps.tatravel.module.user.ProfileFragment;
import com.irfankhoirul.apps.tatravel.module.user.ProfilePresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since 1.0
 */

public class MainActivity extends BaseActivity implements
        LoginOrRegisterFragment.FragmentListener,
        ProfileFragment.FragmentListener {

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
    ProfilePresenter profilePresenter;
    private SearchFragment searchFragment;
    private DepartureFragment departureFragment;
    private LoginOrRegisterFragment loginOrRegisterFragment;
    private ProfileFragment profileFragment;

    @Override
    protected void initializeFragment() {
        currentFragment = new SearchFragment();
        setCurrentFragment(currentFragment, false);

        profileFragment = new ProfileFragment();

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
    public void llOrder() {
        if (!(currentFragment instanceof DepartureFragment)) {
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
    }

    @OnClick(R.id.llProfile)
    public void llProfile() {
        // Todo : Check Session
/*
        if (!(currentFragment instanceof ProfileFragment)) {
            if (Session.getInstance() != null && Session.getInstance().getSessionData() != null) {
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
*/
    }

    public void resetIconColor() {
        ivSearch.setColorFilter(ContextCompat.getColor(this, R.color.grey_500));
        tvSearch.setTextColor(ContextCompat.getColor(this, R.color.grey_500));
        ivOrder.setColorFilter(ContextCompat.getColor(this, R.color.grey_500));
        tvOrder.setTextColor(ContextCompat.getColor(this, R.color.grey_500));
        ivProfile.setColorFilter(ContextCompat.getColor(this, R.color.grey_500));
        tvProfile.setTextColor(ContextCompat.getColor(this, R.color.grey_500));
    }

    @Override
    public void onRegisterSuccess() {
        llProfile();
    }

    @Override
    public void onLoginSuccess() {
        llProfile();
    }

    @Override
    public void onLogoutSuccess() {
        Log.v("Logout", "Success");
        resetOptionMenu();
        if (loginOrRegisterFragment != null) {
            setCurrentFragment(loginOrRegisterFragment, false);
        } else {
            this.loginOrRegisterFragment = new LoginOrRegisterFragment();
            setCurrentFragment(loginOrRegisterFragment, false);
        }
    }

    private void resetOptionMenu() {
        btOptionMenu.setVisibility(View.GONE);
    }

}
