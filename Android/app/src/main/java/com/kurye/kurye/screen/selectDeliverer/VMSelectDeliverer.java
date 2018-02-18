package com.kurye.kurye.screen.selectDeliverer;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableArrayList;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.kurye.kurye.entity.response.DelivererEntity;
import com.kurye.kurye.screen.filter.FilterActivity;
import com.kurye.kurye.task.FilterTask;
import com.kurye.kurye.viewEntity.DelivererVM;
import com.ramotion.cardslider.CardSliderLayoutManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ahmet on 2/18/2018.
 */

public class VMSelectDeliverer extends AndroidViewModel {
    private final RecyclerView.OnScrollListener scrollListener;
    private ObservableArrayList<DelivererVM> deliverers = new ObservableArrayList<>();

    public VMSelectDeliverer(@NonNull Application application) {
        super(application);
        List<DelivererEntity> load = FilterTask.getInstance().load();
        List<DelivererVM> list = new ArrayList<>();
        DelivererVM vm = new DelivererVM(load.get(0).getFirstName() + " " + load.get(0).getLastName(), load.get(0).getRoute());
        list.add(vm);
        deliverers.addAll(list);
        scrollListener = new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    onActiveCardChange(
                            ((CardSliderLayoutManager) recyclerView.getLayoutManager())
                                    .getActiveCardPosition());
                }
            }
        };
    }

    private void onActiveCardChange(int activeCardPosition) {

    }

    public RecyclerView.OnScrollListener getScrollListener() {
        return scrollListener;
    }

    public ObservableArrayList<DelivererVM> getDeliverers() {
        return deliverers;
    }

    public void performChoose(View view) {
        FilterActivity.start(view.getContext());
    }
}
