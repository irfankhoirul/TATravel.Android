package com.irfankhoirul.apps.tatravel.core.base;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.irfankhoirul.apps.tatravel.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public abstract class BaseFragmentHolderActivity extends BaseActivity {

    @BindView(R.id.flFragmentContainer)
    protected FrameLayout flFragmentContainer;
    @BindView(R.id.btOptionMenu)
    protected ImageButton btOptionMenu;
    @BindView(R.id.tvToolbarTitle)
    protected TextView tvToolbarTitle;
    @BindView(R.id.ivIcon)
    protected ImageView ivIcon;
    @BindView(R.id.btBack)
    protected ImageButton btBack;
    @BindView(R.id.vMenuBarShadow)
    protected View vMenuBarShadow;
    @BindView(R.id.rlActivityFragmentHolder)
    protected RelativeLayout rlActivityFragmentHolder;

    @Override
    protected void initializeView() {
        setContentView(R.layout.activity_fragment_holder);
        ButterKnife.bind(this);
    }

    @Override
    protected TextView getTvToolbarTitle() {
        return tvToolbarTitle;
    }

    @OnClick(R.id.btBack)
    public void btBack() {
        onBackPressed();
    }

}
