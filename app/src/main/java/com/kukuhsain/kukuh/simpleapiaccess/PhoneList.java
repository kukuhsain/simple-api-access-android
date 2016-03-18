package com.kukuhsain.kukuh.simpleapiaccess;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kukuh on 18/03/16.
 */
public class PhoneList {

    /**
     * No args constructor for use in serialization
     *
     */
    public PhoneList() {
    }

    /**
     *
     * @param id
     * @param reviews
     * @param price
     * @param description
     * @param name
     * @param images
     */
    /*public PhoneList(Integer id, String name, Float price, Object description, List<Object> images, List<Object> reviews) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.images = images;
        this.reviews = reviews;
    }*/

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
