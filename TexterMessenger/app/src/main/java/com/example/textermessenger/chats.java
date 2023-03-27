package com.example.textermessenger;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class chats extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    RecyclerView recyclerView;

    public chats() {

    }

    public static chats newInstance(String param1, String param2) {
        chats fragment = new chats();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chats, container, false);
        recyclerView = view.findViewById(R.id.recyclerview_id);

        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        ArrayList<contacts_Model> list = new ArrayList<>();

        list.add(new contacts_Model(R.drawable.a,"Henry Enricks","I am doing good.Get well soon","10:31 Am"));
        list.add(new contacts_Model(R.drawable.b,"Kevin Gloster","How are you","06:47 Am"));
        list.add(new contacts_Model(R.drawable.c,"Sundar Pichai","Hello","Today"));
        list.add(new contacts_Model(R.drawable.d,"Nora","Whats your name?","01:21 Am"));
        list.add(new contacts_Model(R.drawable.e,"Charistopher","l`ve planned for a dinner","Yesterday"));
        list.add(new contacts_Model(R.drawable.f,"Henry Enricks","I am doing good.Get well soon","10:31 Am"));
        list.add(new contacts_Model(R.drawable.g,"Henry Enricks","I am doing good.Get well soon","10:31 Am"));
        list.add(new contacts_Model(R.drawable.h,"Henry Enricks","I am doing good.Get well soon","10:31 Am"));
        list.add(new contacts_Model(R.drawable.i,"Henry Enricks","I am doing good.Get well soon","10:31 Am"));
        list.add(new contacts_Model(R.drawable.j,"Henry Enricks","I am doing good.Get well soon","10:31 Am"));
        list.add(new contacts_Model(R.drawable.k,"Henry Enricks","I am doing good.Get well soon","10:31 Am"));
        list.add(new contacts_Model(R.drawable.l,"Henry Enricks","I am doing good.Get well soon","10:31 Am"));

        RecyclerContactsAdapter adapter = new RecyclerContactsAdapter(list);
        recyclerView.setAdapter(adapter);

        return view;
    }
}