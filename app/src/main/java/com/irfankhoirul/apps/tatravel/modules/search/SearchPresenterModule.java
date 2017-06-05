package com.irfankhoirul.apps.tatravel.modules.search;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */

@Module
public class SearchPresenterModule {

    private final SearchContract.View mView;

    public SearchPresenterModule(SearchContract.View view) {
        mView = view;
    }

    @Provides
    SearchContract.View provideSearchContractView() {
        return mView;
    }
}
