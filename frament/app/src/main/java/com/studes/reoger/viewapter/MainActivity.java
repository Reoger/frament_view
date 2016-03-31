package com.studes.reoger.viewapter;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initView();


        initEvent();

    }

    private void initEvent() {
        address.setOnClickListener(this);
        frd.setOnClickListener(this);
        settings.setOnClickListener(this);
        weixin.setOnClickListener(this);

        Setselect(0);
    }

    private void Setselect(int i) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        hideFragemt(ft);
        switch (i) {
            case 0:
                if (mtable0 == null) {
                    mtable0 = new addressFragment();
                    ft.add(R.id.frameLayout, mtable0);
                } else {
                    ft.show(mtable0);
                }
                address_img.setImageResource(R.drawable.tab_address_pressed);
                break;
            case 1:
                if (mtable1 == null) {
                    mtable1 = new FrdFragment();
                    ft.add(R.id.frameLayout, mtable1);
                } else {
                    ft.show(mtable1);
                }
                frd_img.setImageResource(R.drawable.tab_find_frd_pressed);
                break;
            case 2:
                if (mtable2 == null) {
                    mtable2 = new settingFragment();
                    ft.add(R.id.frameLayout, mtable2);
                } else {
                    ft.show(mtable2);
                }
                settings_img.setImageResource(R.drawable.tab_settings_pressed);
                break;
            case 3:
                if (mtable3 == null) {
                    mtable3 = new WeiFragment();
                    ft.add(R.id.frameLayout, mtable3);
                } else {
                    ft.show(mtable3);
                }
                weixin_img.setImageResource(R.drawable.tab_weixin_pressed);
                break;
        }
        ft.commit();
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

    }

    @Override
    public void onClick(View v) {
        initcloor();
        switch (v.getId()) {
            case R.id.address:
                address_img.setImageResource(R.drawable.tab_address_pressed);
                Setselect(0);
                break;
            case R.id.find_frd:
                frd_img.setImageResource(R.drawable.tab_find_frd_pressed);
                Setselect(1);
                break;
            case R.id.settings:
                settings_img.setImageResource(R.drawable.tab_settings_pressed);
                Setselect(2);
                break;
            case R.id.weixin:
                weixin_img.setImageResource(R.drawable.tab_weixin_pressed);
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


}
