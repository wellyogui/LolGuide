
package com.example.wellington.lolguide.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Image implements Serializable{

    @SerializedName("full")
    @Expose
    public String full;
    @SerializedName("sprite")
    @Expose
    public String sprite;
    @SerializedName("group")
    @Expose
    public String group;
    @SerializedName("x")
    @Expose
    public Integer x;
    @SerializedName("y")
    @Expose
    public Integer y;
    @SerializedName("w")
    @Expose
    public Integer w;
    @SerializedName("h")
    @Expose
    public Integer h;

}
