
package com.example.wellington.lolguide.model.item;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stats {

    @SerializedName("FlatPhysicalDamageMod")
    @Expose
    public Integer flatPhysicalDamageMod;
    @SerializedName("FlatSpellBlockMod")
    @Expose
    public Integer flatSpellBlockMod;

}
