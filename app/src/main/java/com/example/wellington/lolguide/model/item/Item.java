
package com.example.wellington.lolguide.model.item;


import java.util.List;

import com.example.wellington.lolguide.model.Image;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("sanitizedDescription")
    @Expose
    public String sanitizedDescription;
    @SerializedName("colloq")
    @Expose
    public String colloq;
    @SerializedName("plaintext")
    @Expose
    public String plaintext;
    @SerializedName("stacks")
    @Expose
    public Integer stacks;
    @SerializedName("depth")
    @Expose
    public Integer depth;
    @SerializedName("from")
    @Expose
    public List<String> from = null;
    @SerializedName("tags")
    @Expose
    public List<String> tags = null;
    @SerializedName("maps")
    @Expose
    public Maps maps;
    @SerializedName("image")
    @Expose
    public Image image;
    @SerializedName("stats")
    @Expose
    public Stats stats;
    @SerializedName("gold")
    @Expose
    public Gold gold;
    @SerializedName("effect")
    @Expose
    public Effect effect;

}
