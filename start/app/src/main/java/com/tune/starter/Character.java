package com.tune.starter;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Kyle on 2017-01-09.
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
