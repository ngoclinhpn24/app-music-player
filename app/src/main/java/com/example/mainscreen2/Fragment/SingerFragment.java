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
import com.example.mainscreen2.Adapter.SingerAdapter;
import com.example.mainscreen2.Model.Banner;
import com.example.mainscreen2.Model.Playlist;
import com.example.mainscreen2.Model.Singer;
import com.example.mainscreen2.R;
import com.smarteist.autoimageslider.DefaultSliderView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SingerFragment extends Fragment {
    ArrayList<Singer> singers;
    SingerAdapter adapter;
    RecyclerView rvSinger;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_singer,container, false);
        rvSinger = view.findViewById(R.id.rvSinger);
        getData();
        return view;
    }

    private void getData() {
        ApiService.apiService.getDataSinger().enqueue(new Callback<List<Singer>>() {
            @Override
            public void onResponse(Call<List<Singer>> call, Response<List<Singer>> response) {
                Log.d("Singer", "Call Api Success");
                singers = (ArrayList<Singer>) response.body();
                adapter = new SingerAdapter(singers, getContext());
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
                linearLayoutManager.scrollToPosition(0);
                rvSinger.setAdapter(adapter);
                rvSinger.setLayoutManager(linearLayoutManager);

            }

            @Override
            public void onFailure(Call<List<Singer>> call, Throwable t) {
                Log.d("Singer", "Call Api Error");
            }
        });
    }

}
