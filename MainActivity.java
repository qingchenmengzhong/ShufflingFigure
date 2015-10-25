package com.example.wzb.shuffling_figure;

import android.media.Image;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    int[] images = {
            R.drawable.p1,
            R.drawable.p2,
            R.drawable.p3,
            R.drawable.p4
    };
    ViewPager mviewpager;
    PagerAdapter mpgAdapter;
    List<ImageView> ims=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView(){
        mviewpager = (ViewPager) findViewById(R.id.mviewpager);
        mpgAdapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return images==null?0:images.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view ==object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setBackgroundResource(images[position]);
                //imageView.setScaleType(ImageView.ScaleType.CENTER);
                container.addView(imageView);
                ims.add(imageView);
                return imageView;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(ims.get(position));
            }
        };
        mviewpager.setAdapter(mpgAdapter);
    }

}
