package com.codingdemos.imagezoom;

import android.os.Parcel;
import android.os.Parcelable;

public class Chair implements Parcelable {
    public final String name;
    public Integer photo = 0;

    public static final Creator<Chair> CREATOR = new Creator<Chair>() {
        @Override
        public Chair createFromParcel(Parcel in) {
            return new Chair(in);
        }

        @Override
        public Chair[] newArray(int size) {
            return new Chair[size];
        }
    };

/*
    public Chair(String name) {
        this.name = name;
    }
*/
    public Chair(String name, Integer photo) {
        this.name = name;
        this.photo = photo;
    }

    protected Chair(Parcel in) {
        name = in.readString();
        photo = in.readInt();
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(photo);
    }
}
