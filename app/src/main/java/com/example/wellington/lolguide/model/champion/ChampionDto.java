package com.example.wellington.lolguide.model.champion;

import com.example.wellington.lolguide.model.Image;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wellington on 20/12/16.
 */

public class ChampionDto {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("image")
    @Expose
    public Image image;
    @SerializedName("skins")
    @Expose
    public List<Skin> skins;
    @SerializedName("lore")
    @Expose
    public String lore;
    @SerializedName("allytips")
    @Expose
    public List<String> allytips;
    @SerializedName("enemytips")
    @Expose
    public List<String> enemytips;
    @SerializedName("tags")
    @Expose
    public List<String> tags;
    @SerializedName("info")
    @Expose
    public Info info;
    @SerializedName("stats")
    @Expose
    public Stats stats;
    @SerializedName("spells")
    @Expose
    public List<Spell> spells;
    @SerializedName("passive")
    @Expose
    public Passive passive;


}
