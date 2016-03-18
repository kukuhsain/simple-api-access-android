package com.kukuhsain.kukuh.simpleapiaccess;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kukuh on 18/03/16.
 */
public class PhoneList {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("price")
    @Expose
    public Float price;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("images")
    @Expose
    public List<Image> images = new ArrayList<Image>();
    @SerializedName("reviews")
    @Expose
    public List<Review> reviews = new ArrayList<Review>();

}
