package com.kurye.kurye.screen.show.cards;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kurye.kurye.R;
import com.kurye.kurye.viewEntity.OrderVM;

public class SliderAdapter extends RecyclerView.Adapter<SliderCard> {
    private OrderVM[] content;

    public SliderAdapter(OrderVM[] content) {
        this.content = content;
    }

    @Override
    public SliderCard onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.layout_slider_card, parent, false);

        return new SliderCard(view);
    }

    @Override
    public void onBindViewHolder(SliderCard holder, int position) {
        holder.setContent(content[position].getPicture().get());
    }

    @Override
    public int getItemCount() {
        return content.length;
    }

}
