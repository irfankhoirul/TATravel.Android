package com.irfankhoirul.apps.tatravel.data.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.irfankhoirul.mvp_core.base.BasePojo;

/**
 * Merupakan model dari tabel UserDevice
 *
 * @author  Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since   1.0
 */

public class UserDevice extends BasePojo implements Parcelable {
    public static final Creator<UserDevice> CREATOR = new Creator<UserDevice>() {
        @Override
        public UserDevice createFromParcel(Parcel in) {
            return new UserDevice(in);
        }

        @Override
        public UserDevice[] newArray(int size) {
            return new UserDevice[size];
        }
    };
    @SerializedName("id_user")
    @Expose
    private int idUser;
    @SerializedName("produsen")
    @Expose
    private String produsen;
    @SerializedName("model")
    @Expose
    private String model;
    @SerializedName("secret_code")
    @Expose
    private String secretCode;
    @SerializedName("FCM_token")
    @Expose
    private String FCMToken;
    @SerializedName("user")
    @Expose
    private User user;

    protected UserDevice(Parcel in) {
        id = in.readInt();
        createdAt = in.readString();
        updatedAt = in.readString();
        idUser = in.readInt();
        produsen = in.readString();
        model = in.readString();
        secretCode = in.readString();
        FCMToken = in.readString();
        user = in.readParcelable(User.class.getClassLoader());
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getProdusen() {
        return produsen;
    }

    public void setProdusen(String produsen) {
        this.produsen = produsen;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSecretCode() {
        return secretCode;
    }

    public void setSecretCode(String secretCode) {
        this.secretCode = secretCode;
    }

    public String getFCMToken() {
        return FCMToken;
    }

    public void setFCMToken(String FCMToken) {
        this.FCMToken = FCMToken;
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
        dest.writeInt(id);
        dest.writeString(createdAt);
        dest.writeString(updatedAt);
        dest.writeInt(idUser);
        dest.writeString(produsen);
        dest.writeString(model);
        dest.writeString(secretCode);
        dest.writeString(FCMToken);
        dest.writeParcelable(user, flags);
    }
}
