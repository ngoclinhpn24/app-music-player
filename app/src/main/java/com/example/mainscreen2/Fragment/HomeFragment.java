package com.example.mainscreen2.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.mainscreen2.API.ApiService;
import com.example.mainscreen2.Model.Banner;
import com.example.mainscreen2.R;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.IndicatorView.animation.type.SlideAnimation;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    View view;
    HorizontalScrollView horizontalScrollView;
    TextView txtxemthem;
    private SliderLayout auto_slider;
    private View img_avatar;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home,container, false);
        horizontalScrollView = view.findViewById(R.id.horizontalScrollView);
        txtxemthem = view.findViewById(R.id.textViewXemThem);

        anhxa();
        Into();
        setSliderViews();
        GetData();

        return view;
    }

    private void anhxa() {
        auto_slider = view.findViewById(R.id.auto_slider);
        img_avatar = view.findViewById(R.id.img_avatar);
    }

    private void Into() {
        auto_slider.setIndicatorAnimation(IndicatorAnimations.FILL);
        auto_slider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        auto_slider.setScrollTimeInSec(1);

//        img_avatar.setBackgroundResource(R.drawable.zingmp3_1);
    }

    private void setSliderViews() {
        ApiService.apiService.getDataBanner().enqueue(new Callback<List<Banner>>() {
            @Override
            public void onResponse(Call<List<Banner>> call, Response<List<Banner>> response) {
                Toast.makeText(getContext(), "Call Api Success", Toast.LENGTH_SHORT).show();
                ArrayList<Banner> banners = (ArrayList<Banner>) response.body();

                for(int i = 0; i < 5; i++)
                {
                    DefaultSliderView sliderView = new DefaultSliderView(getContext());
                    switch (i) {
                        case 0:
                            // có thể thay bằng url : setImangUrl. Tí lấy API dùng
                            sliderView.setImageUrl(banners.get(0).getImageUrl());
                            break;
                        case 1:
                            sliderView.setImageUrl(banners.get(1).getImageUrl());
                            break;
                        case 2:
                            sliderView.setImageUrl(banners.get(2).getImageUrl());
                            break;
                        case 3:
                            sliderView.setImageUrl(banners.get(3).getImageUrl());
                            break;
                        case 4:
                            sliderView.setImageUrl(banners.get(4).getImageUrl());
                            break;
                    }
                    sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);

                    auto_slider.addSliderView(sliderView);
                }
            }

            @Override
            public void onFailure(Call<List<Banner>> call, Throwable t) {
                Toast.makeText(getContext(), "Call Api Error", Toast.LENGTH_SHORT).show();
            }
        });

//        for(int i = 0; i < 5; i++)
//        {
//            DefaultSliderView sliderView = new DefaultSliderView(getContext());
//            switch (i) {
//                case 0:
//                    // có thể thay bằng url : setImangUrl. Tí lấy API dùng
//                    sliderView.setImageDrawable(R.drawable.zingmp3_1);
//                    break;
//                case 1:
//                    sliderView.setImageDrawable(R.drawable.zingmp3_2);
//                    break;
//                case 2:
//                    sliderView.setImageDrawable(R.drawable.zingmp3_3);
//                    break;
//                case 3:
//                    sliderView.setImageDrawable(R.drawable.zingmp3_4);
//                    break;
//                case 4:
//                    sliderView.setImageDrawable(R.drawable.zingmp3_5);
//                    break;
//            }
//            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
//
//            auto_slider.addSliderView(sliderView);
//        }
    }

    // lay du lieu trong Gan Day, The Loai, Chu de, Top 100
    private void GetData(){
    }

}
