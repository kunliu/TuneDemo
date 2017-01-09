package com.iphrack.tunedemo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Kyle on 2017-01-06.
 */

public class Character {
    @SerializedName("name")
    public String name;

    @SerializedName("house")
    public String house;

    @SerializedName("image")
    public String image;

    @SerializedName("biography")
    public String biography;
}
