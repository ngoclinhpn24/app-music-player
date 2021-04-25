//package com.example.mainscreen2;
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
//import java.util.List;
//
//public class PhotoAdapter extends PagerAdapter {
//    private Context context;
//    private List<Banner> listPhoto;
//
//    public PhotoAdapter(Context context, List<Banner> listPhoto) {
//        this.context=context;
//        this.listPhoto=listPhoto;
//    }
//
//    @Override
//    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        container.removeView((View) object);
//    }
//
//    @NonNull
//    @Override
//    public Object instantiateItem(@NonNull ViewGroup container, int position) {
//        View view =LayoutInflater.from(container.getContext()).inflate(R.layout.item_photo, container, false);
//        ImageView imageView = view.findViewById(R.id.img_photo);
//
//        Photo photo = listPhoto.get(position);
//        if(photo != null) {
//            Glide.with(context).load(photo.getResourceId()).into(imageView);
//        }
//
//        //add view to viewgroup
//        container.addView(view);
//
//        return view;
//    }
//
//    @Override
//    public int getCount() {
//        if(listPhoto != null) {
//            return listPhoto.size();
//        }
//        return 0;
//    }
//
//    @Override
//    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
//        return view == object;
//    }
//
//
//}
