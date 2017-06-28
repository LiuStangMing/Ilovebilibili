package com.bilibili.ccc.ilovebilibili_master.activity;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.bilibili.ccc.ilovebilibili_master.CustomView.ViewPagerIndictor;
import com.bilibili.ccc.ilovebilibili_master.R;
import com.bilibili.ccc.ilovebilibili_master.fragment.CarToonFragment;
import com.bilibili.ccc.ilovebilibili_master.fragment.FindFragment;
import com.bilibili.ccc.ilovebilibili_master.fragment.LiveFragment;
import com.bilibili.ccc.ilovebilibili_master.fragment.MainContentFragment;
import com.bilibili.ccc.ilovebilibili_master.fragment.PartitionFragment;
import com.bilibili.ccc.ilovebilibili_master.fragment.RecommendFragment;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    private CoordinatorLayout mFrameLayout;
    private Toolbar mToolbar;

    private CircleImageView mUserImage;

    private FloatingActionButton mfloatBtn;

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

    private MainContentFragment mainContentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.id_main_content_drawerlayout);
        mFrameLayout = (CoordinatorLayout) findViewById(R.id.id_main_content_framelayout);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mViewPager = (ViewPager)findViewById(R.id.id_main_content_viewpager);
        mViewPagerIndictor = (ViewPagerIndictor)findViewById(R.id.viewpagerindictor);
        mUserImage = (CircleImageView) findViewById(R.id.userImage);
        mfloatBtn = (FloatingActionButton) findViewById(R.id.fab);
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        //去除标题Title
        actionBar.setDisplayShowTitleEnabled(false);
        initData();
        adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
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

        mUserImage.setImageResource(R.drawable.userimage1);
        mUserImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(Gravity.START);
            }
        });

        mfloatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"click on",Toast.LENGTH_SHORT).show();
            }
        });

//        mainContentFragment = new MainContentFragment();
//        mainContentFragment.setDrawerLayou(mDrawerLayout);
//        getSupportFragmentManager().beginTransaction().add(R.id.id_main_content_framelayout,
//                mainContentFragment).commit();

    }

    public void initData() {
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.id_main_content_sousuo:

                break;
            case R.id.id_main_content_xiazai:

                break;
            case R.id.id_main_content_game:

                break;
        }
        return true;
    }
}
