package com.example.wellington.lolguide.view.ui.details.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wellington.lolguide.R;
import com.example.wellington.lolguide.model.champion.Skin;
import com.example.wellington.lolguide.view.adapter.SkinAdapter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class SkinFragment extends Fragment {

    public static final String SKIN = "skins";
    public static final String NAMECHAMP = "nameChamp";

    private View view;
    private List<Skin> mSkin;
    private SkinAdapter skinAdapter;
    private String mChampName;


    @Bind(R.id.rlSkin)
    RecyclerView rlSkin;

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
        if (bundle != null) {
            mSkin = (List<Skin>) bundle.getSerializable(SKIN);
            mChampName = bundle.getString(NAMECHAMP);
            getSkins(mSkin);
        }

        return view;

    }

    public void getSkins(List<Skin> skin) {

        LinearLayoutManager llManager = new LinearLayoutManager(getActivity());

        rlSkin.setLayoutManager(llManager);

        skinAdapter = new SkinAdapter(getActivity(), skin, mChampName, new SkinAdapter.OnObjectClickListener() {
            @Override
            public void OnObjectClickListener(Skin skin, String url) {
                Intent intent = new Intent(getActivity(), SkinSaver.class);
                Bundle bundle = new Bundle();
                bundle.putString(SkinSaver.SAVESKIN, url);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        rlSkin.setAdapter(skinAdapter);

    }


}
