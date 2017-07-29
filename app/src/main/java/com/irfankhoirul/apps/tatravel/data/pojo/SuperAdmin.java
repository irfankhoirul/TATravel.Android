package com.irfankhoirul.apps.tatravel.data.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.irfankhoirul.mvp_core.base.BasePojo;

/**
 * Merupakan model dari tabel SuperAdmin
 *
 * @author  Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since   1.0
 */

public class SuperAdmin extends BasePojo implements Parcelable {
    public static final Creator<SuperAdmin> CREATOR = new Creator<SuperAdmin>() {
        @Override
        public SuperAdmin createFromParcel(Parcel in) {
            return new SuperAdmin(in);
        }

        @Override
        public SuperAdmin[] newArray(int size) {
            return new SuperAdmin[size];
        }
    };
    @SerializedName("id_user")
    @Expose
    private int idUser;
    @SerializedName("user")
    @Expose
    private User user;

    protected SuperAdmin(Parcel in) {
        id = in.readInt();
        createdAt = in.readString();
        updatedAt = in.readString();
        idUser = in.readInt();
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
        dest.writeInt(id);
        dest.writeString(createdAt);
        dest.writeString(updatedAt);
        dest.writeInt(idUser);
    }
}
