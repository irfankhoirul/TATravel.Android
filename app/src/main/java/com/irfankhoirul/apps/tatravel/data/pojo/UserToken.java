package com.irfankhoirul.apps.tatravel.data.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.irfankhoirul.mvp_core.base.BasePojo;

/**
 * Merupakan model dari tabel UserToken
 *
 * @author  Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since   1.0
 */

public class UserToken extends BasePojo implements Parcelable {
    public static final Creator<UserToken> CREATOR = new Creator<UserToken>() {
        @Override
        public UserToken createFromParcel(Parcel in) {
            return new UserToken(in);
        }

        @Override
        public UserToken[] newArray(int size) {
            return new UserToken[size];
        }
    };
    @SerializedName("expired_at")
    @Expose
    private long expiredAt;
    @SerializedName("id_user")
    @Expose
    private int idUser;
    @SerializedName("id_user_device")
    @Expose
    private int idUserDevice;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("total_request")
    @Expose
    private int totalRequest;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("user_device")
    @Expose
    private UserDevice userDevice;

    protected UserToken(Parcel in) {
        id = in.readInt();
        createdAt = in.readString();
        updatedAt = in.readString();
        expiredAt = in.readLong();
        idUser = in.readInt();
        idUserDevice = in.readInt();
        status = in.readString();
        token = in.readString();
        totalRequest = in.readInt();
        user = in.readParcelable(User.class.getClassLoader());
        userDevice = in.readParcelable(UserDevice.class.getClassLoader());
    }

    public long getExpiredAt() {
        return expiredAt;
    }

    public void setExpiredAt(long expiredAt) {
        this.expiredAt = expiredAt;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdUserDevice() {
        return idUserDevice;
    }

    public void setIdUserDevice(int idUserDevice) {
        this.idUserDevice = idUserDevice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getTotalRequest() {
        return totalRequest;
    }

    public void setTotalRequest(int totalRequest) {
        this.totalRequest = totalRequest;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserDevice getUserDevice() {
        return userDevice;
    }

    public void setUserDevice(UserDevice userDevice) {
        this.userDevice = userDevice;
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
        dest.writeLong(expiredAt);
        dest.writeInt(idUser);
        dest.writeInt(idUserDevice);
        dest.writeString(status);
        dest.writeString(token);
        dest.writeInt(totalRequest);
        dest.writeParcelable(user, flags);
        dest.writeParcelable(userDevice, flags);
    }
}
