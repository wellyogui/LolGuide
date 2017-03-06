package com.example.wellington.lolguide.view.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.wellington.lolguide.R;
import com.example.wellington.lolguide.model.ChampionEnum;
import com.example.wellington.lolguide.model.ObjectAdapter;
import com.example.wellington.lolguide.model.champion.ChampionDto;
import com.example.wellington.lolguide.presenter.ChampionPresenter;
import com.example.wellington.lolguide.repository.contracts.ChampionListListener;
import com.example.wellington.lolguide.utils.AppConfigs;
import com.example.wellington.lolguide.view.adapter.MainAdapter;
import com.example.wellington.lolguide.view.ui.MainActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class ChampionFragment extends Fragment {

    public static final String CHAMPION = "champion";

    //region [Private Members]
    private MainAdapter mainAdapter;
    private ChampionPresenter championPresenter;
    private GridLayoutManager mLayoutManager;
    private List<ObjectAdapter> list = new ArrayList<>();
    private List<ChampionDto> champList = new ArrayList<>();
    private List<ChampionDto> filterChamp = new ArrayList<>();
    private List<ChampionDto> filterName = new ArrayList<>();

    private String region = "br";
    //endregion

    @Bind(R.id.rvChampion)
    RecyclerView rvChampion;
    @Bind(R.id.ivLogo)
    ImageView ivLogo;


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
        championPresenter.loadChampionList(region, "image,info,tags", AppConfigs.api_key, new ChampionListListener() {
            @Override
            public void onChampionListLoad(List<ChampionDto> championList) {

                displayChampionList(ObjectAdapter.convertChampionToObject(championList));
                champList = championList;

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

    public void closeLogo() {
        ivLogo.setVisibility(View.GONE);
    }

    public void displayChampionList(List<ObjectAdapter> championList) {
        list = championList;
        sort();
        mainAdapter = new MainAdapter(getActivity(), list, new MainAdapter.OnObjectClickListener() {
            @Override
            public void OnObjectClickListener(ObjectAdapter objectAdapter,ImageView ivBorder,ImageView ivPortrait) {
                Toast.makeText(getActivity(), "Object Adapter" + objectAdapter.Id, Toast.LENGTH_SHORT).show();

                Pair<View, String> pair1 = Pair.create((View) ivBorder, ivBorder.getTransitionName());
                Pair<View, String> pair2 = Pair.create((View) ivPortrait, ivPortrait.getTransitionName());

                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(), pair1, pair2);


                ((MainActivity) getActivity()).callDetails(objectAdapter.Id, optionsCompat);
            }
        });

        rvChampion.setAdapter(mainAdapter);


        mainAdapter.notifyDataSetChanged();

    }

    public void resetChampionList(){

        List<ObjectAdapter> champFilter = ObjectAdapter.convertChampionToObject(champList);

        displayChampionList(champFilter);
    }

    public void sort() {
        Collections.sort(list, new Comparator<ObjectAdapter>() {
            @Override
            public int compare(ObjectAdapter o1, ObjectAdapter o2) {
                return o1.Name.compareToIgnoreCase(o2.Name);
            }
        });
    }

    public void reverse() {
        Collections.reverse(list);

        mainAdapter.notifyDataSetChanged();

    }

    public void filterChamp(ChampionEnum championEnum) {

        filterChamp = championPresenter.filterTag(champList, championEnum);

        List<ObjectAdapter> champFilter = ObjectAdapter.convertChampionToObject(filterChamp);

        displayChampionList(champFilter);

    }

    public void filterName(String champName) {

        filterName = championPresenter.filterName(filterChamp != null && filterChamp.size() > 0 ?
                filterChamp : champList, champName);

        List<ObjectAdapter> champFilter = ObjectAdapter.convertChampionToObject(filterName);

        displayChampionList(champFilter);

    }

    public void cleanChampFilter(){

        filterChamp.clear();

    }

    public void nonFilter() {
        List<ObjectAdapter> champFilter = ObjectAdapter.convertChampionToObject(champList);

        displayChampionList(champFilter);
    }


}
