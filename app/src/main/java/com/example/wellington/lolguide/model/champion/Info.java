
package com.example.wellington.lolguide.model.champion;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Info implements Serializable{

    @SerializedName("attack")
    @Expose
    public Integer attack;
    @SerializedName("defense")
    @Expose
    public Integer defense;
    @SerializedName("magic")
    @Expose
    public Integer magic;
    @SerializedName("difficulty")
    @Expose
    public Integer difficulty;

}
