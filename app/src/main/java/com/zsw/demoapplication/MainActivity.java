package com.zsw.demoapplication;


import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.zsw.demoapplication.fragment.ResourceFragment;
import com.zsw.demoapplication.fragment.WorldFragment;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    private FrameLayout container;
    private RadioGroup group;
    private RadioButton world;
    private RadioButton resource;
    private WorldFragment worldFragment;
    private ResourceFragment resourceFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initEvent();
    }

    private void initView() {
        group = (RadioGroup) findViewById(R.id.rg_group);
        group.setOnCheckedChangeListener(this);

        container = (FrameLayout) findViewById(R.id.fl_container);
        world = (RadioButton) findViewById(R.id.rbt_world);
        resource = (RadioButton) findViewById(R.id.rbt_resource);

        world.setChecked(true);
    }

    private void initEvent() {

    }


    private void initData() {

    }

    /**
     * 隐藏所有Fragment
     */
    public void hideAllFragment(FragmentTransaction transaction) {
        if (worldFragment != null) {
            transaction.hide(worldFragment);
        }
        if (resourceFragment != null) {
            transaction.hide(resourceFragment);
        }
    }

    /**
     * radioGroup
     * @param group
     * @param checkedId
     */
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        hideAllFragment(transaction);
        switch (checkedId) {
            case R.id.rbt_world:
                //如果选择的是世界综合，显示世界综合页面
                if(worldFragment==null){
                    worldFragment = new WorldFragment();
                    transaction.add(R.id.fl_container,worldFragment);
                }else{
                    transaction.show(worldFragment);
                }
                break;
            case R.id.rbt_resource:
                //如果选择的是资源，显示资源页面
                if(resourceFragment==null){
                    resourceFragment = new ResourceFragment();
                    transaction.add(R.id.fl_container,resourceFragment);
                }else{
                    transaction.show(resourceFragment);
                }
                break;
        }
        transaction.commit();
    }
}

