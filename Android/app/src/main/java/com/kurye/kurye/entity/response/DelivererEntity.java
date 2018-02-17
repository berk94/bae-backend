package com.kurye.kurye.entity.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DelivererEntity {
    @SerializedName("_id")
    @Expose
    private String id;

    @SerializedName("firstName")
    @Expose
    private String firstName;

    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("weightCapacity")
    @Expose
    private double weightCapacity;

    @SerializedName("volumeCapacity")
    @Expose
    private double volumeCapacity;

    @SerializedName("route")
    @Expose
    private List<RouteEntity> route = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getWeightCapacity() {
        return weightCapacity;
    }

    public void setWeightCapacity(double weightCapacity) {
        this.weightCapacity = weightCapacity;
    }

    public double getVolumeCapacity() {
        return volumeCapacity;
    }

    public void setVolumeCapacity(double volumeCapacity) {
        this.volumeCapacity = volumeCapacity;
    }

    public List<RouteEntity> getRoute() {
        return route;
    }

    public void setRoute(List<RouteEntity> route) {
        this.route = route;
    }
}