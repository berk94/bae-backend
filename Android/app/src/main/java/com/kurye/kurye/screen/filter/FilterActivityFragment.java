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

    public FilterActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_filter, container, false);

        SteppersView steppersView = v.findViewById(R.id.steppersView);
        steppersView.setConfig(getConfig());
        steppersView.setItems(getStepperItems());
        steppersView.build();

        return v;
    }

    @NonNull
    private ArrayList<SteppersItem> getStepperItems() {
        ArrayList<SteppersItem> steps = new ArrayList<>();

        SteppersItem stepFirst = new SteppersItem();
        stepFirst.setLabel("Ne");
        stepFirst.setSubLabel("telefon, bilgisayar...");

        stepFirst.setFragment(EditTextFragment.newInstance("Ne Almak İstiyorsunuz?"));
        stepFirst.setPositiveButtonEnable(true);
        steps.add(stepFirst);

        SteppersItem stepSecond = new SteppersItem();
        stepSecond.setLabel("Nereden");
        stepSecond.setSubLabel("New York, Tokio...");
        SupportPlaceAutocompleteFragment fragment = new SupportPlaceAutocompleteFragment();
        AutocompleteFilter typeFilter = new AutocompleteFilter.Builder().setTypeFilter(AutocompleteFilter.TYPE_FILTER_CITIES).build();
        fragment.setFilter(typeFilter);
        stepSecond.setFragment(fragment);
        stepSecond.setPositiveButtonEnable(true);

        steps.add(stepSecond);

        SteppersItem stepThird = new SteppersItem();
        stepThird.setLabel("Ne Zaman");
        stepThird.setSubLabel("Bugün, yarın...");
        stepThird.setFragment(DateRangeFragment.newInstance());
        stepThird.setPositiveButtonEnable(true);

        steps.add(stepThird);
        return steps;
    }

    @NonNull
    private SteppersView.Config getConfig() {
        SteppersView.Config steppersViewConfig = new SteppersView.Config();
        steppersViewConfig.setOnFinishAction(() -> {
            // Action on last step Finish button
        });

        steppersViewConfig.setOnCancelAction(() -> {
            // Action when click cancel on one of steps
        });

        steppersViewConfig.setOnChangeStepAction((position, activeStep) -> {
            // Action when click continue on each step
        });

        // Setup Support Fragment Manager for fragments in steps
        steppersViewConfig.setFragmentManager(getChildFragmentManager());
        return steppersViewConfig;
    }
}
