package com.irfankhoirul.apps.tatravel.data.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.irfankhoirul.mvp_core.base.BasePojo;

/**
 * Merupakan model dari tabel UserFacebook
 *
 * @author Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since 1.0
 */

public class UserFacebook extends BasePojo implements Parcelable {
    public static final Creator<UserFacebook> CREATOR = new Creator<UserFacebook>() {
        @Override
        public UserFacebook createFromParcel(Parcel in) {
            return new UserFacebook(in);
        }

        @Override
        public UserFacebook[] newArray(int size) {
            return new UserFacebook[size];
        }
    };
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

    protected UserFacebook(Parcel in) {
        token = in.readString();
        tokenStatus = in.readString();
        facebookId = in.readString();
        idUser = in.readInt();
        user = in.readParcelable(User.class.getClassLoader());
    }

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(token);
        dest.writeString(tokenStatus);
        dest.writeString(facebookId);
        dest.writeInt(idUser);
        dest.writeParcelable(user, flags);
    }
}
