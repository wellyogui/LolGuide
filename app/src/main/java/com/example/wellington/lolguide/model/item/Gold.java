
package com.example.wellington.lolguide.model.item;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Gold {

    @SerializedName("base")
    @Expose
    public Integer base;
    @SerializedName("total")
    @Expose
    public Integer total;
    @SerializedName("sell")
    @Expose
    public Integer sell;
    @SerializedName("purchasable")
    @Expose
    public Boolean purchasable;

}
