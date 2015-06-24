package com.suren.baseadapterforrecyleview.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2014/12/7.
 */
public class ItemEntity implements Parcelable {

    private String name;
    private String desc;
    private String headImageUrl;

    public ItemEntity(String name){
        this.name = name;
    }

    public ItemEntity(String name, String desc, String headImageUrl) {
        this.name = name;
        this.desc = desc;
        this.headImageUrl = headImageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getHeadImageUrl() {
        return headImageUrl;
    }

    public void setHeadImageUrl(String headImageUrl) {
        this.headImageUrl = headImageUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.desc);
        dest.writeString(this.headImageUrl);
    }

    private ItemEntity(Parcel in) {
        this.name = in.readString();
        this.desc = in.readString();
        this.headImageUrl = in.readString();
    }

    public static final Parcelable.Creator<ItemEntity> CREATOR = new Parcelable.Creator<ItemEntity>() {
        public ItemEntity createFromParcel(Parcel source) {
            return new ItemEntity(source);
        }

        public ItemEntity[] newArray(int size) {
            return new ItemEntity[size];
        }
    };
}
