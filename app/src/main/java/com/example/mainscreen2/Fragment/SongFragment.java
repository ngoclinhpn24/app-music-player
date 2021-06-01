package com.example.mainscreen2.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mainscreen2.API.ApiService;
import com.example.mainscreen2.Adapter.AlbumSuggestAdapter;
import com.example.mainscreen2.Adapter.PlaylistAdapter;
import com.example.mainscreen2.Adapter.SongAdapter;
import com.example.mainscreen2.Model.Banner;
import com.example.mainscreen2.Model.Playlist;
import com.example.mainscreen2.Model.Song;
import com.example.mainscreen2.R;
import com.smarteist.autoimageslider.DefaultSliderView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SongFragment extends Fragment {
    ArrayList<Song> songs;
    SongAdapter adapter;
    RecyclerView rvSong;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_song,container, false);
        rvSong = view.findViewById(R.id.rvSong);
        getData();
        return view;
    }

    private void getData() {
        ApiService.apiService.getDataSong().enqueue(new Callback<List<Song>>() {
            @Override
            public void onResponse(Call<List<Song>> call, Response<List<Song>> response) {
                Log.d("Song", "Call Api Success");
                songs = (ArrayList<Song>) response.body();
                adapter = new SongAdapter(songs, getContext());
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                linearLayoutManager.scrollToPosition(0);
                rvSong.setAdapter(adapter);
                rvSong.setLayoutManager(linearLayoutManager);

            }

            @Override
            public void onFailure(Call<List<Song>> call, Throwable t) {
                Log.d("Song", "Call Api Error");
            }
        });
    }

}
