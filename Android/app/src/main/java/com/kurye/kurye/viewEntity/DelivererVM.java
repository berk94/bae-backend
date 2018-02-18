package com.kurye.kurye.viewEntity;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;

import com.kurye.kurye.entity.response.RouteEntity;

import java.util.List;

/**
 * Created by ahmet on 2/18/2018
 */

public class DelivererVM extends ViewModel {
    private ObservableField<String> name = new ObservableField<>();
    private ObservableArrayList<RouteEntity> routes = new ObservableArrayList<>();

    public DelivererVM(String name, List<RouteEntity> routes) {
        this.name.set(name);
        this.routes.addAll(routes);
    }

    public ObservableField<String> getName() {
        return name;
    }

    public ObservableArrayList<RouteEntity> getRoutes() {
        return routes;
    }
}
