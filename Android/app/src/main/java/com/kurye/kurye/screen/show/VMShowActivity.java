package com.kurye.kurye.screen.show;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableInt;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.kurye.kurye.R;
import com.kurye.kurye.screen.filter.FilterActivity;
import com.kurye.kurye.viewEntity.OrderVM;
import com.ramotion.cardslider.CardSliderLayoutManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ahmet on 2/18/2018.
 */

public class VMShowActivity extends AndroidViewModel {
    private RecyclerView.OnScrollListener scrollListener;
    private ObservableArrayList<OrderVM> orders = new ObservableArrayList<>();
    private ObservableInt position = new ObservableInt();
    public VMShowActivity(@NonNull Application application) {
        super(application);
        scrollListener = new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    position.set(
                            ((CardSliderLayoutManager) recyclerView.getLayoutManager())
                                    .getActiveCardPosition());
                }
            }
        };
        List<OrderVM> list = new ArrayList<>();
        list.add(new OrderVM("The Louvre", "Aug 1 - Dec 15    7:00-18:00", "PARIS",
                application.getString(R.string.text1), R.drawable.p1));
        list.add(new OrderVM("Gwanghwamun", "Aug 1 - Dec 15    7:00-18:00", "SEOUL",
                application.getString(R.string.text2), R.drawable.p2));
        list.add(new OrderVM("Tower Bridge", "Sep 5 - Nov 10    8:00-16:00", "LONDON",
                application.getString(R.string.text3), R.drawable.p3));
        list.add(new OrderVM("Temple of Heaven", "Mar 8 - May 21    7:00-18:00", "BEIJING",
                application.getString(R.string.text4), R.drawable.p4));
        list.add(new OrderVM("Aegeana Sea", "Mar 10 - May 21    7:00-18:00", "THIRA",
                application.getString(R.string.text5), R.drawable.p5));
        orders.addAll(list);
    }

    public ObservableArrayList<OrderVM> getOrders() {
        return orders;
    }

    public void performAdd(View view) {
        FilterActivity.start(view.getContext());
    }

    public RecyclerView.OnScrollListener getScrollListener() {
        return scrollListener;
    }

    public ObservableInt getPosition() {
        return position;
    }
}
