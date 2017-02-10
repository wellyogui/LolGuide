
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
    @SerializedName("tooltip")
    @Expose
    public String tooltip;
    @SerializedName("image")
    @Expose
    public Image image;
    @SerializedName("costBurn")
    @Expose
    public String costBurn;
    @SerializedName("cooldownBurn")
    @Expose
    public String cooldownBurn;
    @SerializedName("rangeBurn")
    @Expose
    public String rangeBurn;

}
