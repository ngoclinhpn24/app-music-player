package com.example.mainscreen2.Model;
//-----------------------------------com.example.mainscreen2.Model.AlbumSuggest.java-----------------------------------
        //package com.example.mainscreen2.Model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Album {

    @SerializedName("Album_id")
    @Expose
    private String albumId;
    @SerializedName("Album_name")
    @Expose
    private String albumName;
    @SerializedName("Singer_id")
    @Expose
    private String singerId;
    @SerializedName("Album_image_url")
    @Expose
    private String albumImageUrl;

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getSingerId() {
        return singerId;
    }

    public void setSingerId(String singerId) {
        this.singerId = singerId;
    }

    public String getAlbumImageUrl() {
        return albumImageUrl;
    }

    public void setAlbumImageUrl(String albumImageUrl) {
        this.albumImageUrl = albumImageUrl;
    }

}
