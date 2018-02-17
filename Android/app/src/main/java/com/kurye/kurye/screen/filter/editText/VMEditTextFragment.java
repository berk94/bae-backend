package com.kurye.kurye.screen.filter.editText;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;

/**
 * Created by ahmet on 2/17/2018.
 */

public class VMEditTextFragment extends ViewModel {
    private ObservableField<String> text = new ObservableField<>("");
    private ObservableField<String> hint = new ObservableField<>("");

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
}
