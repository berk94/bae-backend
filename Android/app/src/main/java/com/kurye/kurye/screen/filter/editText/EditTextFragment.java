package com.kurye.kurye.screen.filter.editText;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kurye.kurye.databinding.FragmentEditTextBinding;

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

        if (getArguments() != null) {
            String hint = getArguments().getString(ARG_HINT);
            vmEditTextFragment.setHint(hint);
        }
        binding.setVm(vmEditTextFragment);
        binding.executePendingBindings();
        return binding.getRoot();
    }

}
