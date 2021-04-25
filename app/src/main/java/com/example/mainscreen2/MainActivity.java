package com.example.mainscreen2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import album.Album;
import category.Category;
import category.CategoryAdapter;
import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private ViewPager viewPager;

    private RecyclerView rcvCategory;
    private CategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // them cac muc category, hien thi theo huong Vertial
        rcvCategory = findViewById(R.id.rcv_category);
        categoryAdapter = new CategoryAdapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvCategory.setLayoutManager(linearLayoutManager);

        categoryAdapter.setData(getListCategory());
        rcvCategory.setAdapter(categoryAdapter);

//        Into();
//        anhxa();
//        setClick();
//        setUpViewPager();
    }

    private List<Category> getListCategory(){
        List<Category> listCategory = new ArrayList<>();
        List<Album> listAlbum = new ArrayList<>();
        listAlbum.add(new Album(R.drawable.abm1, "Album 1"));
        listAlbum.add(new Album(R.drawable.abm2, "Album 2"));
        listAlbum.add(new Album(R.drawable.abm3, "Album 3"));
        listAlbum.add(new Album(R.drawable.abm4, "Album 4"));
        listAlbum.add(new Album(R.drawable.abm5, "Album 5"));

        listAlbum.add(new Album(R.drawable.abm1, "Album 1"));
        listAlbum.add(new Album(R.drawable.abm2, "Album 2"));
        listAlbum.add(new Album(R.drawable.abm3, "Album 3"));
        listAlbum.add(new Album(R.drawable.abm4, "Album 4"));
        listAlbum.add(new Album(R.drawable.abm5, "Album 5"));

        listCategory.add(new Category("Gần đây", listAlbum));
        listCategory.add(new Category("Top 100", listAlbum));
        listCategory.add(new Category("Album hot", listAlbum));
        listCategory.add(new Category("Thể loại", listAlbum));
        return  listCategory;
    }

    private void Into() {

    }

    private void setClick() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_home:
                       viewPager.setCurrentItem(0);
                        break;
                    case R.id.action_user:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.action_setting:
                        viewPager.setCurrentItem(2);
                        break;
                }
                return true;
            }
        });
    }

    private void anhxa() {
        bottomNavigationView = findViewById(R.id.bottom_nav);
        viewPager = findViewById(R.id.view_pager);

    }

    private void setUpViewPager() {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(viewPagerAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.action_home).setChecked(true);
                        break;
                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.action_user).setChecked(true);
                        break;
                    case 2:
                        bottomNavigationView.getMenu().findItem(R.id.action_setting).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }
}