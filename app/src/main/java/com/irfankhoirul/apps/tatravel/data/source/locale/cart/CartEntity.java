package com.irfankhoirul.apps.tatravel.data.source.locale.cart;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by Irfan Khoirul on 7/3/2017.
 */

@Entity
public class CartEntity {
    @Id
    private String key;

    private String value;

    @Generated(hash = 1963121286)
    public CartEntity(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Generated(hash = 1508478210)
    public CartEntity() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
