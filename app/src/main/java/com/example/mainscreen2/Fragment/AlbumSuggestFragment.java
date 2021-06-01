package com.example.mainscreen2.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mainscreen2.API.ApiService;
import com.example.mainscreen2.Adapter.AlbumSuggestAdapter;
import com.example.mainscreen2.Model.Album;
import com.example.mainscreen2.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumSuggestFragment extends Fragment {
    AlbumSuggestAdapter adapter;
    ArrayList<Album> albums;
    RecyclerView rvListAlbumSuggest;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_album_suggest,container, false);
        rvListAlbumSuggest = view.findViewById(R.id.rvListAlbumSuggest);
        getData();
        return view;
    }

    private void getData() {
        ApiService.apiService.getDataAlbumSuggest().enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                albums  = (ArrayList<Album>) response.body();
                Log.d("album", "Call Album Success");
                adapter = new AlbumSuggestAdapter(albums, getContext());
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
                linearLayoutManager.scrollToPosition(0);
                rvListAlbumSuggest.setAdapter(adapter);
                rvListAlbumSuggest.setLayoutManager(linearLayoutManager);

            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {
                Log.d("album", "Call Album Error");
            }
        });
    }
}
