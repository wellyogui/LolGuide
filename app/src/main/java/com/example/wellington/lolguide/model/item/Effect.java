
package com.example.wellington.lolguide.model.item;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Effect {

    @SerializedName("Effect5Amount")
    @Expose
    public String effect5Amount;
    @SerializedName("Effect3Amount")
    @Expose
    public String effect3Amount;
    @SerializedName("Effect1Amount")
    @Expose
    public String effect1Amount;
    @SerializedName("Effect2Amount")
    @Expose
    public String effect2Amount;
    @SerializedName("Effect4Amount")
    @Expose
    public String effect4Amount;

}
