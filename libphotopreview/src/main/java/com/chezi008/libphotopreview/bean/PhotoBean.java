package com.chezi008.libphotopreview.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * - @description:
 * - @author:  chezi008/chezi008@qq.com
 * - @date:  2019/9/6 11:52
 */
public class PhotoBean implements Parcelable {
    public String path;

    public PhotoBean(String path) {
        this.path = path;
    }

    protected PhotoBean(Parcel in) {
        path = in.readString();
    }

    public static final Creator<PhotoBean> CREATOR = new Creator<PhotoBean>() {
        @Override
        public PhotoBean createFromParcel(Parcel in) {
            return new PhotoBean(in);
        }

        @Override
        public PhotoBean[] newArray(int size) {
            return new PhotoBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(path);
    }
}
