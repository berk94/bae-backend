package com.kurye.kurye.entity.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RouteEntity {

    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("location")
    @Expose
    private LocationEntity location;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public LocationEntity getLocation() {
        return location;
    }

    public void setLocation(LocationEntity location) {
        this.location = location;
    }
}