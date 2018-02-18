package com.kurye.kurye.viewEntity;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;
import android.graphics.drawable.Drawable;

/**
 * Created by ahmet on 2/18/2018
 */

public class OrderVM extends ViewModel {
    private ObservableField<String> place = new ObservableField<>();
    private ObservableField<String> time = new ObservableField<>();
    private ObservableField<String> country = new ObservableField<>();
    private ObservableField<String> description = new ObservableField<>();
    private ObservableField<Drawable> picture = new ObservableField<>();

    public OrderVM(String place, String time, String country, String description, Drawable picture) {
        this.place.set(place);
        this.time.set(time);
        this.country.set(country);
        this.description.set(description);
        this.picture.set(picture);
    }

    public ObservableField<String> getPlace() {
        return place;
    }

    public ObservableField<String> getTime() {
        return time;
    }

    public ObservableField<String> getCountry() {
        return country;
    }

    public ObservableField<String> getDescription() {
        return description;
    }

    public ObservableField<Drawable> getPicture() {
        return picture;
    }
}
