package com.kurye.kurye.screen.show.cards;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.kurye.kurye.R;


public class SliderCard extends RecyclerView.ViewHolder {

    private final ImageView imageView;

    public SliderCard(View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.image);
    }

    void setContent(Drawable drawable) {
        imageView.setImageDrawable(drawable);
    }

}