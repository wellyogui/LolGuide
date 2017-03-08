package com.example.wellington.lolguide.view.ui.details.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.wellington.lolguide.R;
import com.example.wellington.lolguide.model.champion.Champion;
import com.example.wellington.lolguide.model.champion.ChampionDto;
import com.example.wellington.lolguide.model.champion.Skin;
import com.example.wellington.lolguide.utils.AppConfigs;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class SkinFragment extends Fragment {

    public static final String SKIN = "skins";

    private Context mContext;

    private View view;
    private Skin mSkin;

    @Bind(R.id.ivSkin1)
    ImageView ivSkin1;

    public SkinFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_skin, container, false);
        ButterKnife.bind(this, view);

        Bundle bundle = getArguments();
        if (bundle != null){
//            mSkin = (Skin) bundle.getSerializable(SKIN);
//            getSkins(mSkin);
        }

        return view;

    }

    public void getSkins(Skin skin){

        Picasso.with(getActivity()).load(String.format(AppConfigs.skinsImage, "Aatrox", skin.num)).into(ivSkin1);


    }

}
