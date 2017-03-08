package com.example.wellington.lolguide.presenter;

import com.example.wellington.lolguide.model.ChampionEnum;
import com.example.wellington.lolguide.model.champion.Champion;
import com.example.wellington.lolguide.model.champion.ChampionDto;
import com.example.wellington.lolguide.model.champion.ChampionFree;
import com.example.wellington.lolguide.model.champion.ChampionFreeList;
import com.example.wellington.lolguide.repository.CLolApi;
import com.example.wellington.lolguide.repository.contracts.ChampFreeListListener;
import com.example.wellington.lolguide.repository.contracts.ChampionDetailListener;
import com.example.wellington.lolguide.repository.contracts.ChampionListListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
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

    public void loadChampionDetails(String region, String id, final String champData, String key, final ChampionDetailListener listener) {
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

    public void loadChampionFree(String region, String key, final ChampFreeListListener listener) {
        listener.onRequestStarted();

        lolApi.getmLolApi()
                .getFreeRotation(region, "true", key)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ChampionFreeList>() {
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
                    public void onNext(ChampionFreeList champion) {
                        listener.onChampionFreeLoad(champion);
                    }
                });
    }

    public List<ChampionDto> filterTag(List<ChampionDto> championList, ChampionEnum championEnum) {

        List<ChampionDto> filterChamp = new ArrayList<>();


        if (championList != null && championList.size() > 0) {
            for (ChampionDto champions : championList) {

                if (champions.tags != null && champions.tags.size() > 0) {

                    for (String tag : champions.tags) {

                        if (tag.toLowerCase().equals(championEnum.toString().toLowerCase())) {
                            filterChamp.add(champions);
                            break;
                        }
                    }
                }
            }
        }

        return filterChamp;

    }

    public List<ChampionDto> findFreeChampions(List<ChampionDto> championDtoList, List<ChampionFree> championFreeList) {
        List<ChampionDto> filterChamp = new ArrayList<>();

        for (ChampionFree championFree : championFreeList) {
            for (ChampionDto championDto : championDtoList) {
                if (Objects.equals(championDto.id, championFree.id)) {

                    filterChamp.add(championDto);
                    break;

                }
            }
        }

        return filterChamp;
    }


    public List<ChampionDto> filterName(List<ChampionDto> championDtos, String nameChampion) {

        List<ChampionDto> filterName = new ArrayList<>();

        if (championDtos != null && championDtos.size() > 0) {
            for (ChampionDto champions : championDtos) {
                if (champions.name != null && champions.name.length() > 0) {
                    if (champions.name.toLowerCase().contains(nameChampion.toLowerCase())) {
                        filterName.add(champions);

                    }
                }

            }
        }

        return filterName;

    }

}
