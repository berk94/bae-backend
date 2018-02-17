package com.kurye.kurye.task;

import android.support.annotation.IntDef;
import android.support.annotation.NonNull;

import com.kurye.kurye.entity.response.ItemEntity;
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
    private static ItemTask instance;
    private List<ItemEntity> items;

    public static ItemTask getInstance() {
        if (instance==null){
            instance = new ItemTask();
        }
        return instance;
    }

    public int pageCount(){
        if (itemsIsEmpty())return 0;
        return (int) Math.ceil(items.size()/10.0);
    }

    public List<ItemEntity> load(int i){
        if (itemsIsEmpty()||i>=pageCount())return null;
        int fromIndex = i * 10;
        int toIndex = Math.min((i+1) * 10, items.size());
        return items.subList(fromIndex,toIndex);
    }

    public void fetch(@NonNull SearchResultListener listener) {
        NetworkApi.getInstance().getItems(new NetworkCallback<List<ItemEntity>>() {
            @Override
            public void onSuccess(List<ItemEntity> response) {
                if (response==null||response.isEmpty()){
                    listener.onResult(FAIL,"No Matching Results");
                } else {
                    items = response;
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
        return items ==null|| items.isEmpty();
    }

    public static final int FAIL = 0;
    public static final int SUCCESS = 1;
    @IntDef({FAIL, SUCCESS})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Status {}

    public interface SearchResultListener{
        void onResult(@Status int status, String message);
    }
}
