//package com.example.mainscreen2.Adapter;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//
//import androidx.annotation.NonNull;
//import androidx.viewpager.widget.PagerAdapter;
//
//import com.bumptech.glide.Glide;
//import com.example.mainscreen2.Model.Banner;
//
//import java.sql.Array;
//import java.util.ArrayList;
//import com.example.mainscreen2.R;
//import com.smarteist.autoimageslider.SliderLayout;
//
//public class BannerAdapter extends PagerAdapter {
//    Context context;
//    ArrayList<Banner> banners;
//
//    public BannerAdapter(Context context, ArrayList<Banner> banners) {
//        this.context=context;
//        this.banners=banners;
//    }
//
//    @Override
//    public int getCount() {
//        return banners.size();
//    }
//
//    @Override
//    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
//        return view == object;
//    }
//
//    @NonNull
//    @Override
//    public Object instantiateItem(@NonNull ViewGroup container, int position) {
//        View view =LayoutInflater.from(container.getContext()).inflate(R.layout.fragment_banner, container, false);
//        ImageView sliderLayout = view.findViewById(R.id.auto_slider);
//
//        Banner banner = banners.get(position);
//        if(banner != null) {
//            Glide.with(context).load(banner.getBannerImageUrl()).into(sliderLayout);
//        }
//
//        //add view to viewgroup
//        container.addView(view);
//
//        return view;
//    }
//        @Override
//    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        container.removeView((View) object);
//    }
//}
