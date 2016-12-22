
package com.example.wellington.lolguide.model.spell;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

public class Spell {

    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("version")
    @Expose
    public String version;
    @SerializedName("data")
    @Expose
    public HashMap<String,SummonerSpellDto> spellDtoHashMap;

}
