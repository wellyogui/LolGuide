
package com.example.wellington.lolguide.model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Leveltip implements Serializable{

    @SerializedName("label")
    @Expose
    public List<String> label = null;
    @SerializedName("effect")
    @Expose
    public List<String> effect = null;

}
