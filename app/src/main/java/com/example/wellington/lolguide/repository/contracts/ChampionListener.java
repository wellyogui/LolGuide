package com.example.wellington.lolguide.repository.contracts;

import com.example.wellington.lolguide.model.champion.Champion;

/**
 * Created by wellington on 19/12/16.
 */

public interface ChampionListener extends BaseListener{

    void onLoadDetails(Champion champion);


}


