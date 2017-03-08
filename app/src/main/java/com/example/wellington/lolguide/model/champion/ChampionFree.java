package com.example.wellington.lolguide.model.champion;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by wellington on 07/03/17.
 */

public class ChampionFree {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("active")
    @Expose
    public Boolean active;
    @SerializedName("botEnabled")
    @Expose
    public Boolean botEnabled;
    @SerializedName("freeToPlay")
    @Expose
    public Boolean freeToPlay;
    @SerializedName("botMmEnabled")
    @Expose
    public Boolean botMmEnabled;
    @SerializedName("rankedPlayEnabled")
    @Expose
    public Boolean rankedPlayEnabled;

}
