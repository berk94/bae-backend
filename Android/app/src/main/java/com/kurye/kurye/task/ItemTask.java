package com.kurye.kurye.task;

import android.support.annotation.IntDef;
import android.support.annotation.NonNull;

import com.kurye.kurye.entity.response.ItemEntity;
import com.kurye.kurye.entity.response.BaseResponse;
import com.kurye.kurye.network.NetworkApi;
import com.kurye.kurye.network.NetworkCallback;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;


/**
 * Item interacter. Used for managing item data.
 *
 * Created by ahmet on 2/4/2018.
 */
public class ItemTask {
    public static final int FAIL = 0;
    public static final int SUCCESS = 1;
    private static ItemTask instance;
    private List<ItemEntity> items;

    public static ItemTask getInstance() {
        if (instance==null){
            instance = new ItemTask();
        }
        return instance;
    }

    public List<ItemEntity> load() {
        return items;
    }

    public void fetch(@NonNull SearchResultListener listener) {
        NetworkApi.getInstance().getItems(new NetworkCallback<BaseResponse<List<ItemEntity>>>() {
            @Override
            public void onSuccess(BaseResponse<List<ItemEntity>> response) {
                if (response == null || response.getCode() != 200) {
                    listener.onResult(FAIL,"No Matching Results");
                } else {
                    items = response.getData();
                    listener.onResult(SUCCESS,null);
                }
            }

            @Override
            public void onServiceFailure(int httpResponseCode, String message) {
                listener.onResult(FAIL,message);
            }

            @Override
            public void onNetworkFailure(Throwable message) {
                listener.onResult(FAIL,"Unknown Error");
            }
        });
    }

    public boolean itemsIsEmpty() {
        return items == null || items.isEmpty();
    }
    @IntDef({FAIL, SUCCESS})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Status {}

    public interface SearchResultListener{
        void onResult(@Status int status, String message);
    }
}
