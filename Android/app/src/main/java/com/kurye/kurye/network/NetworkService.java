package com.kurye.kurye.network;


import com.kurye.kurye.entity.response.ItemEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;

/**
 * Basic retrofit service interface.
 *
 * No magical stuff here..
 * Created by ahmet on 2/4/2018.
 */
public interface NetworkService {

    @POST(NetworkConstants.ITEMS)
    Call<List<ItemEntity>> getItems();
}