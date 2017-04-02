package com.irfankhoirul.apps.tatravel.view.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.irfankhoirul.apps.tatravel.R;
import com.irfankhoirul.apps.tatravel.view.fragment.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;

public abstract class BaseActivity extends FragmentActivity implements BaseFragment.FragmentListener {

    @BindView(R.id.btBack)
    ImageButton btBack;
    @BindView(R.id.tvToolbarTitle)
    TextView tvToolbarTitle;
    @BindView(R.id.btOptionMenu)
    ImageButton btOptionMenu;
    @BindView(R.id.flFragmentContainer)
    FrameLayout flFragmentContainer;

    BaseFragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeFragment();
        initializeView();
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
