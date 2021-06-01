//-----------------------------------com.example.mainscreen2.Model.Singer.java-----------------------------------

package com.example.mainscreen2.Model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Singer {

    @SerializedName("singer_id")
    @Expose
    private String singerId;
    @SerializedName("singer_name")
    @Expose
    private String singerName;
    @SerializedName("singer_image_url")
    @Expose
    private String singerImageUrl;

    public String getSingerId() {
        return singerId;
    }

    public void setSingerId(String singerId) {
        this.singerId = singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getSingerImageUrl() {
        return singerImageUrl;
    }

    public void setSingerImageUrl(String singerImageUrl) {
        this.singerImageUrl = singerImageUrl;
    }

}