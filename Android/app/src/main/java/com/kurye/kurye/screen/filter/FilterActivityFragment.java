package com.kurye.kurye.screen.filter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.ui.SupportPlaceAutocompleteFragment;
import com.kurye.kurye.R;
import com.kurye.kurye.screen.filter.dateRange.DateRangeFragment;
import com.kurye.kurye.screen.filter.editText.EditTextFragment;

import java.util.ArrayList;

import me.drozdzynski.library.steppers.SteppersItem;
import me.drozdzynski.library.steppers.SteppersView;

/**
 * A placeholder fragment containing a simple view.
 */
public class FilterActivityFragment extends Fragment {

    private SteppersView steppersView;

    public FilterActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_filter, container, false);

        steppersView = v.findViewById(R.id.steppersView);
        steppersView.setConfig(getConfig());
        steppersView.setItems(getStepperItems());
        steppersView.build();

        return v;
    }

    @NonNull
    private ArrayList<SteppersItem> getStepperItems() {
        ArrayList<SteppersItem> steps = new ArrayList<>();

        SteppersItem stepFirst = new SteppersItem();
        stepFirst.setLabel(getString(R.string.select_item_label));
        stepFirst.setSubLabel(getString(R.string.select_item_description));

        stepFirst.setFragment(EditTextFragment.newInstance(getString(R.string.select_item_question)));
        stepFirst.setPositiveButtonEnable(true);
        steps.add(stepFirst);

        SteppersItem stepSecond = new SteppersItem();
        stepSecond.setLabel(getString(R.string.select_from_city_label));
        stepSecond.setSubLabel(getString(R.string.select_city_description));

        SupportPlaceAutocompleteFragment fragmentFrom = new SupportPlaceAutocompleteFragment();
        AutocompleteFilter typeFilterFrom = new AutocompleteFilter.Builder().setTypeFilter(AutocompleteFilter.TYPE_FILTER_CITIES).build();
        fragmentFrom.setFilter(typeFilterFrom);
        stepSecond.setFragment(fragmentFrom);
        stepSecond.setPositiveButtonEnable(true);
        steps.add(stepSecond);

        SteppersItem stepThird = new SteppersItem();
        stepThird.setLabel(getString(R.string.select_to_city_label));
        stepThird.setSubLabel(getString(R.string.select_city_description));

        SupportPlaceAutocompleteFragment fragmentTo = new SupportPlaceAutocompleteFragment();
        AutocompleteFilter typeFilterTo = new AutocompleteFilter.Builder().setTypeFilter(AutocompleteFilter.TYPE_FILTER_CITIES).build();
        fragmentTo.setFilter(typeFilterTo);
        stepThird.setFragment(fragmentTo);
        stepThird.setPositiveButtonEnable(true);
        steps.add(stepThird);

        SteppersItem stepFourth = new SteppersItem();
        stepFourth.setLabel(getString(R.string.select_time_label));
        stepFourth.setSubLabel(getString(R.string.select_time_description));
        stepFourth.setFragment(DateRangeFragment.newInstance());
        stepFourth.setPositiveButtonEnable(true);

        steps.add(stepFourth);
        return steps;
    }

    private int stepPosition = 0;

    @NonNull
    private SteppersView.Config getConfig() {
        SteppersView.Config steppersViewConfig = new SteppersView.Config();
        steppersViewConfig.setOnFinishAction(() -> {
            // Action on last step Finish button
        });

        steppersViewConfig.setOnCancelAction(() -> {
            // Action when click cancel on one of steps
            getActivity().finish();
        });

        steppersViewConfig.setOnChangeStepAction((position, activeStep) -> {
            // Action when click continue on each step
        });

        // Setup Support Fragment Manager for fragments in steps
        steppersViewConfig.setFragmentManager(getChildFragmentManager());
        return steppersViewConfig;
    }
}
