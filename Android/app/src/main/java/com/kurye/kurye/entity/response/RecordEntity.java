package com.kurye.kurye.entity.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RecordEntity {

    @SerializedName("_id")
    @Expose
    private LocationEntity location;
    @SerializedName("totalCount")
    @Expose
    private int totalCount;

    public LocationEntity getLocation() {
        return location;
    }

    public void setLocation(LocationEntity location) {
        this.location = location;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

}