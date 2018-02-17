package com.kurye.kurye.entity.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class OrderEntity {
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("delivererID")
    @Expose
    private String delivererID;
    @SerializedName("customerID")
    @Expose
    private String customerID;
    @SerializedName("itemId")
    @Expose
    private String itemId;

    @SerializedName("startDate")
    @Expose
    private Date startDate;

    @SerializedName("endDate")
    @Expose
    private Date endDate;

    @SerializedName("createdAt")
    @Expose
    private Date createdAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDelivererID() {
        return delivererID;
    }

    public void setDelivererID(String delivererID) {
        this.delivererID = delivererID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }


    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}