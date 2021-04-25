package com.example.mainscreen2.Model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Banner {

    @SerializedName("Suggest_id")
    @Expose
    private String suggestId;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Image_url")
    @Expose
    private String imageUrl;

    public String getSuggestId() {
        return suggestId;
    }

    public void setSuggestId(String suggestId) {
        this.suggestId = suggestId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}