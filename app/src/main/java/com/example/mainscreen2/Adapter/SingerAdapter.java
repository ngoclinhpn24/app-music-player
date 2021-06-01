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
import com.example.mainscreen2.Model.Singer;
import com.example.mainscreen2.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SingerAdapter extends RecyclerView.Adapter<SingerAdapter.ViewHolder>  {
    private List<Singer> singers;
    private Context context;

    public SingerAdapter(List<Singer> singers, Context context) {
        this.singers=singers;
        this.context=context;
    }

    @NonNull
    @Override
    public SingerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View albumView =LayoutInflater.from(parent.getContext()).inflate(R.layout.item_singer, parent, false);
        SingerAdapter.ViewHolder viewHolder = new SingerAdapter.ViewHolder(albumView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SingerAdapter.ViewHolder holder, int position) {
            Singer singer=singers.get(position);
            Picasso.with(context).load(singer.getSingerImageUrl()).into(holder.img_singer);
    }

    @Override
    public int getItemCount() {
        return singers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView img_singer;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_singer = itemView.findViewById(R.id.img_singer);
        }
    }
}
