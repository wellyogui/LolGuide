
package com.example.wellington.lolguide.model.champion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.wellington.lolguide.model.Image;
import com.example.wellington.lolguide.model.spell.SummonerSpellDto;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Champion {

    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("version")
    @Expose
    public String version;
    @SerializedName("data")
    @Expose
    public HashMap<String,ChampionDto> championDtoHashMap;
}
