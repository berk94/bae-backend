package com.kurye.kurye.screen.filter.editText;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.kurye.kurye.databinding.FragmentEditTextBinding;
import com.kurye.kurye.entity.response.ItemEntity;
import com.kurye.kurye.task.ItemTask;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EditTextFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditTextFragment extends Fragment {
    private static final String ARG_HINT = "arg.hint";

    public EditTextFragment() {
    }

    public static EditTextFragment newInstance(String hint) {
        EditTextFragment fragment = new EditTextFragment();
        Bundle args = new Bundle();
        args.putString(ARG_HINT, hint);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentEditTextBinding binding = FragmentEditTextBinding.inflate(inflater, container, false);
        VMEditTextFragment vmEditTextFragment = ViewModelProviders.of(this).get(VMEditTextFragment.class);

        ItemTask.getInstance().fetch((status, message) -> {
            if (status == ItemTask.SUCCESS) {
                vmEditTextFragment.getEnabled().set(true);
                List<ItemEntity> load = ItemTask.getInstance().load();
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                        android.R.layout.simple_dropdown_item_1line);
                for (ItemEntity itemEntity : load) {
                    adapter.add(itemEntity.getName());
                }

                vmEditTextFragment.getAdapter().set(adapter);
            } else {
                Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
            }
        });
        if (getArguments() != null) {
            String hint = getArguments().getString(ARG_HINT);
            vmEditTextFragment.setHint(hint);
        }
        binding.setVm(vmEditTextFragment);
        binding.executePendingBindings();
        return binding.getRoot();
    }

}
