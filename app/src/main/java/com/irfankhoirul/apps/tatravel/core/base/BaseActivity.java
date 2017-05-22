package com.irfankhoirul.apps.tatravel.core.base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.irfankhoirul.apps.tatravel.R;

import butterknife.BindView;
import butterknife.OnClick;

public abstract class BaseActivity extends FragmentActivity implements BaseFragment.FragmentListener {

    @BindView(R.id.flFragmentContainer)
    protected FrameLayout flFragmentContainer;
    protected BaseFragment currentFragment;
    @BindView(R.id.btBack)
    protected ImageButton btBack;
    @BindView(R.id.tvToolbarTitle)
    protected TextView tvToolbarTitle;
    @BindView(R.id.btOptionMenu)
    protected ImageButton btOptionMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initializeFragment();
    }

    protected abstract void initializeFragment();

    protected abstract void initializeView();

    protected void setCurrentFragment(BaseFragment fragment, boolean addToBackStack) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (currentFragment != null && addToBackStack) {
            fragmentTransaction.addToBackStack(currentFragment.getTitle());
        }

        fragmentTransaction.replace(R.id.flFragmentContainer, fragment, fragment.getTitle());
        fragmentTransaction.commit();

        this.currentFragment = fragment;
    }

    @OnClick(R.id.btBack)
    public void btBack() {
        onBackPressed();
    }

    @Override
    public void setTitle(String title) {
        tvToolbarTitle.setText(title);
    }
}
