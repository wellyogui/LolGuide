package com.example.wellington.lolguide.presenter;

import com.example.wellington.lolguide.model.ObjectAdapter;
import com.example.wellington.lolguide.model.champion.Champion;
import com.example.wellington.lolguide.model.champion.ChampionDto;
import com.example.wellington.lolguide.model.spell.Spell;
import com.example.wellington.lolguide.model.spell.SummonerSpellDto;
import com.example.wellington.lolguide.repository.CLolApi;
import com.example.wellington.lolguide.repository.contracts.ChampionDetailListener;
import com.example.wellington.lolguide.repository.contracts.ChampionListListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.internal.util.ObserverSubscriber;
import rx.schedulers.Schedulers;

/**
 * Created by wellington on 19/12/16.
 */

public class ChampionPresenter {

    private CLolApi lolApi;

    public ChampionPresenter() {
        lolApi = new CLolApi();
    }

    public void loadChampionList(String region, final String champData, String key, final ChampionListListener listener) {
        listener.onRequestStarted();

        lolApi.getmLolApi()
                .getChampionList(region, champData, key)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Champion>() {
                    @Override
                    public void onCompleted() {
                        listener.onRequestFinished();
                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.onRequestFinished();
                        listener.onError(e);
                    }

                    @Override
                    public void onNext(Champion champion) {
                        List<ChampionDto> championDtoList = new ArrayList<>();

                        for (Map.Entry<String, ChampionDto> championDtoEntry : champion.championDtoHashMap.entrySet()) {
                            ChampionDto championDto = championDtoEntry.getValue();
                            championDtoList.add(championDto);
                        }

                        listener.onChampionListLoad(championDtoList);
                    }
                });
    }

    public void loadChampionDetails(String region, String id,final String champData, String key, final ChampionDetailListener listener) {
        listener.onRequestStarted();

        lolApi.getmLolApi().getChampion(region, id, champData, key)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ChampionDto>() {
                    @Override
                    public void onCompleted() {
                        listener.onRequestFinished();
                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.onRequestFinished();
                        listener.onError(e);
                    }

                    @Override
                    public void onNext(ChampionDto championDto) {
                        listener.onChampionDetail(championDto);
                    }
                });
    }
}
