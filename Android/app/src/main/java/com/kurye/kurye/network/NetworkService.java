package com.kurye.kurye.network;


import com.kurye.kurye.entity.response.ItemResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Basic retrofit service interface.
 *
 * No magical stuff here..
 * Created by ahmet on 2/4/2018.
 */
public interface NetworkService {

    @GET(NetworkConstants.ITEMS)
    Call<ItemResponse> getItems();
}