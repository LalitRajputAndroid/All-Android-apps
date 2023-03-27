package com.example.textermessenger;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerContactsAdapter extends RecyclerView.Adapter<Recycler_viewholder> {

    ArrayList<contacts_Model> list;
    public RecyclerContactsAdapter(ArrayList<contacts_Model> list) {
        this.list = list;

    }

    @NonNull
    @Override
    public Recycler_viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.contacts_singlerow,parent,false);

        return new Recycler_viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Recycler_viewholder holder, int position) {

        holder.image.setImageResource(list.get(position).getImg());
        holder.name.setText(list.get(position).getName());
        holder.msg.setText(list.get(position).getMsg());
        holder.time.setText(list.get(position).getTime());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
