
package com.example.wellington.lolguide.model.champion;

import java.io.Serializable;
import java.util.List;

import com.example.wellington.lolguide.model.Image;
import com.example.wellington.lolguide.model.Leveltip;
import com.example.wellington.lolguide.model.Var;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Spell implements Serializable{

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
    @SerializedName("leveltip")
    @Expose
    public Leveltip leveltip;
    @SerializedName("image")
    @Expose
    public Image image;
    @SerializedName("resource")
    @Expose
    public String resource;
    @SerializedName("maxrank")
    @Expose
    public Double maxrank;
    @SerializedName("cost")
    @Expose
    public List<Double> cost = null;
    @SerializedName("costType")
    @Expose
    public String costType;
    @SerializedName("costBurn")
    @Expose
    public String costBurn;
    @SerializedName("cooldown")
    @Expose
    public List<Double> cooldown = null;
    @SerializedName("cooldownBurn")
    @Expose
    public String cooldownBurn;
    @SerializedName("effect")
    @Expose
    public List<Object> effect = null;
    @SerializedName("effectBurn")
    @Expose
    public List<String> effectBurn = null;
    @SerializedName("vars")
    @Expose
    public List<Var> vars = null;
    @SerializedName("range")
    @Expose
    public List<Double> range = null;
    @SerializedName("rangeBurn")
    @Expose
    public String rangeBurn;
    @SerializedName("key")
    @Expose
    public String key;

}
