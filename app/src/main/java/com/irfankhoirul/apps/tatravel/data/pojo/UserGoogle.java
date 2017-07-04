package com.irfankhoirul.apps.tatravel.data.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.irfankhoirul.mvp_core.base.BasePojo;

/**
 * Merupakan model dari tabel UserGoogle
 *
 * @author  Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since   1.0
 */

public class UserGoogle extends BasePojo implements Parcelable {
    public static final Creator<UserGoogle> CREATOR = new Creator<UserGoogle>() {
        @Override
        public UserGoogle createFromParcel(Parcel in) {
            return new UserGoogle(in);
        }

        @Override
        public UserGoogle[] newArray(int size) {
            return new UserGoogle[size];
        }
    };
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("token_status")
    @Expose
    private String tokenStatus;
    @SerializedName("google_id")
    @Expose
    private String googleId;
    @SerializedName("id_user")
    @Expose
    private int idUser;
    @SerializedName("user")
    @Expose
    private User user;

    protected UserGoogle(Parcel in) {
        token = in.readString();
        tokenStatus = in.readString();
        googleId = in.readString();
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

    public String getGoogleId() {
        return googleId;
    }

    public void setGoogleId(String googleId) {
        this.googleId = googleId;
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
        dest.writeString(googleId);
        dest.writeInt(idUser);
        dest.writeParcelable(user, flags);
    }
}
