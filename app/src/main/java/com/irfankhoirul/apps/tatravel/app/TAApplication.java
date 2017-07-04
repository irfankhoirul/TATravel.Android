package com.irfankhoirul.apps.tatravel.app;

import android.support.multidex.MultiDexApplication;

import com.irfankhoirul.apps.tatravel.data.source.locale.cart.DaoMaster;
import com.irfankhoirul.apps.tatravel.data.source.locale.cart.DaoSession;

import org.greenrobot.greendao.database.Database;

/**
 * Created by Irfan Khoirul on 4/16/2017.
 */

public class TAApplication extends MultiDexApplication {
    private static final boolean ENCRYPTED = false;
    private AppComponent appComponent;

    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(getApplicationContext()))
                .build();

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, ENCRYPTED ? "tatravel-db-encrypted" : "tatravel-db");
        Database db = ENCRYPTED ? helper.getEncryptedWritableDb("4ea8d2335b430796cf3f500368c5b0f5b1dc90f5") : helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

}