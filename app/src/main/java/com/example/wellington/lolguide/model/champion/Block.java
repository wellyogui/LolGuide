
package com.example.wellington.lolguide.model.champion;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Block {

    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("recMath")
    @Expose
    public Boolean recMath;
    @SerializedName("items")
    @Expose
    public List<Item> items = null;

}
