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
import com.example.mainscreen2.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistAdapter.ViewHolder>  {
    private List<Playlist> playlists;
    private Context context;

    public PlaylistAdapter(List<Playlist> playlists, Context context) {
        this.playlists=playlists;
        this.context=context;
    }

    @NonNull
    @Override
    public PlaylistAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View albumView =LayoutInflater.from(parent.getContext()).inflate(R.layout.item_playlist, parent, false);
        PlaylistAdapter.ViewHolder viewHolder = new PlaylistAdapter.ViewHolder(albumView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PlaylistAdapter.ViewHolder holder, int position) {
        Playlist playlist = playlists.get(position);
        Picasso.with(context).load(playlist.getPlaylistImageUrl()).into(holder.img_playlist);
        holder.tv_nameplaylist.setText(playlist.getPlaylistName());
    }

    @Override
    public int getItemCount() {
        return playlists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView img_playlist;
        public TextView tv_nameplaylist;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_playlist = itemView.findViewById(R.id.img_playlist);
            tv_nameplaylist = itemView.findViewById(R.id.tv_nameplaylist);
        }
    }
}
