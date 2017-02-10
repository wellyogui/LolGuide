
package com.example.wellington.lolguide.model.champion;

import com.example.wellington.lolguide.model.Image;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Passive implements Serializable{

    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("description")
    @Expose
    public String description;

    @SerializedName("image")
    @Expose
    public Image image;

}
