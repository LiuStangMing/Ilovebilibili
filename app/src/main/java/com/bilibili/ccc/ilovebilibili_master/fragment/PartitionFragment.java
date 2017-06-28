package com.bilibili.ccc.ilovebilibili_master.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bilibili.ccc.ilovebilibili_master.BaseFragment.BaseFragment;
import com.bilibili.ccc.ilovebilibili_master.R;


public class PartitionFragment extends BaseFragment {
    @Override
    public View initView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_main_partition,null);
        return view;
    }
}
