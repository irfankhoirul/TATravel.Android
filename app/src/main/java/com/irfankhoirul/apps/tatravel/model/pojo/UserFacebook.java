package com.irfankhoirul.apps.tatravel.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.irfankhoirul.apps.tatravel.base.BaseModel;

import org.parceler.Parcel;

/**
 * Merupakan model dari tabel UserFacebook
 *
 * @author Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since 1.0
 */

@Parcel
public class UserFacebook extends BaseModel {
    @SerializedName("token")
    @Expose
    private String token;

    @SerializedName("token_status")
    @Expose
    private String tokenStatus;

    @SerializedName("facebook_id")
    @Expose
    private String facebookId;

    @SerializedName("id_user")
    @Expose
    private int idUser;

    @SerializedName("user")
    @Expose
    private User user;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTokenStatus() {
        return tokenStatus;
    }

    public void setTokenStatus(String tokenStatus) {
        this.tokenStatus = tokenStatus;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
