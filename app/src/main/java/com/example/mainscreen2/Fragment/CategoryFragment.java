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
import com.example.mainscreen2.Adapter.CategoryAdapter;
import com.example.mainscreen2.Adapter.PlaylistAdapter;
import com.example.mainscreen2.Model.Category;
import com.example.mainscreen2.Model.Playlist;
import com.example.mainscreen2.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryFragment extends Fragment {
    private List<Category> categorys;
    private CategoryAdapter adapter;
    private RecyclerView rvCategory;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category,container, false);
        rvCategory = view.findViewById(R.id.rvCategory);
        getData();
        return view;
    }

    private void getData() {
        ApiService.apiService.getDataCategory().enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                Log.d("Category", "Call Api Success");
                categorys = (ArrayList<Category>) response.body();
                adapter = new CategoryAdapter(categorys, getContext());
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
                linearLayoutManager.scrollToPosition(0);
                rvCategory.setAdapter(adapter);
                rvCategory.setLayoutManager(linearLayoutManager);
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                Log.d("Playlist", "Call Api Error");
            }
        });
    }
}
