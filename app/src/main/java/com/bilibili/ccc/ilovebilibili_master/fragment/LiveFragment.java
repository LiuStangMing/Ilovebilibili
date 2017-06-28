package com.bilibili.ccc.ilovebilibili_master.fragment;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bilibili.ccc.ilovebilibili_master.BaseFragment.BaseFragment;
import com.bilibili.ccc.ilovebilibili_master.Data.LiveBean;
import com.bilibili.ccc.ilovebilibili_master.adapter.LiveRecyclerViewAdapter;
import com.bilibili.ccc.ilovebilibili_master.R;
import java.util.ArrayList;
import java.util.List;


public class LiveFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private List<LiveBean> liveBeans;
    //判断toolbar是否显示
    private boolean isshow = true;
    //滑动的距离
    private int disy;
    @Override
    public View initView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_live_content,container,false);
        findView(view);
        return view;
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    public void findView(View view){
        mRecyclerView = (RecyclerView) view.findViewById(R.id.id_live_recycleview);
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.id_reflash);
    }

    @Override
    public void initData() {
        liveBeans = new ArrayList<LiveBean>();
        liveBeans.add(new LiveBean());
        liveBeans.add(new LiveBean());
        liveBeans.add(new LiveBean("推荐主播",1772,R.drawable.image1));
        liveBeans.add(new LiveBean("绘画专区",31,R.drawable.image1));
        liveBeans.add(new LiveBean("生活娱乐",351,R.drawable.image1));
        liveBeans.add(new LiveBean("唱见舞见",40,R.drawable.image1));
        liveBeans.add(new LiveBean("手游直播",402,R.drawable.image1));
        liveBeans.add(new LiveBean("单机联机",313,R.drawable.image1));
        liveBeans.add(new LiveBean("网络游戏",391,R.drawable.image1));
        liveBeans.add(new LiveBean("电子竞技",265,R.drawable.image1));
        liveBeans.add(new LiveBean("御宅文化",56,R.drawable.image1));
        liveBeans.add(new LiveBean("放映厅",515,R.drawable.image1));
        LiveRecyclerViewAdapter adapter = new LiveRecyclerViewAdapter(getContext(),liveBeans);
        LinearLayoutManager lm = new LinearLayoutManager(getContext());
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(lm);
        mRecyclerView.setAdapter(adapter);

        mSwipeRefreshLayout.setOnRefreshListener(this);
    }


    private static final int REFLASH = 0x111;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if (msg.what == REFLASH){
                Toast.makeText(getContext(),"刷新成功",Toast.LENGTH_SHORT).show();
                //// TODO: 2017/4/21  刷新业务逻辑
                mSwipeRefreshLayout.setRefreshing(false);
            }

        }
    };


    @Override
    public void onRefresh() {
        mHandler.sendEmptyMessageDelayed(REFLASH,2000);
    }
}
