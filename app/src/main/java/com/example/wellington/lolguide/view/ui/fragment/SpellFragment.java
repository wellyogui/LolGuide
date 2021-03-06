package com.example.wellington.lolguide.view.ui.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wellington.lolguide.R;

import butterknife.ButterKnife;


public class SpellFragment extends Fragment {

    public static final String SPELL = "spell";


    public SpellFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_spell, container, false);

        ButterKnife.bind(this, view);

        return view;
    }


}
