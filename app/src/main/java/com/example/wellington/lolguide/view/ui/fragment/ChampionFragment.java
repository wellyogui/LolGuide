package com.example.wellington.lolguide.view.ui.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.wellington.lolguide.R;
import com.example.wellington.lolguide.model.ObjectAdapter;
import com.example.wellington.lolguide.model.champion.Champion;
import com.example.wellington.lolguide.model.champion.ChampionDto;
import com.example.wellington.lolguide.presenter.ChampionPresenter;
import com.example.wellington.lolguide.repository.contracts.ChampionListListener;
import com.example.wellington.lolguide.utils.AppConfigs;
import com.example.wellington.lolguide.view.adapter.MainAdapter;
import com.example.wellington.lolguide.view.ui.MainActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class ChampionFragment extends Fragment {

    public static final String CHAMPION = "champion";

    private MainAdapter mainAdapter;
    private ChampionPresenter championPresenter;
    private GridLayoutManager mLayoutManager;
    private List<ObjectAdapter> list = new ArrayList<>();

    public boolean isFirstLoad = true;
    private int mNextOffset = 0;

    private String region = "br";


    @Bind(R.id.rvChampion)
    RecyclerView rvChampion;

    public ChampionFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_champion, container, false);
        ButterKnife.bind(this, view);
        championPresenter = new ChampionPresenter();
        mLayoutManager = new GridLayoutManager(getActivity(), 4);
        rvChampion.setLayoutManager(mLayoutManager);



        getList();

        return view;

    }

    private void getList() {
        championPresenter.loadChampionList(region, "image,info", AppConfigs.api_key, new ChampionListListener() {
            @Override
            public void onChampionListLoad(List<ChampionDto> championList) {

                displayChampionList(ObjectAdapter.convertChampionToObject(championList));


            }

            @Override
            public void onRequestStarted() {

            }

            @Override
            public void onRequestFinished() {

            }

            @Override
            public void onError(Throwable error) {

            }
        });
    }

    public void displayChampionList(List<ObjectAdapter> championList) {
        list = championList;

        mainAdapter = new MainAdapter(getActivity(), list, new MainAdapter.OnObjectClickListener() {
            @Override
            public void OnObjectClickListener(ObjectAdapter objectAdapter) {
                Toast.makeText(getActivity(), "Object Adapter" + objectAdapter.Id, Toast.LENGTH_SHORT).show();

                ((MainActivity) getActivity()).callDetails(objectAdapter.Id);
            }
        });

        rvChampion.setAdapter(mainAdapter);
        mainAdapter.notifyDataSetChanged();

    }

}
