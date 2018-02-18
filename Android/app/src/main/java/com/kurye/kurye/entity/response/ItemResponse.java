package com.kurye.kurye.entity.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ItemResponse {

    @SerializedName("code")
    @Expose
    private int code;
    @SerializedName("data")
    @Expose
    private List<ItemEntity> data = null;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<ItemEntity> getData() {
        return data;
    }

    public void setData(List<ItemEntity> data) {
        this.data = data;
    }

}
