package com.example.wellington.lolguide.view.ui.details.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wellington.lolguide.R;

import butterknife.ButterKnife;

public class HabilidadesFragment extends Fragment {

    public static final String HABILIDADE = "habilidades";
    public static final String PASSIVA = "passiva";


    private View view;

    public HabilidadesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_habilidades, container, false);
        ButterKnife.bind(this, view);
        return view;


    }
}

