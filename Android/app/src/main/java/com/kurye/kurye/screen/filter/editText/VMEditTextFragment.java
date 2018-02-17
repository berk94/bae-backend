package com.kurye.kurye.screen.filter.editText;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.widget.ArrayAdapter;

/**
 * Created by ahmet on 2/17/2018.
 */

public class VMEditTextFragment extends ViewModel {
    private ObservableField<String> text = new ObservableField<>("");
    private ObservableBoolean enabled = new ObservableBoolean();
    private ObservableField<String> hint = new ObservableField<>("");
    private ObservableField<ArrayAdapter<String>> adapter = new ObservableField<>();

    public ObservableField<String> getText() {
        return text;
    }

    public void setText(ObservableField<String> text) {
        this.text = text;
    }

    public ObservableField<String> getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint.set(hint);;
    }

    public ObservableField<ArrayAdapter<String>> getAdapter() {
        return adapter;
    }


    public ObservableBoolean getEnabled() {
        return enabled;
    }
}
