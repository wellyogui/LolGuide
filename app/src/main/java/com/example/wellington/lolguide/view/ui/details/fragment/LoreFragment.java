package com.example.wellington.lolguide.view.ui.details.fragment;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wellington.lolguide.R;
import com.example.wellington.lolguide.model.champion.Champion;
import com.example.wellington.lolguide.model.champion.ChampionDto;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoreFragment extends Fragment {

    private View view;


    public static final String LORE = "lore";


    @Bind(R.id.tvLore)
    TextView tvLore;
    @Bind(R.id.tvLoreTitle)
    TextView tvLoreTittle;

    public LoreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_lore, container, false);
        ButterKnife.bind(this, view);

        Bundle bundle = getArguments();
        if (bundle != null){
            String lore = bundle.getString(LORE);
            getLore(lore);
        }

        Typeface type = Typeface.createFromAsset(getContext().getAssets(), "fonts/FrizQuadrata.ttf");
        tvLore.setTypeface(type);
        tvLoreTittle.setTypeface(type);

        return view;
    }

    public void getLore(String lore){

        tvLore.setText(Html.fromHtml(lore));

    }

}
