package com.bilibili.ccc.ilovebilibili_master.fragment;


import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.bilibili.ccc.ilovebilibili_master.BaseFragment.BaseFragment;
import com.bilibili.ccc.ilovebilibili_master.CustomView.UserImageView;
import com.bilibili.ccc.ilovebilibili_master.CustomView.ViewPagerIndictor;
import com.bilibili.ccc.ilovebilibili_master.R;
import java.util.ArrayList;
import java.util.List;


public class MainContentFragment extends BaseFragment {

    private ViewPager mViewPager;
    private List<Fragment> contents;
    private FindFragment findFragment;
    private LiveFragment liveFragment;
    private PartitionFragment partitionFragment;
    private RecommendFragment recommendFragment;
    private CarToonFragment carToonFragment;
    private FragmentPagerAdapter adapter;
    private ViewPagerIndictor mViewPagerIndictor;
    private String[] titles = new String[]{"直播","推荐","追番","分区","发现"};
    private DrawerLayout mDrawerLayout;


    public MainContentFragment(){
    }

    private void findViews(View view) {
        mViewPager = (ViewPager) view.findViewById(R.id.id_main_content_viewpager);
        mViewPagerIndictor = (ViewPagerIndictor) view.findViewById(R.id.viewpagerindictor);
    }

    @Override
    public View initView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.bilibili_main_content,null);
        findViews(view);
        initData();
        adapter = new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return contents.get(position);
            }
            @Override
            public int getCount() {
                return contents.size();
            }
        };
        //设置ViewPager缓存的页面个数
        mViewPager.setOffscreenPageLimit(4);
        mViewPager.setAdapter(adapter);
        mViewPagerIndictor.setViewPager(mViewPager,0);
        return view;
    }

    public void setDrawerLayou(DrawerLayout layout){
        mDrawerLayout = layout;
    }

    @Override
    public void initData() {
        super.initData();
        contents = new ArrayList<Fragment>();
        liveFragment = new LiveFragment();
        recommendFragment = new RecommendFragment();
        carToonFragment = new CarToonFragment();
        partitionFragment = new PartitionFragment();
        findFragment = new FindFragment();
        contents.add(liveFragment);
        contents.add(recommendFragment);
        contents.add(carToonFragment);
        contents.add(partitionFragment);
        contents.add(findFragment);
        mViewPagerIndictor.setItemTitles(titles);
    }


}
