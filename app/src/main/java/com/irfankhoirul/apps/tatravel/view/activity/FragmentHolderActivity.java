package com.irfankhoirul.apps.tatravel.view.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.irfankhoirul.apps.tatravel.R;
import com.irfankhoirul.apps.tatravel.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public abstract class FragmentHolderActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_fragment_holder);
        ButterKnife.bind(this);

        initializeFragment();
    }

    protected abstract void initializeFragment();

    protected abstract void initializeView();

    protected void setCurrentFragment(BaseFragment fragment, boolean addToBackStack) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (currentFragment != null && addToBackStack) {
            fragmentTransaction.addToBackStack(currentFragment.getLabel());
        }

        fragmentTransaction.replace(R.id.flFragmentContainer, fragment, fragment.getLabel());
        fragmentTransaction.commit();

        this.currentFragment = fragment;
    }

    protected void setTitle(String title) {
        tvToolbarTitle.setText(title);
    }

    @OnClick(R.id.btBack)
    public void btBack() {
        onBackPressed();
    }
}
