
package com.example.wellington.lolguide.model;
import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Var implements Serializable{

    @SerializedName("key")
    @Expose
    public String key;
    @SerializedName("link")
    @Expose
    public String link;
    @SerializedName("coeff")
    @Expose
    public List<Double> coeff = null;

}
