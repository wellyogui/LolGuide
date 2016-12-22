
package com.example.wellington.lolguide.model.spell;

import java.util.List;

import com.example.wellington.lolguide.model.Image;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SummonerSpellDto {

    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("sanitizedDescription")
    @Expose
    public String sanitizedDescription;
    @SerializedName("tooltip")
    @Expose
    public String tooltip;
    @SerializedName("sanitizedTooltip")
    @Expose
    public String sanitizedTooltip;
    @SerializedName("image")
    @Expose
    public Image image;
    @SerializedName("resource")
    @Expose
    public String resource;
    @SerializedName("maxrank")
    @Expose
    public Integer maxrank;
    @SerializedName("cost")
    @Expose
    public List<Integer> cost = null;
    @SerializedName("costType")
    @Expose
    public String costType;
    @SerializedName("costBurn")
    @Expose
    public String costBurn;
    @SerializedName("cooldown")
    @Expose
    public List<Integer> cooldown = null;
    @SerializedName("cooldownBurn")
    @Expose
    public String cooldownBurn;
    @SerializedName("effect")
    @Expose
    public List<Object> effect = null;
    @SerializedName("effectBurn")
    @Expose
    public List<String> effectBurn = null;
    @SerializedName("range")
    @Expose
    public List<Integer> range = null;
    @SerializedName("rangeBurn")
    @Expose
    public String rangeBurn;
    @SerializedName("summonerLevel")
    @Expose
    public Integer summonerLevel;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("key")
    @Expose
    public String key;
    @SerializedName("modes")
    @Expose
    public List<String> modes = null;

}
