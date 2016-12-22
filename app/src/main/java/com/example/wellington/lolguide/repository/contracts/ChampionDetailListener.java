package com.example.wellington.lolguide.repository.contracts;

import com.example.wellington.lolguide.model.champion.ChampionDto;

/**
 * Created by wellington on 20/12/16.
 */

public interface ChampionDetailListener extends BaseListener {

    void onChampionDetail (ChampionDto championDto);

}
