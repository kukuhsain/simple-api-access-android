package com.kukuhsain.kukuh.simpleapiaccess;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by kukuh on 18/03/16.
 */
public class Image {

    @SerializedName("full")
    @Expose
    public String full;
    @SerializedName("thumb")
    @Expose
    public String thumb;

}
