package com.example.wellington.lolguide.repository.contracts;

import com.example.wellington.lolguide.model.champion.Champion;
import com.example.wellington.lolguide.model.champion.ChampionDto;

import java.util.List;

/**
 * Created by wellington on 19/12/16.
 */

public interface ChampionListListener extends BaseListener {

    void onChampionListLoad(List<ChampionDto> championList);

}
