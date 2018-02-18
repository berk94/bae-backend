package com.kurye.kurye.network;


import com.kurye.kurye.entity.request.SearchDeliverersRequest;
import com.kurye.kurye.entity.response.BaseResponse;
import com.kurye.kurye.entity.response.DelivererEntity;
import com.kurye.kurye.entity.response.ItemEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Basic retrofit service interface.
 *
 * No magical stuff here..
 * Created by ahmet on 2/4/2018.
 */
public interface NetworkService {

    @GET(NetworkConstants.ITEMS)
    Call<BaseResponse<List<ItemEntity>>> getItems();

    @POST(NetworkConstants.SEARCH_DELIVERERS)
    Call<BaseResponse<List<DelivererEntity>>> searchDeliverers(@Body SearchDeliverersRequest searchDeliverersRequest);
}