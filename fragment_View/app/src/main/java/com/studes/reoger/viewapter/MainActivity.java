package com.studes.reoger.viewapter;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements View.OnClickListener {
    private LinearLayout address;
    private LinearLayout frd;
    private LinearLayout settings;
    private LinearLayout weixin;
    private ImageButton address_img;
    private ImageButton frd_img;
    private ImageButton settings_img;
    private ImageButton weixin_img;

    private Fragment mtable0;
    private Fragment mtable1;
    private Fragment mtable2;
    private Fragment mtable3;

    private List<Fragment> mFragment;
    private FragmentPagerAdapter mAdapter;
    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initView();

        initEvent();

        Setselect(1);
    }

    private void initEvent() {
        address.setOnClickListener(this);
        frd.setOnClickListener(this);
        settings.setOnClickListener(this);
        weixin.setOnClickListener(this);


        mViewPager.setAdapter(mAdapter);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int i = mViewPager.getCurrentItem();
                pppp(i);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        Setselect(0);
    }

    private void Setselect(int i) {
        pppp(i);
        mViewPager.setCurrentItem(i);
    }

    private void hideFragemt(FragmentTransaction fragmentTransaction) {
        if (mtable0 != null) {
            fragmentTransaction.hide(mtable0);
        }
        if (mtable1 != null) {
            fragmentTransaction.hide(mtable1);
        }
        if (mtable2 != null) {
            fragmentTransaction.hide(mtable2);
        }
        if (mtable3 != null) {
            fragmentTransaction.hide(mtable3);
        }
    }

    private void initView() {
        address = (LinearLayout) findViewById(R.id.address);
        frd = (LinearLayout) findViewById(R.id.find_frd);
        settings = (LinearLayout) findViewById(R.id.settings);
        weixin = (LinearLayout) findViewById(R.id.weixin);
        address_img = (ImageButton) findViewById(R.id.address_img);
        frd_img = (ImageButton) findViewById(R.id.find_frd_img);
        settings_img = (ImageButton) findViewById(R.id.settings_img);
        weixin_img = (ImageButton) findViewById(R.id.weixin_img);
        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);

        mtable0 = new WeiFragment();
        mtable1 = new addressFragment();
        mtable2 = new settingFragment();
        mtable3 = new FrdFragment();
        mFragment = new ArrayList<Fragment>();
        mFragment.add(mtable0);
        mFragment.add(mtable1);
        mFragment.add(mtable2);
        mFragment.add(mtable3);

        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragment.get(position);
            }

            @Override
            public int getCount() {
                return mFragment.size();
            }
        };
    }

    @Override
    public void onClick(View v) {
        initcloor();
        switch (v.getId()) {
            case R.id.weixin:
                Setselect(0);
                break;
            case R.id.settings:
                Setselect(1);
                break;
            case R.id.address:
                Setselect(2);
                break;
            case R.id.find_frd:
                Setselect(3);
                break;
        }

    }

    private void initcloor() {
        address_img.setImageResource(R.drawable.tab_address_normal);
        frd_img.setImageResource(R.drawable.tab_find_frd_normal);
        settings_img.setImageResource(R.drawable.tab_settings_normal);
        weixin_img.setImageResource(R.drawable.tab_weixin_normal);
    }

    private void pppp(int i) {
        initcloor();
        switch (i) {
            case 2:
                address_img.setImageResource(R.drawable.tab_address_pressed);
                break;
            case 3:
                frd_img.setImageResource(R.drawable.tab_find_frd_pressed);
                break;
            case 1:
                settings_img.setImageResource(R.drawable.tab_settings_pressed);
                break;
            case 0:
                weixin_img.setImageResource(R.drawable.tab_weixin_pressed);
                break;
        }
    }


}
