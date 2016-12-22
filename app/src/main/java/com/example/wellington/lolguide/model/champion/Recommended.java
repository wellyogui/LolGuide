
package com.example.wellington.lolguide.model.champion;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Recommended {

    @SerializedName("champion")
    @Expose
    public String champion;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("map")
    @Expose
    public String map;
    @SerializedName("mode")
    @Expose
    public String mode;
    @SerializedName("blocks")
    @Expose
    public List<Block> blocks = null;

}
