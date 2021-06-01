package com.example.mainscreen2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mainscreen2.Model.Playlist;
import com.example.mainscreen2.Model.Song;
import com.example.mainscreen2.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder>  {
    private List<Song> songs;
    private Context context;

    public SongAdapter(List<Song> songs, Context context) {
        this.songs=songs;
        this.context=context;
    }

    @NonNull
    @Override
    public SongAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View albumView =LayoutInflater.from(parent.getContext()).inflate(R.layout.item_song, parent, false);
        SongAdapter.ViewHolder viewHolder = new SongAdapter.ViewHolder(albumView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SongAdapter.ViewHolder holder, int position) {
        Song song = songs.get(position);
        Picasso.with(context).load(song.getSongImageUrl()).into(holder.img_song);
        holder.tv_nameSong.setText(song.getSongName());
        holder.tv_nameSinger.setText(song.getSingerName());
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView img_song;
        public TextView tv_nameSong;
        public TextView tv_nameSinger;
        public ImageView img_heart;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_song = itemView.findViewById(R.id.img_song);
            tv_nameSong = itemView.findViewById(R.id.tv_nameSong);
            tv_nameSinger = itemView.findViewById(R.id.tv_nameSinger);
            img_heart = itemView.findViewById(R.id.img_heart);
        }
    }
}
