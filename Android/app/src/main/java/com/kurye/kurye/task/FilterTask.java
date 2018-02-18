package com.kurye.kurye.task;

import android.support.annotation.NonNull;

import com.kurye.kurye.entity.request.SearchDeliverersRequest;
import com.kurye.kurye.entity.response.BaseResponse;
import com.kurye.kurye.entity.response.DelivererEntity;
import com.kurye.kurye.network.NetworkApi;
import com.kurye.kurye.network.NetworkCallback;

import java.util.List;


/**
 * Item interacter. Used for managing deliverer data.
 * <p>
 * Created by ahmet on 2/4/2018.
 */
public class FilterTask extends Task{

    private static FilterTask instance;
    private List<DelivererEntity> items;

    public static FilterTask getInstance() {
        if (instance == null) {
            instance = new FilterTask();
        }
        return instance;
    }

    public List<DelivererEntity> load() {
        return items;
    }

    public void fetch(SearchDeliverersRequest searchDeliverersRequest, @NonNull OnResultListener listener) {
        NetworkApi.getInstance().getDeliverers(searchDeliverersRequest, new NetworkCallback<BaseResponse<List<DelivererEntity>>>() {
            @Override
            public void onSuccess(BaseResponse<List<DelivererEntity>> response) {
                if (response == null || response.getCode() != 200) {
                    listener.onResult(FAIL, "No Matching Results");
                } else {
                    items = response.getData();
                    listener.onResult(SUCCESS, null);
                }
            }

            @Override
            public void onServiceFailure(int httpResponseCode, String message) {
                listener.onResult(FAIL, message);
            }

            @Override
            public void onNetworkFailure(Throwable message) {
                listener.onResult(FAIL, "Unknown Error");
            }
        });
    }

    public boolean itemsIsEmpty() {
        return items == null || items.isEmpty();
    }

}
