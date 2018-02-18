package com.kurye.kurye.screen.selectDeliverer;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableArrayList;
import android.support.annotation.NonNull;
import android.view.View;

import com.kurye.kurye.entity.response.DelivererEntity;
import com.kurye.kurye.screen.filter.FilterActivity;
import com.kurye.kurye.task.FilterTask;
import com.kurye.kurye.viewEntity.DelivererVM;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ahmet on 2/18/2018.
 */

public class VMSelectDeliverer extends AndroidViewModel {
    private ObservableArrayList<DelivererVM> deliverers = new ObservableArrayList<>();

    public VMSelectDeliverer(@NonNull Application application) {
        super(application);
        List<DelivererEntity> load = FilterTask.getInstance().load();
        List<DelivererVM> list = new ArrayList<>();
        DelivererVM vm = new DelivererVM(load.get(0).getFirstName() + " " + load.get(0).getLastName(), load.get(0).getRoute());
        list.add(vm);
        deliverers.addAll(list);
    }

    public ObservableArrayList<DelivererVM> getDeliverers() {
        return deliverers;
    }

    public void performAdd(View view) {
        FilterActivity.start(view.getContext());
    }
}
