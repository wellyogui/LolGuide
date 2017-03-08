package com.example.wellington.lolguide.model.champion;

import com.example.wellington.lolguide.repository.contracts.BaseListener;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by wellington on 07/03/17.
 */

public class ChampionFreeList {

    @SerializedName("champions")
    @Expose
    public List<ChampionFree> champions = null;
}
