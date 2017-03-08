package com.example.wellington.lolguide.repository.contracts;

import com.example.wellington.lolguide.model.champion.ChampionFreeList;

/**
 * Created by wellington on 07/03/17.
 */

public interface ChampFreeListListener extends BaseListener{

    void onChampionFreeLoad(ChampionFreeList championFreeList);



}
