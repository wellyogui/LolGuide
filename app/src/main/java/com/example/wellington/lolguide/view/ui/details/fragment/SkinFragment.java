package com.example.wellington.lolguide.view.ui.details.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wellington.lolguide.R;
import com.example.wellington.lolguide.model.champion.Champion;
import com.example.wellington.lolguide.model.champion.ChampionDto;
import com.example.wellington.lolguide.model.champion.Skin;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class SkinFragment extends Fragment {

    public static final String SKIN = "skins";

    private Context mContext;

    private View view;

    public SkinFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_skin, container, false);
        ButterKnife.bind(this, view);
        return view;

    }

    public void getSkins(Skin skin){


    }

}
