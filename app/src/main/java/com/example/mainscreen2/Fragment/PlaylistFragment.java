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
import com.example.mainscreen2.Model.Banner;
import com.example.mainscreen2.Model.Playlist;
import com.example.mainscreen2.R;
import com.smarteist.autoimageslider.DefaultSliderView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlaylistFragment extends Fragment {
    ArrayList<Playlist> playlists;
    PlaylistAdapter adapter;
    RecyclerView rvPlaylist;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_playlist,container, false);
        rvPlaylist = view.findViewById(R.id.rvPlaylist);
        getData();
        return view;
    }

    private void getData() {
        ApiService.apiService.getDataPlaylist().enqueue(new Callback<List<Playlist>>() {
            @Override
            public void onResponse(Call<List<Playlist>> call, Response<List<Playlist>> response) {
                Log.d("Playlist", "Call Api Success");
                playlists = (ArrayList<Playlist>) response.body();
                adapter = new PlaylistAdapter(playlists, getContext());
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
                linearLayoutManager.scrollToPosition(0);
                rvPlaylist.setAdapter(adapter);
                rvPlaylist.setLayoutManager(linearLayoutManager);

            }

            @Override
            public void onFailure(Call<List<Playlist>> call, Throwable t) {
                Log.d("Playlist", "Call Api Error");
            }
        });
    }

}
