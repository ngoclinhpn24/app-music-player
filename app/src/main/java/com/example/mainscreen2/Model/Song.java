//-----------------------------------com.example.mainscreen2.Model.Song.java-----------------------------------

package com.example.mainscreen2.Model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Song {

    @SerializedName("Song_id")
    @Expose
    private String songId;
    @SerializedName("Album_id")
    @Expose
    private String albumId;
    @SerializedName("Playlist_id")
    @Expose
    private String playlistId;
    @SerializedName("Category_id")
    @Expose
    private String categoryId;
    @SerializedName("Song_name")
    @Expose
    private String songName;
    @SerializedName("Song_image_url")
    @Expose
    private String songImageUrl;
    @SerializedName("Singer_id")
    @Expose
    private String singerId;
    @SerializedName("Song_link")
    @Expose
    private String songLink;
    @SerializedName("Song_likes")
    @Expose
    private String songLikes;
    @SerializedName("User_id")
    @Expose
    private String userId;
    @SerializedName("Singer_name")
    @Expose
    private String singerName;

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(String playlistId) {
        this.playlistId = playlistId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongImageUrl() {
        return songImageUrl;
    }

    public void setSongImageUrl(String songImageUrl) {
        this.songImageUrl = songImageUrl;
    }

    public String getSingerId() {
        return singerId;
    }

    public void setSingerId(String singerId) {
        this.singerId = singerId;
    }

    public String getSongLink() {
        return songLink;
    }

    public void setSongLink(String songLink) {
        this.songLink = songLink;
    }

    public String getSongLikes() {
        return songLikes;
    }

    public void setSongLikes(String songLikes) {
        this.songLikes = songLikes;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

}