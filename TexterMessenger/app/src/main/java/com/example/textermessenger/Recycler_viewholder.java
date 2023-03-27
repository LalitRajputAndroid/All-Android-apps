package com.example.textermessenger;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;

public class Recycler_viewholder extends RecyclerView.ViewHolder {

    ImageView image;
    MaterialTextView name,msg,time;
    public Recycler_viewholder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.image_id);
        name = itemView.findViewById(R.id.nametext_id);
        msg = itemView.findViewById(R.id.msgtext_id);
        time = itemView.findViewById(R.id.timetext_id);
    }
}
