package com.studes.reoger.viewapter;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ViewPager mViewPage;
    private LinearLayout address;
    private LinearLayout frd;
    private LinearLayout settings;
    private LinearLayout weixin;
    private ImageButton address_img;
    private ImageButton frd_img;
    private ImageButton settings_img;
    private ImageButton weixin_img;
    private List<View> listView = new ArrayList<View>();
    private PagerAdapter mAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initView();

        address.setOnClickListener(this);
        frd.setOnClickListener(this);
        settings.setOnClickListener(this);
        weixin.setOnClickListener(this);
        mViewPage.setAdapter(mAdapter);

        mViewPage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                initcloor();
                switch (position){
                    case 0:
                        address_img.setImageResource(R.drawable.tab_address_pressed);
                        break;
                    case 1:
                        frd_img.setImageResource(R.drawable.tab_find_frd_pressed);
                        break;
                    case 2:
                        settings_img.setImageResource(R.drawable.tab_settings_pressed);
                        break;
                    case 3:
                        weixin_img.setImageResource(R.drawable.tab_weixin_pressed);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initView() {
        mViewPage = (ViewPager) findViewById(R.id.ViewPager);
        address = (LinearLayout) findViewById(R.id.address);
        frd = (LinearLayout) findViewById(R.id.find_frd);
        settings = (LinearLayout) findViewById(R.id.settings);
        weixin = (LinearLayout) findViewById(R.id.weixin);
        address_img = (ImageButton) findViewById(R.id.address_img);
        frd_img = (ImageButton) findViewById(R.id.find_frd_img);
        settings_img = (ImageButton) findViewById(R.id.settings_img);
        weixin_img = (ImageButton) findViewById(R.id.weixin_img);

        LayoutInflater inflater = LayoutInflater.from(this);
        View table01 = inflater.inflate(R.layout.layout_01,null);
        View table02 = inflater.inflate(R.layout.layout_02,null);
        View table03 = inflater.inflate(R.layout.layout_03, null);
        View table04 = inflater.inflate(R.layout.layout_04,null);
        listView.add(table01);
        listView.add(table02);
        listView.add(table03);
        listView.add(table04);

        mAdapter = new PagerAdapter() {


            @Override
            public int getCount() {
                return listView.size();
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(listView.get(position));
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view = listView.get(position);
                container.addView(view);
                return view;
            }
        };



    }

    @Override
    public void onClick(View v) {
        initcloor();
        switch (v.getId()){
            case R.id.address:
                address_img.setImageResource(R.drawable.tab_address_pressed);
                mViewPage.setCurrentItem(0);
                break;
            case R.id.find_frd:
                frd_img.setImageResource(R.drawable.tab_find_frd_pressed);
                mViewPage.setCurrentItem(1);
                break;
            case R.id.settings:
                settings_img.setImageResource(R.drawable.tab_settings_pressed);
                mViewPage.setCurrentItem(2);
                break;
            case R.id.weixin:
                weixin_img.setImageResource(R.drawable.tab_weixin_pressed);
                mViewPage.setCurrentItem(3);
                break;
        }

    }

    private void initcloor() {
        address_img.setImageResource(R.drawable.tab_address_normal);
        frd_img.setImageResource(R.drawable.tab_find_frd_normal);
        settings_img.setImageResource(R.drawable.tab_settings_normal);
        weixin_img.setImageResource(R.drawable.tab_weixin_normal);
    }


}
