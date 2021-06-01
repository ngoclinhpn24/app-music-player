package com.example.mainscreen2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mainscreen2.Model.Album;
import com.example.mainscreen2.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AlbumSuggestAdapter extends RecyclerView.Adapter<AlbumSuggestAdapter.ViewHolder> {
    private List<Album> albums;
    private Context context;

    public AlbumSuggestAdapter(List<Album> albums, Context context) {
        this.albums=albums;
        this.context=context;
    }

    @NonNull
    @Override
    public AlbumSuggestAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View albumView =LayoutInflater.from(parent.getContext()).inflate(R.layout.item_album_suggest, parent, false);
        ViewHolder viewHolder = new ViewHolder(albumView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumSuggestAdapter.ViewHolder holder, int position) {
        Album albumSuggest = albums.get(position);
        Picasso.with(context).load(albumSuggest.getAlbumImageUrl()).into(holder.img_album);
        holder.tv_nameAlbum.setText(albumSuggest.getAlbumName());
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }


    public class ViewHolder  extends  RecyclerView.ViewHolder{
        public ImageView img_album;
        public TextView tv_nameAlbum;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_album = itemView.findViewById(R.id.img_album);
            tv_nameAlbum = itemView.findViewById(R.id.tv_nameAlbum);
        }
    }
}

