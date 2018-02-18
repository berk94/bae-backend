package com.kurye.kurye.screen.selectDeliverer;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kurye.kurye.R;
import com.kurye.kurye.databinding.FragmentSelectDelivererBinding;

/**
 * Created by elifguler on 18.02.2018.
 */

public class SelectDelivererActivityFragment extends Fragment {

    private FragmentSelectDelivererBinding binding;

    public SelectDelivererActivityFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_select_deliverer, container, false);
        VMSelectDeliverer vmSelectDeliverer = ViewModelProviders.of(this).get(VMSelectDeliverer.class);
        binding.setVmSelectDeliverer(vmSelectDeliverer);
        binding.executePendingBindings();
        return binding.getRoot();
    }
}
