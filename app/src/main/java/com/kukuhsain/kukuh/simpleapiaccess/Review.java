package com.kukuhsain.kukuh.simpleapiaccess;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by kukuh on 18/03/16.
 */
public class Review {

    @SerializedName("stars")
    @Expose
    public Integer stars;
    @SerializedName("body")
    @Expose
    public String body;
    @SerializedName("author")
    @Expose
    public String author;

}
